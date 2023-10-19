// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your cod
// importera klassar for input, listor
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
//huvud class
public class Main {
    // skapa en lista att laga instancar av bil klassar
    public static List<Truck> trucks = new ArrayList<>();
   // huvud metod att köra
    public static void main(String[] args) {
        // skapa en scanner object för input från användaren
        Scanner scanner = new Scanner(System.in);
        // loopa att visa menyen och valen
        while (true) {
            System.out.println("1. See docked trucks");
            System.out.println("2. Register a new truck");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {  // hjälp från google och ChatGpt att lösa ett problem att adda extra validation den funkade,
                /*Exception in thread "main" java.util.InputMismatchException
               	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	            at java.base/java.util.Scanner.next(Scanner.java:1594)
	            at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	            at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	            at Main.main(Main.java:21)*/
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // anropa metoden att visa bilar på plats
                        seeDockedTrucks();
                        break;
                    case 2:
                        //anropa metoden att registrera en bil
                        registerNewTruck(scanner);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("OBS!! Please enter a valid numeric choice (1, 2, or 3).");
                scanner.next(); // Consume the invalid input
            }

        }
    }

    private static void seeDockedTrucks() {
        System.out.println("Docked trucks:");
        for (Truck truck : trucks) {
            System.out.println("Type: " + truck.getType() + ", Weight: " + truck.getWeight() + ", Docked at: " + truck.getDockedAt() + " .");
        }
    }

    private static void registerNewTruck(Scanner scanner) {
        System.out.print("Enter truck type (van, light , heavy): ");
        String type = scanner.next();
       // kolla om typen är OK
        if (!(type.equals("van") || type.equals("light") || type.equals("heavy"))) {
            System.out.println("Please try again.");
            return;
        }
           System.out.print("Enter truck weight: ");
           double weight = scanner.nextDouble();
           //skapa en instance av bil class beror på typen
        Truck truck;

        if (type.equals("van")) {
            truck = new Van(weight);
        } else if (type.equals("light")) {
            truck = new SmallTruck(weight);
        } else if (type.equals("heavy")) {
            truck = new HeavyTruck(weight);
        } else {
            System.out.println("Invalid type. Please try again.");
            return;
        }
        // plats att lasta
        String dockedAt = getDockedAt(truck);

        if (dockedAt != null) {
            // om finns plats sätta platsen och bilen i listan
            truck.setDockedAt(dockedAt);//sätter o uppdaterar lastbilen platsattribut till där den ska parkeras.
            trucks.add(truck);// lägger bilen till listan
            System.out.println("registered successfully, and vehicle can dock at " + dockedAt + " .");
        } else {
            System.out.println("Truck cannot be docked for now please wait to get an available place.");
        }
    }

    private static String getDockedAt(Truck truck) {
        String[] places = {"A", "B", "C", "D", "E"};

        for (String place : places) {
            boolean isTaken = false;
            for (Truck t : trucks) {
                if (t.getDockedAt().equals(place)) {
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken && truck.canDockAt(place)) {
                return place;
            }
        }

        return null;
    }
}
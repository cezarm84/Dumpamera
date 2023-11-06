class SmallTruck extends Truck {
    public SmallTruck(double weight) {
        super("light", weight);
    }

    @Override
    public boolean canDockAt(String place) {
        if (place.equals("A") && getWeight() < 5) {
            // om vikt midre än 5 kan lasta vid A
            return true;
        } else if (place.equals("C") && !isPlaceTaken("C")) {
            // om plats C och är ledig du kan docka
            return true;
        } else if (place.equals("D") && !isPlaceTaken("D")) {
            // om plats D och är ledig du kan docka
            return true;
        }
        return false;
    }

    private boolean isPlaceTaken(String place) { // behöver att kolla om A är ledig
        for (Truck truck : Main.trucks) {        // ha tillgång till trucks i main
            if (truck.getDockedAt().equals(place)) {
                return true;
            }
        }
        return false;
    }
}

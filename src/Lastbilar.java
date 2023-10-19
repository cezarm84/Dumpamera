abstract class Truck {
    private String type;// string att spara typ
    private double weight;// double att spara vikt
    private String dockedAt;// string att spara var är plats

    public Truck(String type, double weight) {// constructor
        this.type = type;
        this.weight = weight;
        this.dockedAt = "";// inga bilar har dockat,
    }

    public String getType() {// get metod att retrieva typen
        return type;
    }

    public double getWeight() {// get metoden för vikten
        return weight;
    }

    public String getDockedAt() {// get metod för platsen
        return dockedAt;
    }

    public void setDockedAt(String dockedAt) {// setter metod att updater dockAT fältet av en truck instance
        this.dockedAt = dockedAt;
    }

    public abstract boolean canDockAt(String place);
}// abstract metod  canDockAt viklen jobbar i subclasses @override
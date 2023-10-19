class Van extends Truck {
    public Van(double weight) {
        super("van", weight);
    }

    @Override
    public boolean canDockAt(String place) {
        return place.equals("A") || place.equals("B");
    }
}
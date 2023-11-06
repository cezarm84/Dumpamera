class HeavyTruck extends Truck {
    public HeavyTruck(double weight) {
        super("heavy", weight);
    }

    @Override
    public boolean canDockAt(String place) {
        return place.equals("E") || (place.equals("D") && getWeight() < 9);
    }
}

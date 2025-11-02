package challenge;

public class Place {
    private String name;
    private int distanceFromStart; // distance from Sydney

    public Place(String name, int distanceFromStart) {
        this.name = name;
        this.distanceFromStart = distanceFromStart;
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    @Override
    public String toString() {
        return name + " (" + distanceFromStart + " km)";
    }
}

package set03;

public abstract class Sequence {
    private int[] sequence;
    private Location[] locations;

    public Sequence(Location[] locations){
        this.locations = locations;

    }

    public double nextTime(){
         return new Route(locations,nextRouteSequence()).routeDuration();

    }

    public abstract boolean hasnextRoute();

    public abstract int[] nextRouteSequence();

    public Location[] getLocations() {
        return locations;
    }
}

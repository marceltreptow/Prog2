package set03;

public class Location {
    private double x;
    private double y;
    private String name;

    public Location(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public double getDistance(Location l1){
        double newx = x - l1.getX();
        double newy = y - l1.getY();
        return Math.sqrt(Math.pow(newx, 2) + Math.pow(newy,2));

    }

    /*public static void main(String[] args) {
        Location l1 = new Location("A",1,2);
        System.out.println(l1.getDistance(new Location("B",2,2)));
    }*/
}

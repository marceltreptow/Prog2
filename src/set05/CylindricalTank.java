package set05;

public class CylindricalTank implements Tonks, Cloneable{
    private Tonks next = null;
    private double radius;
    private double height;

    public CylindricalTank(double radius, double height) {
        this.radius = radius;
        this.height = height;

    }

    @Override
    public double calculateVolume() {
        return height * (Math.PI * Math.pow(radius,2));

    }

    @Override
    public double calculateSurface() {
        return 2 * Math.PI * radius * (radius + height);

    }

    public Tonks getNext(){
        return next;

    }

    public void setNext(Tonks tank){
        next = tank;

    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Tonks clone() {
        return new CylindricalTank(radius,height);

    }

    public int hashcode(){
        return (int) (radius * 11 + height * 5);

    }
}

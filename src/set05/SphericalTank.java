package set05;

import java.util.Iterator;

public class SphericalTank implements Tonks, Cloneable{
    private Tonks next = null;
    private double radius;

    public SphericalTank(double radius) {
        this.radius = radius;

    }

    @Override
    public double calculateVolume() {
        return 4 * Math.PI * Math.pow(radius,2);
    }

    @Override
    public double calculateSurface() {
        return (4/3) * Math.PI * Math.pow(radius,3);

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

    @Override
    public Tonks clone() {
        return new SphericalTank(radius);
    }

    public int hashcode(){
        return (int) (radius * 8);

    }
}

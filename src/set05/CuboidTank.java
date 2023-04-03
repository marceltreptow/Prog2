package set05;

import java.util.Iterator;

public class CuboidTank implements Tonks, Cloneable{
    private Tonks next = null;
    private double length;
    private double heigth;
    private double wide;

    public CuboidTank(double length, double heigth, double wide) {
        this.length = length;
        this.heigth = heigth;
        this.wide = wide;

    }

    @Override
    public double calculateVolume() {
        return length * heigth * wide;
    }

    @Override
    public double calculateSurface() {
        return 2 * (length * heigth + length * wide + wide * heigth);

    }

    public Tonks getNext(){
        return next;

    }

    public void setNext(Tonks tank){
        next = tank;

    }

    public double getLength() {
        return length;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWide() {
        return wide;
    }

    @Override
    public Tonks clone() {
        return new CuboidTank(length,heigth,wide);
    }

    public int hashcode(){
        return (int) (length * 11 + wide * 5 - heigth);

    }
}

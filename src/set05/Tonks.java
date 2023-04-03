package set05;

public interface Tonks {

    public double calculateVolume();

    public double calculateSurface();

    public Tonks getNext();

    public void setNext(Tonks tank);

    public Tonks clone();

    public int hashCode();

}

package set05;

public class TonkList implements Iterable<Object>,Cloneable {
    Tonks first;
    Tonks last;
    private int size = 0;

    @Override
    public TonkIterator iterator() {
        return new TonkIterator(this);
    }

    public void add(Tonks tank){
        if(isEmpty())
            first = last = tank;
        else {
            last.setNext(tank);
            last = tank;
        }
        size++;

    }

    public boolean isEmpty(){
        return size == 0;

    }

    public double getVolume(){
        double result = 0;
        if(!isEmpty()){
            result = first.calculateVolume();
            TonkIterator tonkIterator = iterator();
            while (tonkIterator.hasNext()) {
                result += tonkIterator.next().calculateVolume();

            }
        }

        return result;
    }

    public double getSurfice(){
        double result = 0;
        if(!isEmpty()){
            result = first.calculateSurface();
            TonkIterator tonkIterator = iterator();
            while (tonkIterator.hasNext()) {
                result += tonkIterator.next().calculateSurface();

            }
        }

        return result;
    }

    @Override
    public String toString() {
        return size + " Tank(s)\nVolumen: "+ getVolume() + "\nOberfläche: " + getSurfice();

    }

    @Override
    public TonkList clone() throws CloneNotSupportedException {
        TonkIterator tonkIterator = iterator();
        TonkList clone = new TonkList();

        if (size > 1) {
            Tonks next = first;
            clone.add(next.clone());
            while (tonkIterator.hasNext()) {
                next = tonkIterator.next();
                clone.add(next.clone());

            }
        }
        return clone;

    }

    public static boolean equalTonks(Tonks tank1, Tonks tank2){
        if(tank1.getClass() != tank2.getClass())
            return false;
        else
            return true;

    }

    public static boolean sameTonks(Tonks tank1, Tonks tank2){
        if(tank1.getClass() == tank2.getClass() && tank1.hashCode() == tank2.hashCode())
            return true;
        else
            return false;

    }

    public void setLast(Tonks last) {
        this.last = last;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

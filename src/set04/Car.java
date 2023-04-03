package set04;

public class Car implements Cloneable {
    private int length;
    private int passengers;
    private Car next = null;

    public Car(int length, int passengers) {
        this.length = length;
        this.passengers = passengers;

    }

    public int getLength() {
        return length;
    }

    public int getPassengers() {
        return passengers;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car clone = new Car(length,passengers);
        clone.setNext(next);
        return clone;

    }
}

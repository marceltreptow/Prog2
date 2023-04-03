package set04;

public class Locomotive {
    private int length;
    private int type;
    private Car first;
    private String name;

    public Locomotive(int length, int type, String name) {
        this.length = length;
        this.type = type;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public int getType() {
        return type;
    }

    public Car getFirst() {
        return first;
    }

    public void setFirst(Car first) {
        this.first = first;
    }
}

package set02;

public class Range implements Sequence{
    private int count;
    private int max;

    public Range (int count, int max){
        this.count = count;
        this.max = max;

    }

    @Override
    public boolean hasNext() {
        return count <= max;
    }

    @Override
    public int nextElemnt() {
        return count++;
    }
}

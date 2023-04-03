package set02;

public class Naturals implements Sequence{

    private int count = 1;

    public boolean hasNext(){
        return true;

    }

    public int nextElemnt(){
        return count++;

    }
}

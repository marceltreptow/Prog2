package set02;

public class Evens extends Filter{
    private Sequence seq;

    public Evens (Sequence seq){
        super(seq);

    }

    @Override
    public boolean testPassCondition(int element) {
        return element % 2 == 0;

    }
}

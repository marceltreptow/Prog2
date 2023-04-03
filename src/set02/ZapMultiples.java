package set02;

public class ZapMultiples extends Filter{
    private Sequence seq;
    private int division;

    public ZapMultiples(Sequence seq, int division){
        super(seq);
        this.division = division;

    }

    @Override
    public boolean testPassCondition(int element) {
        return element % division == 0;

    }
}

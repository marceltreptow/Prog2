package set02;

public abstract class Filter implements Sequence{
    private int nextelement;
    private Sequence seq;

    public Filter (Sequence seq){
        this.seq = seq;

    }

    @Override
    public boolean hasNext() {
        if (!seq.hasNext())
            return false;
        else {
            nextelement = seq.nextElemnt();
            if (testPassCondition(nextelement))
                return true;
            else
                return hasNext();

        }
    }

    @Override
    public int nextElemnt() {
        return nextelement;

    }

    public abstract boolean testPassCondition(int element);

}

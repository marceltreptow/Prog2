package set02;

public class PrimeNumbers extends Filter{
    Sequence seq;

    public PrimeNumbers(Sequence seq){
        super(seq);

    }

    @Override
    public boolean testPassCondition(int element) {
        for (int i = element / 2 + 1; i > 1; i--) {
            if (element % i == 0)
                return false;

        }
        return true;

    }
}

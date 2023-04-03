package set05;

import java.util.Iterator;

public class TonkIterator implements Iterator<Object> {
    private TonkList tonklist;
    private Tonks curr;

    public TonkIterator(TonkList tonk) {
        this.tonklist = tonk;
        curr = tonklist.first;

    }

    @Override
    public boolean hasNext() {
        return curr.getNext() != null;

    }

    @Override
    public Tonks next() {
        Tonks result = curr.getNext();
        curr = curr.getNext();
        return result;

    }

    @Override
    public void remove() {
        if(!tonklist.isEmpty()) {
            while (tonklist.sameTonks(tonklist.last, next())) {
            }
            curr.setNext(null);
            tonklist.setLast(curr);
            tonklist.setSize(tonklist.getSize() - 1);

        }
    }
}

package TestIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

class MyLinkedListIterator implements Iterator<Object> {

    private MyLinkedList list;
    private MyLinkedListNode curr;
    private int modCountInit;

    public MyLinkedListIterator(MyLinkedList list) {
        this.list = list;
        this.curr = list.first;
        modCountInit = list.modCount;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public Object next() {
        if (modCountInit < list.modCount)
            throw new ConcurrentModificationException();
        Object result = curr.getItem();
        curr = curr.getNext();
        return result;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}

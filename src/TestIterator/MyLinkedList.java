package TestIterator;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList implements Iterable<Object> {
    MyLinkedListNode first;
    private MyLinkedListNode last;
    private int size;
    int modCount;

    public void add(Object item) {
        MyLinkedListNode node = new MyLinkedListNode(item);
        if (isEmpty()) {
            last = first = node;
        } else {
            node.setPrev(last);
            last.setNext(node);
            last = node;
        }
        size++;
        modCount++;
    }

    public Object remove() {
        Object result = first.getItem();
        first = first.getNext();
        if (first == null)
            last = null;
        else
            first.setPrev(null);
        size--;
        modCount++;
        return result;
    }

    public Object get(int index) {
        MyLinkedListNode curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.getNext();
        return curr.getItem();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Object item : this)
            result = result * 7 + Objects.hashCode(item);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyLinkedList list = (MyLinkedList) obj;
        if (size() != list.size())
            return false;
        Iterator<Object> it1 = iterator();
        Iterator<Object> it2 = list.iterator();
        while (it1.hasNext())
            if (!Objects.equals(it1.next(), it2.next()))
                return false;
        return true;
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyLinkedListIterator(this);
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        Iterator<Object> it = list.iterator();
        System.out.println(it.next());
        list.remove();
        System.out.println(it.next());
        /*
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
         */

        for (Object item : list)
            System.out.println(item);
    }
}

package set07;

import java.util.Iterator;

public class MyDequeUtil {
    public static <T extends Comparable<T>> MyDeque merge(MyDeque myDeque1, MyDeque myDeque2){
        MyDeque myDeque = new MyDeque(myDeque1.capacity()+myDeque2.capacity());
        Iterator myDeque1iterator = myDeque1.iterator();
        while (myDeque1iterator.hasNext())
            myDeque.addLast((T)myDeque1iterator.next());
        Iterator myDeque2iterator = myDeque2.iterator();
        while (myDeque2iterator.hasNext())
            myDeque.addLast((T)myDeque2iterator.next());

        return myDeque;
    }

    public static <T extends Comparable<T>> MyDeque selectLess(MyDeque myDeque, T element){
        Iterator iterator = myDeque.iterator();
        MyDeque newmyDeque =  new MyDeque(myDeque.capacity());
        int compare;
        while (iterator.hasNext()) {
            if(iterator.next() !=  null)
                compare = element.compareTo((T) iterator.next());
            else
                compare = 0;
            if (compare > 0)
                newmyDeque.addLast((T)iterator.next());

        }
        return newmyDeque;

    }

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque(10);
        for (int i = 0; i < 3; i++)
            deque.addFirst(i);
        System.out.println(deque);
        for (int i = 3; i < 6; i++)
            deque.addLast(i);
        System.out.println(deque);
        for (int i = 0; i < 2; i++)
            deque.removeFirst();
        System.out.println(deque);
        while (!deque.isEmpty())
            deque.removeLast();
        System.out.println(deque);
        for (int i = 0; i < 8; i++)
            deque.addLast(i);
        System.out.println(deque);
        deque = merge(deque, deque);
        System.out.println(deque);
        System.out.println(selectLess(deque,5));

    }
}

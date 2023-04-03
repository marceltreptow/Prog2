package set07;

import java.util.Arrays;
import java.util.Iterator;

public class MyDeque <T extends Comparable<T>> {
    private Object[] array;
    private int lastpointer = Integer.MAX_VALUE;
    private int firstpointer = Integer.MIN_VALUE;

    public <T> MyDeque(int capacity) {
        array = (T[]) new Object[capacity];

    }

    public boolean isEmptyCalculator(int start, int end) {
        int counter = start;
        if (array[counter] == null) {
            if (counter != end) {
                if (counter != array.length - 1)
                    return isEmptyCalculator(counter + 1, end);
                else
                    return isEmptyCalculator(0, end);
            } else {
                return true;

            }
        } else
            return false;
    }

    public boolean isEmpty() {
        return isEmptyCalculator(firstpointer, lastpointer);

    }

    public boolean isFullCalculator(int start, int end) {
        int counter = start;
        if (array[counter] != null) {
            if (counter != end) {
                if (counter != array.length - 1)
                    return isFullCalculator(counter + 1, end);
                else
                    return isFullCalculator(0, end);
            } else {
                return true;

            }
        } else
            return false;

    }

    public boolean isFull() {
        return isFullCalculator(firstpointer, lastpointer);

    }

    public int sizeCalculator(int start, int end) {
        int counter = start;
        if (counter != end) {
            if (counter != array.length - 1) {
                if (array[counter] != null)
                    return sizeCalculator(counter + 1, end) + 1;
                else
                    return sizeCalculator(counter + 1, end);
            } else {
                if (array[counter] != null)
                    return sizeCalculator(0, end) + 1;
                else
                    return sizeCalculator(0, end);
            }
        } else {
            if (array[counter] != null)
                return +1;
            else
                return 0;
        }
    }

    public int size() {
        return sizeCalculator(firstpointer, lastpointer);

    }

    public int capacity() {
        return array.length;
    }

    public T get(int i) {
        if (i + firstpointer < array.length - 1)
            return (T) array[i += firstpointer];
        else
            return (T) array[i += firstpointer - array.length];

    }

    public void addFirst(T element) {
        if (firstpointer != Integer.MIN_VALUE) {
            if (firstpointer == 0)
                firstpointer = array.length - 1;
            else
                firstpointer--;
            if (firstpointer == lastpointer)
                removeLast();
        } else if (array[array.length - 1] == null)
            firstpointer = array.length - 1;
        else if (lastpointer != 0)
            firstpointer = lastpointer - 1;
        else
            firstpointer = array.length - 1;
        array[firstpointer] = element;
    }

    public T getFirst() {
        return (T) array[firstpointer];

    }

    public T removeFirst() {
        T element = (T) array[firstpointer];
        array[firstpointer] = null;
        if (firstpointer == array.length - 1)
            firstpointer = 0;
        else
            firstpointer++;
        if (lastpointer == firstpointer) {
            if (lastpointer == array.length - 1)
                lastpointer = 0;
            else
                lastpointer++;

        }
        return (T) element;

    }

    public void addLast(T element) {
        if (lastpointer != Integer.MAX_VALUE) {
            if (lastpointer == array.length - 1)
                lastpointer = 0;
            else
                lastpointer++;
            if (lastpointer == firstpointer)
                removeFirst();
            array[lastpointer] = element;
        } else if (array[0] == null) {
            lastpointer = 0;
        } else if (firstpointer != array.length - 1)
            lastpointer = firstpointer + 1;
        else
            lastpointer = 0;
        array[lastpointer] = element;

    }

    public T getLast() {
        return (T) array[lastpointer];

    }

    public T removeLast() {
        T element = (T) array[lastpointer];
        array[lastpointer] = null;
        if (lastpointer == 0)
            lastpointer = array.length - 1;
        else
            lastpointer--;
        if (lastpointer == firstpointer) {
            if (firstpointer == 0)
                firstpointer = array.length - 1;
            else
                firstpointer--;
        }
        return (T) element;

    }

    @Override
    public String toString() {
        /*Object[] sortarray = new Object[array.length];
        Iterator myiterator = iterator();
        for (int i = 0; myiterator.hasNext(); i++) {
            sortarray[i] = (T) myiterator.next();
        }*/

        return "MyDeque{" +
                "array=" + Arrays.toString(array) +//Arrays.toString(Arrays.stream(sortarray).filter(Objects::nonNull).toArray())
                ", lastpointer=" + lastpointer +
                ", firstpointer=" + firstpointer +
                '}';
    }

    public Iterator iterator() {
        return new Iterator() {
            int counter = checkfirstpointer();
            int end = checklastpointer();

            public boolean hasNext() {

                if (counter != end) {
                    if (counter == array.length - 1) {
                        counter = 0;
                        return true;

                    } else {
                        counter++;
                        return true;
                    }
                } else
                    return false;

            }

            @Override
            public T next() {
                return (T) array[counter];
            }

        };
    }

    public int checkfirstpointer() {
        int i = firstpointer;
        if (firstpointer == Integer.MIN_VALUE) {
            if (lastpointer != array.length - 1)
                i = lastpointer + 1;
            else
                i = 0;
        }
        return i;

    }

    public int checklastpointer() {
        int i = lastpointer;
        if (lastpointer == Integer.MAX_VALUE) {
            if (firstpointer != 0)
                i = firstpointer - 1;
            else
                i = array.length - 1;
        }
        return i;
    }
}


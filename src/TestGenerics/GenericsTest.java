package TestGenerics;

import java.util.*;

public class GenericsTest {

    public static boolean hasEvenSize(Collection<?> container){
        return container.size() % 2 == 0;

    }

    public static int countOccurences(Collection<?> container, Object element){
        int count = 0;
        for (Object el: container){
            if (Objects.equals(el,element))
                count++;

        }
        return count;

    }

    public static double computeAverage(List<? extends Number> numbers){
        double result = 0;
        for (Number number : numbers){
            result+= number.doubleValue();

        }
        // numbers.add(43); //Dafür muss extends zu super geändert werden
        return result / numbers.size();

    }

    public static <T> T chooseByRandom(T... args){
        return args[new Random().nextInt(args.length)];

    }

    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T element){
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            int mid = (left + right) / 2;
            int res = list.get(mid).compareTo(element);
            if(res < 0)
                left = mid + 1;
            else if(res > 0)
                right = mid - 1;
            else if (list. get(mid).equals((element)))
                return mid;
            else
                throw new IllegalStateException("Order not total");
        }
        return -1;


    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A","B","C"));

        //Die Länge der Liste ist gerade
        System.out.println(hasEvenSize(list));

        //Wie häufig kommt ein Objekt vor
        System.out.println(countOccurences(list,"A"));

        //Den Durchschnitt der Liste berechnen
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(computeAverage(list1));

        //Welche Zueweisung ist erlaubt?
        List<?> lx;
        List<? extends Number> ln = new ArrayList<Integer>();
        lx = ln;
        //ln = lx;

        //Binär Objekte in Listen finden
        System.out.println(chooseByRandom("A","B","C"));
        System.out.println((binarySearch(Arrays.asList("A","B","C"),"A")));
        System.out.println((binarySearch(Arrays.asList("A","B","C"),"D")));
    }

    /*
    Allgemeine MySortedList

    class MySortedList<T extends Comparable<T>>{
    ...
        public boolean add(T el){...xy.compareTo(el)...}

     class Person implements Comparable<Person>{
        public int compareTo(Person p2) {}

     }

     MySortedList<Person> = xy... //Ja! Funktioniert!

     //Für student (extends Person):
     class Student extends Person {...}

     MySortedList<student> = xy... //Nein, funktioniert nicht!

     //Lösung
     class MySortedList<T extends Comparable<? super T>>{
    ...
     */
}

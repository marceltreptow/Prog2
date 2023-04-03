package set04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static String addElements(List<Integer> list, int count){
        long current = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
            list.add(12);

        return + count + " Elemente hinzugefügt in " + ((System.currentTimeMillis() - current) / 1000.0) + " Sekunden";

    }

    public static String addElementsAtStart(List<Integer> list, int count){
        long current = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
            list.add(0,12);

        return + count + " Elemente am Anfang hinzugefügt in " + ((System.currentTimeMillis() - current) / 1000.0) + " Sekunden";
    }

    public static String accessSpeed(List<Integer> list){
        long current = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++){
            list.get(i);

        }
        return " Alle Elemte aufgerufen in " + ((System.currentTimeMillis() - current) / 1000.0) + " Sekunden";

    }

    public static String iteratorAccessSpeed(Iterator<Integer> iterator){
        long current = System.currentTimeMillis();
        while (iterator.hasNext()){
            iterator.next();

        }
        return "Alle Elemente mit einem Iterator aufgerufen in " + ((System.currentTimeMillis() - current) / 1000.0) + " Sekunden";

    }



    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Arraylist: " + addElements(arrayList,50000));
        System.out.println("LinkedList: " + addElements(linkedList,50000));

        System.out.println("Arraylist: " + addElementsAtStart(arrayList,50));
        System.out.println("LinkedList: " + addElementsAtStart(linkedList,50));

        System.out.println("Arraylist: " + accessSpeed(arrayList));
        System.out.println("LinkedList: " + accessSpeed(linkedList));

        Iterator<Integer> integerIterator1 = arrayList.iterator();
        Iterator<Integer> integerIterator2 = linkedList.iterator();
        System.out.println("Arraylist: " + iteratorAccessSpeed(integerIterator1));
        System.out.println("LinkedList: " + iteratorAccessSpeed(integerIterator2));


    }
}

package Test;

import java.util.*;

public class NameSorter {
    private ArrayList list = new ArrayList<String>();
    static private Scanner scan = new Scanner(System.in);

    public void readNames() {
        list.clear();
        while(true) {
            System.out.println("Name: ");
            String name = scan.nextLine();
            if (name.isEmpty())
                break;
            list.add(name);

        }
    }

    public void sortNames(){
        Collections.sort(list);

    }

    public void print() {
        for (Object name: list)
            System.out.print(name+ " - ");

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A","B","C","D"));

        Iterator<String> it = list.iterator();

        // list.remove(0); ERROR!

        /* Schmirrt so ab!
        it.next();
        it.next();
        it.remove();
        it.remove();
        */
        while(it.hasNext()){
            System.out.print(it.next() + " ");

        }
        System.out.println();

        for(String name : list)
            System.out.print(name + " ");
        System.out.println();

        NameSorter n = new NameSorter();
        n.readNames();
        n.print();
        n.sortNames();
        n.print();

    }
}

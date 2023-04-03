package TestIterator;

import java.util.*;

public class NameSorter {

    private ArrayList<String> names = new ArrayList<>();
    static private Scanner scanner = new Scanner(System.in);

    public void readNames() {
        names.clear();
        System.out.println("Gib Namen ein (Leerzeile für Eingabeende):");
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty())
                break;
            names.add(name);
        }
    }

    public void sortNames() {
        Collections.sort(names);
    }

    public void printNames() {
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A", "B", "C", "D"));
        Iterator<String> it = list.iterator();

        list.remove(0);
        /*
        it.next();
        it.next();
        it.remove();
        it.remove();
        */

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String name : list)
            System.out.println(name);



        NameSorter ns = new NameSorter();
        ns.readNames();
        ns.sortNames();
        ns.printNames();
    }
}

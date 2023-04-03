package TestIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

// Ausrüstungsplanung für Reise
public class Gegenstand implements Comparable<Gegenstand> {

    private final String name;
    private final int gewicht; // in kg

    public Gegenstand(String name, int gewicht) {
        this.name = name;
        this.gewicht = gewicht;
    }

    public String getName() {
        return name;
    }

    public int getGewicht() {
        return gewicht;
    }

    public String toString() {
        return name + "(" + gewicht + "kg)";
    }

    @Override
    public int compareTo(Gegenstand o) {
        return name.compareTo(o.getName());
    }


    public static void print(final List<Gegenstand> gegenstaende) {
        // gegenstaende = new ArrayList<>(); verhindert durch final!
        //gegenstaende.remove(0); // Laufzeitfehler wegen unmodif...
        System.out.println(gegenstaende);
    }

    public static void main(String[] args) {
        ArrayList<Gegenstand> ausruestung = new ArrayList<>();
        ausruestung.add(new Gegenstand("Grill", 2));
        ausruestung.add(new Gegenstand("Taschenlampe", 1));
        ausruestung.add(new Gegenstand("Kasten Bier", 12));
        ausruestung.add(new Gegenstand("Zelt", 5));

        print(Collections.unmodifiableList(ausruestung));
        //System.out.println(Collections.binarySearch(ausruestung, new Gegenstand("Taschenlampe", 1))); // ???
        Collections.sort(ausruestung);
        System.out.println(ausruestung);
        Collections.sort(ausruestung, new GegenstandComparator());
        System.out.println(ausruestung);
        System.out.println(Collections.max(ausruestung));

        TreeSet<Gegenstand> gegenstaende = new TreeSet<>();
        gegenstaende.addAll(ausruestung);
        System.out.println(gegenstaende);

    }


}

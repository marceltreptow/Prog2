package Test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Gegenstand implements Comparable<Gegenstand>{
    private final String name;
    private final int gewicht;

    public Gegenstand(String name, int gewicht){
        this.name = name;
        this.gewicht = gewicht;

    }

    public String getName() {
        return name;
    }

    public int getGewicht() {
        return gewicht;

    }

    public String toString(){
        return name + "(" + gewicht + " kg)";

    }

    @Override
    public int compareTo(Gegenstand o) {    //Default Sortierung
        return name.compareTo(o.getName());

    }

    public static void print(List<Gegenstand> gegenstands){
        //gegenstands = new ArrayList<>(); // verhindert durch final!
        gegenstands.remove(0);
        System.out.println(gegenstands);

    }

    public static void main(String[] args) {

        ArrayList<Gegenstand> ausruestung = new ArrayList<>();
        ausruestung.add(new Gegenstand("Zelt",2));
        ausruestung.add(new Gegenstand("Vodka",1));
        ausruestung.add(new Gegenstand("Mehr Bier",12));
        ausruestung.add(new Gegenstand("Bier",12));

        print(Collections.unmodifiableList(ausruestung));   //nicht veränderbar in der Methode
        System.out.println(Collections.binarySearch(ausruestung,new Gegenstand("Zelt",2))); // ist Zelt inhalten (funktioniert nicht)
        Collections.sort(ausruestung);      //ausrüstung sortiert
        System.out.println(ausruestung.toString());
        Collections.sort(ausruestung, new GegenstandComparator());  //Ausrüstung nach Gegenstandcomparator sortiert
        System.out.println(ausruestung.toString());
        System.out.println(Collections.max(ausruestung));

    }
}

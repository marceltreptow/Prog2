package Test1;

import java.util.Comparator;

public class GegenstandComparator implements Comparator<Gegenstand> {

    @Override
    public int compare(Gegenstand o1, Gegenstand o2) {
        return -Integer.compare(o1.getGewicht(),o2.getGewicht());

    }
}

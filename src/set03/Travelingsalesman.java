package set03;

import java.util.Scanner;

public class Travelingsalesman {

    public static void print(Sequence sequence){
        while (sequence.hasnextRoute()){
            System.out.println("Die berechnete Route braucht " + sequence.nextTime() + " Felder für einen Kreislauf");
            System.out.println(intPrint(sequence.nextRouteSequence(),sequence.getLocations()));

        }
    }

    public static StringBuffer intPrint(int[] route, Location[] locations) {
        StringBuffer buffer = new StringBuffer();
        for(int i : route)
            buffer.append(locations[i].getName() + ", ");

        return buffer;
    }

    public void startGreedy(Location[] locations){
        Sequence s1 = new GreedyAlgorhytmus(locations);
        print(s1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Location[] locations;

        System.out.println("TravelingSalesMan Problem:\nWähle zwischen 1 und 3");
        switch (scanner.nextInt()){
            case 1:
                locations = new Location[]{new Location("A", 2, 1),
                        new Location("B", 1, 1),
                        new Location("C", 1, 2),
                        new Location("D", 1, 3),
                        new Location("E", 2, 1),
                        new Location("F", 2, 2),
                        new Location("G", 2, 3)};
                new Travelingsalesman().startGreedy(locations);
                break;

            case 2:
                locations = new Location[]{new Location("A", 1, 1),
                        new Location("B", 1, 2),
                        new Location("C", 1, 3),
                        new Location("D", 1, 4),
                        new Location("E", 2, 2),
                        new Location("F", 2, 3),
                        new Location("G", 4, 1),
                        new Location("H", 4, 4),
                        new Location("I", 4, 5),
                        new Location("J", 4, 6),
                        new Location("K", 4, 7)};
                new Travelingsalesman().startGreedy(locations);
                break;

            case 3:
                locations = new Location[]{new Location("A", 1, 1),
                        new Location("B", 1, 2),
                        new Location("C", 1, 3),
                        new Location("D", 1, 4),
                        new Location("E", 2, 2),
                        new Location("F", 2, 3),
                        new Location("G", 4, 1),
                        new Location("H", 4, 4),
                        new Location("I", 4, 5),
                        new Location("J", 4, 6),
                        new Location("K", 4, 7),
                        new Location("L", 5, 1),
                        new Location("M", 5, 4),
                        new Location("N", 5, 5),
                        new Location("O", 5, 6)};
                new Travelingsalesman().startGreedy(locations);
                break;
        }
    }
}

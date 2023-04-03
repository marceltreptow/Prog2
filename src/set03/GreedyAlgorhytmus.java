package set03;

import java.util.ArrayList;

public class GreedyAlgorhytmus extends Sequence {
    private Location[] locations;
    private int[] sequence;

    public GreedyAlgorhytmus (Location[] locations){
        super(locations);
        this.locations = locations;
        sequence = new int[locations.length];

    }

    @Override
    public int[] nextRouteSequence() {
        return sequence;

    }

    @Override
    public boolean hasnextRoute() {
        int bestway;
        ArrayList<Integer> useable = new ArrayList<>();
        /*for (int i = 0; i < locations.length; i++){
            useable.add(i);

        }*/

        if (sequence[0] == 0 && sequence[1] == 0){
            for (int i = 0; i < locations.length-1; i++){
                    bestway = sequence[i];
                for (int a = 0; a < locations.length; a++){
                    boolean next = true;
                    for (int b = 0; b <= i; b++){
                        if(sequence[b] == a)
                            next = false;

                    }
                    if (next)
                        if(locations[sequence[i]].getDistance(locations[a]) < locations[sequence[i]].getDistance(locations[bestway]) || bestway == sequence[i])
                            bestway = a;

                }
                sequence[i+1] = bestway;

            }
            return true;

        } else
            return false;

    }
}

package set03;

public class Route {
    private int[] sequence;
    private Location[] locations;


    public Route (Location[] locations, int[] sequence){
        this.locations = locations;
        this.sequence = sequence;

    }

    public double routeDuration(){
        double result = 0;
        for (int i = 0; i < sequence.length; i++){
            if(i != sequence.length-1)
                result += locations[sequence[i]].getDistance(locations[sequence[i+1]]);
            else
                result += locations[sequence[i]].getDistance(locations[sequence[0]]);

        }
        return result;

    }
}

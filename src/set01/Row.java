package set01;

public class Row {
    private int[] row = new int[7];

    public void fillfield(int assignment, int place){
        row[place] = assignment;

    }

    public int getRowassignment(int place) {
        return row[place];

    }
}

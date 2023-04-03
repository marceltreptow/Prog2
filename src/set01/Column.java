package set01;

public class Column {
    private int height = 0;

    public boolean puton() {
        if (height < 6) {
            height++;
            return false;

        } else
        return true;

    }

    public int getHeight() {
        return height-1;

    }
}

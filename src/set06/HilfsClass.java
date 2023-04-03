package set06;

public class HilfsClass {
    private int count = 1;
    private String word;

    public HilfsClass(String word) {
        this.word = word;

    }

    public int getCount() {
        return count;

    }

    public String getWord() {
        return word;

    }

    public void countUp(){
        count++;

    }
}

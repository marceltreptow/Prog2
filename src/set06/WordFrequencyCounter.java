package set06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WordFrequencyCounter implements Comparator<HilfsClass>{
    private ArrayList<HilfsClass> arrayList = new ArrayList();

    public void analyzeText(File textFile) {
        try {
            BufferedReader in =
                    new BufferedReader(new FileReader(textFile));
// Iterate through each line of the file
            while (true) {
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error occurred while reading from "
                            + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }

    private void analyzeLine(String line) {
        BetterStringTokenizer stringTokenizer = new BetterStringTokenizer(line);

        boolean didcountup = false;
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            for (int i = 0; i < arrayList.size(); i++){
                if(arrayList.get(i).getWord().compareTo(word) == 0) {
                    arrayList.get(i).countUp();
                    didcountup = true;

                }
            }
            if(!didcountup) {
                arrayList.add(new HilfsClass(word));
                didcountup = false;

            }
        }
    }

    @Override
    public int compare(HilfsClass o1, HilfsClass o2) {;
        return o2.getCount() - o1.getCount();

    }

    public void printResults(){
        arrayList.sort(Comparator.comparing(HilfsClass::getCount).reversed());
        for(int i = 0; i < arrayList.size(); i++){
            System.out.printf("%10s : %3d ", arrayList.get(i).getWord(), arrayList.get(i).getCount());
            if((i+1) % 5 == 0)
                System.out.println();


        }
    }

    public static void main(String[] args) throws IOException {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("src/data/Song.txt"));
        counter.printResults();

    }
}
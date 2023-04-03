package KlausurTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Filewriter {


    public static void main(String[] args) {
        List<Integer> arrayList2 = Arrays.asList(1,2,7,4,5,6);
        Collections.sort(arrayList2,(x,y) -> x.compareTo(y));
        arrayList2.sort((x,y) -> -x.compareTo(y));
        System.out.println(arrayList2);
        System.out.println(arrayList2.stream().filter(x -> x < 5).findAny());
        System.out.println(arrayList2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("yeet");
        arrayList.set(0,"Hure");
        Iterator iterator = arrayList.iterator();
        System.out.println(arrayList);
        try {
            saveToVsvFile(new File(""));
            throw new Exception("JÄGERMEISTER");
        } catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void saveToVsvFile(File file) {


    }
}

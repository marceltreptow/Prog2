package Test;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        String[] strArr = new String[]{"A", "B"};
        Object[] objArr = new Object[]{new Object(), new Object()};

        // strArr = objArr; // geht nicht
        objArr = strArr;
        objArr[0] = new Object();

        ArrayList<String> strArrL = new ArrayList<>();
        ArrayList<Object> objArrL = new ArrayList<>();

        //strArrL = objArrL; // Error, logisch!
        //objArrL = strArrL; // Error, huch!

        strArrL.add("e");
        System.out.println(strArrL.size());


    }
}

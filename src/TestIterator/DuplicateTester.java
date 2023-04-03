package TestIterator;

import java.util.*;

public class DuplicateTester {

    // Variante mit O(n^2)
    public boolean containsDuplicates(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            for (int j = i + 1; j < list.size(); j++)
                if (obj.equals(list.get(j)))
                    return true;
        }
        return false;
    }

    // Variante mit O(n)
    public boolean containsDuplicates2(List<Object> list) {
        Set<Object> set = new HashSet<>();
        for (Object obj : list) {
            if (set.contains(obj))
                return true;
            set.add(obj);
        }
        return false;
    }

    // Variante mit O(n)
    public boolean containsDuplicates3(List<Object> list) {
        Set<Object> set = new TreeSet<>();
        for (Object obj : list) {
            if (!set.add(obj))
                return true;
        }
        return false;
    }

    // Variante mit O(n)
    public boolean containsDuplicates4(List<Object> list) {
        Set<Object> set = new HashSet<>(list);
        return list.size() > set.size();
    }

    public static void main(String[] args) {
        DuplicateTester tester = new DuplicateTester();
        System.out.println(tester.containsDuplicates2
                (Arrays.asList("A", "B", "C"))); // false
        System.out.println(tester.containsDuplicates2
                (Arrays.asList("A", "B", "C", "A"))); // true


        Map<String, String> map = new HashMap<>();
        map.put("A","A1");

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
    }
}

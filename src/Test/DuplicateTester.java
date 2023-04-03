package Test;

import java.util.*;

public class DuplicateTester {

    public boolean containsDuplicates(List<Object> list){
        for(int i = 0; i <list.size(); i++){
            Object obj = list.get(i);
            for (int j = i+1; j < list.size(); j++){
                if(obj.equals(list.get(j)))
                    return true;

            }
        }
        return false;

    }

    public boolean containsDuplicates2(List<Object> list){
        Set<Object> set = new HashSet<>();
        for (Object obj : list){
            if(set.contains((obj)))
                return true;
            set.add(obj);

        }
        return false;

    }

    public boolean containsDuplicates3(List<Object> list){
        Set<Object> set = new HashSet<>();
        for (Object obj : list){
            if(!set.add(obj))
                return true;

        }
        return false;

    }

    public boolean containsDuplicates4(List<Object> list) {
        Set<Object> set = new HashSet<>(list);
        return list.size() > set.size();

    }

    public static void main(String[] args) {
        DuplicateTester tester = new DuplicateTester();
        System.out.println(tester.containsDuplicates(Arrays.asList("A","B","C")));
        System.out.println(tester.containsDuplicates2(Arrays.asList("A","B","C")));
        System.out.println(tester.containsDuplicates3(Arrays.asList("A","B","C")));
        System.out.println(tester.containsDuplicates4(Arrays.asList("A","B","C")));


        HashMap<String, String> map = new HashMap<>();
        map.put("A","A");

        Set<String> set =  new HashSet<>();
        set.add("A");
        set.add("B");

    }
}

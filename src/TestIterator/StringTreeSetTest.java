package TestIterator;

public class StringTreeSetTest {
    public static void main(String[] args) {
        StringTreeSet set = new StringTreeSet();
        System.out.println(set.add("B"));
        System.out.println(set.add("B"));
        System.out.println(set.add("A"));
        System.out.println(set.add("C"));
        System.out.println(set.add("D"));
        System.out.println(set.contains("D")); // true
        System.out.println(set.contains("E")); // false
        System.out.println(set.depth()); // 3

    }
}

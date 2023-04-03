package Test0422;

import java.util.*;

public class InnerClassTest { //Sortieren von Innerenobjekten in dieser Klasse
    public static void main(String[] args) {
        List<ZooTier> list = new ArrayList<>();
        list.add(new ZooTier("Flatter","Hurensohn","Tom"));
        list.add(new ZooTier("Hänno","Spandauianer","Spandau"));
        list.add(new ZooTier("Günther","Mensch","Unter der Brücke bei Tom"));

        ZooTier tier = new ZooTier("Flatter","Hurensohn","Tom");
        tier.setName("Klaus"); //Warum geht tier.setName("Klaus").setName("Anna"); nicht?;


        class MyComp implements Comparator<ZooTier> {
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.getName().compareTo(o2.getName());

            }
        }
        System.out.println(list);
        list.sort(new MyComp());
        System.out.println(list);

        list.sort(new Comparator<ZooTier>() { //Nicht so schön
            @Override
            public int compare(ZooTier o1, ZooTier o2) {
                return -o1.getName().compareTo(o2.getName());

            }
        });

        System.out.println(list);
        list.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        //Mit Lambfa-Ausdruck   mit Methodenreferenz
        //(x,y) -> Math.max(x,y)    Math::max
        //tier -> tier.getName()    ZooTier::getName
        //x -> System.out.println(x)    System.out::println //vorsicht

        list.sort(Comparator.comparing(ZooTier::getGattung).reversed());
        System.out.println(list);

        list.forEach(System.out::println);

        list.stream().map(ZooTier::getHerkunft).distinct().sorted().forEach(System.out::println);

        System.out.println();
        Object[] objs = new Object[]{" ","1","3",null,2,'1'};
        Arrays.stream(objs).filter(Objects::nonNull).
                map(Object::toString).map(String::trim).
                filter(s -> !s.isEmpty()).map(Integer::parseInt).sorted().
                forEach(System.out::println);

    }

    public static class ZooTier implements Comparable<ZooTier>{
        private String name;
        private final String gattung;
        private final String herkunft;

        public ZooTier(String name, String gattung, String herkunft) {
            this.name = name;
            this.gattung = gattung;
            this.herkunft = herkunft;
        }

        public String getName() {
            return name;
        }


        public String getGattung() {
            return gattung;
        }


        public String getHerkunft() {
            return herkunft;
        }

        @Override
        public String toString() {
            return "ZooTier{" +
                    "name='" + name + '\'' +
                    ", gattung='" + gattung + '\'' +
                    ", herkunft='" + herkunft + '\'' +
                    '}';
        }

        public void setName(String name) {
            this.name = name;

        }

        @Override
        public int compareTo(ZooTier o) {
            return this.getName().compareTo(o.getName());
        }
    }
}

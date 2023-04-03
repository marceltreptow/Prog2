package set04;

public class TrainTest {
    public static void main(String[] args) {
        Train train1 = new Train(new Locomotive(0,5311,"Big Chief"),"Santa Fe");
        train1.add(0,new Car(12,50));
        train1.add(1,new Car(15,75));
        train1.add(2,new Car(20,100));
        System.out.println(train1.toString());

        Train train2 = new Train(new Locomotive(21,5409,"Steel Horse"),"Rio Grande Express");
        train2.add(0,new Car(13,60));
        train2.add(1,new Car(18,80));
        System.out.println(train2.toString());

        System.out.println(train2.relink(train1).toString());
        System.out.println(train2.toString());

        train2.revert();
        System.out.println(train2.toString());
    }
}

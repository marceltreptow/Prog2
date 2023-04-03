package set02;

public class Sequencetest {
    public static void println(Sequence s){
        for (int i = 0; i < 10; i++) {
            if (s.hasNext())
                System.out.print(s.nextElemnt() + ", ");
            else {
                System.out.println(" ... ");
                return;

            }
        }
        System.out.println(" ... ");

    }

    public static void main(String[] args) {
        Sequence n1 = new Naturals();
        System.out.println("Natürliche Zahlen: ");
        println(n1);
        System.out.println("Natürliche Zahlen zwischen 7 und 14: ");
        println(new Range(7,14));
        System.out.println("Gerade Zahlen zwischen 7 und 14: ");
        println(new Evens(new Range(2,14)));
        System.out.println("Zahlen, die zwischen 2 und 14 sind und sich durch 3 teilen lassen: ");
        println(new ZapMultiples(new Range(2,14),3));
        System.out.println("Primzahlen zwischen 3 und 20: ");
        println(new PrimeNumbers(new Range(3,20)));

    }
}

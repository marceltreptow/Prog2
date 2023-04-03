package set05;

public class TonksTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        TonkList tanklist = new TonkList();
        tanklist.add(new CuboidTank(1,3,4));
        tanklist.add(new SphericalTank(4));
        tanklist.add(new CylindricalTank(3,4));
        System.out.println(tanklist.toString());

        TonkList tanklistclone = tanklist.clone();
        TonkIterator tonkIterator = new TonkIterator(tanklist);
        tonkIterator.remove();
        System.out.println(tanklist.toString());
        System.out.println(tanklistclone.toString());

    }
}

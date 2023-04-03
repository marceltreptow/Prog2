package set04;

public class Train {
    private Locomotive locomotive;
    private String name;

    public Train(Locomotive locomotive, String name) {
        this.locomotive = locomotive;
        this.name = name;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public boolean hasCars (){
        return locomotive.getFirst() != null;

    }

    public boolean add(int position, Car newcar){
        if (position == 0) {
            if(locomotive.getFirst() == null) {
                locomotive.setFirst(newcar);
                return true;
            } else {
                newcar.setNext(locomotive.getFirst());
                locomotive.setFirst(newcar);
                return true;

            }
        }

        if(locomotive.getFirst() == null)
            return false;
        Car next = locomotive.getFirst();

        while (position > 1){
            position--;
            if(next.getNext() == null)
                return false;
            next = next.getNext();

        }
        if (next.getNext() == null){
            next.setNext(newcar);
            return true;

        } else {
            newcar.setNext(next.getNext());
            next.setNext(newcar);
            return true;

        }
    }

    public int getPassengers(){
        Car next = locomotive.getFirst();
        int result = 0;
        while (next != null){
            result +=  next.getPassengers();
            next = next.getNext();

        }
        return result;

    }

    public int getLength(){
        Car next = locomotive.getFirst();
        int result = locomotive.getLength();
        while (next != null){
            result +=  next.getLength();
            next = next.getNext();

        }
        return result;
    }

    public Car removeFirst(){
        Car replacedcar = locomotive.getFirst();
        locomotive.setFirst(locomotive.getFirst().getNext());
        return replacedcar;

    }

    public Train relink(Train train2){
        if (train2.hasCars()){
            int position = 1;
            Car last = locomotive.getFirst();
            while (last.getNext() != null){
                last = last.getNext();
                position++;

            }
            add(position++,train2.removeFirst());
            train2.locomotive.setFirst(null);
            return train2;

        }
        return null;

    }

    public void revert() {
        if(hasCars()) {
            if(locomotive.getFirst().getNext() != null) {
                Car next = locomotive.getFirst().getNext();
                locomotive.getFirst().setNext(null);
                Car first;
                while (next != null) {
                    try {
                    first = next.clone();
                    } catch (CloneNotSupportedException e) {
                        return;

                    }
                    add(0,first);
                    next = next.getNext();

                }
            }
        }
    }


    @Override
    public String toString() {
        return "Lokomotivtyp: " + getLocomotive().getType() + "\nPassagieranzahl: " + getPassengers() + "\nLänge: " + getLength();

    }
}

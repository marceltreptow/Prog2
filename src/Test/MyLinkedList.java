package Test;

public class MyLinkedList {
    private MyLinkedListNode first;
    private MyLinkedListNode last;
    private int size;
    private int modcount;

    public void add(Object item){
        MyLinkedListNode node = new MyLinkedListNode(item);
        if(isEmpty()){
            last = first = node;

        } else {
          node.setPre(last);
          last.setNext(node);

        }
        size++;
        modcount++;

    }

    public boolean isEmpty(){
        return size == 0;

    }

    public Object remove(){
        Object result = last.getItem();
        first = first.getPre();
        if(first == null)
            last = null;
        else
            first.setPre(null);
        size--;
        modcount++;
        return result;

    }

    public Object get(int index){
        MyLinkedListNode curr = first;
        return null;

    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());

    }
}

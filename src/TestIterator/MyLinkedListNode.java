package TestIterator;

class MyLinkedListNode {
    private MyLinkedListNode prev;
    private MyLinkedListNode next;
    private Object item;

    public MyLinkedListNode(Object item) {
        this.item = item;
    }

    public void setPrev(MyLinkedListNode prev) {
        this.prev = prev;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public MyLinkedListNode getPrev() {
        return prev;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public Object getItem() {
        return item;
    }

}

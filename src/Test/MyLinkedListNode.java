package Test;

class MyLinkedListNode {
    private MyLinkedListNode pre;
    private MyLinkedListNode next;
    private Object item;

    MyLinkedListNode(Object item){
        this.item = item;

    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public MyLinkedListNode getPre() {
        return pre;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    public void setPre(MyLinkedListNode pre) {
        this.pre = pre;
    }
}


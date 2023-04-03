package TreeSetTest;

public class StringTreeSetNode {
    private final String key;
    private StringTreeSetNode left;
    private StringTreeSetNode right;

    public StringTreeSetNode(String key){
        this.key = key;

    }

    public void setLeft(StringTreeSetNode left) {
        this.left = left;
    }

    public void setRight(StringTreeSetNode right) {
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public StringTreeSetNode getLeft() {
        return left;
    }

    public StringTreeSetNode getRight() {
        return right;

    }
}

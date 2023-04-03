package TestIterator;

public class StringTreeSet {

    private StringTreeSetNode root;

    public boolean add(String key) {
        if (root == null) {
            root = new StringTreeSetNode(key);
            return true;
        } else {
            return addNode(root, key);
        }
    }

    private boolean addNode(StringTreeSetNode curr, String key) {
        int compRes = curr.getKey().compareTo(key);
        if (compRes < 0) {
            if (curr.getRight() == null) {
                curr.setRight(new StringTreeSetNode(key));
                return true;
            } else
                return addNode(curr.getRight(), key);
        } else if (compRes > 0) {
            if (curr.getLeft() == null) {
                curr.setLeft(new StringTreeSetNode(key));
                return true;
            } else
                return addNode(curr.getLeft(), key);
        } else if (curr.getKey().equals(key)) {
            return false;
        } else { // will never happen with strings...
            throw new IllegalArgumentException("order must be total");
        }
    }

    public boolean contains(String key) {
        StringTreeSetNode curr = root;
        while (curr != null) {
            int compRes = curr.getKey().compareTo(key);
            if (compRes < 0)
                curr = curr.getRight();
            else if (compRes > 0)
                curr = curr.getLeft();
            else
                return true;
        }
        return false;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(StringTreeSetNode node) {
        if (node == null)
            return 0;
        else
            return Math.max(depth(node.getLeft()), depth(node.getRight())) + 1;
    }
}

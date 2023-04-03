package TreeSetTest;

public class StringTreeSet {
    private StringTreeSetNode root;

    public boolean add(String key){
        if(root == null) {
            root = new StringTreeSetNode(key);
            return true;

        } else {
            return addNode(root,key);

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

        } else if(curr.getKey().equals((key))){
            return false;

        } else {
            throw new IllegalArgumentException("order must be total");

        }
    }

    public boolean contains(String key) {
        StringTreeSetNode next = root;
        while (next != null){
            int comRes = next.getKey().compareTo(key);
            if(comRes < 0)
                next = next.getRight();
             else if(comRes > 0)
                next = next.getLeft();
            else
                return true;

        }
        return false;

    }

    public int depth(StringTreeSetNode node) {
        if (root == null)
            return 0;
        else
            return Math.max(depth(node.getLeft()), depth(node.getRight()) + 1);


    }

    public int depthCounter(StringTreeSetNode next, int i){
        if(next.getLeft() == null && next.getRight() == null){
            return i;
        } else if(next.getLeft() != null && next.getRight() == null) {
            return depthCounter(next.getLeft(), i++);

        } else if(next.getLeft() == null && next.getRight() != null){
            return depthCounter(next.getRight(), i++);

        } else {
            return Math.max(depthCounter(next.getRight(),i++), depthCounter(next.getLeft(),i++));
        }
    }
}

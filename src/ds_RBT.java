public class ds_RBT<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

    }
    private boolean isRed(Node x){
        if (x == null) return false;
        return x.color;
    }
    private int size(Node x){
        if (x == null) return 0;
        else return x.N;
    }
    public int size(){
         return size(root);
    }
    // h - относительно которого делается поворот
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(x.right);
        return x;
    }
    private Node root;

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(x.right);
        return x;
    }
    void flipColors(Node h){
        h.color = true;
        h.left.color = false;
        h.right.color = false;
    }
    public void put(Key key, Value val){
        root = put(root, key, val);
        root.color = false;
    }
    private Node put(Node h, Key key, Value val){
        if (h == null){
            return new Node(key, val, 1, true);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0)    h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return null; // hit && miss
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val; // hit
    }
}

import java.util.LinkedList;

public class ds_BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) return 0;
        else return n.N;
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

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return min(x.right);
    }

    /*      0 1 2 3 4  5  6
     * key = 3 5 7 9 11 15 19
     * inf(x) - max key, greater than x
     * sup(x) - min key, not smaller than x
     * rank(x) - num of keys, smaller than x
     *
     *   ex.
     *       rank(9) = 3
     *       select(5) = 15
     *       inf(8) = 7
     *       sup(8) = 9
     *
     *       inf(2) = null
     *       sup(20) = null
     *           S       inf(G) E
     *           /\
     *          E  Y
     *         /\
     *        A  R
     *       /\  /\
     *         C H
     * */

    public Key inf(Key key) {
        Node x = inf(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node inf(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return inf(x.left, key);
        Node t = inf(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key sup(Key key) {
        Node x = sup(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node sup(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return sup(x.right, key);
        Node t = sup(x.left, key);
        if (t != null) return t;
        else return x;
    }

    public int rank(Key key) {

        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.left == null) return x.right;
        x.left = delMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delMax() {
        root = delMin(root);
    }

    private Node delMax(Node x) {
        if (x.right == null) return x.left;
        x.right = delMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedList<Key> llq = new LinkedList<>();
        keys(root, llq, lo, hi);
        return llq;
    }

    private void keys(Node x, LinkedList<Key> llq, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, llq, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) llq.add(x.key);
        if (cmphi > 0) keys(x.right, llq, lo, hi);


    }


    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N; // количество узлов

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

    }


}

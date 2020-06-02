
public class LinearProbingHashtable<Key, Value> {

    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashtable(int cap) {
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
        this.M = cap;
    }

    public LinearProbingHashtable() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key null");
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    private void resize(int newSize) {
        LinearProbingHashtable<Key, Value> temp = new LinearProbingHashtable<>(newSize);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                temp.put(keys[i], vals[i]);
        }
        keys = temp.keys;
        vals = temp.vals;
        M = temp.M;
    }   // creating new ht

}

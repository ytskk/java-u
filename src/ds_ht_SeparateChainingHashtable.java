public class ds_ht_SeparateChainingHashtable<Key, Value> {

    private int M; // size
    private int N; // keys

    private ds_ht_SequentialSearchST<Key, Value>[] linkedLists;

    public ds_ht_SeparateChainingHashtable(int M) {
        this.M = M;
        linkedLists = (ds_ht_SequentialSearchST<Key, Value>[]) new ds_ht_SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            linkedLists[i] = new ds_ht_SequentialSearchST<>();
        }
    }

    // avgLength = N/M
    public Value get(Key key) {
        return (Value) linkedLists[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        linkedLists[hash(key)].put(key, val);
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

}

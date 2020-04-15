public class ds_MaxPQueue<Key extends Comparable<Key>> {

    int N = 0;
    int currCap = 2;
    private Key[] pq;

    public ds_MaxPQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public ds_MaxPQueue() {
        pq = (Key[]) new Comparable[currCap];
    }

    public void insert(Key v) {
        if (N == currCap - 2) resize(currCap *= 2);
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if (N > 0 && N == currCap / 4) resize(currCap /= 2);
        return max;
    }

    public Key delLast() {
        Key last = pq[N--];
        pq[N + 1] = null;
        return last;

    }

    public int deep() {
        int deep = 1;
        int k = 1;
        while (k < N) {
            k *= 2;
            deep += 1;
        }
        return deep;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j += 1;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Key peekMax() {
        return pq[1];
    }

    protected boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    protected void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;

    }

    protected void resize(int cap) {
        Key[] tmp = (Key[]) new Comparable[cap];
        for (int i = 1; i <= N; i++) tmp[i] = pq[i];
        pq = tmp;
    }


    public void printQueue() {
        for (int i = 1; i < N + 1; i++) {
            System.out.println("" + i + ": " + pq[i]);
        }
    }


}

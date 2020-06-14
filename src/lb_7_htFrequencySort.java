import java.util.Hashtable;

/* a = {1,2,5,67,3,76,8,3,2,2,7,8,9}
   sort(a)
   a = {2, 2, 2, 3, 3, 8, 8, 1, 5, 67, 76, 7, 9}
    key - elements
    val - frequency
 */
public class lb_7_htFrequencySort {

    private static Hashtable<Comparable, Integer> hashtable = new Hashtable<>();

    private static void map(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i += 1) {
            int val = hashtable.get(a[i]) == null ? 1 : hashtable.get(a[i]) + 1;
            hashtable.put(a[i], val);
        }
    } // filling ht

    private static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i += 1) {
            for (int j = i; j > 0 && over(arr[j], arr[j - 1]); j -= 1) {
                exch(arr, j, j - 1);
            }
        }
    }

    private static void exch(Comparable[] hashQueue, int i, int j) {
        Comparable t = hashQueue[i];
        hashQueue[i] = hashQueue[j];
        hashQueue[j] = t;
    }

    private static boolean over(Comparable a, Comparable b) {
        int A = hashtable.get(a);
        int B = hashtable.get(b);
        if (A > B) return true;
        else if (A < B) return false;
        else return a.compareTo(b) < 0; // b - a < 0 ? true : false
    }

    public static Comparable[] htFrequencySort(Comparable[] a) {
        map(a);
        sort(a);
        return a;
    }
}


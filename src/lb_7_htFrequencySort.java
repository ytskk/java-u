import java.util.Hashtable;

/* a = {1,2,5,67,3,76,8,3,2,2,7,8,9}
   sort(a)
   a = {2, 2, 2, 3, 3, 8, 8, 1, 5, 67, 76, 7, 9}
    keys - elements
    vals - frequency
 */
public class lb_7_htFrequencySort {

    private static Hashtable map(int[] a) {
        int N = a.length;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < N; i++) {
            int val = hashtable.get(a[i]) == null ? 1 : hashtable.get(a[i]) + 1;
            hashtable.put(a[i], val);
        }
        return hashtable;
    }


    public static void htFrequencySort(int[] a) {
        Hashtable<Integer, Integer> hashtable = map(a);
        //  sort(hashtable); // TODO
    }

}


public class ds_ht_HashtableClient {
    public static String generateRandomString(int length) {
        char[] a = new char[length];
        char[] alph = "йцукенгшщзхъфывапролджэячсмитьбю".toCharArray();
//        char[] alph_ = "йцукенгшщзхъфывапролджэячсмитьбю".toUpperCase().toCharArray();
//        a[0] = alph_[StdRandom.uniform(alph.length)];
        for (int i = 0; i < length; i++) {
            a[i] = alph[StdRandom.uniform(alph.length)];
        }
        return new String(a);
    }

    public static void main(String[] args) {
        int MAX = 2_000;
        ds_ht_SeparateChainingHashtable<String, Double> hashtable = new ds_ht_SeparateChainingHashtable<>(101501);
        System.out.println("*** Filling chaining ht");
        Stopwatch st = new Stopwatch();
        for (int i = 0; i < MAX; i++) {
            if (i % (MAX / 10) == 0)
                System.out.print('+');
            hashtable.put(generateRandomString(127), StdRandom.gaussian());
        }
        System.out.println("\n*** Elapsed time" + st.elapsedTime());

        LinearProbingHashtable<String, Double> lpHash = new LinearProbingHashtable<>();
        System.out.println("*** Filling lp ht");
        st = new Stopwatch();
        for (int i = 0; i < MAX; i++) {
            if (i % (MAX / 10) == 0)
                System.out.print('+');
            lpHash.put(generateRandomString(127), StdRandom.gaussian());
        }
        System.out.println("\n*** Elapsed time" + st.elapsedTime());

    }
}

public class StringSearchClient {

    public static String saltedRandomString(int n, int pos, String pat) {
        char[] alph = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        char[] pattern = pat.toCharArray();
        int M = pat.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; i += 1) {
            if (i == pos) {
                for (int j = 0; j < M; j++) {
                    ans[i + j] = pattern[j];
                }
                i += M - 1;
            } else ans[i] = alph[StdRandom.uniform(alph.length)];
        }
        return new String(ans);
    } // generate string with ans

    public static void main(String[] args) {
        String pat = "needleinahaystack";
        int N = 1_000_000_00;
        int R = 256;
        String txt = saltedRandomString(N, 175, pat);

        Stopwatch st;
        int pos_;

        st = new Stopwatch();
        pos_ = StringSearch.less_primitive_search(pat, txt);
        System.out.println("Found substring using less_primitive_search, elapsed time: " + st.elapsedTime() + "\npositon: " + pos_);

        st = new Stopwatch();
        int[][] dfa = StringSearch.detDFA(pat, R);
        pos_ = StringSearch.KMPSearch(pat, txt, dfa);
        System.out.println("Found substring using KMP, elapsed time: " + st.elapsedTime() + "\npositon: " + pos_);

        st = new Stopwatch();
        int[] right = StringSearch.getShifts(pat, R);
        pos_ = StringSearch.BMSearch(pat, txt, right);
        System.out.println("Found substring using Bayer-Moore, elapsed time: " + st.elapsedTime() + "\npositon: " + pos_);

    }
}

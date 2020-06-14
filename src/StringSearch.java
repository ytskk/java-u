public class StringSearch {

    public static int primitive_search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i < N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == M) return i; // hit

        }
        return N;
    }

    public static int less_primitive_search(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        else return N;
    }

    /*
     *     ababaaabbbabaaaabab
     * q0 q1
     * abbba
     *             a                             a,b
     *             |        qo        qo         |
     * (q0) -a-> (q1) -a-> (q2) -b-> (q3) -b-> (q4)
     *
     * DFA[][]
     *    a b
     * 0  1 0
     * 1  1 2
     * 2  0 3
     * 3  0 4
     * 4  5 0
     * 5  5 5
     *
     *
     * */

    public static int[][] detDFA(String pat, int R) {

        int M = pat.length();
        int[][] d = new int[R][M];
        d[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                d[c][j] = d[c][X];
            }
            d[pat.charAt(j)][j] = j + 1;
            X = d[pat.charAt(j)][X];
        }
        return d;
    }

    /**
     * Trace getDFA('abbba', 2)
     * d[2][5]
     * a b
     * 0 1 0
     * 1 1 2
     * 2 1 3
     * 3 1 4
     * 4 1 0
     * a a b b b a b b a b b a b b b a a a b b a b a a b a
     * 1 1 2 3 4 *
     */

    /*Knuth-Morris-Pratt*/
    public static int KMPSearch(String pat, String txt, int[][] dfa) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;
        else return N;
    }

    /*
     * Bayer-Moore
     * a a b b b a b b a b b a b b b a a a b b a b a a b a
     *                       a b b b a
     * */
    public static int[] getShifts(String pat, int R) {
        int M = pat.length();
        int[] right = new int[R];
        for (int c = 0; c < R; c += 1)
            right[c] -= 1;
        for (int j = 0; j < M; j += 1)
            right[pat.charAt(j)] = j;
        return right;
    }
    /*abcbcab R = 3
     * a b c
     * 5 6 4
     * abbabbcbbcbabcadcbcababbcbacbaac
     *            abcbcad
     * */

    public static int BMSearch(String pat, String txt, int[] right) {
        int N = txt.length(), M = pat.length();
        int skip;
        for (int i = 0; i < N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j -= 1) {
                if (pat.charAt(j) == txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return N;
    }

}

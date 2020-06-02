public class Alphabet {

    char[] alph;
    String alph_string;

    public Alphabet(String a) {
        alph = a.toCharArray();
        alph_string = a;
    }

    public char chr(int index) {
        return alph[index];
    }

    public int ord(char c) {
        return alph_string.indexOf(c);
    }

    public int R() {
        return alph.length;
    }
}

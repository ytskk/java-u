public class SearchClient {
    public static String generatedEvent() {
        /* types
         0. birthday date
         1. die date
         2. coming date
         3. exit date
         4. meeting date
         */
        int gender = StdRandom.uniform(2);
        int eventType = StdRandom.uniform(5);

        switch (eventType) {
            case 0:
                if (gender == 1)
                    return generateName(gender) + " родилась";
                else
                    return generateName(gender) + " родился";
            case 1:
                if (gender == 1)
                    return generateName(gender) + " умерла";
                else
                    return generateName(gender) + " умер";
            case 2:
                if (gender == 1)
                    return generateName(gender) + " пришла в " + generateRandomString();
                else
                    return generateName(gender) + " пришёл в " + generateRandomString();
            case 3:
                if (gender == 1)
                    return generateName(gender) + " ушла из " + generateRandomString();
                else
                    return generateName(gender) + " ущёл из " + generateRandomString();
            case 4:
                return generateName(StdRandom.uniform(2)) + " и " + generateName(StdRandom.uniform(2)) + " встретились";

        }
        return "";
    }

    public static String generateRandomString() {
        int length = StdRandom.uniform(4, 13);
        char[] a = new char[length];
        for (int i = 0; i < length; i++) {
            a[i] = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ".charAt(StdRandom.uniform(32));
        }
        return new String(a);
    }

    public static String generateName(int gender) {
        char[] vowels = "аеиоуяэыю".toCharArray();
        char[] consonants = "бвгджзклмнпрстфхцчшщ".toCharArray();
        String[] syllables = {"cv", "cvc", "vc", "ccv"};
        String[] suffixes = {"ов", "ев", "ин"};


        StringBuilder name = new StringBuilder();
        StringBuilder sunName = new StringBuilder();

        for (int i = 0; i < StdRandom.uniform(2, 3); i++) {
            char[] syl = syllables[StdRandom.uniform(4)].toCharArray();
            for (int j = 0; j < syl.length; j++) {
                if (syl[j] == 'c')
                    syl[j] = consonants[StdRandom.uniform(consonants.length)];
                else if (syl[j] == 'v')
                    syl[j] = vowels[StdRandom.uniform(vowels.length)];
            }
            name.append(new String(syl));
        }
        if (gender == 1) {
            name.append("a");
        } else
            name.append(consonants[StdRandom.uniform(consonants.length)]);
        name = new StringBuilder(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());

        // surnName
        for (int i = 0; i < StdRandom.uniform(1, 2); i++) {
            char[] syl = syllables[StdRandom.uniform(4)].toCharArray();
            for (int j = 0; j < syl.length; j++) {
                if (syl[j] == 'c')
                    syl[j] = consonants[StdRandom.uniform(consonants.length)];
                else if (syl[j] == 'v')
                    syl[j] = vowels[StdRandom.uniform(vowels.length)];
            }
            sunName.append(new String(syl));
        }
        if (gender == 1) {
            sunName.append(suffixes[StdRandom.uniform(suffixes.length)] + "a");
        } else
            sunName.append(sunName + suffixes[StdRandom.uniform(suffixes.length)]);
        sunName = new StringBuilder(sunName.substring(0, 1).toUpperCase() + sunName.substring(1).toLowerCase());

        return name + " " + sunName;
    }

    public static void main(String[] args) {
        ds_BST<Date_, String> bst = new ds_BST<>();
//
//        // test gen
//        for (int i = 0; i < 10; i++) {
//            System.out.println(generatedEvent());
//        }

        int MAX = 100_000;

        Stopwatch st = new Stopwatch();
        System.out.println("*** Building tree");
        for (int i = 0; i < MAX - 1; i++) {
            if (i % (MAX / 10) == 0) System.out.print('*');
            bst.put(new Date_(), generatedEvent());
        }

        Date_ d = new Date_();
        String event = generatedEvent();
        bst.put(d, event);
        System.out.println();
        System.out.println("*** Tree size (num of elements) " + bst.size() + " added for " + st.elapsedTime());
        System.out.println("*** Founding events by date \"" + d + "\"...");
//        Stopwatch st = new Stopwatch();

        String ev_ = bst.get(d);
        System.out.println("*** Event founded: " + ev_);
        System.out.println("*** Elapsed time: " + st.elapsedTime());
        Date_ lo = new Date_("1 января 2020 г.");
        Date_ hi = new Date_("13 апреля 2020 г.");
        System.out.println("*** Output result of serch in ...");
        for (Date_ a : bst.keys(lo, hi)) {
            System.out.println(a + ":\t" + bst.get(a));
        }


        /*
        for (int i = 0; i < MAX; i++) {
            if (i % (MAX/10) == 0) System.out.print('*');
            bst.put(StdRandom.uniform(1000000), StdRandom.uniform(1000000));
        }
        */

    }
}

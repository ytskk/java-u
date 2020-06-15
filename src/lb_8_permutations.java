public class lb_8_permutations {
    private Integer[] charIndexArray;

    public void print(String s) {
        char[] charArray = s.toCharArray();
        charIndexArray = new Integer[charArray.length];
        convertCharToInt(charArray, charIndexArray);
        sort_ShellSort sh = new sort_ShellSort();
        sh.sort(charIndexArray);
        nextStep(charIndexArray.clone(), 0);
    }

    public int getPermutationsFac(String str) {
        int num = getUniqueChar(str);
        int factorial = 1;
        while (num != 0) factorial *= num--;
        return factorial;
    }

    private int getUniqueChar(String test) {
        String temp = "";
        for (int i = 0; i < test.length(); i++) if (temp.indexOf(test.charAt(i)) == -1) temp += test.charAt(i);
        return temp.length();
    }


    private void nextStep(Integer[] a, int indexNow) {
        if (a.length == 1) {
            charIndexArray[indexNow] = a[0];
            printCharIndexArray(charIndexArray);
            return;
        }

        ds_BST<Integer, Integer> bst = new ds_BST<>();

        for (Integer integer : a) {
            if (bst.get(integer) != null)
                continue;
            charIndexArray[indexNow] = integer;
            nextStep(copyArray(a, integer), indexNow + 1);
            bst.put(integer, 1);
        }
    }

    private void printCharIndexArray(Integer[] a) {
        for (int unicode : a) System.out.print((char) unicode);
        System.out.println();
    }

    private void convertCharToInt(char[] charArray, Integer[] intArray) {
        for (int i = 0; i < charArray.length; i += 1) intArray[i] = (int) charArray[i];
    }

    private Integer[] copyArray(Integer[] a, int without) {
        Integer[] result = new Integer[a.length - 1];
        int i = 0;
        boolean alreadySkipped = false;
        for (Integer num : a) {
            if (without == num && !alreadySkipped) {
                alreadySkipped = true;
                continue;
            }

            result[i++] = num;
        }
        return result;
    }

    public void letTheChaosBegin(String str) {
        print(str);
    }
}

package learn;

public class Bit {

    public static int inBitOnes(int num) {
        int endNum;
        for (endNum = 0; num != 0; num >>= 1) {
            endNum += num & 1;
        }
        return endNum;
    }

    public static int inBitZeros(int num, String type) {
        if (num >= 0) {
            if (num == 0) {
                return 1;
            }
            int pow = 0;
            while (num >= Math.pow(2, pow))
                pow += 1;
            return type.equals("zeros") ? (pow - inBitOnes(num)) : type.equals("pow") ? pow : -1;
        } else
            throw new NumberFormatException("Try only positive numbers");
    }

    public static String intInBit(int number) {
        /// TEST ///
        if (number >= 0) {
            if (number == 0)
                return "0";
            StringBuilder str;

            for (str = new StringBuilder(); number != 0; number >>= 1) {
                str.append((number & 1) == 1 ? "1" : "0");
            }

            return str.reverse().toString();
        } else
            throw new NumberFormatException("Try only positive numbers");

    }
}

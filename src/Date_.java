import java.util.StringTokenizer;

public class Date_ implements Comparable<Date_> {

    private int day;
    private int month;
    private int year;
    private String[] names = {"нуября", "января", "февраля", "марта", "апреля", "мая",
            "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

    public Date_(int d, int m, int y) {

        int[] rules = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (y % 4 == 0) {
            rules[2] += 1;
        }

        if (m > 12 || m < 1 || d < 1 || d > rules[m]) {
            throw new IllegalArgumentException("Invalid");
        }

        this.day = d;
        this.month = m;
        this.year = y;

    }

    public Date_() {

        year = StdRandom.uniform(1570, 2500);
        int[] rules = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year % 4 == 0) {
            rules[2] += 1;
        }
        month = StdRandom.uniform(1, 13);
        day = StdRandom.uniform(1, rules[month] + 1);
    }

    public Date_(String rusDate) {
        // 26 jan 1970
        StringTokenizer st = new StringTokenizer(rusDate);

        String[] names = {"нуября", "января", "февраля", "марта", "апреля", "мая",
                "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

        if (st.countTokens() != 4) throw new StringIndexOutOfBoundsException("Bad date");

        int i = 0;
        while (st.hasMoreElements()) {
            String a = st.nextToken();
            switch (i) {

                case 0:
                    day = Integer.parseInt(a);
                    i += 1;
                    continue;
                case 1:
                    for (int j = 0; j < names.length; j++) {
                        if (a.equals(names[j])) {
                            month = j;
                        }
                    }
                    i += 1;
                    continue;
                case 2:
                    year = Integer.parseInt(a);
                    i += 1;
                    continue;
                case 3:
                    continue;


            }
            i += 1;
        }
    }

    public String toString() {
        String[] names = {"нуября", "января", "февраля", "марта", "апреля", "мая",
                "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

        return day + " " + names[month] + " " + year + "г.";
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return names[month];
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Date_ that) {
        if (this.year > that.year) return +1;
        if (this.year < that.year) return -1;

        if (this.month > that.month) return +1;
        if (this.month < that.month) return -1;

        if (this.day > that.day) return +1;
        if (this.day < that.day) return -1;

        return 0;
    }
}

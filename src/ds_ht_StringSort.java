/*
    Йяршквосушьлэзс	2           count[key + 1]++, count[3]
    Игызхеэкуцы	4
    Мапэдфдс	1
    Эмищьдуфмжуъ	5
    Зефтидржтфчм	1
    Бмычтмлхкюред	2
    Ьбхофчйцщьыяъ	2
    Айьащфшзтхщфщлшъ	1
    Цииъунвгтязнэъъг	2
    Эшйбкйскжефтэм	4
    Южзяьжщшлис	4
    Знхыдюдбе	1
    Эъздижд	2
    Щэздьжо	3
    Сапояыс	1
    Жцсухлж	1
    Ьррътъвэк	5
    Оььуфехщ	1
    Ощеижчтскщ	1
    Авнуакц	1
    Ьчыпаеогъянц	5
    Мюхюшэбайждечунщ	5
    Ьжджрюлщйьицд	4
    Зябэмял	1
    Янрлэраяврпдхзбв	3

    Метод распределяющего подсчёта:
        count[max+2]
                0   1   2   3   4   5   6
        count   0   0   10  5   2   4   4
        count[r+1] += count[r]
        count   0   0   10  15  17  21  25 = n

        Мапэдфдс	1
        Айьащфшзтхщфщлшъ	1
        Знхыдюдбе	1
        Сапояыс	1
        Жцсухлж	1
        Оььуфехщ	1
        Ощеижчтскщ	1
        Авнуакц	1
        Зябэмял	1
        Йяршквосушьлэзс	2
        Бмычтмлхкюред	2
        Ьбхофчйцщьыяъ	2
        Цииъунвгтязнэъъг	2
        Эъздижд	2
        Щэздьжо	3
        Янрлэраяврпдхзбв	3
        Игызхеэкуцы	4
        Эшйбкйскжефтэм	4
        Южзяьжщшлис	4
        Ьжджрюлщйьицд	4
        Эмищьдуфмжуъ	5
        Ьррътъвэк	5
        Ьчыпаеогъянц	5
        Мюхюшэбайждечунщ	5

* */

// ДОДЕЛАТЬ
public class ds_ht_StringSort {

    public static String generateString(int length) {
        char[] alph = "qwert".toCharArray();
        char[] alph_ = "QWERT".toUpperCase().toCharArray();
        char[] res = new char[length];
        res[0] = alph_[StdRandom.uniform(alph_.length)];
        for (int i = 1; i < length; i++) {
            res[i] = alph[StdRandom.uniform(alph.length)];
        }
        return new String(res);
    }


    public static void main(String[] args) {

        int MAX = 1_00000;
        String[] a = new String[MAX];
        System.out.println("*** Filling array");
        for (int i = 0; i < MAX; i++) {
            if (i % (MAX / 10) == 0) System.out.print('*');
            a[i] = generateString(7);
        }
        Stopwatch st = new Stopwatch();
        MSDSort.sort(a, 7);
        System.out.println("Elapsed time: " + st.elapsedTime());


    }
}

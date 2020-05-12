package Part3;
import java.util.Scanner;
public class Task8 {
    public static void main(String[] args) {
        System.out.println("Введите два числа");
        Scanner bc = new Scanner(System.in);
        long b = bc.nextLong(); // вводим первое число
        long c = bc.nextLong(); // вводим второе число
        long b1 = b;  //  вводим данные перменные
        long c1 = c;  //  чтобы не изменять b и с
        int lenb = (b == 0 ? 1 : 0); // кол-во цифр первого числа
        int lenc = (c == 0 ? 1 : 0); // кол-во цифр второго числа
        while (b1 != 0) {
            lenb++;
            b1 /= 10;
        }
        while (c1 != 0) {
            lenc++;
            c1 /= 10;
        }
        int maxlen = Math.max(lenb, lenc); // наибольшее кол-во цифр из двух чисел
        double bmas[] = new double[maxlen]; // вспомогательный массив чисел из первого числа
        double cmas[] = new double[maxlen]; // вспомогательный массив чисел из второго числа
        bmas[0] = b / (Math.pow(10, lenb - 1));
        bmas[0] = (int) bmas[0];
        cmas[0] = c / (Math.pow(10, lenc - 1));
        cmas[0] = (int) cmas[0];
        double bmasnew[] = new double[lenb]; // массив цифр, из которых состоит первое число
        double cmasnew[] = new double[lenc]; // массив цифр, из которых состоит второе число
        bmasnew[0] = bmas[0];
        cmasnew[0] = cmas[0];
        for (int i = 1; i < maxlen; i++) {
            bmas[i] = b / (Math.pow(10, lenb - 1 - i));
            bmas[i] = (int) bmas[i];
            bmasnew[i] = bmas[i] - bmas[i - 1] * 10;
            if (i == lenb - 1) {
                break;
            }
        }
        for (int j = 1; j < maxlen; j++) {
            cmas[j] = c / (Math.pow(10, lenc - 1 - j));
            cmas[j] = (int) cmas[j];
            cmasnew[j] = cmas[j] - cmas[j - 1] * 10;
            if (j == lenc - 1) {
                break;
            }
        }
        for (int g = 0; g <= 9; g++) {
            for (int f = 0; f < maxlen; f++) {
                for (double el : bmasnew) {
                    for (double ek : cmasnew) {
                        if (el == g && ek == g) {
                            System.out.println("В обоих числах содержится цифра " + g);
                            g++;
                        }
                    }
                }
            }
        }
    }
}

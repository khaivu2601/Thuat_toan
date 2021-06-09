import java.util.Scanner;

public class Thuat_Toan_KMP {
    public static int[] KMP(char[] x) {
        int[] kmpNext = new int[x.length + 1];
        int i = 0;
        int j = -1;
        kmpNext[0] = -1;
        while (i < x.length - 1) {
            while (j > -1 && x[i] != x[j]) {
                j = kmpNext[j];
            }
            i++;
            j++;
            if (x[i] == x[j]) {
                kmpNext[i] = kmpNext[j];
            } else {
                kmpNext[i] = j;
            }
        }
        return kmpNext;
    }
    public static void Ktra(char[] x, char[] y) {
        int[] kmpNext =KMP(x);
        int i = 0;
        int m = 0;
        while (m <= y.length - x.length) {
            if (x[i] == y[m + i]) {
                i++;
                if (i == x.length) {
                    System.out.print(m + "    ");
                    m = m + i - kmpNext[i];
                    i = kmpNext[i];
                }
            } else {
                m = m + i - kmpNext[i];
                i = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String x = "chiến sĩ";
        char[] X = x.toCharArray();
        String y = "người chiến sĩ cách mạng !";
        char[] Y = y.toCharArray();
        System.out.print("Các vị trí xuất hiện của x trong y là: ");
        Ktra(X, Y);
    }
}

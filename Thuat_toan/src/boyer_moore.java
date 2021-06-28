public class boyer_moore {
    public static int[] Boyer(char[] x) {
        int[] bc = new int[255];
        int m = x.length;
        for (int i = 0; i < 255; i++) {
            bc[i] = m;
        }
        for (int i = 0; i < m - 1; i++) {
            bc[(int) x[i]] = m - i - 1;
        }
        return bc;
    }
    public static void search(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int[] Boyer = Boyer(x);
        int shift = Boyer[x[m - 1]];
        Boyer[x[m - 1]] = 0;
        int i = 0;
        int k = 0;
        while (i <= n - m) {
            k = Boyer[y[i + m - 1]];
            while (k != 0) {
                i += k;
                k = Boyer[y[i + m - 1]];
                i += k;
                k = Boyer[y[i + m - 1]];
                i += k;
                k = Boyer[y[i + m - 1]];
            }
            if (cmp(x, y, i)) {
                System.out.println(i);
            }
            i += shift;
        }
    }
    public static boolean cmp(char[] x, char[] y, int y1) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[y1++]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[] x = "khaivu".toCharArray();
        char[] y = "ho ten toi la khaivu".toCharArray();
        System.out.print("vị trí xuất hiện trong văn bản của xâu mẫu là: ");
        search(x, y);
    }
}

public class KMP {
    public static int[] KMP(String x) {
        int[] kmpNext = new int[x.length() + 1];
        int i = 0;
        int j = -1;
        kmpNext[0] = -1;
        while (i < x.length() - 1) {
            while (j > -1 && x.charAt(i) != x.charAt(j)) {
                j = kmpNext[j];
            }
            i++;
            j++;
            if (x.charAt(i) == x.charAt(j)) {
                kmpNext[i] = kmpNext[j];
            } else {
                kmpNext[i] = j;
            }
        }

        return kmpNext;
    }
    public static void TimKiem(String x, String y) {
        int[] kmpNext = KMP(x);
        int i = 0,m=0;
        while (m <= y.length() - x.length()) {
            if (x.charAt(i) == y.charAt(m+i)) {
                i++;
                if (i == x.length()) {
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
    public static void function(String x){
        int i=1,j=0;
        int []lps=new int[225];
        while (i< x.length()){
            if(x.charAt(i)==x.charAt(j)){
                j+=1;
                lps[i]=j;
                i+=1;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    lps[i]=0;
                    i+=1;
                }
            }
        }
        System.out.println(lps);
    }
    public static void main(String[] args) {
        String x = "am";
        String y = "hom nay la thu nam khong phai ram";
        System.out.print("Các vị trí xuất hiện của x trong y là: ");
        TimKiem(x,y);
        System.out.println("");
        function(x);
    }
}

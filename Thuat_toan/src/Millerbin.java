import java.util.Scanner;

public class Millerbin extends BPL{
    public static void Miller(int n,int t) {
        int r=(n-1)/2;
        for (int i = 0; i < t; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * n-2 + 2;
            int a = (int) randomDouble;
            System.out.println("Random number a : " + a);
            int y = BPL(a, r, n);
            if (y != 1 && y != n - 1) {
                int j=1;
                while (j<=0 && y!=n-1){
                    y=BPL(y,2,n);
                    if(y==1){
                        System.out.println("hợp số");
                        j=j+1;
                    }
                    if(y!=n-1){
                        System.out.println("SNT");
                    }
                }

            }
            else{
                System.out.println("SNT");
            }
        }
    }
}

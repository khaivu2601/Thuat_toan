import java.util.Scanner;
import java.math.*;

public class b2 extends BPL{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập n");
        int n=sc.nextInt();
        System.out.println("nhập p 0<p<1");
        double p=sc.nextDouble();
        int r=(n-1)/2;
        int t= (int) (Math.log10(1-p)/Math.log10(0.25));
        System.out.println(t);
        for (int i = 0; i < t; i++) {
            System.out.println("nhập a");
            int a = sc.nextInt();
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

import java.math.BigInteger;
import java.util.Scanner;

public class Fermat_Rabin extends BPL{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập n");
        int n=sc.nextInt();
        System.out.println("nhập t");
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * n-2 + 2;
            int a = (int) randomDouble;
            System.out.println("Random number is : " + a);
            int r=BPL(a,n-1,n);
            if(r!=1){
                System.out.printf("%d là hợp số \n",n);
            }else
            {
                System.out.printf("%d là SNT \n",n);
            }
        }
    }
}

import java.math.BigInteger;
import java.util.Scanner;

public class BPL {
    public static int BPL(int a,int k,int n) {
        Scanner sc= new Scanner(System.in);
        int[] binary= new int[32];
        int exponent=k;// xác định số mũ
        int t=0;// số bit của k
        for(int i=0;k>0;i++){
            binary[i]=k%2;
            k/=2;
            t=i;
        }
        int b=1;
        if(exponent==0){
//            System.out.println("b= "+b);
           return b;
        }
        int A=a;
        if(binary[0]==1){
            b=a;
        }
        for(int i=1;i<=t;i++){
            A=(A*A)%n;
            if(binary[i]==1){
                b=(A*b)%n;
            }
        }
//       System.out.println("b="+b);
        return b;
    }
}

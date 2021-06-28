import java.util.Scanner;

import static java.lang.Math.*;

public class Pollards_Rho {
    static Scanner sc= new Scanner(System.in);
    public static int gcd(int a, int b){
        int c=0;
        a=abs(a);
        while (b>0){
            c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
    public static void Tinh(int a,int b,int n){
        while (true){
            a=(a*a+1)%n;
            b=(b*b+1)%n;
            b=(b*b+1)%n;
            int d=gcd(a-b,n);

            if (d>1&&d<n) {
                System.out.printf("thành công !!! %d",d);
                System.exit(1);
            }
            else
                if(d==n){
                System.out.println("fail!!1");
                break;
            }
        }
    }
    public static void main(String[] args) {
        int a=2,b=2;
        System.out.println("nhập n");
        int n=sc.nextInt();
        Tinh(a,b,n);

    }
}

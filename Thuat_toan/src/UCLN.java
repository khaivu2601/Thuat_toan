import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập a");
        int a=sc.nextInt();
        System.out.println("nhập b");
        int b=sc.nextInt();
        if(a<b){
            System.out.println("nhập lại b (b<=a)" );
            b=sc.nextInt();
        }
        System.out.printf("gcd(%d,%d) =",a,b);
        int c=0;
        while (b>0){
            c=a%b;
            a=b;
            b=c;
        }
        System.out.println(a);
    }
}

import java.util.Scanner;

public class Tamthuong {
    public int n,c;
    Scanner sc =new Scanner(System.in);

    public void input(){
        System.out.println("Nhap so nguyen can tim thua so nguyen to =");
        n=sc.nextInt();

    }
    public long uCLN(long a,long b){
        a=Math.abs(a);
        while (b>0){
            long r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public void pollardRho(){
        while (true){
            System.out.println("Nhap ham x^2 +c; c= ");
            c=sc.nextInt();
            long a=2;long b=2;
            while (true){
                a=(a*a+c)%n;//a=((a%n)*(a%n))

                b=(b*b+c)%n;

                b=(b*b+c)%n;

                long d;
                d=  uCLN(a-b,n);

                if(d>1&&d<n){
                    System.out.printf("Thua so khong tam thuong cua %d la: %d",n,d);
                    System.exit(1);
                }
                else if(d==n){
                    System.out.println("Ket thuc that bai! Nhap lai c");
                    break;
                }
            }
        }

    }
}

import java.util.Scanner;

public class Nghich_Dao_inFp {
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhập p:");
        long p=sc.nextLong();
        System.out.println("nhập a:");
        long a= sc.nextLong();
        if(a>p){
            System.out.println("nhập lại a nhỏ hơn p");
             a= sc.nextLong();
        }
        long u=a,v=p;
        int x1=1,x2=0;
        while(u!=1){
            int q= (int) (v/u),r= (int) (v%u);
            int x=x2-q*x1;
            v=u;u=r;x2=x1;x1=x;
        }
        System.out.printf("kq=");
        System.out.printf("%d",x1);
    }
}

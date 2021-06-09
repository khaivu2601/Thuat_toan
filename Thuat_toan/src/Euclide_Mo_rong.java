import java.util.Scanner;

public class Euclide_Mo_rong {
static     Scanner sc= new Scanner(System.in);
    public static int Tim_ucln(int a,int b,int c){
        while (b>0){
            c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
    public static void Euclide(int a,int b,int d){
        if(b==0){
            d=a;
            int x=1;
            int y=0;
            System.out.printf("(%d,%d,%d)",d,x,y);
        }else{
            int x2=1,x1=0,y2=0,y1=1;
            while(b>0){
                int q=a/b,r=a%b;
                int x=x2-q*x1;
                int y=y2-q*y1;
                a=b;b=r;x2=x1;x1=x;y2=y1;y1=y;
            }
            d=a;
            int x = x2;
            int y=y2;
            System.out.printf("(%d,%d,%d)",d,x,y);
        }

    }

    public static void main(String[] args) {
        System.out.println("nhập a");
        int a=sc.nextInt();
        System.out.println("nhập b");
        int b=sc.nextInt();
        if(a<b){
            System.out.println("nhập lại b (b<=a)" );
            b=sc.nextInt();
        }
        int c=0;
        int d=Tim_ucln(a,b,c);
        Euclide(a,b,d);
    }
}

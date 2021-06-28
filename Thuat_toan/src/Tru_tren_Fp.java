import java.util.Scanner;

import static java.lang.Math.pow;

public class Tru_tren_Fp {
    static Scanner sc= new Scanner(System.in);
    public static void Nhap(int a[],int n)
    {
        for (int i = 0; i <n; i++) {
            System.out.printf("nhập phần tử  thứ %d",i);
            System.out.printf("\t");
            a[i]=sc.nextInt();
        }
    }

    public static int Tinh(int c[],int a[],int b[],int n,int e,int w) {
        int epsilon=0;

        for (int i = n-1; i >=0 ; i--) {
            w= a[i] - b[i]-epsilon;


            if(w<0 )
            {
                epsilon=1;
                c[i]=w+e;
            }
            else
            {
                epsilon=0;
                c[i]=(w)%e;
            }

        }
        System.out.printf("(%d",epsilon);
        System.out.printf("(");
        for (int i = 0; i <n ; i++) {
            if(i==n-1){
                System.out.printf("%d",c[i]);
            }else {
                System.out.printf("%d,", c[i]);
            }
        }
        System.out.println("))");
        return epsilon;
    }

    public static void main(String[] args) {
        System.out.println("nhập p =");
        long p = sc.nextLong();
        System.out.println("nhập w:");
        int w = sc.nextInt();
        System.out.println("nhập t:");
        int t = sc.nextInt();
        int n = t;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] g = new int[n];
        Nhap(a, n);
        Nhap(b, n);
        int e= (int) pow(2,w);
        int k=Tinh(c,a,b,n,e,w);
        int d[]={25,214,153,165};
        if(k==1){
            for (int i = 0; i < n; i++) {
                g[i]=(c[i]+d[i])%e;
                System.out.println(g[i]);
            }
        }else
            System.out.printf("(%d",k);
        System.out.printf("(");
        for (int i = 0; i <n ; i++) {
            if(i==n-1){
                System.out.printf("%d",c[i]);
            }else {
                System.out.printf("%d,", c[i]);
            }
        }
        System.out.println("))");
    }
}

import java.util.Scanner;

import static java.lang.Math.pow;

public class Multiprecision_subtraction {
    static Scanner sc= new Scanner(System.in);
    public static void NhapA(int a[],int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.printf("nhập phần tử thứ a[%d]",i);
            a[i]=sc.nextInt();
        }
    }
    public static void NhapB(int b[],int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.printf("nhập phần tử thứ b[%d]",i);
            b[i]=sc.nextInt();
        }
    }
    public static void Tinh(int c[],int a[],int b[],int n,int e,int epsilon,int w) {
        epsilon=0;

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

    }

    public static void main(String[] args) {
        int n=4;
        int[]a=new int[n];
        int[]b=new int[n];
        int []c=new int[n];
        System.out.println("nhập w:");
        int w=sc.nextInt();
        System.out.println("nhập t:");
        int t=sc.nextInt();
        NhapA(a,n);
        NhapB(b,n);
        int epsilon=0;
        int e= (int) pow(2,w);
        Tinh(c,a,b,n,e,epsilon,w);

    }
}

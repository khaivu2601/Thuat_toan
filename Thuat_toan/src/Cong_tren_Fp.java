
import java.util.Scanner;

import static java.lang.Math.pow;

public class Cong_tren_Fp {
    static Scanner sc= new Scanner(System.in);
    public static void Nhap(int a[],int n)
    {
        for (int i = 0; i <n; i++) {
            System.out.printf("nhập phần tử  thứ %d",i);
            System.out.printf("\t");
            a[i]=sc.nextInt();
        }
    }

    public static int Tinh(int c[],int a[],int b[],int L[],int n,int w) {
       int epsilon=0;
        int  e= (int) pow(2,w);
        for( int i=n-1; i>=0; i--)
        {
            int k= a[i] + b[i]+epsilon;

            if(k>=e)
            {
                epsilon=1;
                c[i]=k%e;
            }
            else
            {
                epsilon=0;
                c[i]=k%e;
            }
        }
        System.out.println("mảng sau khi cộng");
        System.out.printf("%d(",epsilon);
        for (int i = 0; i <n; i++) {
            System.out.printf("%d,",c[i]);
        }
        System.out.printf("))\n");
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
        int[] L = new int[n];
        int[] h = new int[n];
        Nhap(a, n);
        Nhap(b, n);
        int k = Tinh(c, a, b, L, n, w);

        int e = (int) pow(2, w);
        if (k == 1) {

        int m= (int) Math.round(Math.log(p)/Math.log(2));
        int q= m/w;
        if(q%10 == 0){
            q=q;
        }else
            q=q+1;

        System.out.println("mảng của số nguyên p :");
        for(int i =t-1 ; i>=0;i--)
        {
            int z = (int) pow(2,w*i);
            L[i]= (int) (p/z);
            p = p%z;
            System.out.printf("%d\t",L[i]);
        }
        System.out.println("\n");
            int[] l = new int[n];
            System.out.println("\n");
            for (int i = 0, j = t - 1; i < t; i++, j--) {

                l[i] = L[j];

            }

            k = 0;
            for (int i = n - 1; i >= 0; i--) {
                h[i] = (c[i] - l[i] - k);
                k = 0;

                if (h[i] <= 0) {
                    h[i] += e;
                    k = 1;
                }
            }
            for (int i = 0; i < t; i++)
                System.out.print(h[i] + "  ");
            }
    }

}

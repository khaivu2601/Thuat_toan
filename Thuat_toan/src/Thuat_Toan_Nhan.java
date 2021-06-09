import java.util.Scanner;

import static java.lang.Math.pow;

public class Thuat_Toan_Nhan {
    static Scanner sc= new Scanner(System.in);
    public static void ChuyensoNguyenlon(int arr[],int p,int w,int a,int t){
        for (int i = t-1; i >=0 ; i--) {
            int z=(int) pow(2,w*i);
            arr[i]=a/z;
            a=a%z;
        }
        for (int i = t-1; i >= 0; i--) {
            System.out.printf("%d",arr[i]);
        }
        System.out.println("\n");
    }

    public static void Phepnhan(int a[],int b[],int c[],int t,int w){
        for (int i = 0; i < t; i++) {
            c[i]=0;
        }
        for (int i = 0; i < t; i++) {
            int U=0;
            for (int j = 0; j < t; j++) {
                int k=c[i+j]+a[i]*b[j]+U;
                int V=0;
                for (int l = 0; l < w; l++) {
                    V+=k%2*pow(2,l);
                    k=k/2;
                    U=k;
                }
                c[i+j]=V;
            }
            c[i+t]=0;
        }
        for (int i = 2*t-1; i >=0 ; i--) {
            System.out.printf("%d\t",c[i]);
        }
    }

    public static void main(String[] args) {
        int []a=new int[100];
        int []b=new int[100];
        int []c=new int[100];
        System.out.println("nhập p :");
        int p=sc.nextInt();
        System.out.println("nhập w");
        int w=sc.nextInt();
        System.out.println("nhập a1");
        int a1=sc.nextInt();
        System.out.println("nhập a2");
        int a2=sc.nextInt();
        int m= (int) Math.round(Math.log(p)/Math.log(2));
        int t= m/w;
        if(t%10 == 0){
            t=t;
        }else
            t=t+1;
        ChuyensoNguyenlon(a,p,w,a1,t);
        ChuyensoNguyenlon(b,p,w,a2,t);
        Phepnhan(a,b,c,t,w);
    }
}
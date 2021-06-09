import java.util.Scanner;

import static java.lang.Math.pow;

public class Chuyen_Mang {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhập p =");
        long p=sc.nextLong();
        int m= (int) Math.round(Math.log(p)/Math.log(2));
        System.out.println(m);
        System.out.println("nhập w =");
        int w= sc.nextInt();
        int t= m/w;
        if(t%10 == 0){
            t=t;
        }else
            t=t+1;
        int b[] =new int[t];
        System.out.println("nhập số nguyên a =");
        long a =sc.nextLong();
        for(int i = t-1 ; i>=0;i--)
        {
            int z = (int) pow(2,w*i);
            b[i]= (int) (a/z);
            a = a%z;
        }
        for(int i = t-1 ; i>=0;i--)
        {
            System.out.println(b[i]);
        }
    }
}

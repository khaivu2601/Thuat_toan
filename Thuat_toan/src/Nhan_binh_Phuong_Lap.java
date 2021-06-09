import java.util.Scanner;

public class Nhan_binh_Phuong_Lap {
    static Scanner sc= new Scanner(System.in);
    public static void Nhi_phan(int k){

    }

    public static void main(String[] args) {
        System.out.println("nhập vào số nguyên a");
        int a=sc.nextInt();
        System.out.println("nhập vào số nguyên n");
        int n=sc.nextInt();
        System.out.println("nhập vào k :");
        int k=sc.nextInt();
        if(k>=n){
            System.out.println("nhập lại k << n");
            k=sc.nextInt();
        }
        String z= Integer.toBinaryString(k);
        String b[]=z.split("");
        System.out.printf("dạng nhị phân của %d là :",k);

            System.out.printf("%d",b[3]);

    }
}

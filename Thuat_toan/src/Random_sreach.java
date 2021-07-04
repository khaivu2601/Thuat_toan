import java.util.Scanner;

public class Random_sreach extends Millerbin{
    public static int SinhSo(){
        double random= Math.random();
        random=random * 1000 +3;
        return (int) random;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập t");
        int t= sc.nextInt();
        int n= SinhSo();
        if(n%7==0){
            System.out.println("again!!!");
            n=SinhSo();
            System.out.println("số sinh ngẫu nhiên nlà "+n);
        }
        System.out.println("số sinh ngẫu nhiên là "+n);
        Miller(n,t);
    }
}

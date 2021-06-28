import java.util.Scanner;

public class snt {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập n :");
        int n=sc.nextInt();
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                for (int j = 2; j < i; j++) {
                    if(i%j!=0){
                        System.out.printf("%d \t",i);
                    }
                }
            }
        }
    }
}

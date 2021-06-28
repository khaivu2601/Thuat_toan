import java.util.Scanner;

public class Sang_Nguyen_thuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập n");
        int n=sc.nextInt();

        boolean []a= new boolean[n+1];
        for (int i = 2; i <= n ; i++) {
            a[i]=true;
        }
        for (int i = 2; i <=n ; i++) {
            if(a[i]==true){
                for (int j = 2*i; j <=n ; j+=i) {
                    a[j]=false;

                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            if(a[i]==true){
                System.out.printf("%d \t",i);
            }
        }
    }
}

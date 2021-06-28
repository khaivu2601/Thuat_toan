import java.util.Scanner;

public class PT_SNt {
    public static void main(String[] args) {
        System.out.println("nhập n:");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 2; i <= n; i++) {
            int dem=0;
            while (n%i==0){
                dem=dem+1;
                n/=i;
            }
            if(dem==0){
            }
            else{
                System.out.printf("%d^%d\t",i,dem);
            }

        }
    }
}

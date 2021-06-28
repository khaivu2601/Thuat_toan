import java.util.Scanner;

public class Carmicheal extends BPL {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
        System.out.println("nhập n");
    int n=sc.nextInt();
        System.out.println("nhập t");
    int t=sc.nextInt();
    boolean kt = false;
        for (int a=2; a < n-2; a++) {
            int r=BPL(a,n-1,n);
        int c=0;
        while (a>0){
                c=n%a;
                n=a;
                a=c;
        }
        if(r!=1){
            kt=false;
        }if(r==1 && a==1)
        {
            kt=true;
        }
    }
        if(kt==true ){
            System.out.printf("%d là số carmicheal",n);
        }
        else
            if (kt==false){
            System.out.printf("%d ko là số carmicheal ",n);
        }
}
}

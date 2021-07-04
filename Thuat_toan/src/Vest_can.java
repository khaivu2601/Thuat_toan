public class Vest_can {
    public static void Dem(String s1,String s2){
        int check;
        int count=0;
        for (int i = 0; i < s1.length() ; i++) {
            if(s1.charAt(i)==s2.charAt(0)){
                check=1;
                for (int j = 0; j < s2.length(); j++) {
                    if(s2.charAt(j)!=s1.charAt(i+j)){
                        check =0;
                        break;
                    }
                }
                if(check==1){
                    count++;
                }
            }
        }
        System.out.println("số lần xuất hiện "+count);
    }
    public static void ViTri(String s1, String s2){
        int count =0;
        int check;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)==s2.charAt(0)){
                check=1;
                for (int j = 0; j < s2.length(); j++) {
                    if(s2.charAt(j)!=s1.charAt(i+j)){
                        check=0;
                        break;
                    }
                }
                if(check==1){
                    System.out.printf("\n vị trí xuất hiện %d",i);
                }
            }
        }
    }
    public static void main(String[] args) {
        String s1="hôm nay là thứ nam ko phải ngày ram";
        String s2="am";
        Dem(s1,s2);
        ViTri(s1,s2);

    }
}

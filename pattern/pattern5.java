import java.util.*;
public class pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the limit! ");
        int n = sc.nextInt();

        int sp = n/2;
        int st = 1;
       

        for(int i = 1; i <= n; i++){

            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            for(int k=1;k<=st;k++){
                System.out.print("*\t");
            }
            if(i<=n/2){
                st=st+2;
                sp--;
            }
            else{
                st=st-2;
                sp++;
            }
            
            

        System.out.println();
        }

        
    }
}
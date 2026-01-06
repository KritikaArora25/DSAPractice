import java.util.*;
public class pattern6{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the limit! ");
        int n = sc.nextInt();

        int st = (n/2)+1;
        int sp = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j<=st ; j++){
                System.out.print("*\t");
            }
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            for(int j = 1; j<=st ; j++){
                System.out.print("*\t");
            }
            if(i<= n/2){
                sp=sp+2;
                st--;
            }
            else{
                sp=sp-2;
                st++;
            }
            System.out.println();
            

        }
    }
}

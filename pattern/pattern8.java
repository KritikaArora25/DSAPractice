import java.util.*;
public class pattern8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the limit!");
        int n = sc.nextInt();

        int c = 5;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){

                if( i+j == n+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }

            }
            System.out.println();

        }

    }
}

import java.util.*;
public class pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt(); 

        int a = 0;
        int b = 1;
        int c = 0;
        

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                
                // if ( i == 1){
                //     System.out.print(a+"\t");
                // }
                // else if ( i == 2){
                //     System.out.print(b+"\t");
                // }
                // else{
                    System.out.print(a+"\t");
                    c = a + b;
                    
                    a = b;
                    b = c;
                }
                System.out.println();
    }
    
}
}


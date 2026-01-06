import java.util.*;
public class BenjaminBulbs {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of bulbs: ");
        int n = scanner.nextInt();
        
        System.out.println("Bulb which are still on : ");
        for (int i = 1; i * i <= n; i++){
            System.out.print(i * i+" ");
        }


    }
    
}

import java.util.*;
public class BseAdd {
    public static int getSum(int n1, int n2, int b){
        int rv = 0;
        int c = 0;
        int p = 1;

        while(n1 > 0 || n2 > 0 || c > 0){
            int dig1 = n1 % 10;
            int dig2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int d = dig1 + dig2 + c;
            c = d / b;
            d = d % b;
            rv += d * p;
            p *= 10;
        }

        return rv;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers you want to be added : ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println("Enter their base : ");
        int b = sc.nextInt();

        System.out.println("Sum of " + n1 + " and " + n2 + " is : " +getSum(n1, n2, b) );

        sc.close();
    }
    
}

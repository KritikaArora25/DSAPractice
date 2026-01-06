import java.util.*;
public class B2Decimal {
    public static int convert(int n , int b){
        int rv = 0;
        int p = 1;
        while(n!=0){

            int r = n%10;
            n = n/10;

            rv += r * p;
            p *= b;

        }
        return rv;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scn.nextInt();
        
        System.out.println("Enter the base you want the number to convert in :");
        int b = scn.nextInt();

        System.out.println("The number in base " + b + " is : " + convert( n , b ));

        scn.close();


    }
}

import java.util.*;
public class Deci2b{
    public static int convert(int n, int b){
        int rv = 0;
        int p = 1;
        while(n!=0){

            int r = n % b;
            n = n / b;

            rv += r * p;
            p = p * 10;
        }
        return rv;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number in decimal base : ");
        int n = sc.nextInt();

        System.out.print("Enter the base you want to convert that number in : ");
        int b = sc.nextInt();

        System.out.println("Your converted number is : "+convert( n , b ));

        sc.close();



    }
}
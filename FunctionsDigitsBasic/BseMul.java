import java.util.*;
public class BseMul {
    public static int getProduct(int b, int n1, int n2){
        int rv = 0;
        int p = 1;
        while(n2 > 0){
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int sprd = getProductWithSingleDigit(n1, d2, b);
            rv = getSum(rv, sprd*p, b);
            p *= 10;

        }
        return rv;
    }
    public static int getProductWithSingleDigit(int n1, int d2, int b){
        int rv = 0; 
        int c = 0;
        int p = 1;
        while(n1 > 0 || c > 0){
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int d = d1 * d2 + c;

            c = d / b;
            d = d % b;

            rv += d * p;
            p *=10;

        }
        return rv;

    }
    public static int getSum(int n1, int n2, int b){
        int c = 0;
        int rv = 0;
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to be multiplied : ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println("Enter base of the numbers you just entered : ");
        int b = sc.nextInt();

        System.out.println("Multiplication of "+ n1 +" and "+ n2 + " is :" + getProduct(b, n1, n2));

        sc.close();



    }
    
}

import java.util.*;
public class Anybase {
    public static int convert2Deci(int n, int b1){
        int temp = n;
        int p = 1;
        int rv = 0;

        while(temp!=0){
            int r = temp % 10;
            temp = temp / 10;

            rv += r * p;
            p = p * b1;


        }
        return rv;
    }
    public static int convertDeci2Any(int n, int b2 ){
        int temp = n;
        int p = 1;
        int rv = 0;
        
        while(temp!=0){
            int r = temp % b2;
            temp = temp / b2;

            rv += r * p;
            p = p * 10;


        }
        return rv;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Enter base of the number: ");
        int b1 = sc.nextInt();
        System.out.println("Enter the base you want to convert your number to: ");
        int b2 = sc.nextInt();
    
        // Step 1: Convert input number from base b1 to decimal
        int decimalValue = convert2Deci(n, b1);
        System.out.println("Converting num to Decimal for easy calculation: " + decimalValue);
    
        // Step 2: Convert decimal number to the desired base b2
        int convertedValue = convertDeci2Any(decimalValue, b2);
        System.out.println("Converting Decimal to required base: " + convertedValue);
    
        sc.close();
    }
    

    
}

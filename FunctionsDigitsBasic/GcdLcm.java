import java.util.*;
public class GcdLcm{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers whose GCD and LCM needs to be calculated : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        
        int oa = a;
        int ob = b;
       
        while(a % b != 0){
        int rem= a % b;
        a=b;
        b=rem;
        }
        int gcd = b;
        int lcm = (oa * ob) / gcd;

        System.out.println("GCD : "+gcd);
        System.out.println("LCM : "+lcm);
        

        }
        

    }

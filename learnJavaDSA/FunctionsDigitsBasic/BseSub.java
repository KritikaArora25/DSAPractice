import java.util.*;
public class BseSub {
    public static int getSub(int n1, int n2, int b){
        int rv = 0;
        int c=0;
        int p = 1;

        while(n2 > 0){
            int d1 = n1 % 10;
            n1 = n1 / 10;
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int d = 0;
            d2 = d2 + c;
            if(d2 >= d1){
                c = 0;
                d = d2 - d1;
            }else{
                c = -1;
                d = d2 + b - d1;
            }

            rv += d * p;
            p = p * 10;
        }
        return rv;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers you want to be subtracted : ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println("Enter their base : ");
        int b = sc.nextInt();

        System.out.println("Subraction of " + n1 + " and " + n2 + " is : " +getSub(n1, n2, b) );

        sc.close();



    }
}

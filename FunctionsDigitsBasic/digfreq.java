import java.util.*;
public class digfreq {
    public static int getDigitFrequency(int n, int d){
        int c = 0;
        int temp = n;

        while(temp!=0){
            int rem = temp % 10;
            if( rem == d ){
                c++;
            }
            temp = temp / 10;
        }
        
        return c;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number and the digit whose frequency needs to be calculated : ");
        int n = sc.nextInt();
        int d = sc.nextInt();

        int f = getDigitFrequency(n, d);

        System.out.println("Frequency of " + d + " in " + n + " is : " + f);

        sc.close();

    }
}

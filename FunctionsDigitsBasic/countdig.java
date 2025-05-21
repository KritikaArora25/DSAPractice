import java.util.*;
public class countdig {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int count = 0;
        int temp=n;
        while(temp!=0){
            temp=temp/10;
            count++;
        }
        System.out.println("Number of digits in the number "+n+" is "+count);
    }
}

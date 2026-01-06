import java.util.*;
public class RevNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n = sc.nextInt();
        int temp = n;
        int dig=0;
        while(temp!=0){
             dig = temp%10;
            System.out.println(dig);
            dig = 0;
            temp = temp/10;
        }
    }
}

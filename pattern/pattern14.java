import java.util.*;
public class pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n+"\tX\t"+i+"\t=\t"+n*i);
        }
    }
}

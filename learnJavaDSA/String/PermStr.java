import java.util.*;
public class PermStr {
    public static void solution(int f, String str){
        int n = str.length();
        for(int i = 0; i < f ; i ++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for(int div = n ; div >= 1; div-- ){
                int q = temp / div;
                int r = temp %  div;
                

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }
        
    }
    public static int fact(int n){
        int fact = 1;
        for(int i = 2 ; i <= n ; i ++){
            fact = fact * i ;
        }
        return fact ;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        int n = str.length();
        int f = fact(n);

        solution(f, str);
        sc.close();
    }
    
}

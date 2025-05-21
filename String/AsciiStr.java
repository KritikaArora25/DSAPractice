import java.util.*;
public class AsciiStr{
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        for(int i = 1; i < str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            int gap = curr - prev;

            sb.append(gap);
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str = sc.next();
        System.out.println(solution(str));
    }
}
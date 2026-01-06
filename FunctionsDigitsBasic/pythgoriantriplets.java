import java.util.*;
public class pythgoriantriplets {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter numbers : ");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean flag;

        int max = a;
        if(b >= max){
            max = b;
        }
        if(c >= max){
            max = c;
    }
    if(max == a){
        flag = (( b * b + c * c )==( a * a ));
        System.out.println(flag);
    }
    else if(max == b){
        flag = (( a * a + c * c )==( b * b ));
        System.out.println(flag);
    }
    else{
        flag = (( a * a + b * b )==( c * c ));
        System.out.println(flag);
    }
}
}
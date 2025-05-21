import java.util.*;
public class Postfix {
    public static void evaluate(String exp){
        Stack<Integer> vs = new Stack<Integer>();
        Stack<String> is = new Stack<String>();
        Stack<String> ps = new Stack<String>();

        for(int i = 0 ; i < exp.length(); i ++){
            char ch = exp.charAt(i);

            if((ch >= '0' && ch <= '9' ) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                vs.push(ch - '0');  // -'0' converts from Char to int
                is.push(ch + "");  // char to String
                ps.push(ch + ""); // char to String
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v2 = vs.pop();
                int v1 = vs.pop();

                int val = operation(v1 , v2 , ch);
                vs.push(val);

                String infv2 = is.pop();
                String infv1 = is.pop();

                String valInfix = "(" + infv1 + ch + infv2 + ")";
                is.push(valInfix);

                String prev2 = ps.pop();
                String prev1 = ps.pop();

                String valPre = ch + prev1 + prev2;
                ps.push(valPre);



            }
        }
        System.out.println("Value is : "+ vs.pop());
        System.out.println("Value is : "+ is.pop());
        System.out.println("Value is : "+ ps.pop());



        
    }
    public static int operation(int v1 , int v2 , char optor){
        if(optor == '+'){
            return v1 + v2 ;
        }
        else if(optor == '-'){
            return v1 - v2 ;
        }
        else if(optor == '*'){
            return v1 * v2 ;
        }
        else if(optor == '/'){
            return v1 / v2 ;
        }
        return 0;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Expression : ");
        String exp = sc.nextLine();

        evaluate(exp);

    }
}

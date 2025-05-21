import java.util.*;
public class DupStk {
    public static void dupBrckt(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')') {
                if(st.peek() == '('){
                    System.out.println("Duplicate Brackets");
                    return;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
                
            }else{
                st.push(ch);
            }
        
    }
    System.out.println("No Duplicate brackets found!");
}
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String ! ");
    String str = sc.nextLine();
    sc.close();
    dupBrckt(str);
        
    }
    
}

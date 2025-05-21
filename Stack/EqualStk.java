import java.util.*;

public class EqualStk {
    
    
    
    public static int equalStacks(int[] h1 , int[] h2, int[] h3){
        Stack<Integer> st1 = new Stack<>(); 
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        int s1 = 0;
        int s2 = 0; 
        int s3 = 0;

        for(int i = h1.length-1 ; i >= 0 ; i--){
            s1 += h1[i];
            st1.push(s1);
        }
        for(int i = h2.length-1 ; i >= 0 ; i--){
            s2 += h2[i];
            st2.push(s2);
        }
        for(int i = h3.length-1 ; i >= 0 ; i--){
            s3 += h3[i];
            st3.push(s3);
        }
        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {

            s1 = st1.peek();
            s2 = st2.peek();
            s3 = st3.peek();


            if(s1 == s2 && s2 == s3){
                return s1 ;
            }
            if(s1 >= s2 && s1 >= s3){
                st1.pop();
            }
            else if(s2 >= s1 && s2 >= s3){
                st2.pop();
            }
            else{
                st3.pop();
            }   
    }
    return 0;
}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        int n1 = Integer.parseInt(n.split(" ")[0]);
        int n2 = Integer.parseInt(n.split(" ")[1]);
        int n3 = Integer.parseInt(n.split(" ")[2]);

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        
        for(int i = 0 ; i < n1 ; i++){
            h1[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n2 ; i++){
            h2[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n3 ; i++){
            h3[i] = sc.nextInt();
        }

        sc.close();
        System.out.println(equalStacks(h1, h2, h3));

        

    }
}

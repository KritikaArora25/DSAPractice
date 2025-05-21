import java.util.*;
public class SmallPatt {
    public static void smallestNumberPattern(String[] arr){
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int i = 0 ; i < arr.length; i ++){
            if(arr[i].equals( "d")){
                st.push(count);
                count++;
            }
            else if(arr[i].equals( "i")){
                st.push(count);
                count++;
                while(st.size()>0){
                    System.out.print(st.pop() + "  ");
                }
            }
        }
        st.push(count);
        count++;
        while(st.size()>0){
            System.out.print(st.pop() + "  ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input length which should be less than 8 !");
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next().toLowerCase();
        }
        smallestNumberPattern(arr);

        sc.close();

    }
}

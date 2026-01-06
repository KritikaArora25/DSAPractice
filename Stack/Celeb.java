import java.util.*;
public class Celeb {
    public static void findCelebrity(int[][] arr){
        //If a celeb is there print ints index(not position)
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < arr.length ; i ++){
            st.push(i);
        }
        while(st.size() >=2){
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1){
                st.push(j);
            }
            else{
                st.push(i);
            }

        }
        int pot = st.pop();
        for(int i = 0 ; i < arr.length; i++){
            if( i != pot){
                if((arr[i][pot] == 0) || (arr[pot][i] == 1)){
                    System.out.println("None");
                    return;
            }
        }
    }
    System.out.println(pot);
}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people :");
        int p = sc.nextInt();
        System.out.println("Enter the matrix : ");
        int[][] arr = new int[p][p];
        for(int i = 0; i < p; i++){
            String line = sc.nextLine();
            for(int j = 0; j < p; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        findCelebrity(arr);

        sc.close();

    }
}

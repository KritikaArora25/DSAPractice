import java.util.*;
public class PoiPlants {
    public static int poisonousPlants(int[] p){
        Stack<int[]> st = new Stack<>();
        int n = p.length;
        int maxDays = 0;
        for(int i = 0; i < n; i++){
            int days = 0;
            while(!st.isEmpty() && st.peek()[0] >= p[i]){
                days = Math.max(days , st.pop()[1]);
            }if(st.isEmpty()){
                st.push(new int[]{p[i] , 0});
            }else{
                days += 1 ;
                st.push(new int[]{p[i] , days});
                maxDays=Math.max(days , maxDays);
            }
        }
        return maxDays;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];

        for(int i = 0 ; i < p.length ; i ++){
            p[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(poisonousPlants(p));
    }
}

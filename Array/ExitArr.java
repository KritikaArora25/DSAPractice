import java.util.*;
public class ExitArr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
                }
            }
            int dir = 0; // 0 - e , 1 - s , 2 - w , 3 - n
            int i = 0;
            int j = 0;
            
            while(true){

                dir = (dir + arr[i][j]) % 4;

                if(dir == 0){ //east
                    j++;
                }
                else if(dir == 1){//South
                    i++;
                }
                else if(dir == 2){//west
                    j--;
                }
                else if(dir == 3){//North
                    i--;
                }

                if(i<0){
                    i++;
                    break;
                }
                if(j<0){
                    j++;
                    break;
                }
                if(i == m){
                    i--;
                    break;
                }
                if(j==n){
                    j--;
                    break;
                }
            }
            System.out.println("Exit point : "+i + " " + j);
    }
    
}

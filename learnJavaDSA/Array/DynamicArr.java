import java.util.*;
public class DynamicArr {

    public static int[] dynamicArray(int n , String[] queries){
        int[][] arr = new int[n][];
        int lastAnswer = 0;
        int[] results = new int[queries.length];
        int resultIndex = 0;

        for(String query: queries){
            String[] part = query.split(" ");
            int type = Integer.parseInt(part[0]);
            int x = Integer.parseInt(part[1]);
            int y = Integer.parseInt(part[2]);

            int idx = (x ^ lastAnswer) % n;

            if(type == 1){
                if(arr[idx] == null){
                    arr[idx] = new int[1];
                    arr[idx][0] = y;
                }else{
                    int len = arr[idx].length;
                    int[] newArray = new int[len + 1];
                    System.arraycopy(arr[idx], 0, newArray, 0, len);
                    newArray[len] = y;
                    arr[idx] = newArray;
                }
            }
            else if(type == 2){
                lastAnswer = arr[idx][y % arr[idx].length];
                results[resultIndex++] = lastAnswer;
            }
        }
        return Arrays.copyOf(results, resultIndex);
        }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline


        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextLine();
        }
        
        int[] result = dynamicArray(n , queries);
        for(int res : result){
            System.out.println(res);
        }
        sc.close();

    }
    
}

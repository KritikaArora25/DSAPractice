import java.util.*;
public class ArrMani {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
      
        int m = sc.nextInt();
        int[][] queries = new int[m][3];
       
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                queries[i][j] = sc.nextInt();
            }
        }
        int[] arr = new int[n];
        
        
        long[] diff = new long[n + 1]; // Size n+1 for boundary handling
        
        // Process each query
        for (int i = 0; i < m; i++) {
            int a = queries[i][0] - 1; // Convert 1-based index to 0-based
            int b = queries[i][1] - 1; // Convert 1-based index to 0-based
            int k = queries[i][2];
            
            diff[a] += k;           // Add k at index a
            if (b + 1 < n) {
                diff[b + 1] -= k;   // Subtract k after index b
            }
        }
        
        // Calculate the prefix sum and find the maximum value
        long max = 0;
        long current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            max = Math.max(max, current);
        }
        
        // Print the maximum value
        System.out.println(max);
        
        sc.close();
    }
}

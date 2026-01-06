import java.util.*;
public class Gme2stk {
    public static int twoStacks(int maxSum, int[] a, int[] b) {
        int sum = 0, count = 0, i = 0, j = 0;

        // Take elements from stack A until sum exceeds maxSum
        while (i < a.length && sum + a[i] <= maxSum) {
            sum += a[i];
            i++;
        }

        count = i;  // This is the max count if we only take from A

        // Now try taking from stack B, and remove from A if necessary
        while (j < b.length) {
            sum += b[j];
            j++;

            // If sum exceeds maxSum, remove elements from A
            while (sum > maxSum && i > 0) {
                i--;
                sum -= a[i];
            }

            // Check if sum is still within the limit and update max count
            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();  // Number of games

        while (g-- > 0) {
            int n = sc.nextInt();  // Elements in stack A
            int m = sc.nextInt();  // Elements in stack B
            int maxSum = sc.nextInt();  // Max allowed sum

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            System.out.println(twoStacks(maxSum, a, b));
        }

        sc.close();
    }
}


import java.util.*;

public class HrArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the 6x6 array
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Function call to find the maximum hourglass sum
        int maxSum = hourglassSum(arr);
        System.out.println(maxSum);
    }

    public static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE; // Initialize to the smallest possible value

        // Iterate over all possible hourglass starting positions
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                // Calculate the hourglass sum
                int currentSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] // Top row
                                + arr[i+1][j+1]                      // Middle element
                                + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]; // Bottom row

                // Update maxSum if the currentSum is greater
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum; // Return the maximum hourglass sum
    }
}

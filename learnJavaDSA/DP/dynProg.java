package DP;

import java.util.Arrays;
import java.util.Scanner;

public class dynProg {

    public static int fib(int n){
        if( n == 0 || n == 1){
            return n;
        }
        int nm1 = fib(n - 1);
        int nm2 = fib(n - 2);

        int fibn = nm1 + nm2;

        return fibn;
    }

    public static int fibOptimized(int n , int[] qb){
        if( n == 0 || n == 1){
            return n;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        int nm1 = fibOptimized(n - 1 , qb);
        int nm2 = fibOptimized(n - 2 , qb);

        int fibn = nm1 + nm2;
        qb[n] = fibn;

        return fibn;
    }

    public static int climbStair(int n , int[] qb){  // n = no. of stairs
        if(n == 0){
            return 1;
        }else if( n < 0){
            return 0;
        }

        if(qb[n] > 0){
            return qb[n];
        }

        int nm1 = climbStair(n-1, qb);
        int nm2 = climbStair(n-2, qb);
        int nm3 = climbStair(n-3, qb);
        int countPath = nm1 + nm2 + nm3;

        qb[n] = countPath;
        return countPath;
    }

    public static int countPathTab(int n){
        int[] dp = new int[n + 1];
        
        dp[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            if(n == 1){
                dp[i] = dp[i - 1];
            }else if(n == 2){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static int countPathJumps(int n , int[] arr){
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 1 ; j <= arr[i] && i + j < dp.length  ; j++){
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }

    public static int countPathMinMoves(int n , int[] arr){
        Integer[] tab = new Integer[arr.length + 1];
        tab[arr.length] = 0;

        for(int i = arr.length - 1 ; i >= 0; i--){
            if(arr[i] > 0){
                int min = Integer.MAX_VALUE;
                for(int j = 1 ; j <= arr[i] && i + j < tab.length; j++){
                    if(tab[i + j] != null && tab[i + j] < min){
                        min = tab[i + j];
                    }
                }
                tab[i] = (min == Integer.MAX_VALUE) ? null : min + 1;
            }else{
                tab[i] = null;
            }
        }
        return tab[0] == null ? -1 : tab[0]; // -1 = unreachable
    }

    public static int minCostTraverse(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        // dp[maze.length - 1][maze[0].length - 1] = maze[maze.length - 1][maze[0].length - 1];

        for(int i = dp.length - 1 ; i >= 0 ; i--){
            for(int j = dp[0].length - 1 ; j >= 0 ; j--){
                if(i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }else if(i == dp.length - 1){
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }else if(j == dp[0].length - 1){
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i + 1][j] , dp[i][j + 1]) + arr[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static int goldmine(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int i = dp.length - 1 ; i >= 0 ; i--){
            for(int j = dp[0].length - 1 ; j >= 0 ; j--){
                if(j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                    dp[i][j] = Math.max(dp[i][j + 1] , dp[i + 1][j + 1]) + arr[i][j];
                }
                else if(i == dp.length - 1){
                    dp[i][j] = Math.max(dp[i - 1][j + 1] , dp[i][j + 1]) + arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j + 1], Math.max(dp[i - 1][j + 1] , dp[i][j + 1])) + arr[i][j];
                }
                
            }
        }
        int max = dp[0][0];
        for(int i = 0 ; i < dp.length;i++){
            if(max < dp[i][0]){
                max = dp[i][0];
            }
            
        }
        return max;
    }

    public static void targetSum(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length + 1][ target + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length ; j++){
                if( i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    int val = arr[i - 1];
                    if(dp[i - 1][j] == true){
                        dp[i][j] = true;
                    }else if(j >= val){
                        if(dp[i - 1][j - val] == true)
                            dp[i][j] = true;
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);
    }

    public int climbStairs(int n) {
        //base case
        if(n == 0) return 1;
        if(n == 1) return 1;

        int prev2 = 1;
        int prev1 = 1;

        for(int i = 2 ; i <= n ; i++){
            int current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;//no. of steps to reach nth step
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return cost[0];
        if(cost.length == 1) return Math.min(cost[0],cost[1]);

        int first = cost[0];
        int second = cost[1];

        for(int i = 2; i < cost.length; i++){
            int current = Math.min(first , second) + cost[i];
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }

    public int coinChange(int[] coins, int amount) {
        int[] amt = new int[amount + 1];

        Arrays.fill(amt , amount + 1);
        amt[0] = 0;

        for(int i = 1; i <= amount; i++ ){
            for(int j = 0; j < coins.length ; j++){
                if(i >= coins[j]){
                    amt[i] = Math.min(amt[i], 1 + amt[i - coins[j]]);
                }
            }  
        }
        if(amt[amount] < amount + 1){
            return amt[amount];
        }else{
            return -1;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter n");
        // int n = sc.nextInt();
        // int[] qb = new int[n + 1];
        // for(int i = 0 ; i < qb.length ; i++){
        //     qb[i] = 0;
        // }
        // System.out.println(fibOptimized(n, qb));
        // int[] arr = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        // System.out.println(countPathMinMoves(arr.length, arr)); // Output: 4s
        int[] arr ={4,7,3,1,3};
        targetSum(arr, 10);
        
        sc.close();

    }
}

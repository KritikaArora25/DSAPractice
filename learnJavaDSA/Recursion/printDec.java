package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class printDec {

    public static void printDecCnt(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecCnt(n-1);
    }

    public static void printIncCount(int n){
        if( n == 0){
            return;
        }
        printIncCount(n-1);
        System.out.println(n);
    }

    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static int fact(int n){
        if(n == 1){
            return 1;
        }
        return n * fact(n-1);
    }

    public static int powerLinear(int x , int n){
        if(n == 0){
            return 1;
        }
        return x * powerLinear(x, n - 1);
    }

    public static int powerLog(int x, int n){
        if(n == 0){
            return 1;
        }
        int half = powerLog(x, n/2);
        int val = half * half;

        if(n % 2 == 1){
            val = val * x;
        }
        return val;
    }
    public static void printZigZag(int n){
        if(n == 0){
            return;
        }

        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");
        
    }

    public static void toh(int n , String t1 , String t2 , String t3){

        if(n == 0){
            return;
        }

        toh(n-1 , t1 , t3 , t2);
        System.out.println(n + "[ " + t1 + " -> " + t2 + " ]");
        toh(n-1 , t3 , t2 , t1);
    }

    public static void displayArr(int[] arr , int idx){
        if(idx == -1){
            return;
        }

        displayArr(arr, idx - 1);
        System.out.println(arr[idx]);

    }

    public static void displayArrRev(int[] arr , int idx){
        if(idx == -1){
            return;
        }

        System.out.println(arr[idx]);
        displayArrRev(arr, idx - 1);

    }

    public static int maxArr(int[] arr , int idx){

        if( idx == -1){
            return Integer.MIN_VALUE;
        }
        int m1 = maxArr(arr, idx - 1);
        if(m1 > arr[idx]){
            return m1;
        }else{
            return arr[idx];
        }
    }

    public static int firstIdx(int[] arr , int idx , int data){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == data){
            return idx;
        }else{
            int m1 = firstIdx(arr, idx + 1 , data);
            return m1;
        }
    }

    public static int lstIdx(int[] arr , int idx , int data){
        if(idx < 0){
            return -1;
        }
        if(arr[idx] == data){
            return idx;
        }else{
            int m1 = lstIdx(arr, idx - 1 , data);
            return m1;
        }
    }

    public static ArrayList<Integer> allIdx(int[] arr , int idx , int data){
        if(idx == arr.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = allIdx(arr, idx + 1, data);

        if(arr[idx] == data){
            ans.add(idx);
        }
        
        return ans;
    }

    public static int[] allIdx(int[] arr, int idx, int data, int count) {
    if (idx == arr.length) {
        return new int[count];  // base case: array of required size
    }

    if (arr[idx] == data) {
        int[] res = allIdx(arr, idx + 1, data, count + 1);
        res[count] = idx;  // store index during backtracking
        return res;
    } else {
        return allIdx(arr, idx + 1, data, count);
    }
}

    public static ArrayList<String> getss(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> lst = getss(ros);

        ArrayList<String> mres = new ArrayList<>();
        for(String itr : lst){
            mres.add(""+itr);
        }
        for(String itr : lst){
            mres.add(ch+itr);
        }

        return mres;
    }

    static String[] codes = {".," , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};
    public static ArrayList<String> keyComb(String str){
            if(str.length() == 0){
                ArrayList<String> bres = new ArrayList<>();
                bres.add("");
                return bres;
            }
        
            char ch = str.charAt(0); // 5
            String ros = str.substring(1); // 73

            ArrayList<String> rres = keyComb(ros);
            ArrayList<String> mres = new ArrayList<>();

            String code = codes[ch - '0'];

            for(int i = 0 ; i < code.length() ; i++){
                char chr = code.charAt(i);
                for(String s: rres){
                    mres.add(chr+s);
                }
            }
            
        return mres;
    }

    
    public static ArrayList<String> stairPath(int n){
        if(n == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }else if(n < 0){
             ArrayList<String> bres = new ArrayList<>();
             return bres;
        }
        ArrayList<String> path1 = stairPath(n-1);
        ArrayList<String> path2 = stairPath(n-2);
        ArrayList<String> path3 = stairPath(n-3);

        ArrayList<String> paths = new ArrayList<>();

        for(String path : path1){
            paths.add(1+path);
        }

        for(String path : path2){
            paths.add(2+path);
        }

        for(String path : path3){
            paths.add(3+path);
        }
        return paths;
    }

    public static ArrayList<String> getMazePaths(int sr , int sc , int dr , int dc){
        if(sr== dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if(sc < dc){
            hpaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if(sr < dr){
            vpaths = getMazePaths(sr + 1, sc , dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for(String hpath : hpaths){
            paths.add("h" + hpath);
        }

        for(String vpath : vpaths){
            paths.add("v" + vpath);
        }

        return paths;
        
    }

    public static ArrayList<String> getMazePathsWithJumps(int sr , int sc , int dr , int dc){
        if(sr== dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        ArrayList<String> dpaths = new ArrayList<>();

        ArrayList<String> paths = new ArrayList<>();

        for(int ms = 1 ; ms <= dc - sc ; ms++){
            hpaths = getMazePathsWithJumps(sr, sc + ms, dr, dc);
            for(String hpath : hpaths){
                paths.add("h" + ms + hpath);
            }
        }

        for(int ms = 1 ; ms <= dr - sr ; ms++){
            vpaths = getMazePathsWithJumps(sr + ms , sc , dr, dc);
            for(String vpath : vpaths){
                paths.add("v" + ms + vpath);
            }
        }

        for(int ms = 1 ; ms <= dr - sr && ms <= dc - sc ; ms++){
            dpaths = getMazePathsWithJumps(sr + ms , sc + ms , dr, dc);
            for(String dpath : dpaths){
                paths.add("d" + ms + dpath);
            }
        }

        return paths;
        
    }

    public static void printSubseq(String ques , String ans){
        if(ques.length() == 0){
            System.err.print(ans +"\t");
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        printSubseq(roq, ans + ch);
        printSubseq(roq, ans + "");
    }
    

        
    static String[] code_s = {".," , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};
    public static void printKeyComb(String ques , String ans){
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String codesforch = code_s[ch - '0'];
        for(int i = 0 ; i < codesforch.length() ; i++){
            char cho = codesforch.charAt(i);
            printKeyComb(roq, ans + cho);
        }
    }

    public static void printStairPath(int s , int d , String ans){
        if(s == d){
            System.out.println(ans);
            return;
        }
        if(s > d){
            return;
        }
        
        printStairPath(s + 1, d , ans + 1);
        printStairPath(s + 2, d , ans + 2);
        printStairPath(s + 3, d , ans + 3);
    }

    public static void printMazePath(int sr , int sc  , int dr , int dc , String ans){
        if(sr == dr && sc == dc){
            System.out.print(ans + ' ');
            return;
        }
        if(sr > dr || sc > dc){
            return;
        }
        if(sc < dc){
            printMazePath( sr, sc + 1, dr, dc, ans + "h");
        }
        if(sr < dr){
            printMazePath(sr + 1, sc, dr, dc, ans + "v");
        }
        
    }

    public static void printMazePathWithJumps(int sr , int sc  , int dr , int dc , String ans){
        if(sr == dr && sc == dc){
            System.out.print(ans + " ");
            return;
        }
        
        for(int i = 1 ; i <= (dc - sc) ; i++){
            printMazePathWithJumps(sr, sc + i, dr, dc, ans + "h" + i);
        }
        for(int i = 1 ; i <= (dr - sr) ; i++){
            printMazePathWithJumps(sr + i, sc, dr, dc, ans + "v" + i);
        }
        for(int i = 1 ; i <= (dr - sr) && i <= (dc - sc) ; i++){
            printMazePathWithJumps(sr + i, sc + i, dr, dc, ans + "d" + i);
        }
    }

    public static void printPermutation(String ques , String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0 ; i < ques.length() ; i++){
            char ch = ques.charAt(i);
            String roq = ques.substring(0 , i) + ques.substring(i+1);
            
            printPermutation(roq, ans + ch);
        }
    }

    public static void printEncoding(String ques , String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }else if(ques.length() == 1){
            char ch = ques.charAt(0);
            if(ch == '0'){
                return;
            }else{
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(ans + code);
            }
        }else{
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if(ch == '0'){
                return;
            }else{
                int chv = ch - '0'; // ✅ This converts a single character digit like '2' to 2
                char code = (char)('a' + chv - 1);
                printEncoding(roq, ans + code);
            }

            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);

            int chv12 = Integer.parseInt(ch12); // ✅ This converts a 2-digit string like "12" to int 12
            char code = (char)('a' + chv12 - 1);
            printEncoding(roq12, ans + code);
        }
    }

    public static void floodFill(int[][] maze , int row , int col , String ans, boolean[][] visited){
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true){
            return;
        }
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(ans);
            return;
        }

        visited[row][col] = true;
        floodFill(maze, row - 1, col, ans + "t", visited);
        floodFill(maze, row , col - 1, ans + "l", visited);
        floodFill(maze, row + 1, col, ans + "d", visited);
        floodFill(maze, row, col + 1, ans + "r", visited);
        visited[row][col] = false;
    }

    public static void targetSubsets(int[] arr ,int i , int target , String range, int ssf){
        if (i == arr.length) {
            if (ssf == target) {
                System.out.println("Range: " + range);
            }
            return;
        }
        if (range.equals("")) {
            targetSubsets(arr, i + 1, target, arr[i] + "", ssf + arr[i]);
        } else {
            targetSubsets(arr, i + 1, target, range + "-" + arr[i], ssf + arr[i]);
        }
        targetSubsets(arr, i + 1, target, range, ssf);   
    }

    private static boolean queenSafe(int[][] chess, int row, int col){
        for(int i = row - 1 ; i >= 0 ; i--){
            if(chess[i][col] == 1){
                return false;
            }
        }
        for(int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i-- , j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i = row - 1 , j = col + 1; i >= 0 && j < chess.length; i-- , j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void nQueen(int[][] chess, String qsf, int row){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }
        for(int col = 0 ; col < chess.length ; col++){
            if(queenSafe(chess, row, col) == true){
                chess[row][col] = 1;
                nQueen(chess, qsf + row + "-" + col + "," , row + 1);
                chess[row][col] = 0;
            }
        }
        
    }

    public static void knightTour(int[][] chess, int row , int col, int move){
        
        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }else if(move == chess.length * chess.length){
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;

        knightTour(chess, row - 2, col + 1, move + 1);
        knightTour(chess, row - 1, col + 2, move + 1);
        knightTour(chess, row + 1, col + 2, move + 1);
        knightTour(chess, row + 2, col + 1, move + 1);

        knightTour(chess, row + 2, col - 1, move + 1);
        knightTour(chess, row + 1, col - 2, move + 1);
        knightTour(chess, row - 1, col - 2, move + 1);
        knightTour(chess, row - 2, col - 1, move + 1);

        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length ; i++){
            for(int j = 0 ; j < chess[0].length ; j++){
                 System.out.printf("%2d ", chess[i][j]); 
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter n!");
        // int n = sc.nextInt();
        //printDecCnt(n);
        //printIncCount(n);
        // pdi(n);
        // System.out.println(fact(n));
        // System.out.println(powerLinear(5, n));
        // System.out.println(powerLog(5, n));
        //printZigZag(n);

        // toh(n, "A" , "B" , "C");
        // int[] arr = {10 , 20 , 30 , 40 , 50 , 40 , 70 , 80 , 50 , 20 , 10};
        // displayArr(arr, arr.length - 1);
        // displayArrRev(arr, arr.length - 1);
        // System.out.println(maxArr(arr, arr.length - 1));
        // System.out.println(firstIdx(arr, 0, 50));
        // System.out.println(lstIdx(arr, arr.length - 1, 50));
        // System.out.println(allIdx(arr, 0, 50));
        // System.out.println(getss("abc"));
        // System.out.println(keyComb("573"));

        // System.out.println(stairPath(4));
        // System.out.println(getMazePaths(1,1,3,3));
        // System.out.println(getMazePathsWithJumps(1, 1, 3, 3));
        // printSubseq("abc", "");
        // System.out.println();
        // printMazePath(1, 1, 3, 3, "");
        // System.out.println();
        // printMazePathWithJumps(1, 1, 3, 3, "");
        // printPermutation("abc","");
        // printEncoding("123","");
        System.out.println("Enter value of n and m");
        int n = sc.nextInt();
        // int m = sc.nextInt();
        // int[][] arr = new int[n][m];
        // boolean[][] visited = new boolean[n][m];
        // floodFill(arr, 0, 0, "", visited);
        // int[] arr = {10 , 20 , 30 , 40 , 50};
        // targetSubsets(arr, 0, 30,"", 0);
        int[][] chess = new int[n][n];
        // for(int i = 0; i < chess.length ; i++){
        //     for(int j = 0 ; j < chess[0].length ; j++){
        //         chess
        //     }
        // }
        // nQueen(chess,"", 0);
        knightTour(chess, 0, 0, 1);
        sc.close();
    }
    
}

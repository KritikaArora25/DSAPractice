import java.util.*;
public class MatrixMul {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in the first matrix: ");
        int r1 = sc.nextInt();
        System.out.println("Enter the number of columns in the first matrix: ");
        int c1 = sc.nextInt();
        System.out.println("Enter the number of rows in the second matrix: ");
        int r2 = sc.nextInt();
        System.out.println("Enter the number of columns in the second matrix: ");
        int c2 = sc.nextInt();
        int[][] a = new int[r1][c1];
        int[][] b = new int[r2][c2];
        int[][] c = new int[r1][c2];
        System.out.println("Enter the elements of the first matrix: ");
        for(int i=0;i<r1;i++){
        for(int j=0;j<c1;j++){
            a[i][j] = sc.nextInt();
        }
    }
    System.out.println("Enter the elements of the second matrix: ");
    for(int i=0;i<r2;i++){
        for(int j=0;j<c2;j++){
            b[i][j] = sc.nextInt();
        }
    }
    int k = 0;
    if (c1 != r2){
        System.out.println("Matrices cannot be multiplied");
       
    }else{
        for(int i=0;i<c1;i++){
           
            for(int j=0;j<r2;j++){
                k=0;
                while(k < c1){
                    c[i][j] += a[i][k] * b[k][j];
                    k++;
                }
                System.out.print(c[i][j]+" ");
            }
            System.out.println();

    }
    


    }

}
    
}

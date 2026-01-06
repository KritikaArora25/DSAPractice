import java.util.*;
public class Bin2DArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Enter the elements of the 2D array: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
                }
                }
                System.out.println("Enter the element to be seached : ");
                int data = sc.nextInt();

                System.out.println("The 2D array is: ");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }

                    int i = 0;
                    int j = arr[0].length-1;
                    int flg = 0;
                    while(j>=0 && i < arr.length){
                        if(arr[i][j] == data){
                            System.out.println("Data found at arr of i : "+ i +", j : "+j);
                            flg = 1;
                            break;
                }else if(arr[i][j] < data){
                    i++;
                }else if(arr[i][j] > data){
                    j--;
                }
            }
            if( flg == 0){
                System.out.println("Data not found");
            }
        }
    }


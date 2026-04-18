package Rev;

public class alph {
    public static void main(String[] args) {
        int c = 65;
        int n = 5;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j <= i; j++){
        //         System.out.print((char)(c + j) + " ");
        //     }
        //     System.out.println();
        // }

        // patt2
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j <= i; j++){
        //         System.out.print((char)(c + i) + " ");
        //     }
        //     System.out.println();
        // }

        // patt3
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n - i; j++){
        //         System.out.print((char)(c + j) + " ");
        //     }
        //     System.out.println();
        // }


        // patt4
        // for(int i = 0; i < n; i++){
        //     for(int k = 0; k < n - i - 1; k++){
        //         System.out.print(" ");
        //     }
        //     char ch = 'A';
        //     for(int j = 0; j < 2*i +1; j++){
        //        if(j < (2*i +1)/2){
        //         System.out.print(ch++);
        //        }else{
        //         System.out.print(ch--);
        //        }
        //     }
        //     System.out.println();
        // }

        //patt5
        // for(int i = 0; i < n; i++){
        //     int ch = 65 + ( n - i ) - 1;
        //     for(int j = 0; j <= i; j++){
        //         System.out.print((char)(ch + j));
        //     }
        //     System.out.println();
        // }

        // patt6
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n - i; j++){
        //         System.out.print("*");
        //     }
        //     for(int k = 0; k < 2 * i; k++){
        //         System.out.print(" ");
        //     }
        //     for(int l = 0; l < n - i; l++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j <= i; j++){
        //         System.out.print("*");
        //     }
        //     for(int k = 0; k < 2 * (n - i) -2 ; k++){
        //         System.out.print(" ");
        //     }
        //     for(int l = 0; l <= i; l++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // patt7
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < i + 1; j++){
        //         System.out.print("*");
        //     }
        //     for(int k = 0; k < 2 * (n - i) - 2; k++){
        //         System.out.print(" ");
        //     }
        //     for(int j = 0; j < i + 1; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < n - 1; i++){
        //     for(int j = 0; j < n - i - 1; j++){
        //         System.out.print("*");
        //     }
        //     for(int k = 0; k < 2 * (i + 1); k++){
        //         System.out.print(" ");
        //     }
        //     for(int j = 0; j < n - i - 1; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // patt8
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 || j == n - 1|| i == 0|| i == n - 1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

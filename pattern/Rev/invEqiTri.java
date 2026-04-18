package Rev;

public class invEqiTri {
    public static void main(String[] args) {
        int n = 5;
        for(int i = 0; i < n - 1; i++){
            for(int j = 1; j <= n - i - 1 ; j++){
                System.out.print("   ");
            }
            for(int k = 1; k <= (2 * i + 1); k++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= n - i - 1 ; j++){
                System.out.print("   ");
            }
            for(int k = 1; k <= (2 * i + 1); k++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}

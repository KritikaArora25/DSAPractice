import java.util.*;
public class PrimeArLst {
    public static boolean isPrime(int val){
       
        if(val < 2){
            return false;
        }
        if(val == 2){
            return true;
        } 
        if(val % 2 == 0){
            return false;
        } 
        for(int i = 3 ; i*i <= val ; i++){
            if(val % i == 0){
                return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lst = new ArrayList<>();
        System.out.println("Enter the number of elements in the list: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the list: ");
        for(int i = 0 ; i < n ; i++){
            lst.add(sc.nextInt());
        }
        System.out.println("List after removing Prime numbers is: ");
        for(int i = n - 1 ; i >= 1 ; i-- ){
            if(isPrime(lst.get(i))){
                lst.remove(i);
            }
        }
        System.out.println(lst);
        
    }
    
}

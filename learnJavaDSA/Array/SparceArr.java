import java.util.*;
public class SparceArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stringList;
        stringList = new String[n];
        for (int i = 0; i < n; i++) {
            stringList[i] = sc.next();
        }
        int q = sc.nextInt();
        String[] queries;
        queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.next();
        }
        int[] result = new int[q];
        for(int i = 0 ; i < q; i++ ){
            int count = 0 ;
            for (int j = 0; j< n; j++){
                if(queries[i].equals(stringList[j])){
                    count++;
            }

        }
        result[i] = count;
    }
    for(int val: result){
        System.out.println(val);
    }
    
}
}


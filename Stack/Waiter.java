import java.util.*;
public class Waiter {
    public static List<Integer> waiter(int[] number, int q){

        List<Integer> answers = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        //Generate the first 'q' prime numbers
        int[] prime = generatePrimes(q);

        //Push all plates into Stack A initially
        for(int num: number){
            A.push(num);
        }

        //Process q iterations
        for(int i = 0; i < q; i++){
            int currentPrime = prime[i]; //Current Prime Number

            Stack<Integer> nextA = new Stack<>();//New A for next round

            //Process elements in A
            while(!A.isEmpty()){
                int val = A.pop();
                if( val % currentPrime == 0 ){
                    B.push(val); //Divisible numbers go to B 
                }else{
                    nextA.push(val); //Others go to next A
                }
            }

            //Collect answers from B in order(Top to Bottom)
            while(!B.isEmpty()){
                answers.add(B.pop());
            }

            //Move remaining numbers back to A(to maintain order)
            A = nextA;
        }
        
        //Remaining numbers in A(in order)
        while(!A.isEmpty()){
            answers.add(A.pop());
        }
        return answers;

    }

    //Function to generate the first 'q' prime numbers
    public static int[] generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        return primes.stream().mapToInt(i -> i).toArray();
    }

    //Function to check if a number is prime
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2 ; i * i <= num ; i++ ){
            if( num % i == 0 ) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        List<Integer> result = waiter(A, q);

        // Print results in required format
        for (int num : result) {
            System.out.println(num);
        }

        sc.close();
    }
}

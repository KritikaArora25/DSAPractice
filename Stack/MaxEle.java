import java.util.*;
public class MaxEle {
    public static class Max{
        Stack<Integer> allData;
        Stack<Integer> maxData;

        public Max(){
            allData = new Stack<>();
             maxData = new Stack<>();
        }

        void push(int data){
            allData.push(data);
            if(maxData.isEmpty() || data >= maxData.peek()){
                maxData.push(data);
            }
        }

        int pop(){
            if(allData.isEmpty()){
                System.out.println("UnderFlow!");
                return -1;
            }else{
                int data = allData.pop();
                if(data == maxData.peek()){
                    maxData.pop();
                }
                return data;
            }
        }
        int getMax(){
            if(maxData.isEmpty()){
                System.out.println("No Data!");
                return -1;
            }else{
                return maxData.peek();
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //Number of queries
        sc.nextLine(); // Consume newline after nextInt()

        String[] operations = new String[n];
        for(int i = 0 ; i < n ; i++){
            operations[i] = sc.nextLine();
        } 
        Max maxEle = new Max();
    
        for(int i = 0; i < n ; i++){
            if(Integer.parseInt(operations[i].split(" ")[0]) == 1){
                int val = Integer.parseInt(operations[i].split(" ")[1]);
                maxEle.push(val);
            }
            if(Integer.parseInt(operations[i].split(" ")[0]) == 2){
                System.out.println("Element popped : "+maxEle.pop());
            }
            if(Integer.parseInt(operations[i].split(" ")[0]) == 3){
                System.out.println(maxEle.getMax());
            }
        }
        sc.close();

    }
}

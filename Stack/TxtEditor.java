import java.util.*;
public class TxtEditor{
    static StringBuilder s = new StringBuilder();
    static Stack<String> log = new Stack<>();

    //Append the String to the end
    public static void append(String W){
        log.push(s.toString());//Save state for undo
        s.append(W);
    }

    //Delete last k characters
    public static void delete(int k){
        log.push(s.toString());//Save state for undo
        s.delete(s.length() - k, s.length());
    }

    // Print the k-th character (1-based index)
    public static void prnt(int k) {
        System.out.println(s.charAt(k - 1));
    }
    //Undo the last operation
    public static void undo() {
        if (!log.isEmpty()) {
            s = new StringBuilder(log.pop()); // Restore previous state
        }
    }
    public static void textEditor(String[] ops) {
        for (String op : ops) {
            String[] parts = op.split(" ", 2);
            int choice = Integer.parseInt(parts[0]);

            switch (choice) {
                case 1:
                    append(parts[1]);
                    break;
                case 2:
                    delete(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    prnt(Integer.parseInt(parts[1]));
                    break;
                case 4:
                    undo();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = Integer.parseInt(sc.nextLine());
        String[] ops = new String[Q];

        for (int i = 0; i < Q; i++) {
            ops[i] = sc.nextLine();
        }

        textEditor(ops);
        sc.close();
    }
}


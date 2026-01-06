import java.util.*;

public class StringCompression {
    
    // Remove consecutive duplicate characters
    public static String Compression1(String str) {
        String s = str.charAt(0) + "";  // Start with the first character

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr != prev) {
                s += curr;  // Add current character if it's different from the previous one
            }
        }
        return s;
    }

    // Compress string with character count
    public static String Compression2(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str.charAt(0));  // Start with the first character
        int count = 1;  // Initialize count to 1 because the first character is already counted

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;  // Increase count if current character matches previous one
            } else {
                if (count > 1) {
                    s.append(count);  // Add the count if it's greater than 1
                }
                s.append(curr);  // Add the current character
                count = 1;  // Reset count for the next character
            }
        }

        // Add the count for the last character if it's greater than 1
        if (count > 1) {
            s.append(count);
        }

        return s.toString();  // Return the final string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String str = sc.nextLine();

        // Call the correct methods
        System.out.println(Compression1(str));
        System.out.println(Compression2(str));

        sc.close();
    }
}

import java.util.*;
public class MyStringExample {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        System.out.println(str.substring(2,5));

        for(int i = 0 ; i < str.length() ; i++){
            System.out.print(str.charAt(i) + " ");
        }

        System.out.println("hello" + 10 + 20);
        System.out.println(10 + 20 +"hello");


        System.out.println("Enter a string: ");
        String str1 = sc.nextLine();

        String[] parts = str1.split(" ");
        System.out.println("Parts length : "+parts.length);
        for(int i = 0 ; i < parts.length ; i++){
            System.out.println(parts[i]);
        }

        for(int i = 0 ; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++ ){
                System.out.println(str.substring(i,j));
            }
        }

        sc.close();
    }
    
}

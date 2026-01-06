package OOPsInJava;
import java.util.*;
public class OOP1{
    public static class Person{
        String name;
        int age;
        void saysHi(){
            System.out.println( name + " [ " + age + " ] says hi");
        }
        // IF WE FORGET JAVA PROVIDES OUR CLASS A DEFAULT CONSTRUCTOR

        //1.Default constructor
        Person(){
            //constructor

        }

        //2.Parameterised constructor
        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "A";
        p1.age = 10;
        //p1.saysHi();

        Person p2 = new Person();
        p2.name = "B";
        p2.age = 20;
        //p2.saysHi();

        // Person p3 = p1;
        // p3.age = 30;
        // p1.saysHi();
        // p3.saysHi();

        p1.saysHi();
        p2.saysHi();
        swap3(p1, p2);
        p1.saysHi();
        p2.saysHi();

        Person p4 = new Person(2,"B");
        p4.saysHi();


    }
    public static void swap1(Person prsn1 , Person prsn2){
        Person temp = prsn1;
        prsn1 = prsn2;
        prsn2 = temp;
    }

    public static void swap2(Person prsn1 , Person prsn2){

       int age = prsn1.age;
        prsn1.age = prsn2.age;
        prsn2.age = age;

        String name = prsn1.name;
        prsn1.name = prsn2.name;
        prsn2.name = name;
    }

    public static void swap3(Person prsn1 , Person prsn2){

        prsn1 = new Person(); 
        int age = prsn1.age;
        prsn1.age = prsn2.age;
        prsn2.age = age;
        
        prsn2 = new Person(); 
        String name = prsn1.name;
        prsn1.name = prsn2.name;
        prsn2.name = name;
     }


}
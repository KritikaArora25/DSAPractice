package JCF;
import java.util.*;


// import java.lang.reflect.Field;

// class StringLengthComparator implements Comparator<String> {

//     @Override
//     public int compare(String o1, String o2) {

//         return o1.length() - o2.length();
        
//     }
    
// }

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2){
        return 0;
    }
}

class Student{

    private String name;

    private double gpa;

    // Constructors, getters, setters

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){
        return name;
    }

    public double getGpa(){
        return gpa;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "date");
        // words.sort(new StringLengthComparator());
        words.sort((a,b) -> a.length() - b.length());
        System.out.println(words);


        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Akshit", 3.9));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort((o1,o2) -> {
            if(o2.getGpa() - o1.getGpa() > 0){
                return 1;
            }else if(o2.getGpa() - o1.getGpa() < 0){
                return -1;
            }else{
                return o2.getName().compareTo(o1.getName());
            }
        });

        // students.sort(comparator);

        for(Student s: students){
            System.out.println(s.getName() + ": " + s.getGpa());
        }

    }
}

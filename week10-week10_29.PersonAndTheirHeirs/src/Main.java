
import java.util.List;
import people.Person;
import people.Student;
import people.Teacher;

public class Main {

    public static void main(String[] args) {
        // test your code here
        Person olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);

        Object liisa = new Student("Liisa", "Väinö Auerin Street 20 00500 Helsinki");
        System.out.println(liisa);
    }

    public static void printDepartment(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

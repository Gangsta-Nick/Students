import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите информацию о студенте: ФИО, номер группы, номер студенческого билета.\nВведите `end` для завершение.");
                String[] parts = scanner.nextLine().split(",");
                String firstName = parts[0];
                if (firstName.equals("end")) {
                    students.forEach(System.out::println);
                    break;
                }
                String group = parts[1];
                String studentId = parts[2];
                Student student = new Student(firstName, group, studentId);
                if (student.hashCode() == students.hashCode()) {
                    System.out.println("Студент с таким студенческим билетом уже существует.");
                    continue;
                }
                students.add(student);
            }
        }
    }
}
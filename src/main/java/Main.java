import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Проверка Задания 1: Студенты ---
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "QA-53", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Петров", "QA-53", 1, Arrays.asList(2, 2, 3)));
        students.add(new Student("Сидоров", "QA-53", 1, Arrays.asList(5, 5, 5)));

        System.out.println("Исходный список студентов (1 курс):");
        printStudents(students, 1);

        processStudents(students);

        System.out.println("\nСписок студентов после фильтрации (переведены на 2 курс):");
        printStudents(students, 2);

        // --- Проверка Задания 2: Телефонный Справочник ---
        System.out.println("\n--- Телефонный Справочник ---");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79991112233");
        phoneBook.add("Петров", "+79992223344");
        phoneBook.add("Иванов", "+79995556677"); // Однофамилец

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Смирнов");
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            } else {
                student.nextCourse();
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Имя: " + student.getName() + ", Курс: " + student.getCourse());
            }
        }
    }
}

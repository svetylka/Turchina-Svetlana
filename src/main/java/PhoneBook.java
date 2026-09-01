import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public void get(String surname) {
        List<String> phones = book.get(surname);
        if (phones == null || phones.isEmpty()) {
            System.out.println("Фамилия " + surname + " не найдена.");
        } else {
            System.out.println("Номера для " + surname + ": " + phones);
        }
    }
}

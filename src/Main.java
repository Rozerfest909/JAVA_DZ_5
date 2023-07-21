import java.util.*;

// Задание:
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.
// Александр Мешканцов

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        Add(phonebook, "Александр", "+74951293504");
        Add(phonebook, "Екатерина", "+74959716180");
        Add(phonebook, "Александр", "+74950369234");
        Add(phonebook, "Юлия", "+74955444784");
        Add(phonebook, "Александр", "+74951327462");
        Add(phonebook, "Екатерина", "+74952286349");
        Print(phonebook);
    }
    public static void Add(HashMap<String, String> phonebook, String name, String phone) {
        phonebook.merge(name, phone, (ph1, ph2) -> ph1 + ", " + ph2);
    }

    public static void Print(HashMap<String, String> phonebook) {
        ArrayList<Map.Entry<String, String>> list_phonebook = new ArrayList<>(phonebook.entrySet());
        list_phonebook.sort((o1, o2) -> o2.getValue().length() - o1.getValue().length());
        for (Map.Entry<String, String> entry : list_phonebook) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
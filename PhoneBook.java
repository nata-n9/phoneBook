import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        List<String> phoneNumbers = phoneBook.get(name);
        if (!phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
    }

    public List<String> getPhoneNumbers(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return new ArrayList<>();
        }
    }

    public Map<String, List<String>> getPhoneBook() {
        return phoneBook;
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addEntry("Петя", "921-783-7956");
        phoneBook.addEntry("Вася", "911-987-5342");
        phoneBook.addEntry("Петя", "911-987-4587");
        phoneBook.addEntry("Петя", "901-876-7952");
        phoneBook.addEntry("Коля", "901-589-3678");
        phoneBook.addEntry("Вася", "901-528-7952");


        phoneBook.printPhoneBook();
    }
}



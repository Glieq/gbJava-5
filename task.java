import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task {
    private static Map<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (ADD, GET, REMOVE, LIST, EXIT):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("ADD")) {
                String lastName = scanner.next();
                String phoneNumber = scanner.nextLine().trim();
                addPhoneNumber(lastName, phoneNumber);
            } else if (command.equalsIgnoreCase("GET")) {
                String lastName = scanner.nextLine().trim();
                getPhoneNumbers(lastName);
            } else if (command.equalsIgnoreCase("REMOVE")) {
                String lastName = scanner.nextLine().trim();
                removePhoneNumbers(lastName);
            } else if (command.equalsIgnoreCase("LIST")) {
                listAllPhoneNumbers();
            } else if (command.equalsIgnoreCase("EXIT")) {
                break;
            } else {
                System.out.println("Неверная команда. Пожалуйста, повторите ввод.");
            }
        }
    }

    private static void addPhoneNumber(String lastName, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(lastName, numbers);
    }

    private static void getPhoneNumbers(String lastName) {
        List<String> numbers = phoneBook.get(lastName);
        if (numbers != null) {
            System.out.println(numbers);
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    private static void removePhoneNumbers(String lastName) {
        List<String> numbers = phoneBook.remove(lastName);
        if (numbers != null) {
            System.out.println("Удалены все номера по фамилии \"" + lastName + "\"");
        } else {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
    }

    private static void listAllPhoneNumbers() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String lastName = entry.getKey();
            List<String> numbers = entry.getValue();
            System.out.println(lastName + " = " + numbers);
        }
    }
}

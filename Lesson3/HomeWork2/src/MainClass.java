import phonebook.PhoneBook;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов",1234566);
        phoneBook.add("Петров",1234567);
        phoneBook.add("Сидоров",1234568);
        phoneBook.add("Воронин",1234569);
        phoneBook.add("Смирнов",1234561);
        phoneBook.add("Колягин",1234564);
        phoneBook.add("Смирнов",1234562);
        phoneBook.add("Воронин",1234537);
        phoneBook.add("Сидоров",1234547);
        phoneBook.add("Сидоров",1234517);

/*
        Scanner sc = new Scanner(System.in);
        String input;

        while (true){
            System.out.println("Введите имя абонента");
            input = sc.nextLine();

            if (input.length() == 0) {
                System.out.println("Завершение работы...");
                return;
            }

           ArrayList<Integer> phones = phoneBook.get(input);
           System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        }
*/

        String input = "Иванов";
        ArrayList<Integer> phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        input = "Воронин";
        phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        input = "Сидоров";
        phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        input = "Смирнов";
        phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        input = "Петров";
        phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

        input = "Кацев";
        phones = phoneBook.get(input);
        System.out.println("Для абонента "+input+ ((phones == null)?" номера не найдены!" :" найдены следующие номера: "+phones));

    }

}

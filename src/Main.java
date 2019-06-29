import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        printMenu();
        boolean quit = false;

        while (!quit) {
            int input = getInput();

            switch (input) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    phoneBook.showContacts();
                    break;
                case 2:
                    phoneBook.addContact();
                    break;
                case 3:
                    phoneBook.deleteContact();
                    break;
                case 4:
                    phoneBook.modifyContact();
                    break;
                case 5:
                    System.out.println("Quit program");
                    quit = true;
            }
        }

        s.close();
    }

    public static void printMenu() {
        System.out.println("Welcome to mobile phone book app! Here is your options:");
        System.out.println("1: show contacts.");
        System.out.println("2: add new contact.");
        System.out.println("3: delete contact.");
        System.out.println("4: modify contact.");
        System.out.println("5: quit.");
        System.out.println("0: show menu. \n");
    }

    public static int getInput() {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter option (0 for menu): ");

            if (s.hasNextInt()) {
                input = s.nextInt();
                if (input >= 0 && input < 6) {
                    isValid = true;
                } else {
                    System.out.println("Error. Nu such option in menu! Try again. \n");
                }
            } else {
                System.out.println("Error. Enter integer. \n");
                s.next();
            }
        }

        return input;
    }
}

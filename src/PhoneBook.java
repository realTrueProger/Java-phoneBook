import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private ArrayList<Contact> phoneBook = new ArrayList<Contact>();
    public static Scanner s = new Scanner(System.in);

    public ArrayList<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void showContacts() {
        System.out.println("Contacts list:");
        if (phoneBook.size() > 0) {
            for (int i = 0; i < phoneBook.size(); i++) {
                System.out.println((i + 1) + " " + phoneBook.get(i).getName() + " " + phoneBook.get(i).getPhone());
            }
        } else {
            System.out.println("No contacts");
        }
    }

    public void addContact() {
        System.out.println("Please enter name");
        String name = s.nextLine();
        if (isDuplicate(name)) {
            System.out.println("Duplicate contacts not allowed. " + name.toLowerCase() + " contact is already exists");
        } else {
            System.out.println("Please enter phone number");
            String number = s.nextLine();

            phoneBook.add(new Contact(name, number));
        }
    }

    public void deleteContact() {
        System.out.println("Enter contact to delete");
        String name = s.nextLine();
        int position = getPosition(name);
        if (position > -1) {
            phoneBook.remove(position);
            System.out.println("Contact: " + name + " deleted successful");
        } else {
            System.out.println("Contact not found");
        }
    }

    public void modifyContact() {
        System.out.println("Enter contact to edit");
        String name = s.nextLine();
        int position = getPosition(name);
        if (position > -1) {
            System.out.println("New name:");
            String newName = s.nextLine();
            System.out.println("New phone:");
            String newPhone = s.nextLine();
            phoneBook.set(position, new Contact(newName, newPhone));
        } else {
            System.out.println("Contact not found");
        }
    }

    private int getPosition(String name) {
        int position = -1;

        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                position = i;
                break;
            }
        }

        return position;
    }

    private boolean isDuplicate(String name) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (name.toLowerCase().equals(phoneBook.get(i).getName().toLowerCase()))
                return true;
        }

        return false;
    }
}

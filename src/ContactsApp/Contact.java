package ContactsApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contact {


    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static List<ContactInfo> contactObjects = new ArrayList<ContactInfo>();

    public boolean yesNo() {
        String userBoolean = scanner.next();
        return userBoolean.equalsIgnoreCase("yes") || userBoolean.equalsIgnoreCase("y");
    }

    public static boolean yesNo(String userPrompt) {
        System.out.println(userPrompt);
        String userBoolean = sc.next();
        return userBoolean.equalsIgnoreCase("yes") || userBoolean.equalsIgnoreCase("y");
    }


    public static void listStart() {
        String directory = "src/ContactsApp";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectory(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        loadContacts(dataFile);
    }

    public static void loadContacts(Path dataFile) {
        try {
            List<String> contacts = Files.readAllLines(dataFile);
            for (String contact : contacts) {
                ContactInfo c1 = new ContactInfo(contact);
//                String[] numberArray = c1.getNumber().split("");
//                List<String> newArray = new ArrayList<String>();
//                for (String number : numberArray) {
//                    newArray.add(number);
//                }
//                if (!(Objects.equals(newArray.get(4), "-"))){
//                    newArray.add(4, "-");
//                } else if (!(Objects.equals(newArray.get(8), "-"))) {
//                    newArray.add(8, "-");
//                }
//                String str = "";
//                for (String number : newArray) {
//                    str += number;
//                }
//                c1.setNumber(str);
                contactObjects.add(c1);

//                System.out.println(c1);
//                String[] contactArray = contact.split("");
//                List<String> newArray = new ArrayList<String>();
//                for (String text : contactArray) {
//                    newArray.add(text);
//                }
//                newArray.add(21, "-");
//                newArray.add(25, "-");
//                String str = "";
//                for (String text : newArray) {
//                    str += text;
//                }
//                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void viewContacts() {
        System.out.println(String.format("%-15s | %-16s |", "Name", "Phone number"));
        System.out.println("------------------------------------");
        for (ContactInfo contact : contactObjects) {
            System.out.println(contact);
        }

    }

    public static void addContacts() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter name: ");
        String addName = scanner.next();
        System.out.println("Enter Number: ");
        String addNumber = scanner.next();
        String[] numberArray = addNumber.split("");
//        System.out.println(Arrays.toString(numberArray));
        List<String> newArray = new ArrayList<>();
        for (String number : numberArray) {
            newArray.add(number);
        }

        /// OVERWRITE EXISTING CONTACT LOGIC
//        for (ContactInfo contact : contactObjects) {
//            if (contact.getName().equals(addName)) {
//                if (!yesNo("Contact already exists, would you like to overwrite it? yes/no")) {
//                addContacts();
//                }
//            }
//        }
            if (newArray.size() == 10) {
            newArray.add(3, "-");
            newArray.add(7, "-");
                String str = "";
                for (String number : newArray) {
                    str += number;
                }

                ContactInfo newContact = new ContactInfo(addName, str);
                contactObjects.add(newContact);
            } else if (newArray.size() == 7) {
            newArray.add(3, "-");
                String str = "";
                for (String number : newArray) {
                    str += number;
                }
                ContactInfo newContact = new ContactInfo(addName, str);
                contactObjects.add(newContact);
            } else {
                System.out.println("Invalid number, re-enter contact information.");
                addContacts();
            }
//        String str = "";
//        for (String number : newArray) {
//            str += number;
//        }

//        ContactInfo newContact = new ContactInfo(addName, str);
//        contactObjects.add(newContact);
//        String formattedAdd = String.format("%-15s | %-14d |", addName, addNumber);
//        try {
//            Files.write(
//                    dataFile, Arrays.asList(newContact.toString()), StandardOpenOption.APPEND
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void findContacts() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the name of who you are looking for: ");
        String findName = scanner.next();
        System.out.println(String.format("%-15s | %-16s |", "Name", "Phone number"));
        System.out.println("------------------------------------");

//            List<String> contacts = Files.readAllLines(dataFile);
        for (ContactInfo contact : contactObjects) {
            if (contact.getName().contains(findName)) {
//                    ContactInfo c1 = new ContactInfo(contact.);
//                    String[] numberArray = contact.getNumber().split("");
//                    List<String> newArray = new ArrayList<String>();
//                    for (String number : numberArray) {
//                        newArray.add(number);
//                    }
//                    newArray.add(4, "-");
//                    newArray.add(8,"-");
//                    String str ="";
//                    for (String number : newArray){
//                        str+= number;
//                    }
//                    contact.setNumber(str);
                System.out.println(contact);
//                    String[] contactArray = contact.split("");
//                    List<String> newArray = new ArrayList<String>();
//                    for (String text : contactArray) {
//                        newArray.add(text);
//                    }
//                    newArray.add(21, "-");
//                    newArray.add(25, "-");
//                    String str = "";
//                    for (String text : newArray) {
//                        str += text;
//                    }
//                    System.out.println(str);
            }
        }

    }

    public static void deleteContacts() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the name of who you want to delete: ");
        String deleteName = scanner.next();
        contactObjects.removeIf(contact -> contact.getName().contains(deleteName));
    }

    public static void bye(Path dataFile) {
        try {
            List<String> bucket = new ArrayList<>();

            for (ContactInfo contact : contactObjects) {
                String str = contact.toString();
                bucket.add(str);

            }
//            List<String> contacts = Files.readAllLines(dataFile);
            Files.write(dataFile, bucket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void contactMenu() {
        String directory = "src/ContactsApp";
        String filename = "contacts.txt";
        Path dataFile = Paths.get(directory, filename);
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        List<String> menuList = Arrays.asList("View contacts.", "Add a new contact.", "Search a contact by name.", "Delete an existing contact.", "Exit.");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ": " + menuList.get(i));
        }

        System.out.println("Enter an option (1, 2, 3, 4, or 5)");
        int userInt = scanner.nextInt();

        switch (userInt) {
            case 1:
                viewContacts();
                System.out.println("--------");
                contactMenu();
                break;
            case 2:
                addContacts();
                System.out.println("--------");
                contactMenu();
                break;
            case 3:
                findContacts();
                System.out.println("--------");
                contactMenu();
                break;
            case 4:
                deleteContacts();
                System.out.println("--------");
                contactMenu();
            case 5:
//                System.out.println("Bye.");
                bye(dataFile);
        }
    }


    public static void main(String[] args) {
        listStart();
        contactMenu();

    }
}
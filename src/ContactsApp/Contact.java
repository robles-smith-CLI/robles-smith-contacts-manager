package ContactsApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contact {

    public static void listStart() {
        String directory = "ContactsApp";
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
    }

    public static void main(String[] args) {
        String directory = "ContactsApp";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        listStart();

        List<String> menuList = Arrays.asList("View contacts.", "Add a new contact.", "Search a contact by name.", "Delete an existing contact.", "Exit.");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ": " + menuList.get(i));
        }
        System.out.println("Enter an option (1, 2, 3, 4, or 5");
        int userInt = scanner.nextInt();

        switch (userInt) {
            case 1:
                try {
                    List<String> contacts = Files.readAllLines(dataFile);
                    for (String contact : contacts) {
                        System.out.println(contact);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
        }


    }
}
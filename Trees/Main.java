//zZeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cms cms = new cms();
        String filePath = "contacts.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Contact contact = new Contact(data[0], data[1], data[2], data[3]);
                cms.insert(contact);
                System.out.println("Contact details loaded successfully!\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Welcome to the Contact Management System!");
        System.out.println("Reading contact details from file...\n");

        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Please select an option:");
            System.out.println("1. Display contacts (Preorder)");
            System.out.println("2. Display contacts (Inorder)");
            System.out.println("3. Display contacts (Postorder)");
            System.out.println("4. Search for a contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    cms.displayPreorder(cms.getRoot());
                    break;

                case 2:
                    cms.displayInorder(cms.getRoot());
                    break;

                case 3:
                    cms.displayPostorder(cms.getRoot());
                    break;

                case 4:
                    System.out.print("Enter last name to search: ");
                    String lastName = input.next();
                    Contact foundContact = cms.search(lastName); // Searching for the provided last name
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter last name to delete: ");
                    lastName = input.next();
                    cms.delete(lastName); // Deleting the contact with the provided last name
                    System.out.println("Contact deleted successfully (if found).");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        input.close();
    }
}

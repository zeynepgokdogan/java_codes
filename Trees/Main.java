//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManagementSystem cms = new ContactManagementSystem();
        String filePath = "contacts.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Contact contact = new Contact(data[0], data[1], data[2], data[3]);
                cms.insert(contact);
            }
            System.out.println("Contact details loaded successfully!\n");
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
            System.out.print("\nYour choice: ");
            choice = input.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1:
                    System.out.println("Displaying contacts (Preorder): ");
                    cms.displayPreorder(cms.getRoot());
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("Displaying contacts (Inorder): ");
                    cms.displayInorder(cms.getRoot());
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("Displaying contacts (Postorder): ");
                    cms.displayPostorder(cms.getRoot());
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.print("Enter the last name of the contact you want to search for: ");
                    String lastName = input.next();
                    Contact foundContact = cms.search(lastName);
                    if (foundContact != null) {
                        System.out.println("\nContact found: \n-" + foundContact + "\n");
                    } else {
                        System.out.println("Contact not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter the last name of the contact you want to delete: ");
                    lastName = input.next();
                    cms.delete(lastName);
                    System.out.println("\nContact deleted successfully!\n");
                    break;

                case 6:
                    System.out.println("Exiting and saving contact details to file...\n");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
        input.close();
    }
}

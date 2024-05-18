//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String filePath = "sentences.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("Input file content has been read from \"" + filePath + "\"");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        Elections elections = new Elections(wordCount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Get the count of a specific word");
            System.out.println("2. Get the most frequent words");
            System.out.println("3. Get the least frequent words");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the word:");
                    String word = scanner.nextLine();
                    elections.election_1(word);
                    break;
                case 2:
                    System.out.println("Enter the number of words:");
                    int number_1 = scanner.nextInt();
                    scanner.nextLine();
                    elections.election_2(number_1);
                    break;
                case 3:
                    System.out.println("Enter the number of words:");
                    int number_2 = scanner.nextInt();
                    scanner.nextLine();
                    elections.election_3(number_2);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

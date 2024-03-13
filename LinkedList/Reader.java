//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private static boolean innerShouldBreak = false;

    private static Integer dotRemover(String str) {
        String withoutDots = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                withoutDots += str.charAt(i);
            }
        }
        return Integer.parseInt(withoutDots);
    }

    public static void main(String[] args) {

        DoublyLinkedList countryList = new DoublyLinkedList();
        String filePath = "input.txt";

        try (BufferedReader inputReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputReader.readLine()) != null) {
                String[] words = line.split(" ");
                Country country = new Country(words[0], words[1], words[2],
                        words[3], words[4], words[5]);
                countryList.add(country);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath2 = "query.txt";
        try (BufferedReader queryReader = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = queryReader.readLine()) != null) {
                System.out.println("\n");

                String[] words = line.split(" ");
                processQueries(countryList, words, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void processQueries(DoublyLinkedList countryList, String[] words, String line) {
        Node current = countryList.head;
        String queryType = words[0];
        String queryType2 = words[1];

        while (current != null) {
            switch (queryType) {
                case "Query":
                    System.out.println(line);
                    processQuery(countryList, current, queryType2, words);
                    break;

                case "Add":
                    System.out.println(line + ":");
                    String addCountryName = words[1];
                    String addPopulation = words[2];
                    String addCapitalCity = words[3];
                    String addLargestCity = words[4];
                    String addOfficialLanguage = words[5];
                    String addCurrency = words[6];

                    Country countryToAdd = new Country(addCountryName, addPopulation, addCapitalCity,
                            addLargestCity, addOfficialLanguage, addCurrency);

                    if (!countryList.containsCountry(addCountryName)) {
                        countryList.insertFirst(countryToAdd);
                        System.out.println("Adds a new country at the beginning of the list.");
                    }
                    innerShouldBreak = true;
                    break;

                case "Delete":
                    System.out.println(line + ":");
                    String deleteCountry = words[1];
                    countryList.delete(deleteCountry);
                    innerShouldBreak = true;
                    System.out.println("Removes the country " + deleteCountry + " from the list.");
                    break;

                default:
                    System.out.println("Invalid operation type !!");
                    break;
            }

            if (innerShouldBreak) {
                break;
            }

            current = current.next;
        }
    }

    private static void processQuery(DoublyLinkedList countryList, Node current, String queryType2, String[] words) {

        switch (queryType2) {

            case "population":
                String queryType3 = words[2];
                int queryPopulation = dotRemover(words[3]);
                switch (queryType3) {
                    case ">":
                        while (current != null) {
                            if (dotRemover(current.data.getPopulation()) > queryPopulation) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "<":
                        while (current != null) {
                            if (dotRemover(current.data.getPopulation()) < queryPopulation) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }

                        break;
                    case "=":
                        while (current != null) {
                            if (dotRemover(current.data.getPopulation()) == queryPopulation) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    default:
                        System.out.println("Invalid population!!");
                        break;
                }
                innerShouldBreak = true;
                break;

            case "country":
                String queryCountryName = words[3];
                String queryType4 = words[2];
                switch (queryType4) {
                    case ">":
                        while (current != null) {
                            if (current.data.getCountryName()
                                    .compareToIgnoreCase(queryCountryName) > 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "<":
                        while (current != null) {
                            if (current.data.getCountryName()
                                    .compareToIgnoreCase(queryCountryName) < 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "=":
                        while (current != null) {
                            if (current.data.getCountryName().equalsIgnoreCase(queryCountryName)) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    default:
                        System.out.println("Invalid country!!");
                        break;
                }
                innerShouldBreak = true;
                break;

            case "capital_city":
                String queryCapitalCity = words[3];
                String queryType5 = words[2];
                switch (queryType5) {
                    case ">":
                        while (current != null) {
                            if (current.data.getCapitalCity()
                                    .compareToIgnoreCase(queryCapitalCity) > 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "<":
                        while (current != null) {
                            if (current.data.getCapitalCity()
                                    .compareToIgnoreCase(queryCapitalCity) < 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "=":
                        while (current != null) {
                            if (current.data.getCapitalCity().equalsIgnoreCase(queryCapitalCity)) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    default:
                        System.out.println("Invalid capital_city!!");
                        break;
                }
                innerShouldBreak = true;
                break;

            case "largest_city":
                String queryLargestCity = words[3];
                String queryType6 = words[2];
                switch (queryType6) {
                    case ">":
                        while (current != null) {
                            if (current.data.getLargestCity()
                                    .compareToIgnoreCase(queryLargestCity) > 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "<":
                        while (current != null) {
                            if (current.data.getLargestCity()
                                    .compareToIgnoreCase(queryLargestCity) < 0) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    case "=":
                        while (current != null) {
                            if (current.data.getLargestCity().equalsIgnoreCase(queryLargestCity)) {
                                current.data.displayCountry();
                            }
                            current = current.next;
                        }
                        break;
                    default:
                        System.out.println("Invalid largest_city!!");
                        break;
                }
                innerShouldBreak = true;
                break;

            case "currency":
                String queryCurrency = words[3].toUpperCase();
                String queryType7 = words[2];
                char queryLetter = queryCurrency.charAt(0);

                while (current != null) {
                    String currencyFirstLetter = current.data.getCurrency().toUpperCase().substring(0, 1);

                    switch (queryType7) {
                        case ">":
                            if (Character.compare(queryLetter, currencyFirstLetter.charAt(0)) < 0) {
                                current.data.displayCountry();
                                innerShouldBreak = true;
                                break;
                            }
                            break;
                        case "<":
                            if (Character.compare(queryLetter, currencyFirstLetter.charAt(0)) > 0) {
                                current.data.displayCountry();
                                innerShouldBreak = true;
                                break;
                            }
                            break;
                        case "=":
                            if (queryLetter == currencyFirstLetter.charAt(0)) {
                                current.data.displayCountry();
                                innerShouldBreak = true;
                                break;
                            }
                            break;
                        default:
                            System.out.println("Invalid currency!!");
                            innerShouldBreak = true;
                            break;
                    }

                    current = current.next;

                }
                break;

            case "print_all":
                countryList.displayList();
                innerShouldBreak = true;
                break;

            default:
                System.out.println("Invalid query type!!");
                innerShouldBreak = true;
                break;
        }
    }

}
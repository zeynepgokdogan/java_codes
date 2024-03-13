//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

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

        // Read the index.txt
        DoublyLinkedList countryList = new DoublyLinkedList();
        String filePath = "input.txt";

        try (BufferedReader inputReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputReader.readLine()) != null) {
                String[] words = line.split(" ");
                Country country = new Country(words[0], words[1], words[2],
                        words[3], words[4], words[5]);
                countryList.insertFirst(country);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read the query.txt
        String filePath2 = "query.txt";
        try (BufferedReader queryReader = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = queryReader.readLine()) != null) {
                System.out.println("\n");
                System.out.println(line);
                String[] words = line.split(" ");
                Node current = countryList.head;
                String queryType = words[0];
                String queryType2 = words[1];


                boolean innerShouldBreak = false;
                while (current != null) {
                    if (queryType.equals("Query")) {

                        switch (queryType2) {

                            case "population":
                                String queryType3 = words[2];
                                int queryPopulation = dotRemover(words[3]);
                                switch (queryType3) {
                                    case ">":
                                        if (dotRemover(current.data.getPopulation()) > queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    case "<":
                                        if (dotRemover(current.data.getPopulation()) < queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    case "=":
                                        if (dotRemover(current.data.getPopulation()) == queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    default:
                                        break;
                                }
                                innerShouldBreak= true;
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
                                        break;
                                }
                                innerShouldBreak= true;
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
                                        break;
                                }
                                innerShouldBreak= true;
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
                                        break;
                                }
                                innerShouldBreak= true;
                                break;

                            case "currency":
                                String queryCurrency = words[3];
                                String queryType7 = words[2];
                                switch (queryType7) {
                                    case ">":
                                        while (current != null) {
                                            if (current.data.getCurrency().compareToIgnoreCase(queryCurrency) > 0) {
                                                current.data.displayCountry();
                                            }
                                            current = current.next;
                                        }
                                        break;
                                    case "<":
                                        while (current != null) {
                                            if (current.data.getCurrency().compareToIgnoreCase(queryCurrency) < 0) {
                                                current.data.displayCountry();
                                            }
                                            current = current.next;
                                        }
                                        break;
                                    case "=":
                                        while (current != null) {
                                            if (current.data.getCurrency().equalsIgnoreCase(queryCurrency)) {
                                                current.data.displayCountry();
                                            }
                                            current = current.next;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                innerShouldBreak= true;
                                break;

                            case "print_all":
                                countryList.displayList();
                                break;

                            default:
                            System.out.println("Invalid query type");
                            innerShouldBreak= true;
                                break;
                        }
                    }

                    else {
                        switch (queryType) {
                            case "Add":
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
                                }
                                innerShouldBreak= true;
                                break;

                                case "Delete":
                                String deleteCountry = words[1];
                                countryList.delete(deleteCountry);
                                innerShouldBreak= true;
                                break;

                            default:
                            System.out.println("Invalid operation type");
                            innerShouldBreak= true;
                                break;
                        }
                    }
                    if (current != null) {
                        current = current.next;
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        countryList.displayList();
    }
}
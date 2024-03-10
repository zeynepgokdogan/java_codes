//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) {

        // Read the index.txt
        DoublyLinkedList countryList = new DoublyLinkedList();
        String filePath = "input.txt";

        try (BufferedReader inputReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputReader.readLine()) != null ) {
                String[] words = line.split(" ");
                Country country = new Country(words[0], Integer.parseInt(words[1]), words[2],
                        words[3], words[4], words[5]);
                countryList.insertLast(country);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read the query.txt
        String filePath2 = "query.txt";
        try (BufferedReader queryReader = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = queryReader.readLine()) != null) {
                String[] words = line.split(" ");
                Node current = countryList.head;
   System.out.println(line);
                String queryType = words[0];
                String queryType2 = words[1];
                
             
            
                while (current != null) {
                    if (queryType.equals("Query")) {

                        switch (queryType2) {

                            case "population":
                                String queryType3 = words[2];
                                int queryPopulation = Integer.parseInt(words[2]);
                                switch (queryType3) {
                                    case ">":
                                        if (current.data.getPopulation() > queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    case "<":
                                        if (current.data.getPopulation() < queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    case "=":
                                        if (current.data.getPopulation() == queryPopulation) {
                                            current.data.displayCountry();
                                        }

                                        break;
                                    default:
                                        break;
                                }
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

                                break;

                            case "print_all":
                                countryList.displayList();
                                break;

                            default:
                                System.out.println(
                                        "here is an element in the text that does not harmonise with the list");

                                break;
                        }
                    }

                    else {
                        switch (queryType) {
                            case "Add":
                                String addCountryName = words[1];
                                int addPopulation = Integer.parseInt(words[2]);
                                String addCapitalCity = words[3];
                                String addLargestCity = words[4];
                                String addOfficialLanguage = words[5];
                                String addCurrency = words[6];

                                Country countryToAdd = new Country(addCountryName, addPopulation, addCapitalCity,
                                        addLargestCity, addOfficialLanguage, addCurrency);
                                countryList.insertLast(countryToAdd);
                                System.out.println("A new country has been added.");

                                break;

                            case "Delete":
                                String deleteCountryName = words[1];
                                Node deleteCurrent = countryList.head;
                                while (deleteCurrent != null) {
                                    if (deleteCurrent.data.getCountryName().equalsIgnoreCase(deleteCountryName)) {
                                        if (deleteCurrent.previous != null) {
                                            deleteCurrent.previous.next = deleteCurrent.next;
                                        } else {
                                            countryList.head = deleteCurrent.next;
                                        }

                                        if (deleteCurrent.next != null) {
                                            deleteCurrent.next.previous = deleteCurrent.previous;
                                        } else {
                                            countryList.tail = deleteCurrent.previous;
                                        }

                                        System.out.println("Silindi: " + deleteCountryName);
                                        break;
                                    }
                                    deleteCurrent = deleteCurrent.next;
                                }
                                System.out.println(
                                        "Delete" + deleteCountryName + " Removes the country USA from the list.");
                                break;
                            default:
                                break;
                        }
                    }
                    current = current.next;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        countryList.displayList();
    }
}
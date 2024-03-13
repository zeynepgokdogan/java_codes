//Zeynep Gokdogan
public class Country {
    private String countryName;
    private String population;
    private String capitalCity;
    private String largestCity;
    private String officialLanguage;
    private String currency;

    public Country(String countryName, String population, String capitalCity, String largestCity,
            String officialLanguage,
            String currency) {
        this.countryName = countryName;
        this.population = population;
        this.capitalCity = capitalCity;
        this.largestCity = largestCity;
        this.officialLanguage = officialLanguage;
        this.currency = currency;

    }

    public void displayCountry() {
        System.out.println(countryName + " " + population + " " + capitalCity + " "
                + largestCity + " " + officialLanguage + " " + currency);
    }

    public String getCountryName() {
        return countryName;
    }

    public String getPopulation() {
        return population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }

    public String getCurrency() {
        return currency;
    }

}

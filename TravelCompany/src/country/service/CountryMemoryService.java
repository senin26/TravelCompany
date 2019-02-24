package country.service;


import country.Country;
import country.repo.CountryMemoryRepo;

public class CountryMemoryService {

    private CountryMemoryRepo countryRepo = new CountryMemoryRepo();

    public void addCountry(Country country) {
        countryRepo.addCountry(country);
    }

    public Country findCountryByID(long id) {
        return countryRepo.findCountryByID(id);
    }

    public void deleteCountry(Country country) {
        countryRepo.deleteCountry(country);
    }

    public void deleteCountry(Long id) {
        countryRepo.deleteCountry(id);
    }

    public void printCountrys() {
        countryRepo.printCountries();
    }

}

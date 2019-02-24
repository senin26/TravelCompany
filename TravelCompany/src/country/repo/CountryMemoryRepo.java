package country.repo;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;
import common.ArrayUtils;
import country.Country;

import static storage.Storage.countries;

public class CountryMemoryRepo extends AbstractMemoryRepo {

    private int countryIndex = -1;

    @Override
    public void add (TravelCompanyRepo country) {
        if (countryIndex == countries.length - 1){
            Country[] countriesTemp = new Country[countries.length + (countries.length>>1)];
            System.arraycopy(countries,0,countriesTemp,0,countries.length);
            countries = countriesTemp;
        }
        countryIndex++;
        countries[countryIndex] = (Country) country;
    }

    @Override
    public void delete (TravelCompanyRepo country) {
        Integer index = findIndexByEntity((Country) country);
        if (index!=null) {
            deleteByIndex(index);
        }
    }

    @Override
    public Integer findIndexByEntity(TravelCompanyRepo country) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Country findByID (long id) {
        Integer index = findIndexById(id);
        if (index!=null) {
            return countries[index];
        }
        return null;
    }

    @Override
    protected void deleteByIndex (int index) {
        ArrayUtils.deleteByIndex(countries,index);
        countryIndex--;
    }

    @Override
    public void print () {
        for (Country u: countries) {
            System.out.println(u);
        }
    }

    @Override
    public Integer findIndexById (Long id) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

}

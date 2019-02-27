package storage;

import city.City;
import city.domain.City;
import country.Country;
import user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 3;
    public static List<User> users = new ArrayList<>(CAPACITY);
    public static List<City> cities = new ArrayList<>(CAPACITY);
    public static List<Country> countries = new ArrayList<>(CAPACITY);
    public static List<City> cities = new ArrayList<>(CAPACITY);
}

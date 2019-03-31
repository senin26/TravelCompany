package storage;

import city.domain.City;
import country.domain.Country;
import order.domain.Order;
import user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 3;

    public static User[] usersArray = new User[CAPACITY];
    public static Order[] ordersArray = new Order[CAPACITY];
    public static Country[] countriesArray = new Country[CAPACITY];
    public static City[] citiesArray = new City[CAPACITY];

    public static List<User> usersList = new ArrayList<>(CAPACITY);
    public static List<Order> ordersList = new ArrayList<>(CAPACITY);
    public static List<Country> countriesList = new ArrayList<>(CAPACITY);
    public static List<City> citiesList = new ArrayList<>(CAPACITY);
}

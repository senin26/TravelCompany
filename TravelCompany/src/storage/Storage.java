package storage;

import city.City;
import country.Country;
import order.Order;
import user.User;

public class Storage {
    private static final int CAPACITY = 3;
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
}

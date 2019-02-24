package user;


import base.TravelCompanyRepo;
import order.Order;

import java.util.Arrays;

public class User implements TravelCompanyRepo {

    private Long id;
    private String firstName;
    private String lastName;
    private int passportSerialNum;
    private int passportNum;
    private int age;
    private Order[] orders;
    private UserCategory userCategory;
    private int discountPercent;

    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportSerialNum=" + passportSerialNum +
                ", passportNum=" + passportNum +
                ", age=" + age +
                ", orders=" + Arrays.toString(orders) +
                '}';
    }
}
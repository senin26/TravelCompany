package user.domain;

import common.business.domain.BaseDomain;
import order.domain.Order;
import storage.SequenceGenerator;

import java.util.Arrays;

public class User extends BaseDomain {

    private Long id;
    private String firstName;
    private String lastName;
    private int passportSerialNum;
    private int passportNum;
    private int age;
    private Order[] orders;
    private ClientType clientType;
    private int discountPercent;
    private static SequenceGenerator sequenceGenerator;
    //todo implement Builder pattern here!

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
        return  "\n" + "User {" + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                "age=" + age + "\n" +
                "}";
    }

    /*@Override
    public String toString() {
        return  "\n" + "User {" + "\n" +
                "id=" + id + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                "passportSerialNum=" + passportSerialNum + "\n" +
                "passportNum=" + passportNum + "\n" +
                "age=" + age + "\n" +
                "cities=" + Arrays.toString(orders) + "\n" +
                "}";
    }*/

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
}
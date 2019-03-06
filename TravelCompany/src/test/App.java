package test;

public class App {

    public static void main(String[] args) {

        User user = new User();
        Order order = new Order();

        user.add(3253);
        user.add(1454);
        user.add(34436);
        user.add(3253);
        user.add(1454);
        user.add(34436);

        order.add(1);
        order.add(4);
        order.add(785);

        System.out.println(user.getId());
        System.out.println(order.getId());

    }

}

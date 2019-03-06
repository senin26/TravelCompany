package test;

import java.util.ArrayList;
import java.util.List;

public class Order extends Base implements OrderI {

    List<Integer> list = new ArrayList<>();

    public Order() {
        baseGenerator = new OrderIdGenerator();
    }

    @Override
    public void add(int i) {
        super.add(i);
        setId(baseGenerator.getValue());
    }

}

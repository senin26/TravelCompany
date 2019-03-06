package test;

import java.util.ArrayList;
import java.util.List;

public class User extends Base implements UserI {

    List<Integer> list = new ArrayList<>();

    public User() {
        baseGenerator = new UserIdGenerator();
    }

    @Override
    public void add(int i) {
        super.add(i);
        setId(baseGenerator.getValue());
    }

}

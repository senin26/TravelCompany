package test;

import java.util.ArrayList;
import java.util.List;

public class Base {

    protected int id;
    protected List<Integer> list = new ArrayList<>();
    protected BaseGenerator baseGenerator;


    public void add(int i) {
        list.add(i);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

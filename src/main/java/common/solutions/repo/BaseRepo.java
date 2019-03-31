package common.solutions.repo;

import java.util.List;

public interface BaseRepo<TYPE, ID> {

    void insert(TYPE t);

    void update(TYPE t);

    TYPE findById(ID id);

    void deleteById(ID id);

    void printAll();

    List<TYPE> findAll();

}

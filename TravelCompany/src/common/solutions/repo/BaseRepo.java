package common.solutions.repo;

public interface BaseRepo<TYPE, ID> {

    void add(TYPE t);

    void update(TYPE t);

    TYPE findById(ID id);

    void deleteById(long id);

    void printAll();

}

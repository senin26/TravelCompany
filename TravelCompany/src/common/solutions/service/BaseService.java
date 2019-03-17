package common.solutions.service;

import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface BaseService<TYPE, ID> {

    void add(TYPE t);

    TYPE findById(ID id);

    void delete(TYPE t);

    void update(TYPE t);

    void deleteById(ID id);

    void printAll();

}

package common.business.service;

import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface BaseService<TYPE, ID> {

    void add(TYPE t);

    TYPE findById(Long id);

    void delete(TYPE t);

    void update(TYPE t);

    void deleteById(Long id);

    void printAll();

}

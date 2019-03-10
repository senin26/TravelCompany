package common.business.service;

import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface BaseService<T, SearchCondition> {

    void add(T t);

    T findById(Long id);

    void delete(T t);

    List<T> search(SearchCondition searchCondition);

    void update(T t);

    void deleteById(Long id);

    void printAll();

}

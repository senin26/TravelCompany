package common.business.repo;

import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface BaseRepo<T, SearchCondition> {

    void add(T t);

    T findById(long id);

    List<T> search(SearchCondition searchCondition);

    void update(T t);

    void deleteById(long id);

    void printAll();
}

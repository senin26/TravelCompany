package user.service;

import common.business.service.BaseService;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {

    void add(User user);

    User findById(Long id);

    void delete(User user);

    List<User> search(UserSearchCondition searchCondition);

    void update(User user);
}

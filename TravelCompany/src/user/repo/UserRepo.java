package user.repo;

import common.business.repo.BaseRepo;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo {

    void add(User user);

    User findById(long id);

    List<User> search(UserSearchCondition searchCondition);

    void update(User user);
}

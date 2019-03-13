package user.repo;

import common.solutions.repo.BaseRepo;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {
List<User> search(UserSearchCondition userSearchCondition);
}

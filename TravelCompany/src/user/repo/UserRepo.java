package user.repo;

import common.business.repo.BaseRepo;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, UserSearchCondition> {
}

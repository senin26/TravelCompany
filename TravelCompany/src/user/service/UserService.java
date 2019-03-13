package user.service;

import common.business.service.BaseService;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    List<User> search(UserSearchCondition searchCondition);
}

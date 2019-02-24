package user.service;

import baserepo.AbstractMemoryRepo;
import baseservice.AbstractMemoryService;
import user.User;
import user.repo.UserMemoryRepo;

public class UserMemoryService extends AbstractMemoryService {

    public UserMemoryService(UserMemoryRepo repo) {
        this.repo = repo;
    }

}
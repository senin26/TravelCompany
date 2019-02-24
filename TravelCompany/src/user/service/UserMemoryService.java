package user.service;

import baserepo.AbstractMemoryRepo;
import baseservice.AbstractMemoryService;
import user.User;
import user.repo.UserMemoryRepo;

public class UserMemoryService extends AbstractMemoryService {
    UserMemoryRepo repo = new UserMemoryRepo();
}
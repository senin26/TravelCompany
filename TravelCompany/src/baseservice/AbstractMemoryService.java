package baseservice;

import base.TravelCompanyRepo;
import baserepo.AbstractMemoryRepo;
import user.domain.User;

public abstract class AbstractMemoryService {

    protected AbstractMemoryRepo repo;

    public void add(TravelCompanyRepo travelCompanyRepo) {
        repo.add(travelCompanyRepo);
    }

   /* public User findByID(long id) {
        return repo.findByID(id);
    }*/

    public void delete(TravelCompanyRepo travelCompanyRepo) {
        repo.delete(travelCompanyRepo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void print() {
        repo.print();
    }

}

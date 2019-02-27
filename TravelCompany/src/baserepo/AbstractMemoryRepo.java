package baserepo;

import base.TravelCompanyRepo;

public abstract class AbstractMemoryRepo {

     public void deleteById (Long id) {
        Integer index = findIndexById(id);
        if (index!=null) {
            deleteByIndex(index);
        }
    }

    public abstract void add (TravelCompanyRepo travelCompanyRepo);

    public abstract void delete (TravelCompanyRepo travelCompanyRepo);

    public abstract Integer findIndexByEntity(TravelCompanyRepo travelCompanyRepo);

    protected abstract void deleteByIndex (int index);

    public abstract void print();

    protected abstract Integer findIndexById (Long id);

    public abstract TravelCompanyRepo findByID (long id);


}

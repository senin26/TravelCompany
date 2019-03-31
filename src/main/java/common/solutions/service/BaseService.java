package common.solutions.service;

import common.business.exceptions.TravelCompanyUncheckedException;
import common.solutions.functionaldomainsolutions.Replaceable;

import java.util.List;

public interface BaseService<TYPE, ID> {

    void insert(TYPE entity);

    void update(TYPE entity);

    TYPE findById(ID id);

    void deleteById(ID id) throws TravelCompanyUncheckedException;

    void delete(TYPE entity);

    void printAll();

    List<TYPE> findAll();

}
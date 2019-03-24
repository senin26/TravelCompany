package country.search;

import common.business.search.BaseSearchCondition;
import country.domain.Climate;

import static common.solutions.utils.StringUtils.isNotBlank;

public class CountrySearchCondition extends BaseSearchCondition<Long> {
    private String name;
    private Climate climate;
    private CountryOrderByField orderByField;

    public boolean searchByName() {
        return isNotBlank(name);
    }

    public boolean searchByCountry() {
        return isNotBlank(climate.name());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public CountryOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CountryOrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public boolean needOrdering() {
        return super.needOrdering() && orderByField != null;
    }

}
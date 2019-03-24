package city.search;

import city.domain.CityDiscriminator;
import common.business.search.BaseSearchCondition;

public class CitySearchCondition extends BaseSearchCondition<Long> {
    private CityDiscriminator cityDiscriminator;

    public CityDiscriminator getCityDiscriminator() {
        return cityDiscriminator;
    }

    public void setCityDiscriminator(CityDiscriminator cityDiscriminator) {
        this.cityDiscriminator = cityDiscriminator;
    }
}

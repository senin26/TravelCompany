package city.domain;

import java.util.HashMap;
import java.util.Map;

public enum CityDiscriminator {
    BIG_CITY, SMALL_CITY;

    static Map<String, CityDiscriminator> stringModelDiscriminatorMap = new HashMap<>();

    static {
        for (CityDiscriminator discriminator : CityDiscriminator.values()) {
            stringModelDiscriminatorMap.put(discriminator.name(), discriminator);
        }
    }

    public static CityDiscriminator getDiscriminatorByName(String discriminatorName) {
        return stringModelDiscriminatorMap.get(discriminatorName);
    }

    public static boolean isDiscriminatorExists(String discriminator) {
        return getDiscriminatorByName(discriminator) != null;
    }

    public static boolean isDiscriminatorNotExists(String discriminator) {
        return !isDiscriminatorExists(discriminator);
    }


}

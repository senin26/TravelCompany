package user.domain;

import java.util.HashMap;
import java.util.Map;

public enum  ClientType {
    FAVOURITE("Very important person", 10),
    NEW("First time visited the company", 5),
    ORDINARY("Just another client", 0),
    IN_THE_BLACK_LIST("Ignore him",0);

    private String description;
    private int discount;

    private static Map<String, ClientType> clientTypeMap = new HashMap<String, ClientType>();
    
    static {
        ClientType[] clientTypes = ClientType.values();
        for (ClientType item:
             ClientType.values()) {
            clientTypeMap.put(item.name(),item);
        }
    }

    ClientType(String description, int discount) {
        this.description = description;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscount() {
        return discount;
    }

    public static boolean isStrBelongsToEnum(String string){
        if (clientTypeMap.containsKey(string)) return true;
        return false;
    }

    public static ClientType getEnumFromEnumName(String enumName) {
        return clientTypeMap.get(enumName);
    }

}

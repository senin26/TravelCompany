package user.domain;

import java.util.HashMap;
import java.util.Map;

public enum  ClientType {
    FAVOURITE("Very important person", 10),
    NEW("First time visited our service", 5),
    ORDINARY("Just another client", 0),
    IN_THE_BLACK_LIST("Ignore him",0);

    private String description;
    private int discount;

    private static Map<String, ClientType> clientTypeMap = new HashMap<String, ClientType>();
    
    static {
       /* ClientType[] clientTypes = ClientType.values();
        for (int i = 0; i < clientTypes.length; i++) {
            clientTypeMap.put(clientTypes[i].name(),clientTypes[i]);
        }*/
        for (ClientType ct:
             ClientType.values()) {
            clientTypeMap.put(ct.name(),ct);
        }
    }
    
    public static boolean isStrBelongsToEnum(String string){
        if (clientTypeMap.containsKey(string)) return true;
        return false;
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
}

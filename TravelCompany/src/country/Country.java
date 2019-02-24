package country;

import base.TravelCompanyRepo;

public class Country implements TravelCompanyRepo {
    private String name;
    private String lang;
    private Long id;


    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

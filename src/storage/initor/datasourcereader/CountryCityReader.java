package storage.initor.datasourcereader;

import country.domain.Country;

import java.io.File;
import java.util.List;

public class CountryCityReader extends Thread {
    private File fileWithXml;
    private List<Country> countries;
    private boolean done = false;
    private Object sync;

    public CountryCityReader(File fileWithXml) {
        this.fileWithXml = fileWithXml;
    }

    public CountryCityReader(File fileWithXml, Object sync) {
        this.fileWithXml = fileWithXml;
        this.sync = sync;
    }

    @Override
    public void run() {
        try {
            countries = new CountryCityXmlStaxParser().parseFile(fileWithXml.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        done = true;
    }

    private void print() {
        System.out.println(Thread.currentThread().getName());
        for (Country country : countries) {
            System.out.println(country + "\n");
        }
    }

    private void print(Object sync) {
        synchronized (sync) {
            System.out.println(Thread.currentThread().getName());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        }
    }

    public boolean isDone() {
        return done;
    }

    public List<Country> getCountries() {
        return countries;
    }
}

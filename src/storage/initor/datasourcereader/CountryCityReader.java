package storage.initor.datasourcereader;

import country.domain.Country;

import java.io.File;
import java.util.List;

public class CountryCityReader extends Thread{
        private File fileWithXml;
        private List<Country> countries;
        private boolean done = false;
        private Object sync;

        public CountryCityReader(String name, File fileWithXml, List<Country> countries, Object sync) {
            this.fileWithXml = fileWithXml;
            this.setName(name);
            this.countries = countries;
            this.sync = sync;
        }

        @Override
        public void run() {
            try {
                countries = new CountryCityXmlStaxParser().parseFile(fileWithXml.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            print(sync);
            done = true;
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
}

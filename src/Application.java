import common.solutions.utils.FileUtils;
import country.domain.Country;
import storage.initor.datasourcereader.CountryCityXmlStaxParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static class Reader extends Thread {
        File fileWithXml;
        List<Country> countries;
        boolean done = false;
        Object sync;

        public Reader(String name, File fileWithXml, List<Country> countries, Object sync) {
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

    }

    public static void main(String[] args) {
        List<Country> countries1 = new ArrayList<>();
        List<Country> countries2 = new ArrayList<>();
        File fileWithXml1 = null;
        File fileWithXml2 = null;
        Reader reader1 = null;
        Reader reader2 = null;
        Object sync = new Object();
        try {
            fileWithXml1 = FileUtils.createFileFromResource("init_data1", ".xml", "/init_data1.xml");
            fileWithXml2 = FileUtils.createFileFromResource("init_data2", ".xml", "/init_data2.xml");
            reader1 = new Reader("Reader: Russia, USA", fileWithXml1, countries1, sync);
            reader1.start();
            reader2 = new Reader("Reader: Belgium, Netherlands", fileWithXml2, countries2, sync);
            reader2.start();
            /*reader1.join();
            reader2.join();*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml1 != null && fileWithXml2 != null && reader1.done && reader2.done) {
                try {
                    Files.delete(Paths.get(fileWithXml1.toURI()));
                    Files.delete(Paths.get(fileWithXml2.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

import common.solutions.utils.FileUtils;
import country.domain.Country;
import storage.initor.datasourcereader.CountryCityReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        CountryCityReader reader1 = null;
        CountryCityReader reader2 = null;
        List<Country> countries1 = new ArrayList<>();
        List<Country> countries2 = new ArrayList<>();
        File fileWithXml1 = null;
        File fileWithXml2 = null;
        Object sync = new Object();
        try {
            fileWithXml1 = FileUtils.createFileFromResource("init_data1", ".xml", "/init_data1.xml");
            fileWithXml2 = FileUtils.createFileFromResource("init_data2", ".xml", "/init_data2.xml");
            reader1 = new CountryCityReader("Reader: Russia, USA", fileWithXml1, countries1, sync);
            reader1.start();
            reader2 = new CountryCityReader("Reader: Belgium, Netherlands", fileWithXml2, countries2, sync);
            reader2.start();
            /*reader1.join();
            reader2.join();*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml1 != null && fileWithXml2 != null && reader1.isDone() && reader2.isDone()) {
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

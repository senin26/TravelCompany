import common.solutions.utils.FileUtils;
import country.domain.Country;
import storage.initor.datasourcereader.CountryCityXmlDomParser;
import storage.initor.datasourcereader.CountryCityXmlStaxParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("----------DOM xml-parser----------\n");
        File fileWithXml = null;
        try {
            fileWithXml = FileUtils.createFileFromResource("init_data", ".xml", "/init_data.xml");
            List<Country> countries = new CountryCityXmlDomParser().parseFile(fileWithXml.getAbsolutePath());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml != null) {
                try {
                    Files.delete(Paths.get(fileWithXml.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("----------Stax xml-parser----------\n");
        fileWithXml = null;
        try {
            fileWithXml = FileUtils.createFileFromResource("init_data", ".xml", "/init_data.xml");
            List<Country> countries = new CountryCityXmlStaxParser().parseFile(fileWithXml.getAbsolutePath());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWithXml != null) {
                try {
                    Files.delete(Paths.get(fileWithXml.toURI()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

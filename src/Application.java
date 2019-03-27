import common.business.application.StorageType;
import common.business.application.serviceFactory.ServiceSupplier;
import common.business.exceptions.TravelCompanyCheckedException;
import common.solutions.utils.FileUtils;
import country.service.CountryService;
import storage.initor.StorageInitializer;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {

    private static class AppInner {
        static {
            ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);
        }

        private CountryService countryService = ServiceSupplier.getInstance().getCountryService();

        public void fillStorage() throws Exception {
            StorageInitializer storageInitor = new StorageInitializer(countryService);
            File fileWithXml1;
            File fileWithXml2;
            File fileWithXml3;
            File[] filesWithXml = null;
            try {
                fileWithXml1 = FileUtils.createFileFromResource("init_data1", ".xml", "/init_data1.xml");
                fileWithXml2 = FileUtils.createFileFromResource("init_data2", ".xml", "/init_data2.xml");
                fileWithXml3 = FileUtils.createFileFromResource("init_data3", ".xml", "/init_data3.xml");
                filesWithXml = addFilesToArray(fileWithXml1, fileWithXml2, fileWithXml3);
                storageInitor.initStorageWithCountriesAndModels(filesWithXml);
            } catch (TravelCompanyCheckedException e) {
                System.out.println("ERROR while init storage: " + e.getMessage());
                throw e;
            } catch (Exception e) {
                System.out.println("Error: Unknown fucking magic :" + e.getMessage());
                throw e;
            } finally {
                if (filesNotContainNull(filesWithXml)) {
                    deleteAllFiles(filesWithXml);
                }
            }
        }

        private File[] addFilesToArray(File... files) {
            File[] resFileArray = new File[files.length];
            for (int i = 0; i < files.length; i++) {
                resFileArray[i] = files[i];
            }
            return resFileArray;
        }

        private boolean filesNotContainNull(File... files) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == null) return false;
            }
            return true;
        }

        private void deleteAllFiles(File... files) throws Exception {
            for (int i = 0; i < files.length; i++) {
                Files.delete(Paths.get(files[i].toURI()));
            }
        }
    }

    public static void main(String[] args) {
        AppInner appInner = new AppInner();
        try {
            appInner.fillStorage();
        } catch (Exception e) {
            e.printStackTrace();
        }
       appInner.countryService.printAll();

    }
}

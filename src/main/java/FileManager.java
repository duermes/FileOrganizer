import java.io.File;
import java.io.IOException;

public class FileManager {
    String name;
    String directoryPath;
    String lastModification;
    String creationDate;
    double size;
    File file;

    public FileManager(String directoryPath) {
        this.directoryPath = directoryPath;
        file = new File(directoryPath);
    }

    public void loadContent() {

        if (!file.isDirectory() || !file.exists()) {
            System.out.println("Directorio no encontrado o no existe");
            boolean answer = file.getParentFile().mkdirs();
            // crear un package

            if (!answer) {
                System.out.println("No se pudo crear el directorio");
                return;
            }


        }
        System.out.println(file.getParentFile());
    }


}
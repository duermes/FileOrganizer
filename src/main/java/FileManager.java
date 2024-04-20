import java.io.File;

public class FileManager {
    private String directoryPath;
    private File folder;

    public FileManager(String directoryPath) {
        this.directoryPath = directoryPath;
        folder = new File(directoryPath);
    }
    public void loadContent() {

        if (!folder.isDirectory() || !folder.exists()) {
            System.out.println("Creando nuevo directorio...");
            boolean answer = folder.mkdirs();
            if (!answer) {
                System.out.println("No se pudo crear el directorio");
                return;
            }
            System.out.println("Directorio creado");
        }
        System.out.println(folder.getParentFile());

        File[] files = folder.listFiles();

        for (File file : files) {
            if (file != null) {
                if (file.isDirectory()) {
                    System.out.println("Directorio: " + file.getName());
                } else {
                    System.out.println("Archivo: " + file.getName());
                }
            }
        }

    }




}

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileManager {
    private String directoryPath;
    private File folder;
    private File[] files;
    private FileItem[] items;
    private int counter;
    private FileUtils utils;

    public FileManager(String directoryPath, int size) {
        this.directoryPath = directoryPath;
        folder = new File(directoryPath);
        this.items = new FileItem[size];
        this.counter = 0;
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

        files = folder.listFiles();

        for (File file : files) {
            if (file != null) {
                try {
                    Path path = file.toPath();
                    BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                    items[counter++] = new FileItem(file.getName(), file.isDirectory(), attributes.lastModifiedTime(), attributes.creationTime(), attributes.size());
                } catch(IOException ioe) {
                    System.out.println("Error al obtener atributos de "+file.getName());
                }
            } else {
                System.out.println("No hay archivos en el directorio");
            }

        }
    }

    public FileItem[] getItems() {
        return items;
    }

    public int getCounter() {
        return counter;
    }

    public FileItem getItem(int index) {
        return items[index];
    }



}

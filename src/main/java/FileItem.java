import java.io.File;
import java.nio.file.attribute.FileTime;
import java.sql.Date;

public class FileItem {
    private String name;
    private FileTime lastModification;
    private FileTime creationDate;
    private double size;
    private boolean isDirectory;

    FileItem(String name, boolean isDirectory, FileTime lastModification, FileTime creationDate, double size) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.lastModification = lastModification;
        this.creationDate = creationDate;
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public FileTime getLastModification() {
        return lastModification;
    }

    public FileTime getCreationDate() {
        return creationDate;
    }

    public double getSize() {
        return size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public String toString() {
        return "name: "+getName()+" Last Modification: "+getLastModification()+" size: "+
                getSize()+"  directory: "+isDirectory()+" creation date: "+ getCreationDate();
    }


}

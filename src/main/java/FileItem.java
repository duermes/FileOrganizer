import java.io.File;
import java.nio.file.attribute.FileTime;

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

    public String getAttribute(String attributeName) {
        switch (attributeName.toLowerCase()) {
            case "name":
                return this.name;
            case "size":
                return String.valueOf(this.size);
            case "lastmodified":
                return this.getLastModification().toString();
            case "creationdate":
                return this.creationDate.toString();
            default:
                return null;
        }
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
        return "\u001B[36mname: \u001B[33m"+getName()+" \u001B[36mLast Modification: \u001B[33m"+getLastModification()+" \u001B[36msize: \u001B[33m"+
                getSize()+" \u001B[36mdirectory: \u001B[33m"+isDirectory()+" \u001B[36mcreation date: \u001B[33m"+ getCreationDate();
    }
}

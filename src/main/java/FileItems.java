public class FileItems {
    private String name;
    private String lastModification;
    private String creationDate;
    private double size;
    private boolean isDirectory;

    FileItems(String name, boolean isDirectory, String lastModification, String creationDate, double size) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.lastModification = lastModification;
        this.creationDate = creationDate;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public String getLastModification() {
        return lastModification;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public double getSize() {
        return size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }
}

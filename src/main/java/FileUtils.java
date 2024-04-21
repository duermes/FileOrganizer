public class FileUtils {
    public static void sortItemsBySize(FileItem[] items, int size) {
        // using insertion sort
        int j = 0;
        FileItem temp;
        for (int i = 1; i < items.length; i++) {
            temp = items[i];
            j = i-1;
            while (j >= 0 && items[j].getSize() > temp.getSize()) {
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = temp;
        }
    };
    public static void sortItemsByName(FileItem[] items) {


    };

    public static void sortItemsByLastModification(FileItem items) {

    };

    public static void sortItemsByCreationDate(FileItem[] items) {

    };

    public static void searchItem(FileItem[] items, String name) {

    };

}

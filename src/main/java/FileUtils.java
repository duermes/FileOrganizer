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
        int j = 0;
        FileItem temp;

        for (int i = 1; i < items.length; i++) {
            temp = items[i];
            j = i-1;
            int answer = temp.
            while (j >= 0 && items[j].getName() > temp.getName()) {
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = temp;
        }

    };

    public static void sortItemsByLastModification(FileItem items) {

    };

    public static void sortItemsByCreationDate(FileItem[] items) {

    };

    public static int searchItemLinear(FileItem[] items, String name) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    };

    public static int searchItemBinary(FileItem[] items, String name) {
        int low = 0;
        int high = items.length -1;

        while(low <= high) {
            int middle = (low + high)/2;
            int result = name.compareTo(items[middle].getName());
            if (result > 0) {
                low = middle+1;
            } else if (result < 0) {
                high = middle-1;
            } else {
                return middle;
            }
        }
        return -1;

    };

}

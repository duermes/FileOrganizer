import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.ZoneId;
public class FileUtils {
    public static void sortItemsBySize(FileItem[] items) {
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
            String tempName = items[i].getName();
            j = i-1;
            while (j >= 0 && items[j].getName().compareTo(temp.getName()) > 0) {
                items[j+1] = items[j];
                j--;
            }
             items[j+1] = temp;
        }

    };
    public static void sortItemsByLastModification(FileItem[] items) {
        int j = 0;
        FileItem temp;

        for (int i = 1; i < items.length; i++) {
            temp = items[i];
            j = i-1;
            while (j >= 0 && items[j].getLastModification().compareTo(temp.getLastModification()) > 0) {
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = temp;
        }

    };

    public static void sortByCreationAndSize(FileItem[] arr) {
        int j = 0;
        FileItem temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i-1;
            while (j >= 0 && (convertTime(arr[j].getCreationDate()).compareTo(convertTime(temp.getCreationDate())) > 0 ||
                    (convertTime(arr[j].getCreationDate()).compareTo(convertTime(temp.getCreationDate())) == 0 && arr[j].getSize() < temp.getSize()))) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    };


    private static LocalDate convertTime(FileTime date) {
      return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    };

   public static FileItem[] addItem(FileItem[] arr, FileItem item) {
       FileItem[] newArr = new FileItem[arr.length+1];
       int counter = 0;
       for (FileItem a : arr) {
           newArr[counter++] = a;
       }
       newArr[counter] = item;
       return newArr;
   }
    public static FileItem[] removeItem(FileItem[] arr, FileItem item) {
        FileItem[] newArr = new FileItem[arr.length-1];
        int index = searchItemLinear(arr, item.getName());

        if (index != -1) {
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    newArr[counter++] = arr[i];
                }
            }
        } else {
            return arr;
        }
        return newArr;
    }
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
            int middle = low + (high - low)/2;
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
    public static FileItem[] searchPartially(FileItem[] arr, String string) {
        FileItem[] answer = new FileItem[0];
        for (FileItem item: arr) {
            if (item != null && item.getName().contains(string)) {
                answer = addItem(answer, item);
            }
        }
        return answer.length > 0 ? answer : null;

    }
    public static FileItem[] searchBySize(FileItem[] items, double size) {
        FileItem[] result = new FileItem[0];
        for (FileItem item : items) {
            if (item != null && item.getSize() == size) {
                result = addItem(result, item);
            }
        }

        return result.length > 0 ? result : null;


    };

    public static FileItem[] searchBySizeAndLimitAnswer(FileItem[] arr, int limit) {
        FileUtils.sortItemsBySize(arr);
        FileItem[] result = new FileItem[0];
        while (limit > 0) {
            FileItem[] temp = FileUtils.addItem(result, arr[arr.length-limit]);
            result = temp;
            limit--;
        }
        return result.length > 0 ? result : null;
    };


}

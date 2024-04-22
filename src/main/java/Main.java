public class Main {
    public static void main(String[] args) {
    /*
    Un programa que ordene archivos en un directorio según diferentes criterios, como nombre, tamaño o fecha de modificación.
    Usamos algoritmos de ordenamiento para realizar la clasificación de los archivos.
     */
    //hello
        String packageName = "src/main/java/data";
        FileManager fileManager = new FileManager(packageName, 13);
        fileManager.loadContent();

        /*
        FileUtils.sortByCreationAndSize(fileManager.getItems());

        for (FileItem item : fileManager.getItems()) {
                System.out.println(item);
        }


        FileItem[] arr2 = FileUtils.searchBySizeAndLimitAnswer(fileManager.getItems(), 3);
        System.out.println(arr2);

        for (FileItem item : arr2) {
            System.out.println(item);
        }


       int index = FileUtils.searchItemBinary(fileManager.getItems(), "cat.jpg");
        if (index == -1) {
            System.out.println("No se encontró");
        } else {
            System.out.println("se encontró");
        }

         */



    }
}

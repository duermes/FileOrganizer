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

        // ordenando por tamaño

        for (FileItem item : fileManager.getItems()) {
                System.out.println(item);
        }
        FileUtils.sortItemsBySize(fileManager.getItems(), fileManager.getCounter());

        System.out.println("Ordenado por tamaño");
        for (FileItem item : fileManager.getItems()) {
            if (item != null) {
                System.out.println(item);
            }
        }

       int index = FileUtils.searchItemBinary(fileManager.getItems(), "cat.jpg");


        if (index == -1) {
            System.out.println("No se encontró");
        } else {
            System.out.println("se encontró");
        }



    }
}

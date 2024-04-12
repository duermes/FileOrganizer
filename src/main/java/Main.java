public class Main {
    public static void main(String[] args) {
    /*
    Un programa que ordene archivos en un directorio según diferentes criterios, como nombre, tamaño o fecha de modificación.
    Usamos algoritmos de ordenamiento para realizar la clasificación de los archivos.
     */
    //hello
        String packageName = "src/main/java/data";
        FileManager fileManager = new FileManager(packageName);
        fileManager.loadContent();
        System.out.println("hola");

    }
}

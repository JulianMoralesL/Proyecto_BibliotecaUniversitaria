/**
 * =====================================================================
 *  PROYECTO: Biblioteca Universitaria
 *  ENTREGA 1 - SEMANA 3 - JULIANM
 * =====================================================================
 *
 * ¿QUÉ HACE ESTA CLASE?
 * -------------------------
 * Esta es la clase que se ejecuta cuando corres el programa. Por eso
 *  su único trabajo es decirle a GenerateInfoFiles ahora crea el catálogo" y "ahora crea los préstamos", en ese orden.
 *
 * Es como el botón de encendido: no sabe CÓMO se crean los archivos
 * (eso lo sabe GenerateInfoFiles), solo sabe CUÁNDO pedir que se creen.
 *
 * Al ejecutarse, este programa va a generar dos archivos en la carpeta
 * del proyecto:
 *   - libros.csv
 *   - prestamos.txt
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando generación de archivos...");

            // Le pedimos a GenerateInfoFiles que cree el catálogo de libros.
            // Usamos cantidadDeLibrosDisponibles() para generar un libro
            // por cada dato que ya tenemos guardado, ni uno más ni uno menos.
            int totalLibros = GenerateInfoFiles.cantidadDeLibrosDisponibles();
            GenerateInfoFiles.createBooksFile(totalLibros);

            // Le pedimos que cree 40 préstamos de ejemplo.
            GenerateInfoFiles.createLoansFile(40);

            System.out.println("¡Archivos generados exitosamente!");
        } catch (Exception e) {
            // Si algo sale mal (por ejemplo, no se puede crear el archivo),
            // avisamos el error en vez de dejar que el programa se rompa
            // sin explicación.
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}

import java.io.PrintWriter;
import java.util.Random;

/**
 * =====================================================================
 * PROYECTO: Biblioteca Universitaria
 * ENTREGA 1 - SEMANA 3
 * =====================================================================
 *
 * ¿QUÉ HACE ESTA CLASE?
 * -------------------------
 * Esta clase NO se ejecuta directamente. Es como una "caja de
 * herramientas": guarda los métodos que saben CÓMO crear los archivos,
 * pero quien decide CUÁNDO usarlos es la clase Main (ver Main.java).
 *
 * Los archivos que sabe crear son:
 * 1) libros.csv -> El catálogo de libros (como el inventario).
 * 2) prestamos.txt -> El historial de préstamos hechos por usuarios.
 */
public class GenerateInfoFiles {

    private static final String[] ISBNS = {
        "9780307474728",
        "9788497592208",
        "9780141439600",
        "9780062315007",
        "9780544003415",
        "9788420471839",
        "9780679783268",
        "9780743273565"
    };

    private static final String[] TITULOS = {
        "Cien Años de Soledad",
        "La Sombra del Viento",
        "Orgullo y Prejuicio",
        "El Alquimista",
        "El Señor de los Anillos",
        "Rayuela",
        "Crimen y Castigo",
        "El Gran Gatsby"
    };

    private static final String[] AUTORES = {
        "Gabriel Garcia Marquez",
        "Carlos Ruiz Zafon",
        "Jane Austen",
        "Paulo Coelho",
        "J.R.R. Tolkien",
        "Julio Cortazar",
        "Fiodor Dostoievski",
        "F. Scott Fitzgerald"
    };

    private static final String[] GENEROS = {
        "Realismo Magico",
        "Misterio",
        "Romance",
        "Ficcion",
        "Fantasia",
        "Literatura",
        "Drama",
        "Clasico"
    };

    /**
     * Crea el archivo "libros.csv" con el catálogo completo de la biblioteca.
     *
     * @param booksCount cuántos libros vamos a escribir en el archivo.
     */
    public static void createBooksFile(int booksCount) throws Exception {
    	if (booksCount <= 0 || booksCount > ISBNS.length) {
    	    throw new IllegalArgumentException(
    	        "Cantidad de libros inválida. Debe ser entre 1 y " + ISBNS.length
    	    );
    	}
        PrintWriter writer = new PrintWriter("libros.csv", "UTF-8");

        for (int i = 0; i < booksCount; i++) {

            String linea = ISBNS[i] + ";"
                    + TITULOS[i] + ";"
                    + AUTORES[i] + ";"
                    + GENEROS[i];

            writer.println(linea);
        }

        writer.close();
    }

    /**
     * Crea el archivo "prestamos.txt" con préstamos de ejemplo.
     *
     * @param loansCount cuántos préstamos de ejemplo vamos a generar.
     */
    public static void createLoansFile(int loansCount) throws Exception {

        Random rand = new Random();

        PrintWriter writer = new PrintWriter("prestamos.txt", "UTF-8");

        for (int i = 0; i < loansCount; i++) {

            String isbn = ISBNS[rand.nextInt(ISBNS.length)];
            String fecha = generarFecha(rand);
            String usuario = generarUsuario(rand);

            writer.println(isbn + ";" + fecha + ";" + usuario);
        }

        writer.close();
    }

    /**
     * Genera una fecha al azar del año 2026,
     * en formato dia-mes-anio.
     */
    private static String generarFecha(Random rand) {

        int dia = rand.nextInt(28) + 1;
        int mes = rand.nextInt(12) + 1;
        int anio = 2026;

        String diaTexto = (dia < 10) ? "0" + dia : "" + dia;
        String mesTexto = (mes < 10) ? "0" + mes : "" + mes;

        return diaTexto + "-" + mesTexto + "-" + anio;
    }

    /**
     * Genera un código de usuario al azar
     * (letra mayúscula + número).
     */
    private static String generarUsuario(Random rand) {

        char letra = (char) ('A' + rand.nextInt(26));
        int numero = rand.nextInt(99) + 1;

        return letra + "" + numero;
    }

    /**
     * Nos dice cuántos libros hay definidos
     * en el catálogo de datos.
     */
    public static int cantidadDeLibrosDisponibles() {

        return ISBNS.length;
    }
}
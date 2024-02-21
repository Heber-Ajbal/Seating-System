package sistemadeasientos.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Heber
 */
public class Archivo {

    private String nombre;

    /**
     * Constructor para la clase Archivo.
     *
     * @param nombre El nombre del archivo.
     */
    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método lee el contenido de un archivo de texto y devuelve una lista
     * enlazada que contiene cada línea del archivo. Si el archivo existe, lee
     * cada línea del archivo y la agrega a la lista enlazada. Si el archivo no
     * existe, muestra un mensaje de error. Si ocurre algún error durante la
     * lectura del archivo, muestra un mensaje de error y devuelve null.
     *
     * @return Una lista enlazada que contiene cada línea del archivo de texto,
     * o null si ocurre un error.
     */
    public LinkedList<String> obtenerTextoDelArchivo() {
        LinkedList<String> lineasDeTexto = null;
        try {
            File archivo = obtenerArchivo();
            if (archivo.exists()) {
                lineasDeTexto = new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    lineasDeTexto.add(linea);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Se produjo un Error ");
        }
        return lineasDeTexto;
    }

    /**
     * Este método se encarga de obtener el archivo "asientos.txt" desde el
     * recurso del proyecto. Copia el archivo desde el recurso al sistema de
     * archivos local y devuelve el objeto File correspondiente.
     *
     * @return El archivo "asientos.txt" como un objeto File, o null si ocurre
     * un error.
     */
    private File obtenerArchivo() {
        // Obtener el InputStream del recurso
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sistemadeasientos/resource/asientos.txt");
        if (inputStream != null) {
            // Especificar la ruta de destino del archivo
            //NOTA IMPORTANTE:CAMBIAR A SU RUTA DONDE GUARDO EL PROYECTO
            String rutaDestino = "D:\\Heber\\Documents\\github\\Seating-System\\src\\sistemadeasientos\\resource\\asientos.txt"; // Reemplaza con tu ruta deseada

            try {
                // Crear un nuevo archivo en la ruta de destino
                Path archivoDestino = Paths.get(rutaDestino);
                Files.copy(inputStream, archivoDestino, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

                // Convertir el archivo a tipo File y devolverlo
                return archivoDestino.toFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("No se pudo encontrar el archivo en la ruta especificada.");
            return null;
        }
    }

    /**
     * Este método registra una nueva línea en un archivo de texto.
     *
     * @param linea La línea que se desea registrar en el archivo.
     * @return true si la línea se registró correctamente, false si ocurrió un
     * error.
     */
    public boolean registrar(String linea) {
        //NOTA IMPORTANTE:CAMBIAR A SU RUTA DONDE GUARDO EL PROYECTO
        String rutaArchivo = "D:\\Heber\\Documents\\github\\Seating-System\\src\\sistemadeasientos\\resource\\asientos.txt";
        File archivo = new File(rutaArchivo);
        try {
            if (archivo.exists()) {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return false;
    }
}

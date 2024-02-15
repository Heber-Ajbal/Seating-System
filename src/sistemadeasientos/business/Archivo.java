package sistemadeasientos.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Heber
 */
public class Archivo {
    private String nombre;
    
    public Archivo(String nombre){
        this.nombre = nombre;
    }
    
    public LinkedList<String> obtenerTextoDelArchivo() {
        LinkedList<String> lineasDeTexto=null;
        try {            
            File archivo = obtenerArchivo();     
            if (archivo.exists()) {
                lineasDeTexto=new LinkedList();
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
    
    private File obtenerArchivoa() {       
        try {
            URL url = getClass().getClassLoader().getResource("sistemadeasientos/resources/archivos/asientos.txt");
            return new File(url.toURI());            
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private File obtenerArchivo() {
        // Obtener el InputStream del recurso
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sistemadeasientos/resources/archivos/asientos.txt");
        if (inputStream != null) {
            // Crear un archivo temporal para copiar el contenido del InputStream
            File tempFile;
            try {
                tempFile = File.createTempFile("asientos", ".txt");
                tempFile.deleteOnExit(); // Eliminar el archivo temporal al salir del programa
                // Copiar el contenido del InputStream al archivo temporal
                java.nio.file.Files.copy(inputStream, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                return tempFile;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("No se pudo encontrar el archivo en la ruta especificada.");
            return null;
        }
    }
    
    public boolean registrar(String linea){
        File archivo=obtenerArchivo();
        try{
            if(archivo.exists()){
                FileWriter fw=new FileWriter(archivo,true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw= new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }
        }catch(Exception error){
            error.printStackTrace();
        }
        return false;
    }
    
    public boolean borrarContenido(){
        try{
            File archivo=obtenerArchivo();
            String directorio=archivo.getParent();
            archivo.delete();
            new FileWriter(directorio + "/asientos.txt",true);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}

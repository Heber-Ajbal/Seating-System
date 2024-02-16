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
    
    private File obtenerArchivo() {
    // Obtener el InputStream del recurso
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sistemadeasientos/resource/asientos.txt");
    if (inputStream != null) {
        // Especificar la ruta de destino del archivo
        String rutaDestino = "D:\\Heber\\Documents\\Proyectos Java\\SistemaDeAsientos\\src\\sistemadeasientos\\resource\\asientos.txt"; // Reemplaza con tu ruta deseada
        
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

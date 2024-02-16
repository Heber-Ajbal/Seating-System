/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeasientos.business;

import java.util.LinkedList;
import java.util.StringTokenizer;
import sistemadeasientos.model.ReservacionModel;

/**
 *
 * @author Heber
 */
public class AsientoHelper {
    
    public ReservacionModel[] obtener() {
    ReservacionModel[] reservaciones = null;
    Archivo archivo = new Archivo("asientos.txt");
    LinkedList<String> lineas = archivo.obtenerTextoDelArchivo();
    if (lineas != null) {
        reservaciones = new ReservacionModel[lineas.size()]; // Crear el arreglo del tamaño adecuado
        for (int i = 0; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            StringTokenizer tokens = new StringTokenizer(linea, ";");
            String nombreCliente = tokens.nextToken();
            boolean disponible = Boolean.parseBoolean(tokens.nextToken());
            String posicion = tokens.nextToken();
            String Id = tokens.nextToken();
            float precio = Float.parseFloat(tokens.nextToken());
            reservaciones[i] = new ReservacionModel(nombreCliente, disponible, posicion, Id, precio);
        }
    }
    return reservaciones;
}
    
    public boolean registrarProducto(ReservacionModel r){
        Archivo archivo=new Archivo("asientos.txt");
        return archivo.registrar(r.getNombreCliente()+";"
               + r.isDisponible()+ ";"
               + r.getPocision()+ ";"
               + r.getId()+ ";" + r.getPrecio());
    }
    
    
    public boolean borrarTodo(){
        Archivo archivo=new Archivo("productos.txt");
        return archivo.borrarContenido();                
    }
    
}

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
/**
 * Este método se encarga de obtener las reservaciones desde un archivo de texto
 * y devolverlas como un arreglo de objetos ReservacionModel. Lee el archivo de
 * asientos, parsea cada línea y crea un objeto ReservacionModel para cada
 * reserva.
 *
 * @return Un arreglo de objetos ReservacionModel que representa las
 * reservaciones obtenidas desde el archivo de texto, o null si no se pudo
 * obtener.
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

    /**
     * Este método se encarga de registrar una nueva reservación en el archivo
     * de texto "asientos.txt".
     *
     * @param r El objeto ReservacionModel que se desea registrar.
     * @return true si la reservación se registró correctamente, false si
     * ocurrió un error.
     */
    public boolean registrarProducto(ReservacionModel r) {
        Archivo archivo = new Archivo("asientos.txt");
        return archivo.registrar(r.getNombreCliente() + ";"
                + r.isDisponible() + ";"
                + r.getPocision() + ";"
                + r.getId() + ";" + r.getPrecio());
    }

}

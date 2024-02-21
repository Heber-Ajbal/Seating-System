/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeasientos.business;

import sistemadeasientos.model.ReservacionModel;

/**
 *
 * @author Heber
 */
public class ListaAsientos {

    ReservacionModel[] ListaReservacion = new ReservacionModel[32];
    public ReservacionModel[] AllReservacion;

    /**
     * Agrega una nueva reservación al arreglo de reservaciones. La reservación
     * se agrega en la próxima posición disponible en el arreglo. Si el arreglo
     * está lleno, la reservación no se agrega y se imprime un mensaje de
     * advertencia.
     *
     * @param reservacion La reservación que se desea agregar al arreglo.
     */
    public void Agregar(ReservacionModel reservacion) {
        ListaReservacion[0] = reservacion;
    }

    /**
     * Carga las reservaciones desde un archivo de texto utilizando un objeto de
     * la clase AsientoHelper. Las reservaciones cargadas se asignan al arreglo
     * ListaReservacion y al arreglo AllReservacion. Si no se pueden cargar las
     * reservaciones, los arreglos quedan sin cambios.
     */
    public void cargarProductos() {
        AsientoHelper bd = new AsientoHelper();
        ListaReservacion = bd.obtener();
        AllReservacion = ListaReservacion;
    }

    /**
     * Guarda la primera reservación del arreglo ListaReservacion en un archivo
     * de texto utilizando un objeto de la clase AsientoHelper. Este método
     * registra solo la primera reservación del arreglo en el archivo. Si no hay
     * reservaciones en el arreglo, no se realiza ninguna operación de guardado.
     */
    public void GuardarArchivo() {
        AsientoHelper bd = new AsientoHelper();
        bd.registrarProducto(ListaReservacion[0]);
    }

}

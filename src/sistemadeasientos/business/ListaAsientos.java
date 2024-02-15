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
    
    public void Agregar(ReservacionModel reservacion){
        ListaReservacion[0] = reservacion;
    }
    
    public void cargarProductos(){
        AsientoHelper bd=new AsientoHelper();
        ListaReservacion=bd.obtener();        
    }
    
    public void Imprimir(){
        for(int i=0; i<ListaReservacion.length;i++){
            System.out.println(ListaReservacion[i].getNombreCliente());
        }
    }
}

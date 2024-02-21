/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeasientos.model;

/**
 *
 * @author Heber
 */
public class ReservacionModel {
    private String nombreCliente;
    private boolean disponible;
    private String pocision; 
    private String Id;
    private float precio;

    /**
     * Constructor de la clase ReservacionModel.
     * @param nombreCliente El nombre del cliente que reservó el asiento.
     * @param disponible Indica si el asiento está disponible o no.
     * @param pocision La posición del asiento en el sistema de reservación.
     * @param Id El identificador único del asiento.
     * @param precio El precio del asiento.
     */
    public ReservacionModel(String nombreCliente, boolean disponible, String pocision, String Id, float precio) {
        this.nombreCliente = nombreCliente;
        this.disponible = disponible;
        this.pocision = pocision;
        this.Id = Id;
        this.precio = precio;
    }

    // Métodos getters y setters...
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getPocision() {
        return pocision;
    }

    public void setPocision(String pocision) {
        this.pocision = pocision;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ReservacionModel{" + "nombreCliente=" + nombreCliente + ", disponible=" + disponible + ", pocision=" + pocision + ", Id=" + Id + ", precio=" + precio + '}';
    }
    
    
    
}

package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUNTOS_ATENCION")
public class PuntosAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private ArrayList<String> operaciones; 
    private String latitud;
    private String longitud;
    private String tipo;

   
    public PuntosAtencion(ArrayList<String> operaciones, String latitud, String longitud, String tipo) {
        this.operaciones = operaciones;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipo = tipo;
    }
    public PuntosAtencion() {
        ;
    }
    public ArrayList<String> getOperaciones() {
        return operaciones;
    }   
    public void setOperaciones(ArrayList<String> operaciones) {
        this.operaciones = operaciones;
    }   
    public String getLatitud() {
        return latitud;
    }   
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }   
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    


    
}

package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class Operacion_PrestamoPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "id")
    private Prestamo prestamo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;

    public Operacion_PrestamoPK() {
    }

    public Operacion_PrestamoPK(Prestamo prestamo, Date fechaOperacion) {
        this.prestamo = prestamo;
        this.fechaOperacion = fechaOperacion;
    }

   
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

}

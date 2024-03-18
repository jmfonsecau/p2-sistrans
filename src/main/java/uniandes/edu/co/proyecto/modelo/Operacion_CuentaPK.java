package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class Operacion_CuentaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOperacion;

    public Operacion_CuentaPK() {
    }

    public Operacion_CuentaPK(Cuenta cuenta, Date fechaOperacion) {
        this.cuenta = cuenta;
        this.fechaOperacion = fechaOperacion;
    }

    
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

}

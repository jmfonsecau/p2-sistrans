package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERACIONES")

public class Operaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String fecha;
    private Float monto;
    private String tipoOperacion;

    public Operaciones(String fecha, Float monto, String tipoOperacion) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
    }

    public Operaciones() {
        ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
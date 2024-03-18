package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERACIONES_PRESTAMO")
public class Operacion_Prestamo {

    @EmbeddedId
    private Operacion_PrestamoPK pk;

    
    private String tipoOperacion; 

   
    public Operacion_Prestamo() {
    }

    public Operacion_PrestamoPK getPk() {
        return pk;
    }

    public void setPk(Operacion_PrestamoPK pk) {
        this.pk = pk;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}

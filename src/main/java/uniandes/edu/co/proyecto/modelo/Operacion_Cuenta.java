package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERACIONES_CUENTA")
public class Operacion_Cuenta {

    @EmbeddedId
    private Operacion_CuentaPK pk;

   
    private String tipoOperacion;
   
    
    public Operacion_Cuenta() {
    }

    public Operacion_CuentaPK getPk() {
        return pk;
    }

    public void setPk(Operacion_CuentaPK pk) {
        this.pk = pk;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}

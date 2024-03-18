package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFICINA")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;
    private String direccion;
    private Integer num_puntos_atencion;
    private String ciudad;

    public Oficina(String nombre, String direccion, Integer num_puntos_atencion, String ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.num_puntos_atencion = num_puntos_atencion;
        this.ciudad = ciudad;
    }
    public Oficina() {
        ;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getNum_puntos_atencion() {
        return num_puntos_atencion;
    }
    public void setNum_puntos_atencion(Integer num_puntos_atencion) {
        this.num_puntos_atencion = num_puntos_atencion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    

    
}

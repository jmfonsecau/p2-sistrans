package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OFICINA")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String direccion;
    private int numeroPuntosAtencion;
    @ManyToOne
    private Usuario gerente;

    public Oficina(int id, String nombre, String direccion, int numeroPuntosAtencion, Usuario gerente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroPuntosAtencion = numeroPuntosAtencion;
        this.gerente = gerente;
    }

    public Oficina(){
        ;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getNumeroPuntosAtencion() {
        return numeroPuntosAtencion;
    }
    public void setNumeroPuntosAtencion(int numeroPuntosAtencion) {
        this.numeroPuntosAtencion = numeroPuntosAtencion;
    }
    public Usuario getGerente() {
        return gerente;
    }
    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

}

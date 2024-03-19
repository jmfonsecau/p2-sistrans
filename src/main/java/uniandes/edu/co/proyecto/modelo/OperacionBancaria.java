package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERACION_BANCARIA")
public class OperacionBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    @ManyToOne
    private Usuario cliente;
    @ManyToOne
    private Cuenta cuenta;
    private double valor;
    @ManyToOne
    private PuntosAtencion puntoAtencion;
    private Date fecha;
    private String producto;
    
    public OperacionBancaria(int id, String tipo, Usuario cliente, Cuenta cuenta, double valor,
            PuntosAtencion puntoAtencion, Date fecha, String producto) {
        this.id = id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.valor = valor;
        this.puntoAtencion = puntoAtencion;
        this.fecha = fecha;
        this.producto = producto;
    }

    public OperacionBancaria(){
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public PuntosAtencion getPuntoAtencion() {
        return puntoAtencion;
    }

    public void setPuntoAtencion(PuntosAtencion puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}

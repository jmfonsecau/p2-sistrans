package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUENTA")

public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tipo;
    private String estado;
    private String numeroIdentificador;
    private Float saldo;
    private String operaciones_Permitidas;
    private Date fecha_ultima_transaccion;

    public Cuenta(String tipo, String estado, String numeroIdentificador, Float saldo, String operaciones_Permitidas, Date fecha_ultima_transaccion) {
        this.tipo = tipo;
        this.estado = estado;
        this.numeroIdentificador = numeroIdentificador;
        this.saldo = saldo;
        this.operaciones_Permitidas = operaciones_Permitidas;
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
    }

    public Cuenta(){
        ;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(String numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public String getOperaciones_Permitidas() {
        return operaciones_Permitidas;
    }

    public void setOperaciones_Permitidas(String operaciones_Permitidas) {
        this.operaciones_Permitidas = operaciones_Permitidas;
    }

    public Date getFecha_ultima_transaccion() {
        return fecha_ultima_transaccion;
    }

    public void setFecha_ultima_transaccion(Date fecha_ultima_transaccion) {
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
    }
    

    
}

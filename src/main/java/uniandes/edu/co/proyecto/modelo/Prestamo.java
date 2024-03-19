package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRESTAMO")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    @ManyToOne
    private Usuario cliente;
    private double monto;
    private double interes;
    private int numeroCuotas;
    private int diaPagoCuota;
    private double valorCuota;
    private String estado;
    
    public Prestamo(int id, String tipo, Usuario cliente, double monto, double interes, int numeroCuotas,
            int diaPagoCuota, double valorCuota, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.monto = monto;
        this.interes = interes;
        this.numeroCuotas = numeroCuotas;
        this.diaPagoCuota = diaPagoCuota;
        this.valorCuota = valorCuota;
        this.estado = estado;
    }

    public Prestamo(){
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getDiaPagoCuota() {
        return diaPagoCuota;
    }

    public void setDiaPagoCuota(int diaPagoCuota) {
        this.diaPagoCuota = diaPagoCuota;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}

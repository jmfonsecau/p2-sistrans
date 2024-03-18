package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRESTAMO")

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String tipo;
    private String estado;
    private String operacion_a_hacer;
    private Float monto;
    private Float interes;
    private Integer cuotas;
    private String dia_pago;
    private Float valor_cuota;

    public Prestamo(String tipo, String estado, String operacion_a_hacer, Float monto, Float interes, Integer cuotas, String dia_pago, Float valor_cuota) {
        this.tipo = tipo;
        this.estado = estado;
        this.operacion_a_hacer = operacion_a_hacer;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.dia_pago = dia_pago;
        this.valor_cuota = valor_cuota;
    }
    public Prestamo() {
        ;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getOperacion_a_hacer() {
        return operacion_a_hacer;
    }
    public void setOperacion_a_hacer(String operacion_a_hacer) {
        this.operacion_a_hacer = operacion_a_hacer;
    }
    public Float getMonto() {
        return monto;
    }
    public void setMonto(Float monto) {
        this.monto = monto;
    }
    public Float getInteres() {
        return interes;
    }
    public void setInteres(Float interes) {
        this.interes = interes;
    }
    public Integer getCuotas() {
        return cuotas;
    }
    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }
    public String getDia_pago() {
        return dia_pago;
    }
    public void setDia_pago(String dia_pago) {
        this.dia_pago = dia_pago;
    }
    public Float getValor_cuota() {
        return valor_cuota;
    }
    public void setValor_cuota(Float valor_cuota) {
        this.valor_cuota = valor_cuota;
    }
    
    
}

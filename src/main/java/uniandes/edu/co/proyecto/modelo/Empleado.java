package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numero_Documento;
    private String tipo_Documento;
    private String nombre;
    private String direccion_Electronica;
    private String clave;
    private String ciudad;
    private String direccion_Fisica;
    private String nacionalidad;
    private String departamento;
    private String codigo_Postal;
    private String login;
    private String rol;

    public Empleado(String numero_Documento, String tipo_Documento, String nombre, String direccion_Electronica, String clave, String ciudad, String direccion_Fisica, String nacionalidad, String departamento, String codigo_Postal, String login, String rol) {
        this.numero_Documento = numero_Documento;
        this.tipo_Documento = tipo_Documento;
        this.nombre = nombre;
        this.direccion_Electronica = direccion_Electronica;
        this.clave = clave;
        this.ciudad = ciudad;
        this.direccion_Fisica = direccion_Fisica;
        this.nacionalidad = nacionalidad;
        this.departamento = departamento;
        this.codigo_Postal = codigo_Postal;
        this.login = login;
        this.rol = rol;
    }
    public Empleado() {
        ;
    }
    public String getNumero_Documento() {
        return numero_Documento;
    }
    public void setNumero_Documento(String numero_Documento) {
        this.numero_Documento = numero_Documento;
    }
    public String getTipo_Documento() {
        return tipo_Documento;
    }
    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion_Electronica() {
        return direccion_Electronica;
    }
    public void setDireccion_Electronica(String direccion_Electronica) {
        this.direccion_Electronica = direccion_Electronica;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion_Fisica() {
        return direccion_Fisica;
    }
    public void setDireccion_Fisica(String direccion_Fisica) {
        this.direccion_Fisica = direccion_Fisica;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getCodigo_Postal() {
        return codigo_Postal;
    }
    public void setCodigo_Postal(String codigo_Postal) {
        this.codigo_Postal = codigo_Postal;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}

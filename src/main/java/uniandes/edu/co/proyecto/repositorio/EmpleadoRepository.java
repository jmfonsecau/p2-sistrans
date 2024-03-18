package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

    @Query(value = "SELECT * FROM EMPLEADO", nativeQuery = true)
    Collection<Cliente> darEmpleados();

    @Query(value = "SELECT * FROM EMPLEADO WHERE id = :id", nativeQuery = true)
    Cliente darEmpleado(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADO (nombre, tipo_Documento, numero_Documento, direccion_Electronica, clave, ciudad, direccion_Fisica, nacionalidad, departamento, codigo_Postal, login, rol) VALUES (:nombre, :tipo_Documento, :numero_Documento, :direccion_Electronica, :clave, :ciudad, :direccion_Fisica, :nacionalidad, :departamento, :codigo_Postal, :login, :rol)", nativeQuery = true)
    void insertarEmpleado(@Param("nombre") String nombre,@Param("tipo_Documento") String tipo_Documento,@Param("numero_Documento") String numero_Documento,@Param("direccion_Electronica") String direccion_Electronica,@Param("clave") String clave,@Param("ciudad") String ciudad,@Param("direccion_Fisica") String direccion_Fisica,@Param("nacionalidad") String nacionalidad,@Param("departamento") String departamento,@Param("codigo_Postal") String codigo_Postal,@Param("login") String login,@Param("rol") String rol);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE EMPLEADO SET nombre = :nombre, tipo_Documento = :tipo_Documento, numero_Documento = :numero_Documento, direccion_Electronica = :direccion_Electronica, clave = :clave, ciudad = :ciudad, direccion_Fisica = :direccion_Fisica, nacionalidad = :nacionalidad, departamento = :departamento, codigo_Postal = :codigo_Postal, login = :login, rol = :rol WHERE id = :id", nativeQuery = true)
    void actualizarEmpleado(@Param("id")String id,@Param("nombre") String nombre,@Param("tipo_Documento") String tipo_Documento,@Param("numero_Documento") String numero_Documento,@Param("direccion_Electronica") String direccion_Electronica,@Param("clave") String clave,@Param("ciudad") String ciudad,@Param("direccion_Fisica") String direccion_Fisica,@Param("nacionalidad") String nacionalidad,@Param("departamento") String departamento,@Param("codigo_Postal") String codigo_Postal,@Param("login") String login,@Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EMPLEADO WHERE id = :id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") String id);
    
}

package uniandes.edu.co.proyecto.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM CLIENTE WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENTE (nombre, tipo_Documento, numero_Documento, direccion_Electronica, clave, ciudad, direccion_Fisica, nacionalidad, departamento, codigo_Postal, login, rol) VALUES (:nombre, :tipo_Documento, :numero_Documento, :direccion_Electronica, :clave, :ciudad, :direccion_Fisica, :nacionalidad, :departamento, :codigo_Postal, :login, :rol)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre,@Param("tipo_Documento") String tipo_Documento,@Param("numero_Documento") String numero_Documento,@Param("direccion_Electronica") String direccion_Electronica,@Param("clave") String clave,@Param("ciudad") String ciudad,@Param("direccion_Fisica") String direccion_Fisica,@Param("nacionalidad") String nacionalidad,@Param("departamento") String departamento,@Param("codigo_Postal") String codigo_Postal,@Param("login") String login,@Param("rol") String rol);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE CLIENTE SET nombre = :nombre, tipo_Documento = :tipo_Documento, numero_Documento = :numero_Documento, direccion_Electronica = :direccion_Electronica, clave = :clave, ciudad = :ciudad, direccion_Fisica = :direccion_Fisica, nacionalidad = :nacionalidad, departamento = :departamento, codigo_Postal = :codigo_Postal, login = :login, rol = :rol WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id")String id,@Param("nombre") String nombre,@Param("tipo_Documento") String tipo_Documento,@Param("numero_Documento") String numero_Documento,@Param("direccion_Electronica") String direccion_Electronica,@Param("clave") String clave,@Param("ciudad") String ciudad,@Param("direccion_Fisica") String direccion_Fisica,@Param("nacionalidad") String nacionalidad,@Param("departamento") String departamento,@Param("codigo_Postal") String codigo_Postal,@Param("login") String login,@Param("rol") String rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLIENTE WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") String id);

    
}

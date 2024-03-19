package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;

import java.sql.Date;
import java.util.Collection;

public interface OperacionBancariaRepository extends JpaRepository<OperacionBancaria, Integer> {
    
    @Query(value = "SELECT * FROM OPERACION_BANCARIA", nativeQuery = true)
    Collection<OperacionBancaria> darOperacionesBancarias();

    @Query(value = "SELECT * FROM OPERACION_BANCARIA WHERE id = :id", nativeQuery = true)
    OperacionBancaria darOperacionBancaria(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_BANCARIA (tipo_operacion, clienteId, producto, valor, puesto_atencion, fecha) VALUES (:tipoOperacion, :clienteId, :producto, :valor, :puestoAtencion, :fecha)", nativeQuery = true)
    void insertarOperacionBancaria(@Param("tipoOperacion") String tipoOperacion, @Param("clienteId") int clienteId, @Param("producto") String producto, @Param("valor") double valor, @Param("puestoAtencion") PuntosAtencion puestoAtencion, @Param("fecha") Date fecha);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_BANCARIA SET tipo_operacion = :tipoOperacion, clienteId = :clienteId, producto = :producto, valor = :valor, puesto_atencion = :puestoAtencion, fecha = :fecha WHERE id = :id", nativeQuery = true)
    void actualizarOperacionBancaria(@Param("id") String id, @Param("tipoOperacion") String tipoOperacion, @Param("clienteId") int clienteId, @Param("producto") String producto, @Param("valor") double valor, @Param("puestoAtencion") PuntosAtencion puestoAtencion, @Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_BANCARIA WHERE id = :id", nativeQuery = true)
    void eliminarOperacionBancaria(@Param("id") int id);
}

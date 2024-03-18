package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{

    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE numeroIdentificador = :numeroIdentificador", nativeQuery = true)
    Cuenta darCuenta(@Param("numeroIdentificador") String numeroIdentificador);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (tipo, estado, numeroIdentificador, saldo, operaciones_Permitidas, fecha_ultima_transaccion) VALUES (:tipo, :estado, :numeroIdentificador, :saldo, :operaciones_Permitidas, :fecha_ultima_transaccion)", nativeQuery = true)
    void insertarCuenta(@Param("tipo") String tipo,@Param("estado") String estado,@Param("numeroIdentificador") String numeroIdentificador,@Param("saldo") Float saldo,@Param("operaciones_Permitidas") String operaciones_Permitidas,@Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET tipo = :tipo, estado = :estado, numeroIdentificador = :numeroIdentificador, saldo = :saldo, operaciones_Permitidas = :operaciones_Permitidas, fecha_ultima_transaccion = :fecha_ultima_transaccion WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param ("id") String id,@Param("tipo") String tipo,@Param("estado") String estado,@Param("numeroIdentificador") String numeroIdentificador,@Param("saldo") Float saldo,@Param("operaciones_Permitidas") String operaciones_Permitidas,@Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") String id);
    
}

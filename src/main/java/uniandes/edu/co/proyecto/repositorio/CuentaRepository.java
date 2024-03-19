package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.util.Collection;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM CUENTA", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM CUENTA WHERE id = :id", nativeQuery = true)
    Cuenta darCuenta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUENTA (tipo, cliente, saldo, fecha_ultima_transaccion, estado) VALUES (:tipo, :cliente, :saldo, :fechaUltimaTransaccion, :estado)", nativeQuery = true)
    void insertarCuenta(@Param("tipo") String tipo, @Param("cliente") Usuario usuario, @Param("saldo") double saldo, @Param("fechaUltimaTransaccion") String fechaUltimaTransaccion, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CUENTA SET saldo = :saldo, fecha_ultima_transaccion = :fechaUltimaTransaccion, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarCuenta(@Param("id") int id, @Param("saldo") double saldo, @Param("fechaUltimaTransaccion") String fechaUltimaTransaccion, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUENTA WHERE id = :id", nativeQuery = true)
    void eliminarCuenta(@Param("id") int id);
}

package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta;
import uniandes.edu.co.proyecto.modelo.Operaciones;

public interface Operacion_CuentaRepository extends JpaRepository<Operacion_Cuenta, uniandes.edu.co.proyecto.modelo.Operacion_CuentaPK>{
  
    @Query(value = "SELECT * FROM OPERACIONES_CUENTA", nativeQuery = true)
    Collection<Operaciones> darOperaciones();

    @Query(value = "SELECT * FROM OPERACIONES_CUENTA WHERE id = :id", nativeQuery = true)
    Operaciones darOperacion(@Param("id")String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONES_CUENTA ( fecha, tipo, valor, cuenta) VALUES (:fecha, :tipo, :valor, :cuenta)", nativeQuery = true)
    void insertarOperacion(@Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACIONES_CUENTA SET tipo = :tipo, estado = :estado, operacion_a_hacer = :operacion_a_hacer, monto = :monto, interes = :interes, cuotas = :cuotas, dia_pago = :dia_pago, valor_cuota = :valor_cuota WHERE id = :id", nativeQuery = true)
    void actualizarOperacion(@Param("id")String id, @Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONES_CUENTA WHERE id = :id", nativeQuery = true)
    void eliminarOperacion(@Param("id")String id);
}

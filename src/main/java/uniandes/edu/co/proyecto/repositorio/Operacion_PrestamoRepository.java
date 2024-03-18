package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Operacion_Prestamo;
import uniandes.edu.co.proyecto.modelo.Operaciones;

public interface Operacion_PrestamoRepository extends JpaRepository<Operacion_Prestamo, uniandes.edu.co.proyecto.modelo.Operacion_PrestamoPK>{
    
       @Query(value = "SELECT * FROM OPERACION_PRESTAMO", nativeQuery = true)
    Collection<Operaciones> darOperaciones();

    @Query(value = "SELECT * FROM OPERACION_PRESTAMO WHERE id = :id", nativeQuery = true)
    Operaciones darOperacion(@Param("id")String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACION_PRESTAMO ( fecha, tipo, valor, cuenta) VALUES (:fecha, :tipo, :valor, :cuenta)", nativeQuery = true)
    void insertarOperacion(@Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACION_PRESTAMO SET tipo = :tipo, estado = :estado, operacion_a_hacer = :operacion_a_hacer, monto = :monto, interes = :interes, cuotas = :cuotas, dia_pago = :dia_pago, valor_cuota = :valor_cuota WHERE id = :id", nativeQuery = true)
    void actualizarOperacion(@Param("id")String id, @Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACION_PRESTAMO WHERE id = :id", nativeQuery = true)
    void eliminarOperacion(@Param("id")String id);


}

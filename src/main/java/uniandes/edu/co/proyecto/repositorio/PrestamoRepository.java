package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, String>{

    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<Prestamo> darPrestamos();
    
    @Query(value = "SELECT * FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id")String id);

    @Modifying
    @Query(value = "INSERT INTO PRESTAMO (tipo, estado, operacion_a_hacer, monto, interes, cuotas, dia_pago, valor_cuota) VALUES (:tipo, :estado, :operacion_a_hacer, :monto, :interes, :cuotas, :dia_pago, :valor_cuota)", nativeQuery = true)
    void insertarPrestamo(@Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Query(value = "UPDATE PRESTAMO SET tipo = :tipo, estado = :estado, operacion_a_hacer = :operacion_a_hacer, monto = :monto, interes = :interes, cuotas = :cuotas, dia_pago = :dia_pago, valor_cuota = :valor_cuota WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id")String id, @Param("tipo")String tipo, @Param("estado")String estado, @Param("operacion_a_hacer")String operacion_a_hacer, @Param("monto")Float monto, @Param("interes")Float interes, @Param("cuotas")Integer cuotas, @Param("dia_pago")String dia_pago, @Param("valor_cuota")Float valor_cuota);

    @Modifying
    @Query(value = "DELETE FROM PRESTAMO WHERE id = :id", nativeQuery = true)   
    void eliminarPrestamo(@Param("id")String id);


    
}

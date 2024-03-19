package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;

import java.util.Collection;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    
    @Query(value = "SELECT * FROM PRESTAMO", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRESTAMO (monto, interes, numero_cuotas, dia_pago_cuota, valor_cuota, estado) VALUES (:monto, :interes, :numeroCuotas, :diaPagoCuota, :valorCuota, :estado)", nativeQuery = true)
    void insertarPrestamo(@Param("monto") double monto, @Param("interes") double interes, @Param("numeroCuotas") int numeroCuotas, @Param("diaPagoCuota") int diaPagoCuota, @Param("valorCuota") double valorCuota, @Param("estado") String estado);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE PRESTAMO SET monto = :monto, interes = :interes, numero_cuotas = :numeroCuotas, dia_pago_cuota = :diaPagoCuota, valor_cuota = :valorCuota, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") int id, @Param("monto") double monto, @Param("interes") double interes, @Param("numeroCuotas") int numeroCuotas, @Param("diaPagoCuota") int diaPagoCuota, @Param("valorCuota") double valorCuota, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRESTAMO WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") int id);
}

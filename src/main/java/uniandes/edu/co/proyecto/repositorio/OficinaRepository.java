package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Oficina;

import java.util.Collection;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {
    
    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE id = :id", nativeQuery = true)
    Oficina darOficina(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (nombre, direccion, numero_puntos_atencion, gerente_id) VALUES (:nombre, :direccion, :numeroPuntosAtencion, :gerenteId)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPuntosAtencion") int numeroPuntosAtencion, @Param("gerenteId") int gerenteId);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET nombre = :nombre, direccion = :direccion, numero_puntos_atencion = :numeroPuntosAtencion, gerente_id = :gerenteId WHERE id = :id", nativeQuery = true)
    void actualizarOficina(@Param("id") int id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPuntosAtencion") int numeroPuntosAtencion, @Param("gerenteId") int gerenteId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE id = :id", nativeQuery = true)
    void eliminarOficina(@Param("id") int id);
}

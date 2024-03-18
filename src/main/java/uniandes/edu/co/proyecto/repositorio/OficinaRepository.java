package uniandes.edu.co.proyecto.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.Collection;

public interface OficinaRepository extends JpaRepository<OficinaRepository, String>{

    @Query(value = "SELECT * FROM OFICINA", nativeQuery = true)
    Collection<OficinaRepository> darOficinas();

    @Query(value = "SELECT * FROM OFICINA WHERE id = :id", nativeQuery = true)
    OficinaRepository darOficina(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OFICINA (nombre, direccion, num_puntos_atencion, ciudad) VALUES (:nombre, :direccion, :num_puntos_atencion, :ciudad)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre,@Param("direccion") String direccion,@Param("num_puntos_atencion") Integer num_puntos_atencion,@Param("ciudad") String ciudad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE OFICINA SET nombre = :nombre, direccion = :direccion, num_puntos_atencion = :num_puntos_atencion, ciudad = :ciudad WHERE id = :id", nativeQuery = true)
    void actualizarOficina(@Param("id") String id,@Param("nombre") String nombre,@Param("direccion") String direccion,@Param("num_puntos_atencion") Integer num_puntos_atencion,@Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OFICINA WHERE id = :id", nativeQuery = true)
    void eliminarOficina(@Param("id") String id);
    

    
} 
package uniandes.edu.co.proyecto.repositorio;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PuntosAtencion;

public interface PuntosAtencionRepository extends JpaRepository<PuntosAtencion, String>{
    @Query(value = "SELECT * FROM PUNTOS_ATENCION", nativeQuery = true)
    Collection<PuntosAtencion> darPuntosAtencion();

    @Query(value = "SELECT * FROM PUNTOS_ATENCION WHERE id = :id", nativeQuery = true)
    PuntosAtencion darPuntosAtencion(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTOS_ATENCION (operaciones, latitud, longitud, tipo) VALUES (:operaciones, :latitud, :longitud, :tipo)", nativeQuery = true)
    void insertarPuntosAtencion(@Param("operaciones") ArrayList<String> operaciones, @Param("latitud") String latitud, @Param("longitud") String longitud, @Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PUNTOS_ATENCION (id, operaciones, latitud, longitud, tipo) VALUES (:id, :operaciones, :latitud, :longitud, :tipo)", nativeQuery = true)
    void actualizarPuntosAtencion(@Param("id") String id, @Param("operaciones") ArrayList<String> operaciones, @Param("latitud") String latitud, @Param("longitud") String longitud, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PUNTOS_ATENCION WHERE id = :id", nativeQuery = true)
    void eliminarPuntosAtencion(@Param("id") String id);
    
    
}

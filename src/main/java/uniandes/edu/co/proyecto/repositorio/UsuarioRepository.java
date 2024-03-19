package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.util.Collection;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM USUARIO WHERE documento_identidad = :documento", nativeQuery = true)
    Usuario darUsuario(@Param("documento") String documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIO (documento_identidad, nombre, direccion, email, telefono, ciudad, departamento, codigo_postal, tipo_usuario) VALUES (:documentoIdentidad, :nombre, :direccion, :email, :telefono, :ciudad, :departamento, :codigoPostal, :tipoUsuario)", nativeQuery = true)
    void insertarUsuario(@Param("documentoIdentidad") String documentoIdentidad, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal, @Param("tipoUsuario") String tipoUsuario);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIO SET nombre = :nombre, direccion = :direccion, email = :email, telefono = :telefono, ciudad = :ciudad, departamento = :departamento, codigo_postal = :codigoPostal, tipo_usuario = :tipoUsuario WHERE documento_identidad = :documentoIdentidad", nativeQuery = true)
    void actualizarUsuario(@Param("documentoIdentidad") String documentoIdentidad, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("email") String email, @Param("telefono") String telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal, @Param("tipoUsuario") String tipoUsuario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USUARIO WHERE documento_identidad = :documentoIdentidad", nativeQuery = true)
    void eliminarUsuario(@Param("documentoIdentidad") String documentoIdentidad);
}

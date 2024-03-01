package asandovalarq.gestorproyectos.repositorios;

import asandovalarq.gestorproyectos.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepositorio extends JpaRepository <Usuario, Long> {
        Usuario findByNombreOrEmail(String nombre, String email);
    }


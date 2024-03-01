package asandovalarq.gestorproyectos.repositorios;

import asandovalarq.gestorproyectos.modelos.AsignacionProyectoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignacionProyectoUsuarioRepositorio extends JpaRepository <AsignacionProyectoUsuario, Long> {
    
}

package asandovalarq.gestorproyectos.repositorios;

import asandovalarq.gestorproyectos.modelos.Proyecto;
import asandovalarq.gestorproyectos.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProyectoRepositorio extends JpaRepository <Proyecto, Long> {
        List<Proyecto> findByGerenteOrDesarrolladores(Usuario gerente, Usuario desarrollador);
    }



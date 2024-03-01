package asandovalarq.gestorproyectos.repositorios;

import asandovalarq.gestorproyectos.modelos.HistoriaUsuario;
import asandovalarq.gestorproyectos.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ITareaRepositorio extends JpaRepository <Tarea, Long> {
        List<Tarea> findByHistoriaUsuario(HistoriaUsuario historiaUsuario);
    }


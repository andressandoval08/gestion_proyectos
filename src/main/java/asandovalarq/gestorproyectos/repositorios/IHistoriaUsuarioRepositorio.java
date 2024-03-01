package asandovalarq.gestorproyectos.repositorios;

import asandovalarq.gestorproyectos.modelos.HistoriaUsuario;
import asandovalarq.gestorproyectos.modelos.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHistoriaUsuarioRepositorio extends JpaRepository <HistoriaUsuario, Long> {
        List<HistoriaUsuario> findByProyecto(Proyecto proyecto);
    }


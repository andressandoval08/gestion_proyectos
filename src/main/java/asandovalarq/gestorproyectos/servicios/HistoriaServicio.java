package asandovalarq.gestorproyectos.servicios;

import asandovalarq.gestorproyectos.modelos.HistoriaUsuario;
import asandovalarq.gestorproyectos.modelos.Proyecto;
import asandovalarq.gestorproyectos.repositorios.IHistoriaUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HistoriaServicio {
    @Autowired
    IHistoriaUsuarioRepositorio historiaUsuarioRepositorio;

    public List<HistoriaUsuario> obtenerTodasLasHistorias(){
        return historiaUsuarioRepositorio.findAll();
    }


    public HistoriaUsuario obtenerHistoriaUsuarioPorId(Long historiaId) {
        return historiaUsuarioRepositorio.findById(historiaId).orElseThrow(()->
                new NoSuchElementException("Proyecto no encontrado " + historiaId));
    }

    public HistoriaUsuario crearHistoriaUsuario(String detalles, String criteriosAceptacion, String estado, Proyecto proyecto) {
        HistoriaUsuario nuevaHistoria = new HistoriaUsuario();
        nuevaHistoria.setDetalles(detalles);
        nuevaHistoria.setCriteriosAceptacion(criteriosAceptacion);
        nuevaHistoria.setEstado(estado);
        nuevaHistoria.setProyecto(proyecto);

        return historiaUsuarioRepositorio.save(nuevaHistoria);
    }
}

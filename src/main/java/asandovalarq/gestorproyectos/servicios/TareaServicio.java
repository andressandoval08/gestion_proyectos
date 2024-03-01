package asandovalarq.gestorproyectos.servicios;

import asandovalarq.gestorproyectos.modelos.HistoriaUsuario;
import asandovalarq.gestorproyectos.modelos.Tarea;
import asandovalarq.gestorproyectos.repositorios.ITareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TareaServicio {
    @Autowired
    ITareaRepositorio tareaRepositorio;


    public List<Tarea> obtenerTodasLasTareas(){
        return tareaRepositorio.findAll();
    }

    public Tarea obtenerTareaPorId(Long tareaId) {
        return tareaRepositorio.findById(tareaId).orElseThrow(()->
                new NoSuchElementException("Proyecto no encontrado " + tareaId));
    }

    public Tarea crearTarea(String descripcion, String estado, HistoriaUsuario historiaUsuario) {
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(descripcion);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setHistoriaUsuario(historiaUsuario);

        return tareaRepositorio.save(nuevaTarea);
    }


}

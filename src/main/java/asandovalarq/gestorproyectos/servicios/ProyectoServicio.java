package asandovalarq.gestorproyectos.servicios;

import asandovalarq.gestorproyectos.modelos.Proyecto;
import asandovalarq.gestorproyectos.modelos.Usuario;
import asandovalarq.gestorproyectos.repositorios.IProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProyectoServicio {
    @Autowired
    IProyectoRepositorio proyectoRepositorio;

    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepositorio.findAll();
    }

    public Proyecto obtenerProyectoPorId(Long proyectoId) {
        return proyectoRepositorio.findById(proyectoId).orElseThrow(()->
                new NoSuchElementException("Proyecto no encontrado " + proyectoId));
    }

    public Proyecto crearProyecto(String nombre, String descripcion, String fechaInicio, Usuario gerente) {
        // Crear y guardar el nuevo proyecto
        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombre(nombre);
        nuevoProyecto.setDescripcion(descripcion);
        nuevoProyecto.setFechaInicio(fechaInicio);
        nuevoProyecto.setGerente(gerente);

        return proyectoRepositorio.save(nuevoProyecto);
    }

    public void agregarDesarrolladorAProyecto(Proyecto proyecto, Usuario desarrollador) {
        // Verificar si el desarrollador ya está asociado al proyecto
        if (!proyecto.getDesarrolladores().contains(desarrollador)) {
            proyecto.getDesarrolladores().add(desarrollador);
            proyectoRepositorio.save(proyecto);
        }
    }

}


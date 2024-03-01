package asandovalarq.gestorproyectos.controladorTest;

import asandovalarq.gestorproyectos.controlador.ControladorPrincipal;
import asandovalarq.gestorproyectos.modelos.HistoriaUsuario;
import asandovalarq.gestorproyectos.modelos.Proyecto;
import asandovalarq.gestorproyectos.modelos.Tarea;
import asandovalarq.gestorproyectos.modelos.Usuario;
import asandovalarq.gestorproyectos.repositorios.IHistoriaUsuarioRepositorio;
import asandovalarq.gestorproyectos.repositorios.IProyectoRepositorio;
import asandovalarq.gestorproyectos.repositorios.ITareaRepositorio;
import asandovalarq.gestorproyectos.servicios.HistoriaServicio;
import asandovalarq.gestorproyectos.servicios.ProyectoServicio;
import asandovalarq.gestorproyectos.servicios.TareaServicio;
import asandovalarq.gestorproyectos.servicios.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControladorPrincipalTest {

    @Mock
    private UsuarioServicio usuarioServicio;

    @Mock
    private ProyectoServicio proyectoServicio;
    @Mock
    private IProyectoRepositorio proyectoRepositorio;

    @Mock
    private HistoriaServicio historiaServicio;
    @Mock
    private IHistoriaUsuarioRepositorio historiaUsuarioRepositorio;

    @Mock
    private TareaServicio tareaServicio;
    @Mock
    private ITareaRepositorio tareaRepositorio;

    @InjectMocks
    private ControladorPrincipal controladorPrincipal;

    // ******** UNIT TEST PARA ENDPOINTS RELACIONADO CON USUARIOS *************

    @Test
    void obtenerTodosLosUsuarios() {
        // Arrange
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());
        when(usuarioServicio.obtenerTodosLosUsuarios()).thenReturn(usuarios);

        // Act
        ResponseEntity<List<Usuario>> responseEntity = controladorPrincipal.obtenerTodosLosUsuarios();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usuarios, responseEntity.getBody());
    }

    @Test
    void obtenerUsuarioPorId() {
        // Arrange
        Long userId = 1L;
        Usuario usuario = new Usuario();
        when(usuarioServicio.obtenerUsuarioPorId(userId)).thenReturn(usuario);

        // Act
        ResponseEntity<Usuario> responseEntity = controladorPrincipal.obtenerUsuarioPorId(userId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usuario, responseEntity.getBody());
    }

    @Test
    void crearUsuario() {
        // Arrange
        Usuario usuario = new Usuario(3L, "Loki", "loki@cosmo.com", "password", "desarrollador");
        when(usuarioServicio.crearUsuario(any(), any(), any(), any())).thenReturn(usuario);

        // Act
        ResponseEntity<Usuario> responseEntity = controladorPrincipal.crearUsuario(usuario);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(usuario, responseEntity.getBody());
    }

    // ******** UNIT TESTS PARA ENDPOINTS RELACIONADOS CON PROYECTOS *************

    @Test
    void obtenerProyectoPorId() {
        // Arrange
        Long proyectoId = 1L;
        Proyecto proyecto = new Proyecto();
        when(proyectoRepositorio.findById(proyectoId)).thenReturn(Optional.of(proyecto));

        // Act
        Proyecto result = proyectoServicio.obtenerProyectoPorId(proyectoId);

        // Assert
        assertEquals(proyecto, result);
        verify(proyectoRepositorio, times(1)).findById(proyectoId);
    }

    @Test
    void crearProyecto() {
        // Arrange
        String nombre = "Nuevo Proyecto";
        String descripcion = "Descripción del proyecto";
        Date fechaInicio = new Date();
        Usuario gerente = new Usuario("Gerente", "gerente@example.com", "password");
        Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, fechaInicio, gerente);
        when(proyectoRepositorio.save(any())).thenReturn(nuevoProyecto);

        // Act
        Proyecto result = proyectoServicio.crearProyecto(nombre, descripcion, fechaInicio, gerente);

        // Assert
        assertEquals(nuevoProyecto, result);
        verify(proyectoRepositorio, times(1)).save(any());
    }

    @Test
    void agregarDesarrolladorAProyecto() {
        long proyectoId = 1L;
        Long desarrolladorId = 2L;
        Proyecto proyecto = new Proyecto();
        Usuario desarrollador = new Usuario(4L,"Michael", "Desarrollador", "michael@cosmo.com", "password");

        when(proyectoRepositorio.findById(proyectoId)).thenReturn(Optional.of(proyecto));
        when(usuarioServicio.obtenerUsuarioPorId(desarrolladorId)).thenReturn(desarrollador);
        // proyectoServicio.agregarDesarrolladorAProyecto(proyectoId, desarrolladorId);

        assertTrue(proyecto.getDesarrolladores().contains(desarrollador));
        verify(proyectoRepositorio, times(1)).findById(proyectoId);
        verify(usuarioServicio, times(1)).obtenerUsuarioPorId(desarrolladorId);
    }
}

    // ******** UNIT TESTS PARA ENDPOINTS RELACIONADOS CON HISTORIAS DE USUARIO *************

    @Test
    void obtenerTodasLasHistorias() {
        List<HistoriaUsuario> historias = Arrays.asList(new HistoriaUsuario(), new HistoriaUsuario());
        when(historiaUsuarioRepositorio.findAll()).thenReturn(historias);

        List<HistoriaUsuario> result = historiaServicio.obtenerTodasLasHistorias();

        assertEquals(historias.size(), result.size());
        verify(historiaUsuarioRepositorio, times(1)).findAll();
    }

    @Test
    void obtenerHistoriaUsuarioPorId() {
        Long historiaId = 1L;
        HistoriaUsuario historia = new HistoriaUsuario();
        when(historiaUsuarioRepositorio.findById(historiaId)).thenReturn(Optional.of(historia));

        HistoriaUsuario result = historiaServicio.obtenerHistoriaUsuarioPorId(historiaId);

        assertEquals(historia, result);
        verify(historiaUsuarioRepositorio, times(1)).findById(historiaId);
    }

    @Test
    void crearHistoriaUsuario() {
        HistoriaUsuario nuevaHistoria = new HistoriaUsuario(1L, "Detalles de la historia", "Criterios de aceptación", "En progreso", new Proyecto());
        when(historiaUsuarioRepositorio.save(any())).thenReturn(nuevaHistoria);

        HistoriaUsuario result = historiaServicio.crearHistoriaUsuario(nuevaHistoria.getDetalles(), nuevaHistoria.getCriteriosAceptacion(), nuevaHistoria.getEstado(), nuevaHistoria.getProyecto());

        assertEquals(nuevaHistoria, result);
        verify(historiaUsuarioRepositorio, times(1)).save(any());
    }


    // ******** UNIT TESTS PARA ENDPOINTS RELACIONADOS CON TAREAS *************

    @Test
    void obtenerTodasLasTareas() {
        List<Tarea> tareas = Arrays.asList(new Tarea(), new Tarea());
        when(tareaRepositorio.findAll()).thenReturn(tareas);

        List<Tarea> result = tareaServicio.obtenerTodasLasTareas();

        assertEquals(tareas.size(), result.size());
        verify(tareaRepositorio, times(1)).findAll();
    }

    @Test
    void obtenerTareaPorId() {
        Long tareaId = 1L;
        Tarea tarea = new Tarea();
        when(tareaRepositorio.findById(tareaId)).thenReturn(Optional.of(tarea));

        Tarea result = tareaServicio.obtenerTareaPorId(tareaId);

        assertEquals(tarea, result);
        verify(tareaRepositorio, times(1)).findById(tareaId);
    }

    @Test
    void crearTarea() {
        Tarea nuevaTarea = new Tarea(1L,"Descripción de la tarea", "Pendiente", new HistoriaUsuario());
        when(tareaRepositorio.save(any())).thenReturn(nuevaTarea);

        Tarea result = tareaServicio.crearTarea(nuevaTarea.getDescripcion(), nuevaTarea.getEstado(), nuevaTarea.getHistoriaUsuario());

        assertEquals(nuevaTarea, result);
        verify(tareaRepositorio, times(1)).save(any());
    }
}


package asandovalarq.gestorproyectos.servicios;

import asandovalarq.gestorproyectos.excepciones.UsuarioExistenteException;
import asandovalarq.gestorproyectos.modelos.Usuario;
import asandovalarq.gestorproyectos.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioRepositorio.findAll();
    }


    public Usuario obtenerUsuarioPorId(Long desarrolladorId) {
        return usuarioRepositorio.findById(desarrolladorId).
                orElseThrow(()
                        -> new NoSuchElementException("Usuario no encontrado " + desarrolladorId));
    }

    public Usuario crearUsuario(String nombreUsuario, String email, String contrasenia, String tipo) {
        // Verificar si ya existe un usuario con el mismo nombre de usuario o correo electrónico
        if (usuarioRepositorio.findByNombreOrEmail(nombreUsuario, email) != null) {
            throw new UsuarioExistenteException("El nombre o correo ya esta registrado.");
        }
        // Crea y guarda el nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombreUsuario);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setContrasenia(contrasenia);
        nuevoUsuario.setTipo(tipo);

        return usuarioRepositorio.save(nuevoUsuario);
    }


}

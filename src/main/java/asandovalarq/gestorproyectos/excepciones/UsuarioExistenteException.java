package asandovalarq.gestorproyectos.excepciones;

public class UsuarioExistenteException extends RuntimeException{

    public UsuarioExistenteException(){
        super();
    }

    public UsuarioExistenteException(String mensaje){
        super(mensaje);
    }

}

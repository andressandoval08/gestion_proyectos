package asandovalarq.gestorproyectos.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AsignacionProyectoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_asignacion;

    @ManyToOne
    @JoinColumn(name = "Id_proyecto")
    Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    Usuario usuario;
    String rol;

}

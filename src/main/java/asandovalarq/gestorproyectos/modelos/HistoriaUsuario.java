package asandovalarq.gestorproyectos.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HistoriaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Historia;
    String detalles;
    String criteriosAceptacion;
    String estado;

    @ManyToOne
    @JoinColumn(name = "Id_proyecto")
    Proyecto proyecto;

    @OneToMany(mappedBy = "historiaUsuario")
    private List<Tarea> tareas;

    public HistoriaUsuario(long l, String detallesDeLaHistoria, String criteriosDeAceptación, String enProgreso, Proyecto proyecto) {

    }
}

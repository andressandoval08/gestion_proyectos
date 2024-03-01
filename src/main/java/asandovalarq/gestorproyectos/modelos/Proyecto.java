package asandovalarq.gestorproyectos.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_proyecto;
    String nombre;
    String descripcion;
    String fechaInicio;

    @ManyToOne
    @JoinColumn(name = "Id_gerente")
    private Usuario gerente;

    @ManyToMany
    @JoinTable(
            name = "proyecto_desarrolladores",
            joinColumns = @JoinColumn(name = "Id_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "desarrollador_id"))
    private List<Usuario> desarrolladores;

}

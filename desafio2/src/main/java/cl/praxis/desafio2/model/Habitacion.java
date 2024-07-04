package cl.praxis.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Habitacion {

    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int precio;
    private int habitaciones;
    private int metraje;

}

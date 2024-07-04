package cl.praxis.desafio2.business;

import cl.praxis.desafio2.model.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionBusiness {

    private String DESCRIPCION = "Habitación Clásica con cama extra grande, fotos al océano y balcón";
    private String IMAGEN = "https://images.pexels.com/photos/164595/pexels-photo-164595.jpeg";

    public List<Habitacion> getHabitaciones() {

        Habitacion h1 = new Habitacion(1, "Habitación 1, Doble", DESCRIPCION, IMAGEN, 120000, 1, 20);
        Habitacion h2 = new Habitacion(2, "Habitación 2, Simple", DESCRIPCION, IMAGEN, 100000, 1, 15);
        Habitacion h3 = new Habitacion(3, "Habitación 3, Simple", DESCRIPCION, IMAGEN, 110000, 1, 18);
        Habitacion h4 = new Habitacion(4, "Habitación 4, Simple", DESCRIPCION, IMAGEN, 130000, 2, 25);
        Habitacion h5 = new Habitacion(5, "Habitación 5, Doble", DESCRIPCION, IMAGEN, 150000, 2, 30);
        Habitacion h6 = new Habitacion(6, "Habitación 6, Twin", DESCRIPCION, IMAGEN, 140000, 2, 28);
        Habitacion h7 = new Habitacion(7, "Habitación 7, Suite", DESCRIPCION, IMAGEN, 160000, 3, 35);
        Habitacion h8 = new Habitacion(8, "Habitación 8, Suite", DESCRIPCION, IMAGEN, 170000, 3, 40);

        ArrayList<Habitacion> habitaciones = new ArrayList<>(List.of(h1, h2, h3, h4, h5, h6, h7, h8));

        return habitaciones;
    }

    public Habitacion getHabitacionById (Habitacion habitacion) {
        return getHabitaciones().stream().filter(h -> h.getId() == habitacion.getId()).findFirst().get();
    }

    public int calcularValorCompra (int valorHabitacion, int dias) {
        return valorHabitacion * dias;
    }
}

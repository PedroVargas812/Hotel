import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    public Hotel() {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void mostrarDisponibles() {
        System.out.println("Habitaciones disponibles:");
        for (Habitacion h : habitaciones) {
            if (h.isDisponible()) {
                System.out.println(h);
            }
        }
    }

    public boolean crearReserva(String cliente, int numeroHabitacion, LocalDate fecha) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.isDisponible()) {
                Reserva r = new Reserva(cliente, fecha, h);
                reservas.add(r);
                h.setDisponible(false);
                System.out.println("Reserva creada: " + r);
                return true;
            }
        }
        System.out.println("No se pudo crear la reserva. Habitacion no disponible.");
        return false;
    }
    public boolean eliminarReserva(int numeroHabitacion) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.getHabitacion().getNumero() == numeroHabitacion) {
                r.getHabitacion().setDisponible(true);
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }


    public void mostrarReservas() {
        System.out.println("Reservas realizadas:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}

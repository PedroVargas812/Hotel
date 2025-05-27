import java.time.LocalDate;

public class Reserva {
    private String cliente;
    private LocalDate fecha;
    private Habitacion habitacion;

    public Reserva(String cliente, LocalDate fecha, Habitacion habitacion) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.habitacion = habitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    @Override
    public String toString() {
        return "Reserva de " + cliente + " para la habitación " +
                habitacion.getNumero() + " el día " + fecha;
    }
}

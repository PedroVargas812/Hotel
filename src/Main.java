import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Agregar algunas habitaciones al sistema
        hotel.agregarHabitacion(new Habitacion(101, "Simple"));
        hotel.agregarHabitacion(new Habitacion(102, "Doble"));
        hotel.agregarHabitacion(new Habitacion(103, "Suite"));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== MENÚ DE RESERVAS ====");
            System.out.println("1. Ver habitaciones disponibles");
            System.out.println("2. Crear una nueva reserva");
            System.out.println("3. Eliminar una reserva");
            System.out.println("4. Ver todas las reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    hotel.mostrarDisponibles();
                    break;

                case 2:
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Número de habitación: ");
                    int numHabitacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    LocalDate fecha = LocalDate.now();
                    hotel.crearReserva(cliente, numHabitacion, fecha);
                    break;

                case 3:
                    System.out.print("Número de habitación a cancelar reserva: ");
                    int habitacionCancelar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    boolean eliminada = hotel.eliminarReserva(habitacionCancelar);
                    if (eliminada) {
                        System.out.println("Reserva eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró una reserva para esa habitación.");
                    }
                    break;

                case 4:
                    hotel.mostrarReservas();
                    break;

                case 0:
                    System.out.println("¡Gracias por usar el sistema de reservas!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Reserva{
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean activa;
    
    private static List<Reserva> reservas = new ArrayList<>();

    // Constructor
    public Reserva(Cliente cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFinal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.activa = true;
        reservas.add(this);
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }
    
      public boolean isActiva() {
        return activa;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    // Método para realizar una reserva de vehículo
    public void realizarReserva() {
        if (vehiculo.isDisponibilidad()) {
            vehiculo.setDisponibilidad(false); 
            generarContrato();
            System.out.println("Reserva realizada con éxito para el vehículo con placa: " + vehiculo.getPlaca());
            
        } else {
            System.out.println("El vehículo seleccionado no está disponible para reservar.");
        }
    }
    // Generar contrato
    
    private void generarContrato() {
        System.out.println("----- Contrato de Alquiler -----");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vehículo: " + vehiculo.getModelo() + " - " + vehiculo.getPlaca());
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de finalización: " + fechaFinal);
        System.out.println("Costo total: $" + calcularCostoTotal());
        System.out.println("---------------------------------");
    }
    
     // Método para calcular el costo total del alquiler
    private double calcularCostoTotal() {
        long tiempoInicio = fechaInicio.getTime();
        long tiempoFinal = fechaFinal.getTime();
        long diferenciaEnMilisegundos = tiempoFinal - tiempoInicio;
        long diferenciaEnDias = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24); // Convertir milisegundos a días
        return diferenciaEnDias * vehiculo.getTarifa();
    }
    
     // Métodos para obtener la lista de alquileres activos y pasados del cliente
    public static List<Reserva> obtenerAlquileresActivosCliente(Cliente cliente) {
        List<Reserva> alquileresActivosCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente) && reserva.isActiva()) {
                alquileresActivosCliente.add(reserva);
            }
        }
        return alquileresActivosCliente;
    }

    public static List<Reserva> obtenerAlquileresPasadosCliente(Cliente cliente) {
        List<Reserva> alquileresPasadosCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente) && !reserva.isActiva()) {
                alquileresPasadosCliente.add(reserva);
            }
        }
        return alquileresPasadosCliente;
    }

    // Método para cancelar una reserva
    public void cancelarReserva() {
        if (fechaInicio.after(new Date())) { // Si la fecha de inicio es en el futuro
            reservas.remove(this);
            this.activa = false;
            vehiculo.setDisponibilidad(true); // Marcar el vehículo como disponible nuevamente
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("No se puede cancelar la reserva porque el alquiler ya ha comenzado.");
        }
    }
}

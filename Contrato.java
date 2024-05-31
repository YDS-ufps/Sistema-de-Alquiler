import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato
{
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fechaInicio;
    private Date fechaFinal;
    private double costoTotal;
    private boolean activo;
    
    private static List<Contrato> contratos = new ArrayList<>();

    // Constructor
    public Contrato(Cliente cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFinal, double costoTotal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.costoTotal = costoTotal;
        this.activo = true;
        contratos.add(this);
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

    public double getCostoTotal() {
        return costoTotal;
    }
    
    public boolean isActivo() {
        return activo;
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
    
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
     // Método para ver una lista de contratos de alquiler activos
    public static List<Contrato> obtenerContratosActivos() {
        List<Contrato> contratosActivos = new ArrayList<>();
        for (Contrato contrato : contratos) {
            if (contrato.isActivo()) {
                contratosActivos.add(contrato);
            }
        }
        return contratosActivos;
    }

    // Método para ver una lista de contratos de alquiler pasados
    public static List<Contrato> obtenerContratosPasados() {
        List<Contrato> contratosPasados = new ArrayList<>();
        for (Contrato contrato : contratos) {
            if (!contrato.isActivo()) {
                contratosPasados.add(contrato);
            }
        }
        return contratosPasados;
    }

    // Método para cerrar un contrato de alquiler
    public void cerrarContrato() {
        this.activo = false;
        Vehiculo.marcarVehiculoDisponible(vehiculo); // Marcar el vehículo como disponible nuevamente
    }
}

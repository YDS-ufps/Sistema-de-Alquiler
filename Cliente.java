import java.util.ArrayList;
import java.util.List;

public class Cliente
{
    
    private String nombre; 
    private String direccion;
    private String telefono;
    private String email;
    private int id;
    
    private static List<Cliente> registroClientes = new ArrayList<>();
    private static int contadorClientes = 0;
    
    //Constructor
    public Cliente(String nombre, String direccion, String telefono, String email, int id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.id = id;
        asignarIDCliente();
        registrarCliente(this);
    }
    
    // Getters y Setters
    
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     // Métodos de registro de clientes
    private static void registrarCliente(Cliente cliente) {
        registroClientes.add(cliente);
    }

    public static List<Cliente> obtenerRegistroClientes() {
        return registroClientes;
    }
    
    // Método para asignar un ID único a cada cliente
    private void asignarIDCliente() {
        this.id = ++contadorClientes;
    }
}

package modelo.entidades;

public class Administrativo extends Empleado {
    private static final long serialVersionUID = 1L;
    private Pabellon pabellon;

    public Administrativo(int id, String nombre, String apellido, String dni, String direccion, double sueldo, Pabellon pabellon) {
        super(id, nombre, apellido, dni, direccion, sueldo);
        this.pabellon = pabellon;
    }
}
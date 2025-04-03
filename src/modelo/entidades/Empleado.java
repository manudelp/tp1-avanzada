package modelo.entidades;

public abstract class Empleado extends Persona {
    private static final long serialVersionUID = 1L;
    protected double sueldo;

    public Empleado(int id, String nombre, String apellido, String dni, String direccion, double sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}

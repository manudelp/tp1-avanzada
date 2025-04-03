package modelo.entidades;

public class Profesor extends Empleado {
    private static final long serialVersionUID = 1L;
    private Clase clase;

    public Profesor(int id, String nombre, String apellido, String dni, String direccion, double sueldo, Clase clase) {
        super(id, nombre, apellido, dni, direccion, sueldo);
        this.clase = clase;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}

package modelo.entidades;

public class Alumno extends Persona {
    private static final long serialVersionUID = 1L;
    private Carrera carrera;

    public Alumno(int id, String nombre, String apellido, String dni, String direccion, Carrera carrera) {
        super(id, nombre, apellido, dni, direccion);
        this.carrera = carrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}

package modelo.entidades;
import java.io.Serializable;
import java.util.Objects;

public class Alumno extends Persona {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;

    public Alumno(int id, String nombre, String apellido, int edad, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return id == alumno.id;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + carrera;
    }
}

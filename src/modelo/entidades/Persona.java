package modelo.entidades;
import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String direccion;

    public Persona(int id, String nombre, String apellido, String dni, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
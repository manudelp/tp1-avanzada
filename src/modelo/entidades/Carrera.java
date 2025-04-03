package modelo.entidades;

public class Carrera implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private int cantidadMaterias;
    private int cantidadAnios;

    public Carrera(int id, String nombre, int cantidadMaterias, int cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }
}

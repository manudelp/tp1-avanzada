package modelo.entidades;

public class Pabellon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String direccion;
    private double tamano;

    public Pabellon(int id, String nombre, String direccion, double tamano) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tamano = tamano;
    }
}

package modelo.entidades;

public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int numero;
    private String tamano;
    private int cantidadMesas;
    private final String tipoPizarron;

    public Clase(int id, int numero, String tamano, int cantidadMesas, String tipoPizarron) {
        this.id = id;
        this.numero = numero;
        this.tamano = tamano;
        this.cantidadMesas = cantidadMesas;
        this.tipoPizarron = tipoPizarron;
    }
}

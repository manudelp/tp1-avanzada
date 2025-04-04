package pruebas;

import modelo.entidades.Alumno;
import java.util.ArrayList;

public class PruebaAlumnos {
    public static void main(String[] args) {
        // Crear lista de alumnos
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        // Agregar alumnos a la lista
        listaAlumnos.add(new Alumno(1, "Juan", "Pérez", 20, "Ingeniería Informática"));
        listaAlumnos.add(new Alumno(2, "María", "López", 22, "Arquitectura"));
        listaAlumnos.add(new Alumno(3, "Carlos", "Gómez", 21, "Medicina"));

        // Mostrar los alumnos en la consola
        System.out.println("Lista de Alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }
}

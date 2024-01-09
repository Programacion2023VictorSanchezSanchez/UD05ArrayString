package Tarea5Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para organizar cada grupo del instituto con los alumnos y asignaturas
 * Autor: Víctor Sánchez
 */
public class Grupo {

    Scanner sc = new Scanner(System.in);

    //Declaramos variables
    private String nombreGrupo;
    private String [] alumnos;
    private Asignatura [] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;

    //Constructor para la clase Grupo
    public Grupo(String grupo, int totalAlumnos, int totalAsignaturas){

        this.nombreGrupo = grupo;

        this.alumnos = new String[totalAlumnos];

        this.asignaturas = new Asignatura[totalAsignaturas];

        this.totalAlumnos = totalAlumnos;

        this.totalAsignaturas = totalAsignaturas;
    }

    //Metodo que introduce alumnos en el array y los ordena
    public void leerALumnos(){
        String alumno;
        for (int i = 0; i < this.alumnos.length; i++){
            System.out.println("Nombre del alumno " + i+1 + " :");
            alumno = sc.next();
            this.alumnos[i] = alumno;
        }

        Arrays.sort(this.alumnos);
    }

    //Metodo que muestra los alumnos
    public void mostrarAlumnos(){
        for (int i = 0; i < this.alumnos.length; i++) {
            System.out.println(this.alumnos[i]);
        }
    }

    //Metodo para leer las asignaturas e introducir las notas de los alumnos en dicha asignatura
    public void leerAsignaturas(){
        String asignatura;
        for (int i = 0; i < this.asignaturas.length; i++){
            asignatura = sc.next();
            this.asignaturas[i] = new Asignatura(asignatura);
            this.asignaturas[i].leerNotas(this.totalAlumnos);
        }
    }

    //Metodo para mostrar solo el nombre de la asignatura
    public void mostrarAsignaturas(){
        String asignatura;
        for (int i = 0; i < this.asignaturas.length; i++){
            asignatura = this.asignaturas[i].getNombreAsignatura();
            System.out.println(asignatura);
        }
    }
}

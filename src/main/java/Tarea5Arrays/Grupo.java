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

    public void leerALumnos(){
        String alumno;
        for (int i = 0; i < this.totalAlumnos; i++){
            System.out.println("Nombre del alumno " + i+1 + " :");
            alumno = sc.next();
            this.alumnos[i] = alumno;
        }

        Arrays.sort(this.alumnos);
    }
}

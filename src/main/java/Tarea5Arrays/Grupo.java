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

    /**
     * Constructor para la clase grupo
     * @param grupo nombre del grupo
     * @param totalAlumnos el total de alumnos que habrá en el grupo
     * @param totalAsignaturas el total de asignaturas que habrá en el grupo de tipo clase Asignatura
     */
    public Grupo(String grupo, int totalAlumnos, int totalAsignaturas){

        this.nombreGrupo = grupo;

        this.alumnos = new String[totalAlumnos];

        this.asignaturas = new Asignatura[totalAsignaturas];

        this.totalAlumnos = totalAlumnos;

        this.totalAsignaturas = totalAsignaturas;
    }

    /**
     * Rellenamos el array de alumnos y lo ordenamos
     */
    public void leerALumnos(){
        String alumno;
        for (int i = 0; i < this.alumnos.length; i++){
            System.out.println("Nombre del alumno " + (i+1) + " :");
            alumno = sc.next();
            this.alumnos[i] = alumno;
        }

        Arrays.sort(this.alumnos);
    }

    /**
     * Mostramos el array alumnos
     */
    public void mostrarAlumnos(){
        for (int i = 0; i < this.alumnos.length; i++) {
            System.out.println(this.alumnos[i]);
        }
    }

    /**
     * Rellenamos el array asignaturas y llamamos a la clase asignatura para rellenar con las notas de esta asignatura
     */
    public void leerAsignaturas(){
        String asignatura;
        for (int i = 0; i < this.asignaturas.length; i++){
            System.out.println("Introduce el nombre de la asignatura: ");
            asignatura = sc.next();
            this.asignaturas[i] = new Asignatura(asignatura);
            this.asignaturas[i].leerNotas(this.totalAlumnos);
        }
    }

    /**
     * Mostramos solo el nombre de la asignatura
     */
    public void mostrarAsignaturas(){
        String asignatura;
        for (int i = 0; i < this.asignaturas.length; i++){
            asignatura = this.asignaturas[i].getNombreAsignatura();
            System.out.println(asignatura);
        }
    }

    /**
     * Mostramos la media de las notas de cada asignatura
     */
    public void mostrarMedias(){
        String asignatura;
        double media;
        StringBuilder resultado = new StringBuilder();

        String s = "";
        for(int i = 0 ; i < this.asignaturas.length ; i++){
            asignatura = this.asignaturas[i].getNombreAsignatura();
            media = this.asignaturas[i].media();
            resultado.append(" ").append(asignatura);

        }
        System.out.println(s);
    }

    /**
     * Comprobamos la asignatura con la media más baja
     * @return El nombre de la asignatura con media más baja
     */
    public String dameAsignaturaMinima(){
        String asignatura = "";
        double media = 11;
        for(int i = 0 ; i < this.asignaturas.length ; i++){
            if(this.asignaturas[i].media() < media){
                asignatura = this.asignaturas[i].getNombreAsignatura();
                media = this.asignaturas[i].media();
            }

        }
        return asignatura;

    }

    /**
     * Comprobamos la asignatura con la media más alta
     * @return El nombre de la asignatura con la media más alta
     */
    public String dameAsignaturaMaxima(){
        String asignatura = "";
        double media = 0;
        for(int i = 0 ; i < this.asignaturas.length ; i++){
            if(this.asignaturas[i].media() > media){
                asignatura = this.asignaturas[i].getNombreAsignatura();
                media = this.asignaturas[i].media();
            }

        }
        return asignatura;
    }

    /**
     * Calculamos la media de una asignatura en concreto
     * @param indice la asignatura que daremos la media
     * @return La media de la asignatura
     */
    public double dameMediaAsignatura(int indice){
        double media = this.asignaturas[indice].media();
        return media;
    }

    public double dameAlumnoMedia(int indice){
        double media;
        double sum = 0;
        for (Asignatura asignatura : this.asignaturas) {
            sum = sum + asignatura.notaAlumno(indice);
        }
        media = sum / this.asignaturas.length;
        return media;
    }


}
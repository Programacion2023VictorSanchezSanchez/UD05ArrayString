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

        for(int i = 0 ; i < this.asignaturas.length ; i++){
            asignatura = this.asignaturas[i].getNombreAsignatura();
            media = this.asignaturas[i].media();
            resultado.append(asignatura).append(" ").append(media);

        }
        System.out.println(resultado);
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

    /**
     * Calculamos la media de todas las notas de un alumno
     * @param indice el alumno que queremos hacer la media
     * @return la media de sus notas
     */
    public double dameAlumnoMedia(int indice){
        double media;
        double sum = 0;
        for (Asignatura asignatura : this.asignaturas) {
            sum = sum + asignatura.notaAlumno(indice);
        }
        media = sum / this.asignaturas.length;
        return media;
    }

    /**
     * Devolvemos cuantos suspensos tiene un alumno
     * @param indice el alumno del cual vamos a comprobar las notas
     * @return los suspensos que tiene
     */
    public int dameAlumnoSuspensos(int indice){
        int suspenso = 0;
        for(Asignatura asignatura : this.asignaturas){
            if(asignatura.notaAlumno(indice) < 5){
                suspenso++;
            }
        }
        return suspenso;
    }

    /**
     * Comprobamos cual es el alumno con mejor media
     * @return el nombre del alumno con mejor media
     */
    public String dameMejorAlumnoMedia(){
        double media;
        double mediaMayor = 0;
        String alumno = "";
        for(int i = 0 ; i < this.alumnos.length ; i++){
            media = dameAlumnoMedia(i);
            if(media > mediaMayor){
                mediaMayor = media;
                alumno = this.alumnos[i];
            }
        }
        return alumno;
    }

    public void muestraMediaAlumnos(){
        double media;
        String alumno;
        StringBuilder resultado = new StringBuilder();

        for(int i = 0 ; i < this.alumnos.length ; i++){
            alumno = this.alumnos[i];
            media = dameAlumnoMedia(i);
            resultado.append(alumno).append(" ").append(media);
        }
        System.out.println(resultado);
    }

    /**
     * Comprobamos de cada alumno las asignaturas que tienen suspendidas y mostramos si debería de repetir o no
     */
    public void muestraRepetidores(){
        int suspensos;
        for(int i = 0 ; i < this.alumnos.length ; i++){
            suspensos = dameAlumnoSuspensos(i);
            if(suspensos > 2){
                System.out.println(this.alumnos[i]);
            }
        }
    }

    /**
     * Como el metodo analizarGrupo pero analizamos todas las asignaturas
     */
    public void analizaAsignaturas(){
        for (Asignatura asignatura : this.asignaturas) {
            asignatura.analizaGrupo();
        }
    }

    /**
     * Analizamos el grupo con las medias generales de todo el curso de cada alumno
     */
    public void analizarCurso(){
        int indiceAlto = 0;
        int indiceMedio = 0;
        int indiceBajo = 0;
        float porcentajeAlto = 0;
        float porcentajeMedio = 0;
        float porcentajeBajo = 0;
        for(int i = 0 ; i < this.alumnos.length ; i++){
            if(dameAlumnoMedia(i) > 7){
                indiceAlto++;
            }else if(dameAlumnoMedia(i) >= 5 && dameAlumnoMedia(i) <= 7){
                indiceMedio++;
            }else{
                indiceBajo++;
            }
        }
        porcentajeAlto = (float) (indiceAlto * 100) / this.alumnos.length;
        porcentajeMedio = (float) (indiceMedio * 100) / this.alumnos.length;
        porcentajeBajo = (float) (indiceBajo * 100) / this.alumnos.length;

        if(porcentajeAlto >= 66){
            System.out.println("VAMOS FENOMENAL");
        }else if(porcentajeMedio >= 66){
            System.out.println("REPASAR EJERCICIOS CON DIFICULTAD");
        }else if(porcentajeBajo >= 66){
            System.out.println("VAMOS MAL... REPETIR TEMARIO");
        }else{
            System.out.println("HACER SUBGRUPOS CON TAREAS DIFERENTE DIFICULTAD");
        }

    }


}

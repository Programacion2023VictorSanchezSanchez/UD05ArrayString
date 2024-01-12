package Tarea5Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para calcular las notas de cada asignatura para la evaluación
 * Autor: Víctor Sánchez
 */
public class Asignatura {

    Scanner sc = new Scanner(System.in);

    //Declaramos variables
    private String nombreAsignatura;
    private double [] listaNotas;


    //Getter nombre asignatura
    public String getNombreAsignatura(){
        return this.nombreAsignatura;
    }

    //Getter lista notas
    public double[] getListaNotas() {
        return this.listaNotas;
    }


    //Constructores

    //Constructor con solo el nombre
    public Asignatura(String nombreAsignatura){

        this.nombreAsignatura = nombreAsignatura;
    }

    //Constructor con el nombre y el array de lista de notas
    public Asignatura(String nombreAsignatura, double [] listaNotas){
        this.nombreAsignatura = nombreAsignatura;

        this.listaNotas = listaNotas;
    }

    /**
     * Comprueba si el array esta vacío o no, si esta vacio rellena el array, si no esta vacío pregunta si quieres rellenarlo de nuevo o dejarlo como esta
     * @param totalAlumnos el total de alumnos que queremos guardar en el array
     */
    public void leerNotas(int totalAlumnos) {
        String introducido = "";
        double nota;
        if (this.listaNotas != null) {
            System.out.println("Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            introducido = sc.next();
        }
        if (introducido.equals("s") || introducido.equals("S")) {

            this.listaNotas = new double[totalAlumnos];
            for (int i = 0; i < totalAlumnos; i++) {
                do {
                    System.out.println("Introduzca una nota entre 0 y 10");
                    nota = sc.nextDouble();
                    this.listaNotas[i] = nota;

                } while (nota < 0 && nota > 10);

            }



        }
        if(this.listaNotas == null){

            this.listaNotas = new double[totalAlumnos];

            for (int i = 0; i < totalAlumnos; i++) {
                do {
                    System.out.println("Introduzca una nota entre 0 y 10");
                    nota = sc.nextDouble();
                    this.listaNotas[i] = nota;

                } while (nota < 0 && nota > 10);

            }
        }
        System.out.print("Notas: ");
        for (int i = 0; i < this.listaNotas.length; i++) {
            System.out.print(this.listaNotas[i] + " ");
        }
        System.out.println("");
    }

    //Sobrecargamos el to string
    public String toString(){
        String s = "";
        String nombreAsignatura = "Asignatura: " + this.nombreAsignatura + "\n";
        if(this.listaNotas != null){
            for(int i = 0 ; i < this.listaNotas.length ; i++){
            s =  s + "Alumno " + (i+1) + ": " + this.listaNotas[i] + "\n";


            }
        }
        else{
            s = "Sin notas por el momento";
        }
        s = nombreAsignatura + s;
        return s;
    }

    /**
     * Comprueba si esta vacío el array y si no lo esta hace la media con las notas de todo el array
     * @return la media de todas las notas
     */
    public double media(){
        double media = -1;
        double suma = 0;
        if(this.listaNotas != null) {
            for (double listaNota : this.listaNotas) {
                suma = suma + listaNota;
            }
            media = suma / this.listaNotas.length;
        }

        return media;
    }

    /**
     * Comprobamos cual es la nota más baja de todo el array
     * @return devolvemos el minimo con la nota más baja de todo el array
     */
    public double minimo(){
        double minimo = 11;
        if(this.listaNotas != null) {
            for (double listaNota : this.listaNotas) {
                if (listaNota < minimo) {
                    minimo = listaNota;
                }
            }

        } else {
            minimo = -1;
        }

        return minimo;
    }

    /**
     * Comprobamos cual es la nota más alta de todo el array
      * @return devolvemos la nota más alta del array
     */
    public double maximo(){
        double maximo = 0;
        if(this.listaNotas != null) {
            for (double listaNota : this.listaNotas) {
                if (listaNota > maximo) {
                    maximo = listaNota;
                }
            }

        } else {
            maximo = -1;
        }

        return maximo;
    }

    /**
     * Comprobamos el total de suspensos del array
     * @return devolvemos el total de los suspendidos del array
     */
    public int totalSuspensos(){
        int suspensos = 0;
        if(this.listaNotas != null) {
            for (double listaNota : this.listaNotas) {
                if (listaNota < 5) {
                    suspensos++;
                }
            }

        } else {
            suspensos = -1;
        }

        return suspensos;
    }

    /**
     * Comprobamos el total de aprobados del array
     * @return devolvemos el total de los aprobados del array
     */
    public int totalAprobados(){
        int aprobados = 0;
        if(this.listaNotas != null) {
            for (double listaNota : this.listaNotas) {
                if (listaNota >= 5) {
                    aprobados++;
                }
            }

        } else {
            aprobados = -1;
        }

        return aprobados;
    }

    /**
     * Cambiamos la nota de un alumno
     * @param nota la nueva nota que vamos a darle al alumno
     * @param alumno el alumno al que le cambiaremos la nota
     */
    public void cambiarNota(double nota, int alumno){
        if(alumno < this.listaNotas.length-1){
            this.listaNotas[alumno] = nota;
        }
    }

    /**
     * Comprobamos cual es el alumno con mejor nota
     * @return devolvemos el alumno con mejor nota
     */
    public int mejorAlumno(){
        int indiceMaximo = 0;
        double maximo = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(this.listaNotas[i] > maximo){
                maximo = this.listaNotas[i];
                indiceMaximo = i;
            }
        }
        return indiceMaximo;
    }

    /**
     * Comprobamos cual es el alumno con peor nota
     * @return devolvemos el alumno con peor nota
     */
    public int peorAlumno(){
        int indiceMinimo = 0;
        double minimo = 11;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(this.listaNotas[i] < minimo){
                minimo = this.listaNotas[i];
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }

    /**
     * Devolvemos la nota de un alumno, si el indice no existe devolvemos -1
     * @param indice el alumno que queremos devolver la nota
     * @return devolvemos la nota del indice introducido
     */
    public double notaAlumno(int indice){
        double nota = 0;
        if(indice < this.listaNotas.length){
            nota = this.listaNotas[indice];
        }
        else{
            nota = -1;
        }
        return nota;
    }


    /**
     * Comprobamos si el alumno esta aprobado y lo almacenamos en un array si lo esta
     * @return un array con los alumnos aprobados
     */
    public int [] dameAprobados(){
        int totalAprobados = this.totalAprobados();
        int [] aprobados = new int[totalAprobados];
        int contadorArray = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(this.listaNotas[i] >= 5){
                aprobados[contadorArray] = i;
                contadorArray++;
            }
        }

        return aprobados;
    }

    /**
     * Comprobamos si el alumno esta suspendido y lo almacenamos en un array si lo esta
     * @return un array con los alumnos suspendidos
     */
    public int [] dameSuspensos(){
        int totalSuspensos = this.totalSuspensos();
        int [] suspensos = new int[totalSuspensos];
        int contadorArray = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(this.listaNotas[i] < 5){
                suspensos[contadorArray] = i;
                contadorArray++;
            }
        }

        return suspensos;
    }

    /**
     * Devolvemos la primera nota menor que haya a la nota introducida
     * @param nota la nota que con la que se comparara las del array
     * @return la primera nota menor a la nota introducida
     */
    public int primerMenor(double nota){
        int primerMenor = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(nota > this.listaNotas[i]){
                primerMenor = i;
                i = this.listaNotas.length;
            }
        }
        return primerMenor;
    }


    /**
     *  copiamos el array original y lo ordenadomos
     * @return el array ordenado
     */
    public double [] ordenarArray(){
        double [] arrayOrdenado = this.listaNotas;
        Arrays.sort(arrayOrdenado);

        return arrayOrdenado;
    }


    /**
     * Analiza el grupo para comprobar el porcentaje de la clase segun las notas del array
     */
    public void analizaGrupo(){
        int indiceAlto = 0;
        int indiceMedio = 0;
        int indiceBajo = 0;
        float porcentajeAlto = 0;
        float porcentajeMedio = 0;
        float porcentajeBajo = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(this.listaNotas[i] > 7){
                indiceAlto++;
            }else if(this.listaNotas[i] >= 5 && this.listaNotas[i] <= 7){
                indiceMedio++;
            }else{
                indiceBajo++;
            }
        }
        porcentajeAlto = (float) (indiceAlto * 100) / this.listaNotas.length;
        porcentajeMedio = (float) (indiceMedio * 100) / this.listaNotas.length;
        porcentajeBajo = (float) (indiceBajo * 100) / this.listaNotas.length;

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




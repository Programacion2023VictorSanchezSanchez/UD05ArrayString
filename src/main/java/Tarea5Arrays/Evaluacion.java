package Tarea5Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para calcular las notas de cada asignatura para la evaluación
 * Autor: Víctor Sánchez
 */
public class Evaluacion {

    Scanner sc = new Scanner(System.in);

    //Declaramos variables
    private String nombreAsignatura;
    private double [] listaNotas;

    //Constructores
    public Evaluacion(String nombreAsignatura){

        this.nombreAsignatura = nombreAsignatura;
    }
    public Evaluacion(String nombreAsignatura, double [] listaNotas){
        this.nombreAsignatura = nombreAsignatura;

        this.listaNotas = listaNotas;
    }

    //Metodo para leer las notas
    public void leerNotas(int totalAlumnos) {
        String introducido = "";
        double nota;
        if (this.listaNotas != null) {
            System.out.println("Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            introducido = sc.next();
        }
        if (introducido.equals("s") || introducido.equals("S")) {

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

    //Metodo para la media del array
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

    //Metodos para el minimo y el maximo del array
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

    //Metodos para el total de suspensos y aprobados
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

    //Metodo para cambiar la nota de un alumno
    public void cambiarNota(double nota, int alumno){
        if(alumno < this.listaNotas.length-1){
            this.listaNotas[alumno] = nota;
        }
    }

    //Metodos para mostrar el mejor y el peor alumno
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

    //Metodo para mostrar la nota de un alumno
    public double notaAlumno(int indice){
        double nota = 0;
        if(indice < this.listaNotas.length-1){
            nota = this.listaNotas[indice];
        }
        else{
            nota = -1;
        }
        return nota;
    }


    //Metodos para mostrar los indices de los aprobados o los suspensos
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

    //Metodo que nos da la primera nota menor que la dada
    public double primerMenor(double nota){
        double primerMenor = 0;
        for(int i = 0 ; i < this.listaNotas.length ; i++){
            if(nota < this.listaNotas[i]){
                primerMenor = this.listaNotas[i];
                i = this.listaNotas.length;
            }
        }
        return primerMenor;
    }


    //Metodo para ordenar el array
    public double [] ordenarArray(){
        double [] arrayOrdenado = this.listaNotas;
        Arrays.sort(arrayOrdenado);

        return arrayOrdenado;
    }


    //Analizamos el porcentaje del grupo
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




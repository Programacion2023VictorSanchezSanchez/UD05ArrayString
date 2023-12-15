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
    public void leerNotas(int totalAlumnos){
        String introducido = "";

        if(this.listaNotas != null){
            System.out.println("Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            introducido = sc.next();
        }
        if(introducido.equals("s") || introducido.equals("S")){
            for(int i = 0 ; i < totalAlumnos ; i++){
                double nota = sc.nextDouble();
                if(nota >= 0 && nota <= 10){
                    this.listaNotas[i] = nota;
                }else{
                    System.out.println("Nota no válida, vuelva a introducirla");
                    this.listaNotas[i] = 0;
                }

            }
        }
        System.out.print("Notas: ");
        for(int i = 0 ; i < totalAlumnos ; i++){
            System.out.print(this.listaNotas[i] + " ");
        }

    }

    //Sobrecargamos el to string
    public String toString(){
        String s = "";
        String nombreAsignatura = "Asignatura: " + this.nombreAsignatura + "\n";
        if(this.listaNotas != null){
            for(int i = 0 ; i < this.listaNotas.length ; i++){
                System.out.println(this.nombreAsignatura);
            s =  "Alumno " + i+1 + ": " + this.listaNotas[i] + "\n";


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
            for (int i = 0; i < this.listaNotas.length; i++) {
                suma = suma + this.listaNotas[i];
            }
            media = suma / this.listaNotas.length;
        }

        return media;
    }

    //Metodos para el minimo y el maximo del array
    public double minimo(){
        double minimo = 11;
        if(this.listaNotas != null) {
            for (int i = 0; i < this.listaNotas.length; i++) {
                if(this.listaNotas[i] < minimo){
                    minimo = this.listaNotas[i];
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
            for (int i = 0; i < this.listaNotas.length; i++) {
                if(this.listaNotas[i] > maximo){
                    maximo = this.listaNotas[i];
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
            for (int i = 0; i < this.listaNotas.length; i++) {
                if(this.listaNotas[i] < 5){
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
            for (int i = 0; i < this.listaNotas.length; i++) {
                if(this.listaNotas[i] >= 5){
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
}




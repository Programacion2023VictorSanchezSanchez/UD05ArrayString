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

    public String toString(){
        if(this.listaNotas != null){
            return this.nombreAsignatura + " \n";
        }
        else{
            return this.nombreAsignatura + "\n" +
            "Sin notas por el momento";
        }
    }
}




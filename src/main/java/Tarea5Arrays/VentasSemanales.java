package Tarea5Arrays;

/**
 * Clase para comprobar las Ventas semanales
 * Autor: Víctor Sánchez Sánchez
 */
public class VentasSemanales {

    //Declaramos variables de la clase
    private int numSemanas;
    private int [][] seguimiento;

    // Constructor de la clase
    public VentasSemanales(int numSemanas, int[][] seguimiento){
        this.numSemanas = numSemanas;
        this.seguimiento = new int[numSemanas][7];
    }

    public void guardaVenta(int semana, int dia, int valor){
        if(this.seguimiento[semana][dia] != null){
            this.seguimiento[semana][dia] = valor;
        }
    }


}

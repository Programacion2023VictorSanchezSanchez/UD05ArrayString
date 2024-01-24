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

    /**
     * Comprobamos si la semana esta dentro de los limites del array y asignamos el valor indicado al dia de esa semana
     * @param semana a la cual guardaremos el valor de un dia
     * @param dia al cual le guardaremos el valor
     * @param valor que guardaremos
     */
    public void guardaVenta(int semana, int dia, int valor){
        if(semana < this.seguimiento.length-1){
            this.seguimiento[semana][dia] = valor;
        }
    }

    /**
     * Metodo para recorrer la matriz e inicializar todos los valores a 0
     */
    public void inicializaVentas() {
        for (int i = 0; i < this.seguimiento.length; i++) {
            for (int j = 0; j < this.seguimiento[i].length; j++) {
                this.seguimiento[i][j] = 0;
            }
        }

    }

    /**
     * Sobrecargamos el metodo toString para formatear la salida de la clase
     * @return los datos de la matriz y la clase formateada
     */
    public String toString(){
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("%-15s", "Día"));


        for(int i = 0; i < this.seguimiento[0].length; i++) {
            String dia = getNombreDia(i);

            resultado.append(String.format("%-15s", dia));
        }

        resultado.append("\n");

        for(int i = 0; i < this.seguimiento.length; i++) {
            String semana;
            semana = "S" + (i+1);
            resultado.append(String.format("%-15s", semana));

            for(int j = 0; j < this.seguimiento[i].length; j++) {
                double valor = this.seguimiento[i][j];
                resultado.append(String.format("%-15.2f", valor));
            }

            resultado.append("\n");
        }

        return resultado.toString();
    }

    /**
     * Devolvemos los valores de una semana en concreto
     * @param semana la cual vamos a devolver los valores
     */
    public void totalSemana(int semana){
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("%-15s", "Día"));


        for(int i = 0; i < this.seguimiento[0].length; i++) {
            String dia = getNombreDia(i);
            resultado.append(String.format("%-15s", dia));
        }

        resultado.append("\n");

        String s = "Semana " + semana + ":";

        resultado.append(String.format("%-15s", s));

        for(int i = 0 ; i < this.seguimiento[semana].length ; i++){
            int valor = this.seguimiento[semana][i];

            resultado.append(String.format("%-15s", valor));
        }
        System.out.println(resultado);
    }

    /**
     * Metodo para mostrar el total de ventas de un día en concreto de todas la semanas
     * @param dia de los cuales vamos a sumar todas las ventas de cada semana
     */
    public int totalDiaSemana(int dia){
        int total = 0;

        for(int i = 0 ; i < this.seguimiento.length ; i++){
            total = total + this.seguimiento[i][dia];
        }
        return total;
    }

    /**
     * Mostramos la media de ventas de un dia en todas la semanas
     * @param dia al cual le vamos a sacar la media
     * @return media de un dia de la semana
     */
    public int mediaDiaSemana(int dia){
        int total = totalDiaSemana(dia);
        int media = 0;

        media = total / this.seguimiento.length;

        return media;
    }

    /**
     * Metodo para mostrar el total de ventas de todos los dias de todas las semanas
     */
    public void totalDiasSemana(){
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("%-15s", "Día"));


        for(int i = 0; i < this.seguimiento[0].length; i++) {
            String dia = getNombreDia(i);
            resultado.append(String.format("%-15s", dia));
        }

        resultado.append("\n");

        resultado.append(String.format("%-15s", "Total"));

        for(int i = 0 ; i < this.seguimiento[0].length ; i++){
            int total = totalDiaSemana(i);
            resultado.append(String.format("%-15s", total));
        }
        System.out.println(resultado);
    }

    /**
     * Metodo para mostrar la media de todos los dias de la semana
     */
    public void mediaSemana(){
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("%-15s", "Día"));


        for(int i = 0; i < this.seguimiento[0].length; i++) {
            String dia = getNombreDia(i);
            resultado.append(String.format("%-15s", dia));
        }

        resultado.append("\n");

        resultado.append(String.format("%-15s", "Media"));

        for(int i = 0 ; i < this.seguimiento[0].length ; i++){
            int media = mediaDiaSemana(i);
            resultado.append(String.format("%-15s", media));
        }
        System.out.println(resultado);
    }

    /**
     * Metodo para "traducir" del indice de la matriz de dia al nombre que le corresponde
     * @param dia que buscaremos sacar el nombre
     * @return El nombre del dia
     */
    public String getNombreDia(int dia){
        String nombreDia = "";
        switch(dia){
            case 0:
                nombreDia = "Lunes";
                break;
            case 1:
                nombreDia = "Martes";
                break;
            case 2:
                nombreDia = "Miercoles";
                break;
            case 3:
                nombreDia = "Jueves";
                break;
            case 4:
                nombreDia = "Viernes";
                break;
            case 5:
                nombreDia = "Sabado";
                break;
            case 6:
                nombreDia = "Domingo";
                break;
        }
        return nombreDia;
    }
}

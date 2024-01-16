package Tarea5Arrays;

import java.util.Scanner;

public class Principal3 {
    public static void main (String[] args){
        Principal2 principal2 = new Principal2();

        int opc;

        //Leemos la opción
        opc=principal2.menu();


        /**
         * Llamamos con un switch al metodo necesario para la opcion introducida por el usuario
         * @return opcion seleccionada por el usuario
         */
        //Salimos cuando el usuario pulsa la opcion "13-Salir"
        while (opc != 13){

            switch(opc) {
                case 1: //Leer alumnos

                    break;
                case 2: //Leer notas asignatura

                    break;
                case 3: //Mostrar grupo y notas

                    break;
                case 4: //Ver asignaturas

                    break;
                case 5: //Ver media asignaturas

                    break;
                case 6: //Ver asignatura menor mínimo

                    break;
                case 7: //Ver asignatura mayor máximo

                    break;
                case 8: //Mostrar el alumno con mejor media

                    break;
                case 9: //Muestra media de los alumnos

                    break;
                case 10: //Muestra repetidores

                    break;
                case 11: //Analiza asignaturas

                    break;
                case 12: //Analiza curso

                    break;

            }
            opc=principal2.menu();
        }
        System.out.println("Saliendo...");
    }

    /**
     * Menu que mostramos para obtener el parametro que darle al switch
     * @return la opción que introduzca el usuario entre el 1 y el 2
     */
    int menu(){
        Scanner sc = new Scanner(System.in);
        int opc;
        do{
            System.out.println("1-Leer alumnos");
            System.out.println("2-Leer notas asignatura");
            System.out.println("3-Mostrar grupo y notas");
            System.out.println("4-Ver asignaturas");
            System.out.println("5-Ver media asignaturas");
            System.out.println("6-Ver asignatura menor mínimo");
            System.out.println("7-Ver asignatura mayor máximo");
            System.out.println("8-Mostrar el alumno con mejor media");
            System.out.println("9-Muestra media de los alumnos");
            System.out.println("10-Muestra repetidores");
            System.out.println("11-Analiza asignaturas");
            System.out.println("12-Analiza curso");
            System.out.println("13-Salir");

            System.out.println("Elije una opción: (1-13) ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Has elegido la opción 1: Leer alumnos");
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2: Leer notas asignatura");
                    break;
                case 3:
                    System.out.println("Has elegido la opción 3: Mostrar grupo y notas");
                    break;
                case 4:
                    System.out.println("Has elegido la opción 4: Ver asignaturas");
                    break;
                case 5:
                    System.out.println("Has elegido la opción 5: Ver media asignaturas");
                    break;
                case 6:
                    System.out.println("Has elegido la opción 6: Ver asignatura menor");
                    break;
                case 7:
                    System.out.println("Has elegido la opción 7: Ver asignatura mayor");
                    break;
                case 8:
                    System.out.println("Has elegido la opción 8: Mostrar alumno con mejor media");
                    break;
                case 9:
                    System.out.println("Has elegido la opción 9: Muestra media de los alumnos");
                    break;
                case 10:
                    System.out.println("Has elegido la opción 10: Muestra repetidores");
                    break;
                case 11:
                    System.out.println("Has elegido la opción 11: Analiza asignaturas");
                    break;
                case 12:
                    System.out.println("Has elegido la opción 12: Analiza curso");
                    break;
                case 13:
                    System.out.println("Has elegido la opción 13: Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opc < 1 || opc > 13);
        return opc;
    }
}

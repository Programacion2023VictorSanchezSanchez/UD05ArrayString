package Tarea5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args){
        Principal principal = new Principal();

        int opc;

        //Leemos la opción
        opc=principal.menu();


        /**
         * Llamamos con un switch al metodo necesario para la opcion introducida por el usuario
         * @return opcion seleccionada por el usuario
         */
        //Salimos cuando el usuario pulsa la opcion "2-Salir"
        while (opc != 2){
            switch(opc) {
                case 1: //Probar evaluación
                    principal.testEvaluacion();
                    break;

            }
            opc=principal.menu();
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
            System.out.println("1-Probar evaluacion");
            System.out.println("2-Salir");

            System.out.println("Elije una opción: (1-2) ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Has elegido la opción 1: Probar mi evaluacion");
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2: Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opc < 1 || opc > 2);
        return opc;
    }

    /**
     * Metodo para probar la clase Evaluacion
     */
    private void testEvaluacion(){
        //Creamos array
        double[] miArray = new double[] {3.5, 5.2, 7, 9, 1, 6.6, 3, 5, 7.2};

        //Creamos objeto
        Asignatura matematicas = new Asignatura("matematicas", miArray);

        //Leemos y mostramos las notas
        matematicas.leerNotas(miArray.length);

        //Mostramos notas por alumnos
        System.out.println(matematicas);

        //Mostramos la media
        System.out.println("La media de la clase es: " + matematicas.media());

        //Mostramos minimo y maximo
        System.out.println("El minimo de la clase es: " + matematicas.minimo());
        System.out.println("El maximo de la clase es: " + matematicas.maximo());

        //Mostramos total de aprobados y suspensos
        System.out.println("El total de aprobados en la clase es: " + matematicas.totalAprobados());
        System.out.println("El total de suspendidos en la clase es: " + matematicas.totalSuspensos());

        //Cambiamos una nota y mostramos esa nota en concreto
        matematicas.cambiarNota(0, 4);
        System.out.println("La nota es: " + matematicas.notaAlumno(4));

        //Mostramos peor y mejor alumno
        System.out.println("La peor nota de la clase es :" + matematicas.peorAlumno());
        System.out.println("La mejor nota de la clase es :" + matematicas.mejorAlumno());


        //Mostramos los aprobamos y los suspensos
        int aprobados [] = matematicas.dameAprobados();
        int suspendidos [] = matematicas.dameSuspensos();
        System.out.println("Estos son los aprobados: " + Arrays.toString(aprobados));
        System.out.println("Estos son los suspendidos: " + Arrays.toString(suspendidos));

        //Mostramos el array ordenado
        double ordenado [] = matematicas.ordenarArray();
        System.out.println("Estas son las notas ordenadas: " + Arrays.toString(ordenado));

        //Analizamos el grupo
        matematicas.analizaGrupo();

        Grupo dam = new Grupo("dam", 3, 3);
        dam.leerALumnos();
        dam.leerAsignaturas();
        double media = dam.dameAlumnoMedia(1);
        System.out.println(media);
    }
}

package Tarea5Arrays;

import java.util.Scanner;

public class Principal2 {
    public static void main (String[] args){
    Principal2 principal2 = new Principal2();

    int opc;

    //Leemos la opción
    opc=principal2.menu();


    Scanner sc = new Scanner(System.in);

    //Pedimos la informacion del grupo al usuario
    System.out.println("Introduce el nombre del grupo: ");
    String grupo = sc.next();

    System.out.println("Introduce el total de alumnos del grupo: ");
    int totalAlumnos = sc.nextInt();

    System.out.println("Introduce el total de asignaturas del grupo: ");
    int totalAsignaturas = sc.nextInt();


    //Objeto con el que vamos a hacer las pruebas
    Grupo dam = new Grupo(grupo, totalAlumnos, totalAsignaturas);

    /**
     * Llamamos con un switch al metodo necesario para la opcion introducida por el usuario
     * @return opcion seleccionada por el usuario
     */
    //Salimos cuando el usuario pulsa la opcion "13-Salir"
    while (opc != 13){

        switch(opc) {
            case 1: //Leer alumnos
                principal2.testLeerAlumno(dam);
                break;
            case 2: //Leer notas asignatura
                principal2.testAsignaturaYNotas(dam);
                break;
            case 3: //Mostrar grupo y notas
                principal2.testGrupoYNotas(dam);
                break;
            case 4: //Ver asignaturas
                principal2.testMostrarAsignaturas(dam);
                break;
            case 5: //Ver media asignaturas
                principal2.testMediaAsignaturas(dam);
                break;
            case 6: //Ver asignatura menor mínimo
                principal2.testAsignaturaMenor(dam);
                break;
            case 7: //Ver asignatura mayor máximo
                principal2.testAsignaturaMayor(dam);
                break;
            case 8: //Mostrar el alumno con mejor media
                principal2.testMejorAlumno(dam);
                break;
            case 9: //Muestra media de los alumnos
                principal2.testMediaAlumno(dam);
                break;
            case 10: //Muestra repetidores
                principal2.testRepetidores(dam);
                break;
            case 11: //Analiza asignaturas
                principal2.testAnalizaAsignaturas(dam);
                break;
            case 12: //Analiza curso
                principal2.testAnalizaCurso(dam);
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


    /**
     * Todos estos metodos son para llamar a los metodos de la clase grupo y asi probarlos
     * @param grupo el objeto de grupo que vamos a usar en todos estos metodos
     */
    private void testLeerAlumno(Grupo grupo){
        grupo.leerALumnos();
    }

    private void testAsignaturaYNotas(Grupo grupo){
        grupo.leerAsignaturas();
    }

    private void testGrupoYNotas(Grupo grupo){
        System.out.println(grupo);
    }

    private void testMostrarAsignaturas(Grupo grupo){
        grupo.mostrarAsignaturas();
    }

    private void testMediaAsignaturas(Grupo grupo){
        String media = grupo.mostrarMedias();
        System.out.println(media);
    }

    private void testAsignaturaMenor(Grupo grupo){
        String menor = grupo.dameAsignaturaMinima();
        System.out.println(menor);
    }

    private void testAsignaturaMayor(Grupo grupo){
        String mayor = grupo.dameAsignaturaMaxima();
        System.out.println(mayor);
    }

    private void testMejorAlumno(Grupo grupo){
        String mejor = grupo.dameMejorAlumnoMedia();
        System.out.println(mejor);
    }

    private void testMediaAlumno(Grupo grupo){
        String media = grupo.muestraMediaAlumnos();
        System.out.println(media);
    }

    private void testRepetidores(Grupo grupo){
        grupo.muestraRepetidores();
    }

    private void testAnalizaAsignaturas(Grupo grupo){
        grupo.analizaAsignaturas();
    }

    private void testAnalizaCurso(Grupo grupo){
        grupo.analizarCurso();
    }
}

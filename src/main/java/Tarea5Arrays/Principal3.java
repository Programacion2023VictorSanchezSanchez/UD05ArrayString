package Tarea5Arrays;

import java.util.Scanner;

public class Principal3 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Principal3 principal3 = new Principal3();
        Tarea3String test = new Tarea3String();

        int opc;

        //Leemos la opción
        opc=principal3.menu();


        /**
         * Llamamos con un switch al metodo necesario para la opcion introducida por el usuario
         * @return opcion seleccionada por el usuario
         */
        //Salimos cuando el usuario pulsa la opcion "10-Salir"
        while (opc != 10){
            String input;
            String input2;
            switch(opc) {
                case 1: //esCorrectoNif
                    System.out.println("Introduce un nif: ");
                    input = sc.next();
                    boolean esCorrecto = test.esCorrectoNIF(input);
                    System.out.println(esCorrecto);
                    break;
                case 2: //quitaVocales
                    System.out.println("Introduzca para quitar vocales: ");
                    input = sc.next();
                    String sinVocales = test.quitaVocales(input);
                    System.out.println(sinVocales);
                    break;
                case 3: //quitaEspacios
                    System.out.println("Introduzca para quitar espacios: ");
                    input = sc.next();
                    String sinEspacios = test.quitaEspaciosSobrantes(input);
                    System.out.println(sinEspacios);
                    break;
                case 4: //invertir
                    System.out.println("Introduzca para quitar invertir: ");
                    input = sc.next();
                    String invertido = test.invertir(input);
                    System.out.println(invertido);
                    break;
                case 5: //repeticiones
                    System.out.println("Introduzca una frase: ");
                    input = sc.next();
                    System.out.println("Introduzca la palabra a buscar que se repita: ");
                    input2 = sc.next();
                    int repeticiones = test.repeticiones(input, input2);
                    System.out.println(repeticiones);
                    break;
                case 6: //esPalindromo
                    System.out.println("Introduzca la palabra a comprobar ");
                    input = sc.next();
                    boolean esPalindromo = test.esPalindromo(input);
                    System.out.println(esPalindromo);
                    break;
                case 7: //cifrar
                    System.out.println("Introduzca la palabra a cifrar ");
                    input = sc.next();
                    String cifrado = test.cifrar(input);
                    System.out.println(cifrado);
                    break;
                case 8: //descifrar
                    System.out.println("Introduzca la palabra a descifrar ");
                    input = sc.next();
                    String descifrado = test.desCifrar(input);
                    System.out.println(descifrado);
                    break;
                case 9: //ahorcado
                    System.out.println("Introduce la palabra a adivinar: ");
                    input = sc.next();
                    System.out.println("Introduce los intentos: ");
                    int intentos = sc.nextInt();
                    JuegoAhorcado testJuego = new JuegoAhorcado(input,intentos);
                    testJuego.iniciarJuego();
                    break;

            }
            opc=principal3.menu();
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
            System.out.println("1-esCorrectoNif");
            System.out.println("2-QuitaVocales");
            System.out.println("3-QuitaEspacios");
            System.out.println("4-Invertir");
            System.out.println("5-Repeticiones");
            System.out.println("6-esPalindromo");
            System.out.println("7-Cifrar");
            System.out.println("8-Descifrar");
            System.out.println("9-Ahorcado");
            System.out.println("10-Salir");


            System.out.println("Elije una opción: (1-10) ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Has elegido la opción 1: esCorrectoNif");
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2: QuitaVocales");
                    break;
                case 3:
                    System.out.println("Has elegido la opción 3: QuitaEspacios");
                    break;
                case 4:
                    System.out.println("Has elegido la opción 4: Invertir");
                    break;
                case 5:
                    System.out.println("Has elegido la opción 5: Repeticiones");
                    break;
                case 6:
                    System.out.println("Has elegido la opción 6: esPalindromo");
                    break;
                case 7:
                    System.out.println("Has elegido la opción 7: Cifrar");
                    break;
                case 8:
                    System.out.println("Has elegido la opción 8: Descifrar");
                    break;
                case 9:
                    System.out.println("Has elegido la opción 9: Ahorcado");
                    break;
                case 10:
                    System.out.println("Has elegido la opción 10: Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opc < 1 || opc > 10);
        return opc;
    }

}

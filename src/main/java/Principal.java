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
                case 1: //Probar temperatura

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
            System.out.println("1-Probar temperatura");
            System.out.println("2-Salir");

            System.out.println("Elije una opción: (1-2) ");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Has elegido la opción 1: Probar mi temperatura");
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2: Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opc < 1 || opc > 5);
        return opc;
    }
}

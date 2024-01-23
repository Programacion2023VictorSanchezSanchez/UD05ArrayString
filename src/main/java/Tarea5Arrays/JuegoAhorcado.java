package Tarea5Arrays;

import java.util.Scanner;

/**
 * Clase para el juego del ahorcado
 * Autor: Víctor Sánchez Sánchez
 */
    public class JuegoAhorcado {

        private String palabraSecreta;
        private int intentosRestantes;
        private StringBuilder palabraActual;
        private boolean juegoTerminado;

        // Constructor que recibe la palabra secreta y el número de intentos
        public JuegoAhorcado(String palabraSecreta, int intentos) {
            this.palabraSecreta = palabraSecreta.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Normalizar palabra
            this.intentosRestantes = intentos;
            this.palabraActual = new StringBuilder("_".repeat(this.palabraSecreta.length()));
            this.juegoTerminado = false;
        }

        /**
         * Metodo con el cual iniciamos el juego y no se acaba hasta que se cumpla la condición para que acabe
         */
        public void iniciarJuego() {
            Scanner scanner = new Scanner(System.in);

            while (!this.juegoTerminado) {
                mostrarEstadoJuego();

                System.out.print("Introduce una letra: ");
                String letra = scanner.nextLine().toLowerCase();

                if (letra.length() == 1 && Character.isLetter(letra.charAt(0))) {
                    procesarIntento(letra.charAt(0));
                } else {
                    System.out.println("Entrada no válida. Por favor, introduce una letra.");
                }
            }


        }

        /**
         * Mostramos la palabra actual y los intentos restantes
         */
        private void mostrarEstadoJuego() {
            System.out.println("Palabra actual: " + this.palabraActual);
            System.out.println("Intentos restantes: " + this.intentosRestantes);
        }


        /**
         * Comprobamos si la letra esta en la palabra y si el juego puede haber acabado
         * @param letra que comprobaremos si esta en la palabra secreta
         */
        private void procesarIntento(char letra) {
            if (this.palabraSecreta.contains(String.valueOf(letra))) {
                actualizarPalabraActual(letra);
                System.out.println("¡Letra acertada!");
            } else {
                this.intentosRestantes--;
                System.out.println("Letra incorrecta. Intentos restantes: " + this.intentosRestantes);
            }

            verificarFinJuego();
        }

        /**
         * Reemplazamos el espacio vacío por la letra si es igual.
         * @param letra a comprobar si es igual que una de la palabra
         */
        private void actualizarPalabraActual(char letra) {
            for (int i = 0; i < this.palabraSecreta.length(); i++) {
                if (this.palabraSecreta.charAt(i) == letra) {
                    this.palabraActual.setCharAt(i, letra);
                }
            }
        }

        /**
         * Comprobamos si el juego ha acabado ya sea por falta de intentos o porque acertó la palabra
         */
        private void verificarFinJuego() {
            if (this.palabraActual.toString().equals(this.palabraSecreta)) {
                System.out.println("¡Has ganado!");
                this.juegoTerminado = true;
            } else if (this.intentosRestantes <= 0) {
                System.out.println("¡Has perdido! La palabra secreta era: " + this.palabraSecreta);
                this.juegoTerminado = true;
            }
        }

    }



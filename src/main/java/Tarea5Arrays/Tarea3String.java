package Tarea5Arrays;

/**
 * Clase para almacenar los variados metodos de String creados.
 * Autor: Víctor Sánchez Sánchez.
 */
public class Tarea3String {

    /**
     * Comprobamos si el nif es correcto
     *
     * @param nif que comprobaremos si es correcto
     * @return devolveremos un boolean de si es correcto o no el nif
     */
    public boolean esCorrectoNIF(String nif) {
        boolean esCorrectoNIF = true;

        // Comprobar el tamaño
        if (nif.length() != 9) {
            esCorrectoNIF = false;
        }

        // Comprobar que los primeros 8 caracteres son dígitos
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(nif.charAt(i))) {
                esCorrectoNIF = false;
            }
        }

        // Comprobar que el último caracter es una letra
        char letra = Character.toUpperCase(nif.charAt(8));
        if (!Character.isLetter(letra)) {
            esCorrectoNIF = false;
        }

        // Calcular la letra esperada
        int numero = Integer.parseInt(nif.substring(0, 8));
        char letraEsperada = calcularLetraNIF(numero);

        // Comparar con la letra proporcionada
        if (letra != letraEsperada) {
            esCorrectoNIF = false;
        }
        return esCorrectoNIF;
    }

    /**
     * Metodo para calcular si la letra del NIF es la esperada
     *
     * @param numero por el cual vamos a hacer el modulo de 23 para sacar el indice
     * @return devolvemos la letra esperada
     */
    public char calcularLetraNIF(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numero % 23;
        return letras.charAt(indice);
    }

    /**
     * Reemplazamos todas las vocales del String por espacios vacíos
     *
     * @param conVocales el String con las vocales
     * @return String sin vocales
     */
    public String quitaVocales(String conVocales) {
        String sinVocales = conVocales.replaceAll("[aeiouáéíóúüAEIOUÁÉÍÓÚÜ]", "");
        return sinVocales;
    }

    /**
     * Sustituimos los espacios por asteriscos de una cadena introducida
     *
     * @param conEspacios a la que vamos a sustituir los espacios
     * @return cadena con asteriscos en vez de espacios
     */
    public String quitaEspaciosSobrantes(String conEspacios) {
        // Divide la cadena en palabras
        String[] palabras = conEspacios.trim().split("\\s+");

        // Une las palabras con asteriscos y forma la nueva cadena
        String conAsteriscos = String.join("*", palabras);

        return conAsteriscos;
    }

    /**
     * Invertimos el String introducido
     * @param aInvertir String a invertir
     * @return el String invertido
     */
    public String invertir(String aInvertir) {
        // Convierte la cadena a un array de caracteres
        char[] caracteres = aInvertir.toCharArray();

        // Invierte el array de caracteres
        int inicio = 0;
        int fin = caracteres.length - 1;
        while (inicio < fin) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fin];
            caracteres[fin] = temp;
            inicio++;
            fin--;
        }

        // Crea una nueva cadena a partir del array invertido
        String invetido = new String(caracteres);
        return invetido;

    }

    /**
     * Comprobamos cuantas veces se repite una palabra en una frase
     * @param frase frase que comprobaremos
     * @param palabra palabra que buscamos sus repeticiones
     * @return Las veces que se repite la palabra en la frase
     */
    public int repeticiones(String frase, String palabra) {
        // Convierte ambas la frase y la palabra a minúsculas para hacer la comparación insensible a mayúsculas
        frase = frase.toLowerCase();
        palabra = palabra.toLowerCase();

        // Dividir la frase en palabras
        String[] palabras = frase.split("\\s+");

        // Contador para el número de repeticiones
        int cont = 0;

        // Verificar cada palabra en la frase
        for (String palabraEnFrase : palabras) {
            if (palabraEnFrase.equals(palabra)) {
                cont++;
            }
        }

        return cont;
    }

    /**
     * Comprobamos si la cadena introducida es un palindromo
     * @param cadena que comprobaremos si es palindromo
     * @return Decimos si es palindromo o no con un booleano
     */
    public boolean esPalindromo(String cadena) {
        boolean esPalindromo = false;
        // Elimina espacios y convierte todo a minúsculas (ignorando mayúsculas y espacios)
        String cadenaFormateada = cadena.replaceAll("\\s", "").toLowerCase();

        // Compara la cadena original con su versión invertida
        if(cadenaFormateada.equals(invertir(cadenaFormateada))){
            esPalindromo = true;
        }
        return esPalindromo;
    }

    /**
     * Metodo para cifrar con desplazamiento +3
     * @param aCifrar texto a cifrar
     * @return texto cifrado
     */
    public String cifrar(String aCifrar) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < aCifrar.length(); i++) {
            char caracter = aCifrar.charAt(i);

            // Verifica si el caracter es una letra
            if (Character.isLetter(caracter)) {
                char cifrado = (char) ((caracter - 'A' + 3) % 26 + 'A');
                resultado.append(cifrado);
            } else {
                // Si no es una letra, simplemente añade el caracter sin cifrar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    /**
     * Metodo para descifrar con desplazamiento +3
     * @param aDescifrar texto a descifrar
     * @return texto descifrado
     */
    public String desCifrar(String aDescifrar) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < aDescifrar.length(); i++) {
            char caracter = aDescifrar.charAt(i);

            // Verifica si el caracter es una letra
            if (Character.isLetter(caracter)) {
                char descifrado = (char) ((caracter - 'A' - 3 + 26) % 26 + 'A');
                resultado.append(descifrado);
            } else {
                // Si no es una letra, simplemente añade el caracter sin descifrar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }




}


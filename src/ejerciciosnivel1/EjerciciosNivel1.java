/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosnivel1;

import java.util.Arrays;

/**
 *
 * @author Javier
 */
public class EjerciciosNivel1 {

    int[] listaNumeros = {50, 30, 7, 7, 1, 2};

    public int[] maximos(int[] lista) {
        
        if(lista.length>1){
        int[] arrayMaximos = {lista[0], lista[1]};

        for (int i = 1; i < lista.length; i++) {
            if (arrayMaximos[0] < lista[i]) {
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            } else if (arrayMaximos[1] < lista[i]) {

                arrayMaximos[1] = lista[i];

            }

        }
        
        for (int i = 0; i < arrayMaximos.length; i++) {
            System.out.println(arrayMaximos[i]);
        }
        return arrayMaximos;
        
        }else if(lista.length>1){
            int[] arrayMaximos = {lista[0]};
            return arrayMaximos;
        }
        
        int[] arrayMaximos = {};
        return arrayMaximos;
        
    }

    //Devuelve true si el string es un palíndromo
    public boolean palindromo(String str) {
        String reves = "";
        String noEspacios = quita(str);

        for (int i = str.length(); i > 0; i--) {//Guardamos str del revés y sin espacios

            if (str.charAt(i - 1) != ' ') {

                reves += str.charAt(i - 1);
            }
        }

        if (reves.equalsIgnoreCase(noEspacios)) {
            return true;
        }
        return false;
    }
    
    
    //Quita los espacios de un String
    private String quita(String str){
        String noEspacios = "";
        for (int i = 0; i < str.length(); i++) {//guardamos str sin espacios
            if (str.charAt(i) != ' ') {
                noEspacios += str.charAt(i);
            }
        }
        
        return noEspacios;
    }

    
    
    //Devuelve true si el string es un palíndromo
    public boolean palindromo2(String str) {
        
        str = str.toUpperCase();
        
        str = quita(str);
        
        int izq = 0;
        int der = str.length()-1;

        while(izq<=der && str.charAt(der)==str.charAt(izq)){
            izq++;
            der--;
        }
        System.out.println(izq+" "+der);
        
        if(izq>der){
            return true;
        }
        return false;
        
    }
    //Devuelve true si el string es un isograma
    //Consideramos que no puede haber espacios
    public boolean isograma(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    

    //Imprimir un mes de 31 día, el metodo recibe el día por el que empieza el mes
    public void imprimirMes(int comienzo) {

        int dia = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    if (j < comienzo) {
                        System.out.print(" XX ");
                    } else {
                        dia++;
                        System.out.print(" ");
                        if (dia < 9) {
                            System.out.print("0");
                        }
                        System.out.print(dia + " ");
                    }
                } else {

                    dia++;

                    if (dia <= 31) {
                        System.out.print(" ");
                        if (dia < 9) {
                            System.out.print("0");
                        }
                        System.out.print(dia + " ");
                    } else {
                        System.out.print(" XX ");
                    }
                }
            }
            System.out.println("");
        }
    }

    //Ejercicio igual que el anterior pero probando a meter una matriz
    public void calendarioConMatriz(int comienzo) {
        int calendario[][] = new int[5][7];
        int dia = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    if (j < comienzo) {
                        calendario[i][j] = 0;

                        System.out.print(" " + calendario[i][j] + " ");
                    } else {
                        dia++;
                        calendario[i][j] = dia;
                        System.out.print(" " + calendario[i][j] + " ");
                    }
                } else {

                    dia++;

                    if (dia <= 31) {
                        calendario[i][j] = dia;
                        System.out.print(" " + calendario[i][j] + " ");
                    } else {
                        calendario[i][j] = 0;
                        System.out.print(" " + calendario[i][j] + " ");
                    }
                }
            }
            System.out.println("");
        }

    }

    //Recibe dos String	y devuelve true	si uno es anagrama del otro.
    //Suponemos que no hay tilde
    public boolean anagrama(String str1, String str2) {

        //Lo ponemos en mayúculas para que no nos dé fallo si hay mayusculas y minículas
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        boolean caracterIgual = false;//Esta variable nos indica si un caracter de str1 tiene otro igual en str2

        if (str1.equals(str2)) {//Si son la misma palabra no es una anagrama
            return false;
        }
        
        str1 = quita(str1);
        str2 = quita(str2);

        if (str1.length() == str2.length()) {//Si no miden lo mismo no es un anagrama
            for (int i = 0; i < str1.length(); i++) {
                
                //Comprobamos que los caractere de str1 estén en str2
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        caracterIgual = true;
                    }
                }

                if (!caracterIgual) {//Si un caracter de str1 no esta en str2 no es una anagrama
                    return false;
                }
                caracterIgual = false;

                //Comprobamos que los caractere de str2 estén en str1
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) == str2.charAt(i)) {
                        caracterIgual = true;
                    }
                }

                if (!caracterIgual) {//Si un caracter de str2 no esta en str1 no es una anagrama
                    return false;
                }
                caracterIgual = false;
            }
            return true;//Si sale del ciclo es que es un anagrama
        }

        return false;
    }

    
    //Recibe un String y tiene que devolver otro string con un acronimo formado por la primer letra de esas palabras.
    //Debe ignorar "Las", "la", "de", "y", "e"
    public void acronimo(String str) {

        boolean ultima; //Si es true el programa ha podido valorar la palabra

        //Eliminamos los posibles espacios del principio y final
        while (str.charAt(0) == ' ') {
            str = str.substring(1);
        }

        while (str.charAt(str.length() - 1) == ' ') {
            str = str.substring(0, str.length() - 1);
        }

        //Elimino la posibilidad de que haya hasta 5 espacios seguidos
        str = str.replaceAll("  ", " ");
        str = str.replaceAll("   ", " ");
        str = str.replaceAll("    ", " ");
        str = str.replaceAll("     ", " ");
        str = str.replaceAll("      ", " ");

        String aux1 = "";//En este string guardaremos los dos siguientes caracteres despues de un espacio
        String aux2 = "";//En este string guardaremos los tres siguientes caracteres despues de un espacio
        String aux3 = "";//En este string guardaremos los cuatro siguientes caracteres despues de un espacio

        String acronimo = "";
        
        for (int i = 0; i < str.length(); i++) {//Recorre el string

            ultima = false;

            if (str.charAt(i) == ' ' || i == 0) {//Si es el comienzo de una palabra

                if (i != 0) {
                    i++;
                }

                //Ponemos un try catch por si la útima palabra es menor de tres letras
                try {
                    aux1 = str.substring(i, i + 2);
                    aux2 = str.substring(i, i + 3);
                    aux3 = str.substring(i, i + 4);
                    if (aux1.equalsIgnoreCase("y ") || aux1.equalsIgnoreCase("e ") || aux2.equalsIgnoreCase("la ")
                            || aux2.equalsIgnoreCase("de ") || aux3.equalsIgnoreCase("las ")) {//Si esa palabra es alguna de las que se ignora no se hace nada.

                    } else {
                        acronimo += str.charAt(i);
                    }

                    ultima = true;
                } catch (Exception e) {

                }

                if (!ultima) {//Si es la última palabra y tiene 3 letras.
                    try {
                        aux3 = str.substring(i, i + 3);
                        if (aux3.equalsIgnoreCase("las")) {//Si esa palabra es alguna de las que no se pone no se hace nada.

                        } else {
                            acronimo += str.charAt(i);
                        }

                        ultima = true;
                    } catch (Exception e) {

                    }

                }

                if (!ultima) {//Si es la última palabra y tiene 2 letras.
                    try {
                        aux2 = str.substring(i, i + 2);
                        if (aux2.equalsIgnoreCase("la") || aux2.equalsIgnoreCase("de")) {//Si esa palabra es alguna de las que no se pone no se hace nada.

                        } else {
                            acronimo += str.charAt(i);
                        }

                        ultima = true;
                    } catch (Exception e) {
                    }

                }

                if (!ultima) {//Si es la última palabra y tiene 1 letras.
                    try {
                        aux1 = str.substring(i, i + 1);
                        if (aux1.equalsIgnoreCase("y") || aux1.equalsIgnoreCase("e")) {//Si esa palabra es alguna de las que no se pone no se hace nada.

                        } else {
                            acronimo += str.charAt(i);
                        }

                        ultima = true;
                    } catch (Exception e) {

                    }

                }

            }
        }
        System.out.println(acronimo.toUpperCase());
    }

    public static void main(String[] args) {

        EjerciciosNivel1 ejercicios = new EjerciciosNivel1();

        //ejercicios.acronimo("Tecnología ga la Inf y de las Comgg ye");
        
        System.out.println(ejercicios.anagrama("aeiou ouiie","aiouoiaeue"));
        

        //System.out.println(ejercicios.anagrama("eyopa", "pae oy"));
        
        //ejercicios.maximos(ejercicios.listaNumeros);
        

    }

}

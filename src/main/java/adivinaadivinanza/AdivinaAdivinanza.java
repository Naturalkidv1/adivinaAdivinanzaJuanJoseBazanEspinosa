package adivinaadivinanza;

import java.util.Random;
import java.util.Scanner;

/**
 * Por Juan José Bazán Espinosa
 */
public class AdivinaAdivinanza {

    private static int GeneraAleatorio(int numero1, int numero2) {

        Random numeroAleatorio = new Random();
        int numeroAleatorio1;

        numeroAleatorio1 = numeroAleatorio.nextInt(numero1 - numero2 + 1) + numero2;

        return numeroAleatorio1;
    }

    public static void main(String[] args) {

        Scanner entradaTeclado = new Scanner(System.in);

        int limite1;
        int limite2;
        int limiteMayor;
        int limiteMenor;
        int numeroMaquina;
        int respuestaHumano;
        int numVidas;

        System.out.println("\nBienvenido a AdivinaAdivinanzaTM \n"
                + "Digame que dos números quieres que sean los límites de nuestro juego.");

        System.out.println("Introduzuca el Número 1.");
        limite1 = entradaTeclado.nextInt();
        System.out.println("¡Bien hecho! Ahora introduzca el Número 2.");
        limite2 = entradaTeclado.nextInt();

        if (limite1 >= limite2) {
            limiteMayor = limite1;
            limiteMenor = limite2;

        } else {
            limiteMayor = limite2;
            limiteMenor = limite1;

        }

        System.out.println("Se generará un número aleatorio entre " + limiteMenor + " y " + limiteMayor);

        numeroMaquina = GeneraAleatorio(limiteMayor, limiteMenor);

        System.out.println("Que empiece el juego. ¿Con cuantas vidas quieres jugar?");

        numVidas = entradaTeclado.nextInt();

        for (int contadorRondas = numVidas; contadorRondas != 0; contadorRondas--) {

            System.out.println("\nTienes " + contadorRondas + " vida(s).\n");

            System.out.println("Ahora te toca adivinar el número generado.\n");
            respuestaHumano = entradaTeclado.nextInt();

            if (respuestaHumano == numeroMaquina) {

                System.out.println("Ganaste Humano, al menos esta vez.");
                break;
            } else if (respuestaHumano > numeroMaquina) {

                System.out.println("Error. Es menor.");
                numVidas--;

            } else if (respuestaHumano < numeroMaquina) {
                System.out.println("Error. Es mayor.");
                numVidas--;
                
            }
            
        }
            if (numVidas == 0) {
                System.out.println("\nHas perdido, montón de materia orgánica.\n");
            }

    }
}

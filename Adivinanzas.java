/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinanzas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author F541U
 */
public class Adivinanzas {

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public void iniciarJuego() {

        boolean adivinado = true;
        int numeroIntentos = 0;
        int contadorJug = 0;
        while (adivinado == true) {
            int puntuacion = 100;
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce tu nombre de usuario");
            String nombreUser = sc.nextLine();
            Jugador jugadorActual = new Jugador(nombreUser);

            System.out.println("Introduce numero inicial");
            int numeroInicial = sc.nextInt();
            System.out.println("Introduce el numero final");
            int numeroFinal = sc.nextInt();

            Random r = new Random();
            int numeroPensado = r.nextInt(numeroFinal - numeroInicial) + numeroInicial;
            boolean comprobacion = false;
            while (comprobacion == false) {
                System.out.println("Introduce el numero que tu crees que estoy pensando");
                int suposicion = sc.nextInt();

                if (suposicion == numeroPensado) {
                    comprobacion = true;
                    adivinado = true;

                    
                } else {
                    System.out.println("Error, numero incorrecto, prueba otra vez");
                    numeroIntentos++;
                    puntuacion = puntuacion - 10;
                }

            }
            jugadorActual.setPuntuacion(puntuacion);
            jugadores.add(jugadorActual);
            ordenaCuadroDeHonor();
            for (int i = 0; i < jugadores.size(); i++) {
                        System.out.println(jugadores.get(i).getNombre() + "," + jugadores.get(i).getPuntuacion());
                    }
        }

    }

    private void ordenaCuadroDeHonor() {
        ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
        while (!jugadores.isEmpty()) {
            Jugador jugadorMaxPunt = jugadores.get(0);
            for (int contador = 1; contador < jugadores.size(); contador++) {
                if (jugadores.get(contador).getPuntuacion() > jugadorMaxPunt.getPuntuacion()) {
                    jugadorMaxPunt = jugadores.get(contador);

                }
            }
            jugadoresOrdenados.add(jugadorMaxPunt);
            jugadores.remove(jugadorMaxPunt);

        }
        jugadores = jugadoresOrdenados;
    }
    
}

package com.tictctoe;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner lector = new Scanner(System.in);
        boolean jugarDeNuevo;
        
        do {
            String [] tablero = {"_","_","_","_","_","_","_","_","_"};
            int tirada = 0;
            boolean alguienGano = false;
        
            do {    
                showTablero(tablero);
                String ficha = tirada%2==0? "X":"O";
                juegaPlayer(ficha, tablero, lector);
    
                alguienGano = evaluateWin(tablero);
                if (alguienGano) {
                    showTablero(tablero);
                    System.out.println("Has ganado, player " + ficha + " felicidades!!!");
                    break;
                }
                
                tirada++;
            } while(tirada < 9 && !alguienGano);
            
            if (!alguienGano) {
                showTablero(tablero);
                System.out.println("Empate! No hay más movimientos posibles.");
            }
            
            System.out.println("¿Quieres jugar de nuevo? (s/n)");
            String respuesta = lector.next().toLowerCase();
            jugarDeNuevo = respuesta.equals("s");
            
        } while(jugarDeNuevo);
        
        System.out.println("Gracias por jugar! Hasta la próxima.");
        lector.close();
    }

    static void showTablero(String [] tablero) {
        System.out.println(tablero[0] + " | "+ tablero[1]+" | " + tablero[2]);
        System.out.println(tablero[3] + " | "+ tablero[4]+" | " + tablero[5]);
        System.out.println(tablero[6] + " | "+ tablero[7]+" | " + tablero[8]);
    }

    static void juegaPlayer(String ficha, String[] tablero, Scanner lector) {
        int posicion;
        
        do {
            System.out.println("¿Cuál será tu movimiento, jugador " + ficha + "?");
            while (!lector.hasNextInt()) {
                System.out.println("Entrada no válida. Ingresa un número entre 0 y 8.");
                lector.next();
            }
            posicion = lector.nextInt();
            
            if (posicion < 0 || posicion > 8) {
                System.out.println("Posición inválida. Ingresa un número entre 0 y 8.");
            } else if (!tablero[posicion].equals("_")) {
                System.out.println("Casilla ocupada. Elige otra posición.");
            } else {
                break;
            }
        } while (true);
        
        tablero[posicion] = ficha;
    }

    static boolean evaluateWin(String tablero[]) {
        return (tablero[0].equals(tablero[1]) && tablero[0].equals(tablero[2]) && !tablero[0].equals("_")) ||
               (tablero[3].equals(tablero[4]) && tablero[3].equals(tablero[5]) && !tablero[3].equals("_")) ||
               (tablero[6].equals(tablero[7]) && tablero[6].equals(tablero[8]) && !tablero[6].equals("_")) ||
               (tablero[0].equals(tablero[3]) && tablero[0].equals(tablero[6]) && !tablero[0].equals("_")) ||
               (tablero[1].equals(tablero[4]) && tablero[1].equals(tablero[7]) && !tablero[1].equals("_")) ||
               (tablero[2].equals(tablero[5]) && tablero[2].equals(tablero[8]) && !tablero[2].equals("_")) ||
               (tablero[0].equals(tablero[4]) && tablero[0].equals(tablero[8]) && !tablero[0].equals("_")) ||
               (tablero[2].equals(tablero[4]) && tablero[2].equals(tablero[6]) && !tablero[2].equals("_"));
    }
}


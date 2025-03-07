package com.tictctoe;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String [] tablero = {"_","_","_","_","_","_","_","_","_","_"};
        int tirada = 0;
    do {    
        showTablero(tablero);
        String ficha = tirada%2==0? "X":"O";
        juegaPlayer("X", tablero);
        tirada++;
       } while(true);     
    
    }

    static void showTablero(String [] tablero) {
    System.out.println(tablero[0] + " | "+ tablero[1]+" | " + tablero[2]);
    System.out.println(tablero[3] + " | "+ tablero[4]+" | " + tablero[5]);
    System.out.println(tablero[6] + " | "+ tablero[7]+" | " + tablero[8]);
   }

    static void juegaPlayer(String ficha, String[] tablero) {
    Scanner lector = new Scanner(System.in);
    System.out.println("¿Cual sera tu movimiento, jugador " + ficha+"?") ;
    int posicion = lector.nextInt();

    tablero[posicion] = ficha;
   }

  


}


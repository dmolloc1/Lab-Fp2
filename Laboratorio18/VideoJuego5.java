import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    //static ArrayList <Ejercito> reino1, reino2;
    static Ejercito ejercito_1 = new Ejercito("Ejercito_1");
    static Ejercito ejercito_2 = new Ejercito("Ejercito_2");
    static Scanner sc = new  Scanner(System.in);
    static final String turqueza = "\u001B[30m";
    static final String amarillo = "\u001B[31m";
    public static void main(String[] args) {
        String nR1, nR2;
        boolean continuar = true;
        while(continuar){
            Mapa map = new Mapa("Ejercito");
            ejercito_1.ingresarDatosAleatorio(turqueza);
            map.rellenar(ejercito_1);
            System.out.printf("*** Datos del ejercio %s ***", ejercito_1.getNombre());
            ejercito_1.datosEjercito();
            ejercito_2.ingresarDatosAleatorio(amarillo);
            map.rellenar(ejercito_2);
            System.out.printf("\nDatos del ejercio %s", ejercito_2.getNombre());
            ejercito_2.datosEjercito();
            map.mostrarE();
            System.out.println("\n*** En batalla ***");
            System.out.println("\nNOTA: Se decidira aleatoriamente quien ganara de acuerdo a la suma total de nivel de vida del ejercito\n");
            ganador(ejercito_1, ejercito_2);
            System.out.println("Iniciar una nueva partida (y/n) :");
            continuar = sc.next().charAt(0) == 'y';
        }
    }
    public static void ganador(Ejercito my, Ejercito enemigo){
        boolean gano = definirGanador(my.totalNivelVida(), enemigo.totalNivelVida());
        if(gano) System.out.println("--------- GANO EL EJERCITO 1 --------");
        else  System.out.println("--------- GANO EL EJERCITO 2 --------");

    }
    public static boolean definirGanador(int vida1 , int vida2){
    	double prob1 = (vida1 * 100.0) / (vida1 + vida2);
        double prob2 = (vida2 * 100.0) / (vida1 + vida2);

        System.out.println("Probabilidad de vencer para el primero 1: " + prob1 + "%");
        System.out.println("Probabilidad de vencer para el segundo 2: " + prob2 + "%");
	    Random ran = new Random();
        double randomValue = ran.nextDouble() * 100 + 1 ;
        System.out.printf("\nEl número  es %.2f", randomValue);
        if (randomValue <= prob1) {
            System.out.printf("\nEl primero  gana porque es mayor o igual a %.2f\n", randomValue);
            return true;
        } else {
            System.out.printf("\nEl segundo  gana porque es menor a %.2f\n", randomValue);
            return false;
        }
        
    }
    public static boolean compareString(String word1, String word2){
    		word1 = word1.toUpperCase();
    		word2 = word2.toUpperCase();
    		if (word1.compareTo(word2) <= 0) return false;
    		return true;
    }
}


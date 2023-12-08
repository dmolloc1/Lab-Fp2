import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    static ArrayList <Ejercito> reino1, reino2;
    //static Ejercito ejercito_1, ejercito_2 ;
    static Scanner sc = new  Scanner(System.in);
    static final String turqueza = "\u001B[30m";
    static final String amarillo = "\u001B[31m";
    public static void main(String[] args) {
        iterativeGameReino();
    }
    public static boolean batallaEjercitos(Ejercito ejercito_1, Ejercito ejercito_2){
            Mapa map = new Mapa("Ejercito");
            map.rellenar(ejercito_1);
            System.out.printf("*** Datos del ejercito 1 %s ***", ejercito_1.getReino());
            ejercito_1.datosEjercito();
            map.rellenar(ejercito_2);
            System.out.printf("\nDatos del ejercito 2 %s", ejercito_2.getReino());
            ejercito_2.datosEjercito();
            map.mostrarE();
            System.out.println("\n*** En batalla ***");
            return startGame(map, ejercito_1, ejercito_2);
    }
    public static void ganador(Ejercito my, Ejercito enemigo){
        boolean gano = definirGanador(my.totalNivelVida(), enemigo.totalNivelVida());
        if(gano) System.out.println("--------- GANO EL EJERCITO 1 --------");
        else  System.out.println("--------- GANO EL EJERCITO 2 --------");

    }
    public static  boolean startGame(Mapa map, Ejercito ejercito_1,Ejercito ejercito_2){ 
        boolean continuar = true;
        while (ejercito_1.size() > 0 && ejercito_2.size() > 0  && continuar){    
            System.out.println("\nTurno del primer jugador(celeste) ");
            map.jugar(1, ejercito_1, ejercito_2);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            if(ejercito_1.size() == 0 || ejercito_2.size() == 0){
                if(ejercito_1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_2 ~~~~~~~~~~~~~~~~~");
                    return false;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");
                    return true;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            map.jugar(2, ejercito_1, ejercito_2);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().equalsIgnoreCase("n");
        } 
        if(ejercito_2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");    
            return true;
        }
        return false;
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
    public static void iterativeGameReino(){
        String nR1, nR2;
        boolean continuar = true;
        while(continuar){
            Mapa map = new Mapa();
            int num1 = (int) (Math.random()*5) + 1;
            int num2 = (int) (Math.random()*5) + 1;
            while (num1 == num2){
                num2 = (int)Math.random()*5 + 1;
            }
            System.out.println(num1 + " " + num2 );
            reino1 = crearReino(num1, turqueza);
            nR1 = reino1.get(0).getReino();
            map.rellenar(reino1);
            
            reino2 = crearReino(num2, amarillo);
            nR2 = reino2.get(0).getReino();
            map.rellenar(reino2);
            map.mostrar();
            System.out.println("El tipo de terreno del mapa es " +map.getTerritorio() + "\nSe procedera a efectuar la bonificación");
            System.out.println("El reino 1 es :"+ reino1.get(0).getReino()+ "\nEl reino 2 es :" + reino2.get(0).getReino());
            map.bonificación(reino1);
            map.bonificación(reino2);
            map.mostrar();
            startGame(map, nR1, nR2);
            System.out.println("Iniciar una nueva partida (y/n) :");
            continuar = sc.next().charAt(0) == 'y';
        }
    } 
    public static void startGame(Mapa mapa, String nR1, String nR2){
        boolean continuar = true;
        while(continuar && reino1.size() > 0 && reino2.size() > 0){
            System.out.println("\nTurno del primer jugador(celeste) ");
            mapa.jugar(1, reino1, reino2);
            mapa.mostrar();
            System.out.println("Cantidad de ejercitos de " + nR1+" :" + reino1.size());
            System.out.println("Cantidad de ejercitos de " + nR2 + " :" + reino2.size());
            if(reino1.size() == 0 || reino2.size() == 0){
                if(reino1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO "+ nR2 + " ~~~~~~~~~~~~~~~~~");
                    break;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO "+ nR1+" ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            mapa.jugar(2, reino1, reino2);
            mapa.mostrar();
            System.out.println("Cantidad de ejercitos de " + nR1+" :" + reino1.size());
            System.out.println("Cantidad de ejercitos de " + nR2 + " :"+ reino2.size());
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().charAt(0) == 'n';
        } 
        if(reino2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO "+ nR1+" ~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    public static ArrayList <Ejercito> crearReino(int num, String color){
        ArrayList <Ejercito> reino = new ArrayList<>();
        int armyLength = (int)(Math.random() * Ejercito.MAX_SIZE + 1);
	    
        for (int i = 0; i < armyLength; i++) {
           	Ejercito nuevo = new Ejercito("Ejercito_"+ num + "X"+ (i + 1), num, color);
            nuevo.ingresarDatosAleatorio(color);
            reino.add(nuevo);
	    }
	    return reino;
    }
} 

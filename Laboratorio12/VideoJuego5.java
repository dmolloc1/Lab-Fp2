
import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    static  ArrayList <Soldado> ejercito_1, ejercito_2;
    static Scanner sc = new  Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal(){
    	System.out.println("--------------- MENU PRINCIPAL -----------\n1. Juego rápido\n2. Juego personalizado\n3.Salir");
        System.out.print("Escoge una opción(1, 2 o 3): ");
        int respond = sc.nextInt();
        switch(respond){
            case 1:
            //  startGam|e();
              juegoRapido();
                  menuPrincipal();
            case 2:
        //        juegoPersonalizado();
           //     menuPrincipal();
            case 3:
                  break;
        }
    }
    public static void juegoRapido(){
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
        boolean continuar = true;
        while(continuar){
            Soldado[][]tablero = new Soldado[10][10];
            ejercito_1 = datosEjercito(1, turqueza, tablero);
            System.out.println("................................................................");
	        ejercito_2 = datosEjercito(2, amarillo, tablero);
            System.out.println("\n          ~~~TABLERO~~~");
            mostrarTablero(tablero);
            startGame(ejercito_1,  ejercito_2, tablero); 
            System.out.print("Escoja una opción\n1.Empezar otra ronda nueva\n2. volver al menu principal: ");
            continuar = sc.nextInt() == 1;
        }
        menuPrincipal();
    }
    public static void startGame(ArrayList <Soldado> ejercito_1, ArrayList <Soldado> ejercito_2, Soldado [][] tablero){ 
        boolean continuar = true;
        while (ejercito_1.size() > 0 && ejercito_2.size() > 0  && continuar){    
            System.out.println("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("Turno del primer jugador(celeste) "+ ejercito_1.size());
            jugar(tablero, 1);
            if(ejercito_1.size() == 0 || ejercito_2.size() == 0){
                if(ejercito_1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_2 ~~~~~~~~~~~~~~~~~");
                    break;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
		        }
	        }
            System.out.println("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            System.out.println("Turno del segundo jugador(amarillo) "+ ejercito_2.size());
            jugar(tablero, 2);
                
        } 
        if(ejercito_2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");    
        }
    }
    public static ArrayList <Soldado> creandoEjercito(String color, Soldado[][] tablero) {
	ArrayList <Soldado> listArmy = new ArrayList <Soldado>();
    	int filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * 10 + 1);
	for (int i = 0; i < armyLength; i++) {
            	Soldado nuevo = new Soldado(("Soldado_" + (i + 1)),(int)( Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0);
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
            	boolean posicionValida = false;
            	while (!posicionValida) {
        	       	filaR = (int) (Math.random() * 9);
               		columnaR = (int) (Math.random() * 9);
               		if (rellenarTablero(filaR, columnaR, nuevo, tablero)) {
                  		posicionValida = true;
                	}
            	}
            	nuevo.setFila(filaR + 1);
            	nuevo.setColumna(columnaR );
            	nuevo.setActitud("Neutro");
	    	nuevo.setVive(true); //Valores por defecto
            	nuevo.setColor(color);
            	listArmy.add(nuevo);
	}
	return listArmy;
    }

    public static boolean rellenarTablero(int fila, int columna, Soldado sol, Soldado[][] tablero) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }

    public static void mostrarTablero(Soldado[][] tablero){
    	System.out.println("* | A | B | C | D | E | F | G | H | I | J |\n"+
                           "-------------------------------------------");
        for(int i = 0; i < tablero.length; i++){
	    	String fila = "|";
	    	for(int j = 0; j < tablero[i].length; j++){
	            if(tablero[i][j] == null){ fila = fila +" - " + "|";
		    }else fila = fila + " " + tablero[i][j].getColor() + tablero[i][j].getNivelDeVida()  + "\u001B[0m |";				
	    	}
            	if(i == 9){
	    	    System.out.println((i + 1)  + fila);
            	}
            	else System.out.println((i + 1) +" " + fila);
        }
    }

    public static int totalNivelVida(ArrayList <Soldado> soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }

    public static int promedioNivelVida(ArrayList<Soldado> soldados){
        return totalNivelVida(soldados)/ soldados.size();
    }

    public static void mostrarNivelVida(ArrayList<Soldado> soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }

    public static void ordenarPorNivelBurbuja(ArrayList<Soldado> soldados){
        for(int i = 1; i< soldados.size(); i++){
            for(int j = 0; j < soldados.size() - i; j++){
                if(soldados.get(j).getNivelDeVida() > soldados.get(j + 1).getNivelDeVida()){
                    intercambiar(soldados, j , j + 1);
                }
            }
        }
    }

    public static void ordenarPorNivelSelección(ArrayList <Soldado> soldados){
        for(int i = 0; i < soldados.size() - 1; i++){
            int min = i;
            for(int j = i + 1; j < soldados.size(); j++){
                if(soldados.get(min).getNivelDeVida() >  soldados.get(j).getNivelDeVida()){
                    min = j;
                }
            }
            intercambiar(soldados, min, i);
        }
    }

    public static void intercambiar(ArrayList <Soldado> lista, int i, int j){
        Soldado vControl = lista.get(i);
        lista.set(i,lista.get(j));
        lista.set(j, vControl);
    }

    public static void mostrarSoldados(ArrayList <Soldado> soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }

    public static ArrayList<Soldado> datosEjercito(int n, String color, Soldado [][] tablero){
	ArrayList <Soldado> ejercito = creandoEjercito(color, tablero);
        int total = totalNivelVida(ejercito);
        System.out.printf("\nEl total de nivel de vida del ejercito %d es : %d", n, total);
        System.out.printf("\nEl promedio de nivel de vida del ejercito %d es : %d", n, promedioNivelVida(ejercito));
        System.out.printf("\n~~~ Soldados del ejercito %d ~~~\n", n);
        mostrarSoldados(ejercito);
        if(n == 1){
		ordenarPorNivelBurbuja(ejercito);//Ordenando el ejercito con el método Burbuja
        	System.out.println("\n       ~MÉTODO BURBUJA~");
	}
	else{ ordenarPorNivelSelección(ejercito);//Ordenando el ejercito con el método de Selección;
	       	System.out.println("\n       ~MÉTODO DE SELECCIÓN~");
        }
        mostrarSoldados(ejercito);
        System.out.printf("\nEl soldado con mayor nivel de vida del ejercito %d es: ", n );
        System.out.println("\n"+ ejercito.get(ejercito.size() - 1).mostrar());
        return ejercito;
    }

    public static boolean moverSoldado(Soldado [][] tablero, int fila, int columna, String comando, int ejercito){	
	Soldado sold = tablero[fila][columna];
        switch (comando) {
            case "A":
                fila = fila - 1;
                if(fila < 0){return true;}
                break;
            case "B":
                fila = fila + 1;
                if(fila > 9){return true;}
                break;
            case "I":
                columna =  columna - 1;
                if(columna  < 0){return true;}
                break;
            case "D":
                columna = columna + 1;
                if(columna > 9){return true;}
                break;
            case "DII":
                fila = fila + 1;
                columna =  columna - 1;
                if(fila > 9 || columna < 0){return true;}
		break;
            case "DDI":
                fila = fila + 1;
                columna =  columna + 1;
                if(fila > 9 || columna > 9){return true;}
                break;
            case "DIS":
                fila = fila - 1;
                columna =  columna - 1;
                if(fila < 0 || columna < 0){return true;}
                break;
            case "DDS":
                fila = fila - 1;
                columna =  columna + 1;
                if(fila < 0 || columna > 9){return true;}
                break;
        }
        System.out.println(fila+ " "+ columna);
        cambiarPosición(tablero, sold, fila , columna, ejercito);
        return false;
    }
    public static void cambiarPosición(Soldado [][] tablero, Soldado sold, int fila, int columna, int ejercito){
        Soldado enemigo = tablero[fila][columna];
        if (enemigo == null) {
            tablero[fila][columna] = sold;
            sold.avanzar(fila, columna);
        }
        else{
            boolean gano = definirGanador(sold.getNivelDeVida(), enemigo.getNivelDeVida());
            sold.atacar(gano);
            enemigo.serAtacado(gano);
            if(gano){
                tablero[fila][columna] = sold;
                sold.avanzar(fila, columna);
            }
            if(!enemigo.getVive()){
                if(ejercito == 1){
                    ejercito_2.remove(enemigo);
                }
                else{ejercito_1.remove(enemigo);}
            }
        }
        if(ejercito == 1){
            if(!sold.getVive()){
                ejercito_1.remove(sold);
            }    
        }else{
            if(!sold.getVive()){
                ejercito_2.remove(sold);
            }    
        }
    }

    public static void jugar(Soldado[][] tablero, int ejercito){
        Scanner sc = new Scanner(System.in);
        System.out.print("Posición del soldado a mover:" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        while(tablero[fila][columna] == null){
            System.out.print("Posición invalida");
            System.out.print("Posición del soldado a mover:" + "\nFila: ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna: ");
	    columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        }
	boolean posValida = true;
        while (posValida){
        	System.out.print("\nDirección (I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ ):");
	     	String dir = sc.next();
	     	posValida = moverSoldado(tablero, fila, columna, dir, ejercito);
        }
        tablero[fila][columna]= null;
        mostrarTablero(tablero);
    }
    public static boolean definirGanador(int vida1 , int vida2){
    	double prob1 = (vida1 * 100.0) / (vida1 + vida2);
        double prob2 = (vida2 * 100.0) / (vida1 + vida2);

        System.out.println("Probabilidad de vencer para Soldado 1: " + prob1 + "%");
        System.out.println("Probabilidad de vencer para Soldado 2: " + prob2 + "%");
	    
        double randomValue = Math.random() * (vida1 + vida2) + 1 ;
        System.out.printf("\nEl número aleatorio es %.2f", randomValue);
        if (randomValue <= prob1) {
            System.out.printf("\nSoldado  gana porque es mayor o igual a %.2f\n", randomValue);
            return true;
        } else {
            System.out.printf("\nSoldado enemigo gana porque es menor a %.2f\n", randomValue);
            return false;
        }
    }
}


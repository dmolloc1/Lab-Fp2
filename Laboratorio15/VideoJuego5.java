import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    static ArrayList <Ejercito> inglaterra, francia;
    //static  ArrayList <Soldado> ejercito_1, ejercito_2;
    static Scanner sc = new  Scanner(System.in);
    public static void main(String[] args) {
        Ejercito[][] tablero =  new Ejercito[10][10];
        inglaterra = crearReino("I", "\u001B[30m" , tablero);
        francia = crearReino("F", "\\u001B[31m" , tablero);
        mostrarTableroEje(tablero);
        boolean continuar = true;
        while(continuar && inglaterra.size() > 0 && francia.size() > 0){
            System.out.println("\nTurno del primer jugador(celeste) ")
            jugarE(tablero, 1);
            System.out.println("Cantidad de ejercitos del Inglaterra: " + inglaterra.size());
            System.out.println("Cantidad de ejercitos del Francia: " + francia.size());
            if(inglaterra.size() == 0 || francia.size() == 0){
                if(inglaterra.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO FRANCIA ~~~~~~~~~~~~~~~~~");
                    break;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL INGLATERRA ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            jugarE(tablero, 2);
            System.out.println("Cantidad de ejercitos del Inglaterra: " + inglaterra.size());
            System.out.println("Cantidad de ejercitos del Francia: " + francia.size());
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().charAt(0) == 'n';
        } 
        if(francia.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO INGLATERRA ~~~~~~~~~~~~~~~~~~~~~~~~");    
        }
    }
    public static ArrayList <Ejercito> crearReino(String num, String color, Ejercito [][] tablero){
        ArrayList <Ejercito> reino = new ArrayList<>();
    	int filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * Ejercito.MAX_SIZE + 1);
	    for (int i = 0; i < armyLength; i++) {
            	Ejercito nuevo = new Ejercito("Ejercito_"+ num + "X"+ (i + 1));
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
            	boolean posicionValida = false;
            	while (!posicionValida) {
        	       	filaR = (int) (Math.random() * 9);
               		columnaR = (int) (Math.random() * 9);
               		
                    if (rellenarTableroEje(filaR, columnaR, nuevo, tablero)) {
                  		posicionValida = true;
                	}
            	}
            	nuevo.setFila(filaR + 1);
            	nuevo.setColumna(columnaR );
            	nuevo.setColor(color);
            	reino.add(nuevo);
	    }
	    return reino;
    }
/*    public static void menuPrincipal(){
    	System.out.println("--------------- MENU PRINCIPAL -----------\n1. Juego rápido\n2. Juego personalizado\n3. Salir");
        System.out.print("Escoge una opción(1, 2 o 3): ");
        int respond = sc.nextInt();
        switch(respond){
            case 1:
                juegoRapido();
            case 2:
                juegoPersonalizado();
            case 3:
                System.out.println("Saliendo del juego");
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
            startGame(ejercito_1,  ejercito_2, tablero); 
            System.out.print("Escoja una opción\n1.Empezar otra ronda nueva\n2. volver al menu principal: ");
            continuar = sc.nextInt() == 1;
        }
        menuPrincipal();
    }
    public static void juegoPersonalizado(){
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
        Soldado[][]tablero = new Soldado[10][10];
        ejercito_1 = datosEjercito(1, turqueza, tablero);
        System.out.println("................................................................");
	ejercito_2 = datosEjercito(2, amarillo, tablero);
        System.out.println("\n          ~~~TABLERO~~~");
        mostrarTablero(tablero);
        int comando = 0;
        do{
            System.out.println("Elija que ejercito manipular(1 o 2):");
            int num = sc.nextInt();
            System.out.println(" 1) Crear Soldado\n 2) Eliminar Soldado\n 3) Clonar Soldado\n 4) Modificar Soldado\n 5) Comparar Soldados" +
               "\n 6) Intercambiar Soldados\n 7) Ver soldado\n 8) Ver ejército\n 9) Sumar niveles\n10) Jugar\n11) Volver");
            System.out.print("Ingrese su opción: ");
            comando = sc.nextInt();
            int fila = 0, columna = 0;
            if (comando != 1 && comando < 7){
                System.out.print("Posición del soldado :" + "\nFila: ");
                fila = sc.nextInt() - 1;
                System.out.print("Columna: ");
                columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
            }
            switch(comando){
                case 1:
                    if(num == 1) ejercito_1.crearSoldado(tablero, turqueza);
                    else ejercito_2.crearSoldado(tablero, amarillo);  
                    break;
                case 2:
                    if(num == 1 && ejercito_1.size() - 1 != 0) ejercito_1.remove(tablero[fila][columna]);
                    if(num == 2 && ejercito_2.size() - 1 != 0) ejercito_2.remove(tablero[fila][columna]);
                    tablero[fila][columna] = null;
                    break;
                case 3:
                    if(num == 1 && Soldado.cantidad (ejercito_2) + 1 <= Soldado.MAX_SIZE) clonarSoldado(fila, columna, ejercito_1, tablero, turqueza);
                    if(num == 2 && Soldado.cantidad (ejercito_2) + 1 <= Soldado.MAX_SIZE) clonarSoldado(fila, columna, ejercito_2, tablero, amarillo);
                    break;
                case 4:
                    if(num == 1) ejercito_1.modificarSoldado(tablero[fila][columna]);
                    else ejercito_2.modificarSoldado(tablero[fila][columna]);
                    break;
                case 5:
                    compararSoldado(fila, columna, tablero);
                    break;
                case 6: 
                    if(num == 1) intercambiarSoldado(tablero[fila][columna], ejercito_1, ejercito_2, tablero, turqueza);
                    else intercambiarSoldado(tablero[fila][columna], ejercito_2, ejercito_1, tablero, amarillo);
                    break;
                case 7:
	            System.out.println("Nombre:");
	            String nom = sc.next();
                    if(num == 1 ) { insertionSortName(ejercito_1);
			            buscarPorNombre( ejercito_1, nom);
		    } else { insertionSortName(ejercito_2);
			    buscarPorNombre(ejercito_2, nom);
	            }
		    break;
                case 8:
                    System.out.println("Datos del ejercito " + num);
                    if(num == 1) mostrarSoldados(ejercito_1);
                    else mostrarSoldados(ejercito_2);
                    break;
                case 9: 
                    if(num == 1) sumarNiveles(ejercito_1);
                    else sumarNiveles(ejercito_2);
                    break;

                case 10:
                    startGame(ejercito_1, ejercito_2, tablero);
                    break;
            }
            mostrarTablero(tablero);
        }while(comando != 11);
        menuPrincipal();
    }

    public static void insertionSortName (ArrayList <Soldado> ejercito){
    	int j;
    	Soldado pivot;
    	for(int i = 0; i < Soldado.cantidad(ejercito); i++){
    		j = i - 1;
    		pivot = ejercito.get(i);
    		while(j >= 0 && compareString(ejercito.get(j).getNombre(), pivot.getNombre())){
			    ejercito.set((j + 1), ejercito.get(j));
			    j--;
      		}
      	    ejercito.set((j + 1), pivot);
	    }
    }
    private static boolean compareString(String word1, String word2){
    		word1 = word1.toUpperCase();
    		word2 = word2.toUpperCase();
    		if (word1.compareTo(word2) <= 0) return false;
    		return true;
    }
    
    public static void buscarPorNombre(ArrayList<Soldado> soldados, String nBuscado) {
        int izq = 0;
        int der = Soldado.cantidad(soldados) - 1;

        while (izq <= der) {
            int medio = izq + (der - izq) / 2;
            String nMedio = soldados.get(medio).getNombre().toUpperCase();
            int comparacion = nMedio.compareTo(nBuscado.toUpperCase());
            if (comparacion == 0) {
                System.out.println(soldados.get(medio).mostrar());
                break;
            }

            if (comparacion < 0) {
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }
        if(izq > der) System.out.println("Soldado no encontrado");
    }

    public static void sumarNiveles(ArrayList <Soldado> ejercito){
        Soldado total =  new Soldado("Neutro", true);
        for(int i = 0; i < Soldado.cantidad(ejercito); i += 2){
            if(!(Soldado.cantidad(ejercito) > i + 1)){
                total = total.sumar(ejercito.get(i));
                break;
            }
            total = total.sumar(ejercito.get(i)).sumar(ejercito.get(i + 1));
        }
        total.setNombre("Total de puntaje del ejercito:");
        System.out.println(total.mostrar());
    }
  */   
	
    public static void clonarSoldado(int filap , int columnap , ArrayList <Soldado> ejercito, Soldado[][] tablero, String color){
        Soldado sold = new Soldado("Reposo", true);
        sold.clonar(tablero[filap][columnap]);//Metodo del objeto soldado
        System.out.print("Nueva posición del soldado clonado :" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        rellenarTablero(fila, columna, sold, tablero);
        sold.setFila(fila);
        sold.setColumna(columna);
        sold.setColor(color);
        ejercito.add(sold);
    }
	
    

    public static void compararSoldado(int fila , int columna, Soldado [][] tablero){
        System.out.print("Posición del soldado a ser comparado :" + "\nFila: ");
        int filaC = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columnaC = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        Soldado soldado1 = tablero[fila][columna];
        Soldado soldado2 = tablero[filaC][columnaC];
        comparar("Nivel de Ataque", "" + soldado1.getNivelAtaque(), "" +soldado2.getNivelAtaque());
        comparar("Nivel de Defensa", "" +soldado1.getNivelDefensa(), "" + soldado2.getNivelDefensa());
        comparar("Vida Actual", "" + soldado1.getVidaActual(), "" +soldado2.getVidaActual());
        comparar("Vive", "" + soldado1.getVive(), "" + soldado2.getVive());
        
    }
    public static void comparar(String atributo, String a, String b){
        int comp = a.compareTo(b);    
        if(comp == 0  ){
            System.out.println(atributo + " es igual");
        }else if(comp > 0) System.out.println(atributo + " es menor"); 
        else System.out.println(atributo + "es mayor");
    }

    public static void intercambiarSoldado(Soldado soldado1, ArrayList <Soldado> original, ArrayList <Soldado> migrar, Soldado[][] tablero, String color){
        System.out.print("Posición del soldado a ser intercambiado :" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        Soldado soldado2 = tablero[fila][columna];
        soldado1.setColor(soldado2.getColor());
        soldado2.setColor(color);
        migrar.add(soldado1);
        original.remove(soldado1);
        original.add(soldado2);
        migrar.remove(soldado2);
    }

    public static void startGame(Ejercito ejercito_1,Ejercito ejercito_2, Soldado [][] tablero){ 

        mostrarTablero(tablero);
        boolean continuar = true;
        System.out.println("Cantidad total de soldados creados: " + Soldado.creados());
        while (ejercito_1.size() > 0 && ejercito_2.size() > 0  && continuar){    
            System.out.println("\nTurno del primer jugador(celeste) ");
            jugar(tablero, 1);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            if(ejercito_1.size() == 0 || ejercito_2.size() == 0){
                if(ejercito_1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_2 ~~~~~~~~~~~~~~~~~");
                    break;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            jugar(tablero, 2);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().charAt(0) == 'n';
        } 
        if(ejercito_2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");    
        }
    }

    public static Ejercito creandoEjercito(Ejercito ejercito, String color, Soldado[][] tablero) {
    	int filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * Soldado.MAX_SIZE + 1);
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
            	ejercito.add(nuevo);
	    }
	    return ejercito;
    }

    public static boolean rellenarTablero(int fila, int columna, Object sol, Object[][] tablero) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }
    public static boolean rellenarTableroEje(int fila, int columna, Ejercito eje, Ejercito[][] tablero) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public static void mostrarTableroEje(Ejercito[][] tablero){
    	System.out.println("* | A | B | C | D | E | F | G | H | I | J |\n"+
                           "-------------------------------------------");
        for(int i = 0; i < tablero.length; i++){
	    	String fila = "|";
	    	for(int j = 0; j < tablero[i].length; j++){
	            if(tablero[i][j] == null){ fila = fila +" - " + "|";
		    }else fila = fila + " " + tablero[i][j].getColor() + tablero[i][j].getReino().charAt(0)  + "\u001B[0m |";				
	    	}
            	if(i == 9){
	    	    System.out.println((i + 1)  + fila);
            	}
            	else System.out.println((i + 1) +" " + fila);
        }
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
    
    

    

    public static void mostrarNivelVida(ArrayList<Soldado> soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }

    

    

    public static void mostrarSoldados(ArrayList <Soldado> soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }

    public static void datosEjercito(Ejercito eje, Soldado [][] tablero){
        do{
            System.out.println("1. Total de vida del ejercito\n2. Promedio de vida\n3. Mostrar Soldados"+
        "\n4.Ordenamiento por Burbuja\n5. Ordenamiento por Selección\n6. Soldados con mayor nivel de vida\n7. Salir");
            int comando = sc.nextInt();
            switch(comando){
                case 1:
                    System.out.printf("\nEl total de nivel de vida del ejercito %d es : %d", eje.getNombre(),  eje.totalNivelVida());  
                    break;
                case 2:
                    System.out.printf("\nEl promedio de nivel de vida del ejercito %d es : %d", eje.getNombre(), eje.promedioNivelVida());
                    break;
                case 3:
                    System.out.printf("\n~~~ Soldados de %d ~~~\n", eje.getNombre());
                    System.out.println("\n" + eje.toString()); 
                    break;
                case 4:
                    eje.ordenarPorNivelBurbuja();//Ordenando el ejercito con el método Burbuja
        	        System.out.println("\n       ~MÉTODO BURBUJA~");
                    System.out.println(eje.toString()); 
                    break;
                case 5:
                    eje.ordenarPorNivelSelección();//Ordenando el ejercito con el método Burbuja
        	        System.out.println("\n       ~MÉTODO DE SELLECIÓN~");
                    System.out.println("\n" + eje.toString()); 
                    break;
                case 6:
                    System.out.println("\nEl soldado con mayor nivel de vida del ejercito es: " );
                    eje.ordenarPorNivelSelección();
                    System.out.println("\n"+ eje.getSoldado(eje.size() - 1).mostrar());
                    break;
            }
        }while(comando != 7);
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
	    Random ran = new Random();
        double randomValue = ran.nextDouble() * 100 + 1 ;
        System.out.printf("\nEl número aleatorio es %.2f", randomValue);
        if (randomValue <= prob1) {
            System.out.printf("\nSoldado  gana porque es mayor o igual a %.2f\n", randomValue);
            return true;
        } else {
            System.out.printf("\nSoldado enemigo gana porque es menor a %.2f\n", randomValue);
            return false;
        }
    }
//Metodos de ejercito
    public static boolean moverEjercito(Ejercito [][] tablero, int fila, int columna, String comando, int ejercito){	
	Ejercito eje = tablero[fila][columna];
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
        cambiarPosiciónE(tablero, eje , fila , columna, ejercito);
        return false;
    }
    public static void cambiarPosiciónE(Ejercito [][] tablero, Ejercito eje, int fila, int columna, int ejercito){
        Ejercito enemigo = tablero [fila][columna];
        if (enemigo == null) {
            tablero[fila][columna] = eje;
        }

        else{
            boolean gano = menuPrincipal(eje, enemigo);
            if(gano){
                tablero[fila][columna] = eje;
                eje.avanzar(fila, columna);
            }
            if(enemigo.size() == 0){
                if(ejercito == 1){
                    francia.remove(enemigo);
                }
                else{inglaterra.remove(enemigo);}
            }
        }
        if(ejercito == 1){
            if(eje.size() == 0){
                inglaterra.remove(eje);
            }    
        }else{
            if(eje.size() == 0){
                francia.remove(eje);
            }    
        }
    }

    public static void jugarE(Ejercito [][] tablero, int ejercito){
        System.out.print("Posición del ejercito a mover:" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        while(tablero[fila][columna] == null){
            System.out.print("Posición invalida");
            System.out.print("Posición del ejercito a mover:" + "\nFila: ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna: ");
	    columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        }
	    boolean posValida = true;
        while (posValida){
        	System.out.print("\nDirección (I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ ):");
	     	String dir = sc.next();
	     	posValida = moverEjercito(tablero, fila, columna, dir, ejercito);
        }
        tablero[fila][columna]= null;
        mostrarTableroEje(tablero);
    }
}


import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    static  ArrayList <Soldado> ejercito_1, ejercito_2;
    static Scanner sc = new  Scanner(System.in);
    public static void main(String[] args) {
        Ejercito[][] tablero =  new Ejercito[10][10];
        Reino inglaterra = crearReino("I", "\u001B[30m" , tablero);
        Reino francia = crearReino("F", "\\u001B[31m" , tablero);
        mostrarTableroEje(tablero);
        boolean continuar = true;
        while(continuar){
            jugarE(tablero, 1);
            mostrarTableroEje(tablero);
            jugarE(tablero, 2);
            mostrarTableroEje(tablero);
            System.out.println("Continuar y/n");
            continuar = sc.nextLine().charAt(0) == y;
        }
    }
    public static Reino crearReino(String num, String color, Ejercito [][] tablero){
        Reino reino = new Reino(num);
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
            	reino.reclutar(nuevo);
	    }
	    return reino;
    }
    public static void menuPrincipal(){
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
                    if(num == 1) crearSoldado(ejercito_1, tablero, turqueza);
                    else crearSoldado(ejercito_2, tablero, amarillo);  
                    break;
                case 2:
                    if(num == 1 && Soldado.cantidad(ejercito_1) - 1 != 0) ejercito_1.remove(tablero[fila][columna]);
                    if(num == 2 && Soldado.cantidad(ejercito_2) - 1 != 0) ejercito_2.remove(tablero[fila][columna]);
                    tablero[fila][columna] = null;
                    break;
                case 3:
                    if(num == 1 && Soldado.cantidad (ejercito_2) + 1 <= Soldado.MAX_SIZE) clonarSoldado(fila, columna, ejercito_1, tablero, turqueza);
                    if(num == 2 && Soldado.cantidad (ejercito_2) + 1 <= Soldado.MAX_SIZE) clonarSoldado(fila, columna, ejercito_2, tablero, amarillo);
                    break;
                case 4:
                    modificarSoldado(tablero[fila][columna]);
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
     public static void crearSoldado(ArrayList <Soldado> ejercito, Soldado [][] tablero, String color){
        if(Soldado.cantidad(ejercito) + 1 <= Soldado.MAX_SIZE){
            Soldado nuevo = new Soldado("Neutro", true);
            System.out.print("Nombre del Soldado:");
            nuevo.setNombre(sc.next());
            System.out.print("\nNivel de vida (1 - 5):");
            nuevo.setNivelDeVida(sc.nextInt());
            System.out.print("\nNivel de ataque(1 - 5):");
            nuevo.setNivelAtaque(sc.nextInt());
            System.out.print("\nNivel de defensa(1 - 5):");
            nuevo.setNivelDefensa(sc.nextInt());
            System.out.print("\nFila");
            int fila = sc.nextInt() - 1;
            System.out.print("\nColumna:");
            int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
            rellenarTablero(fila, columna, nuevo, tablero);
            nuevo.setFila(fila);
            nuevo.setColumna(columna);
            nuevo.setColor(color);
            ejercito.add(nuevo);        
        }
    }
	
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
	
    public static void modificarSoldado(Soldado soldado){
        int opcion;
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Modificar nivel de ataque");
            System.out.println("2. Modificar nivel de defensa");
            System.out.println("3. Modificar vida actual");
            System.out.println("4. Mostrar información del soldado");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nuevo nivel de ataque: ");
                    int nuevoAtaque = sc.nextInt();
                    soldado.setNivelAtaque(nuevoAtaque);
                    break;
                case 2:
                    System.out.print("Ingrese nuevo nivel de defensa: ");
                    int nuevaDefensa = sc.nextInt();
                    soldado.setNivelDefensa(nuevaDefensa);
                    break;
                case 3:
                    System.out.print("Ingrese nueva vida actual: ");
                    int nuevaVida = sc.nextInt();
                    soldado.setVidaActual(nuevaVida);
                    break;
                case 4:
                    System.out.println(soldado.mostrar());
		    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 5);
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

    public static void startGame(ArrayList <Soldado> ejercito_1, ArrayList <Soldado> ejercito_2, Soldado [][] tablero){ 
        mostrarTablero(tablero);
        boolean continuar = true;
        System.out.println("Cantidad total de soldados creados: " + Soldado.creados());
        while (Soldado.cantidad(ejercito_1) > 0 && Soldado.cantidad(ejercito_2) > 0  && continuar){    
            System.out.print("Desea salir (y/n): ");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del primer jugador(celeste) ");
            jugar(tablero, 1);
            System.out.println("Cantidad de soldados del Ejercito 1: " + Soldado.cantidad(ejercito_1));
            System.out.println("Cantidad de soldados del Ejercito 2: " + Soldado.cantidad(ejercito_2));
            if(Soldado.cantidad(ejercito_1) == 0 || Soldado.cantidad(ejercito_2) == 0){
                if(Soldado.cantidad(ejercito_1) == 0){
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
            System.out.println("Cantidad de soldados del Ejercito 1: " + Soldado.cantidad(ejercito_1));
            System.out.println("Cantidad de soldados del Ejercito 2: " + Soldado.cantidad(ejercito_2));
                
        } 
        if(Soldado.cantidad(ejercito_2) == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");    
        }
    }
    public static ArrayList <Soldado> creandoEjercito(String color, Soldado[][] tablero) {
	ArrayList <Soldado> listArmy = new ArrayList <Soldado>();
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
		    }else fila = fila + " " + tablero[i][j].getColor() + tablero[i][j].getReino().getNombre()  + "\u001B[0m |";				
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
    
    public static int totalNivelVida(ArrayList <Soldado> soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }

    public static int promedioNivelVida(ArrayList<Soldado> soldados){
        return totalNivelVida(soldados)/ Soldado.cantidad(soldados);
    }

    public static void mostrarNivelVida(ArrayList<Soldado> soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }

    public static void ordenarPorNivelBurbuja(ArrayList<Soldado> soldados){
        for(int i = 1; i< Soldado.cantidad(soldados); i++){
            for(int j = 0; j < Soldado.cantidad(soldados) - i; j++){
                if(soldados.get(j).getNivelDeVida() > soldados.get(j + 1).getNivelDeVida()){
                    intercambiar(soldados, j , j + 1);
                }
            }
        }
    }

    public static void ordenarPorNivelSelección(ArrayList <Soldado> soldados){
        for(int i = 0; i < Soldado.cantidad(soldados) - 1; i++){
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
    public static boolean moverEjercito(Ejercito [][] tablero, int fila, int columna, String comando, int ejercito){	
	Ejercito sold = tablero[fila][columna];
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
        cambiarPosiciónE(tablero, sold, fila , columna, ejercito);
        return false;
    }
    public static void cambiarPosiciónE(Ejercito [][] tablero, Ejercito sold, int fila, int columna, int ejercito){
        Ejercito enemigo = tablero[fila][columna];
        if (enemigo == null) {
            tablero[fila][columna] = sold;
        }
        else{ menuPrincipal();
        }
    }

    public static void jugarE(Ejercito [][] tablero, int ejercito){
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
	     	posValida = moverEjercito(tablero, fila, columna, dir, ejercito);
        }
        tablero[fila][columna]= null;
        mostrarTableroEje(tablero);
    }
}


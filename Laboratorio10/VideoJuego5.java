
import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    public static void main(String[] args) {
    	Scanner sc = new  Scanner(System.in);
        List <Soldado> ejercito1, ejercito2;
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
	    boolean continuar = true;
	    while(continuar){
            Soldado[][]tablero = new Soldado[10][10];
	        ArrayList <Soldado> ejercito_1 = datosEjercito(1, turqueza, tablero);
            System.out.println("................................................................");
		    ArrayList <Soldado> ejercito_2 = datosEjercito(2, amarillo, tablero);
            System.out.println("\n          ~~~TABLERO~~~");
            mostrarTablero(tablero);
	//Se decide el ejercito ganador 
            jugar(tablero);
            System.out.print("Desea continuar otra ronda (y/n): ");
            continuar = (sc.next().equals("y"));
           
        }
    }


    public static ArrayList <Soldado> creandoEjercito(String color, Soldado[][] tablero) {
        ArrayList <Soldado> listArmy = new ArrayList <Soldado>();
    	int filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * 10 + 1);
	    for (int i = 0; i < armyLength; i++) {
            Soldado nuevo = new Soldado(("Soldado_" + (i + 1)),(int)( Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0);//Valores de combate
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
            nuevo.setValorTablero(color,""+ nuevo.getNivelDeVida());
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
    	for(int i = 0; i < tablero.length; i++){
	    	String fila = "|";
	    	for(int j = 0; j < tablero[i].length; j++){
	            if(tablero[i][j] == null){
					fila = fila +" - " + "|"; 
				}else{
					fila = fila + " " + tablero[i][j].getValorTablero() + " |";
				}
	    	}
	    	System.out.println(fila);
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
    public static void ejercitoGanador(int p1, int p2){
    //Gana el ejercito con mayor puntaje acumulado
        if(p1 > p2){
            System.out.println("GANO EL EJERCITO 1");
        }else{
            if(p1 == p2){
                System.out.println("EMPATE");
            }
            else{System.out.println("GANO EL EJERCITO 2");
            }
        }
    }
   /* public static void moverSoldado(Soldado [][] tablero, String comando){	
	    
        switch (comando) {
            case "N":
                sold.avanzar();
                
                break;
            case "O":
                sold.retroceder();
                break;
            case "S":
                sold.retroceder();
                break;
            case "E":
                sold.avanzar();
                break;
            case "NO":
                sold.retroceder();
                break;
            case "SO":
                sold.retroceder();
                break;
            case "SE":
                sold.retroceder();
                break;
            case "NE":
                sold.retroceder();
                break;
        }
    }*/
    public static void cambiarPosición(Soldado [][] tablero, Soldado sold, int fila, int columna){
        Soldado enemigo = tablero[fila][columna]; 
        if (enemigo == null) {
            tablero[fila][columna] = sold;
            sold.avanzar(fila, columna);
        }
        else{
            sold.atacar(enemigo);
            if(enemigo.serAtacado(sold)){
                tablero[fila][columna] = sold;
                sold.avanzar(fila, columna);
            } 
            else tablero[fila][columna] = enemigo;
        }
    }

    public static void jugar(Soldado[][] tablero){
        Scanner sc = new Scanner(System.in);
        System.out.print("Posición del soldado a mover:" + "\nFila: ");
        int fila = sc.nextInt();
        System.out.print("\nColumna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
    }
}


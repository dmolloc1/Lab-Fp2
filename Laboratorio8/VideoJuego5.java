import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 {
    public static void main(String[] args) {
    	Scanner sc = new  Scanner(System.in);
        HashMap <String, Soldado> ejercito1, ejercito2;
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
	    boolean continuar = true;
        while(continuar){
            Soldado[][] tablero = new Soldado[10][10];
		    int total1 = datosEjercito(1, turqueza, tablero);
            System.out.println("................................................................");
		    int total2 = datosEjercito(2, amarillo, tablero);
            System.out.println("\n          ~~~TABLERO~~~");
            mostrarTablero(tablero);
	//Se decide el ejercito ganador 
            ejercitoGanador(total1, total2);
            System.out.print("Desea continuar otra ronda (y/n): ");
            continuar = (sc.next().equals("y"));
        }
    }


    public static HashMap <String, Soldado> creandoEjercito(String color, Soldado [][] tablero) {
        HashMap <String, Soldado> hashArmy = new  HashMap <String, Soldado>();
    	int nivelR = 0, filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * 10 + 1);
	    for (int i = 0; i < armyLength; i++) {
            Soldado nuevo = new Soldado();
            nuevo.setNombre("Soldado_" + (i + 1));
            nuevo.setNivelDeVida((int) (Math.random() * 5 + 1));
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
            nuevo.setColumna((char) (columnaR + 65));
            nuevo.setValorTablero(color,""+ nuevo.getNivelDeVida());
            hashArmy.put(nuevo.getNombre(), nuevo);
        }
    	return hashArmy;
    }

    public static boolean rellenarTablero(int fila, int columna, Soldado sol, Soldado[][] tablero) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }
    public static void mostrarTablero(Soldado [][] tablero){
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

    public static int totalNivelVida(Soldado [] soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }

    public static int promedioNivelVida(int total, int size){
        return total/ size;
    }

    public static void mostrarNivelVida(Soldado [] soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getNivelDeVida());
        }
    }

    public static Soldado [] ordenarPorNivelBurbuja( Soldado [] soldKey){
//Un hashMap no se puede ordenar debido a que no hay posiciones exactas por ello para ordenarlo lo que podemos hacer es usar el arreglo creado por sus objetos para ir comparando y ordenando
        for(int i = 1; i< soldKey.length; i++){
            for(int j = 0; j < soldKey.length - i; j++){
                if(soldKey[j].getNivelDeVida() > soldKey[j + 1].getNivelDeVida()){
                    soldKey = intercambiar(soldKey, j , j + 1);
                }
            }
        }
        return soldKey;
    }

    public static Soldado [] ordenarPorNivelSelección( Soldado[] soldKey){
    //Para que esta lista ordenada se puedea utilizar debemos regresar el arreglo ordenado en lugar de imprimirlo directamente en el metodo
        for(int i = 0; i < soldKey.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < soldKey.length; j++){
                if(soldKey[min].getNivelDeVida() > soldKey[j].getNivelDeVida()){
                    min = j;
                }
            }
            soldKey = intercambiar(soldKey, min, i);
        }
        return soldKey;
    }

    public static Soldado [] intercambiar(Soldado [] soldKey, int i, int j){
        //Como ahora el arreglo no es estatico se debe actualizar el arreglo soldKey para tener el ordenamiento
        Soldado pivot = soldKey[i];
        soldKey[i] = soldKey[j];
        soldKey[j] = pivot;
        return soldKey;
    }

    public static void mostrarSoldados(Soldado[] soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }

    public static int datosEjercito(int n, String color, Soldado[][] tablero){
        HashMap <String, Soldado> ejercito = creandoEjercito(color, tablero);
        Soldado [] soldKey = (ejercito.values()).toArray(new Soldado [0]);
        int total = totalNivelVida(soldKey);
        System.out.printf("\nEl total de nivel de vida del ejercito %d es : %d", n, total);
        System.out.printf("\nEl promedio de nivel de vida del ejercito %d es : %d", n, promedioNivelVida(total, ejercito.size()));
        System.out.printf("\n~~~ Soldados del ejercito %d ~~~\n", n);
        mostrarSoldados(soldKey);
        if(n == 1){
        	soldKey = ordenarPorNivelBurbuja(soldKey);//Ordenando el ejercito con el método Burbuja
            System.out.println("\n       ~MÉTODO BURBUJA~");
	    }
    	else{ soldKey = ordenarPorNivelSelección(soldKey);//Ordenando el ejercito con el método de Selección;
	        System.out.println("\n       ~MÉTODO DE SELECCIÓN~");
        }
        mostrarSoldados(soldKey);
        System.out.printf("\nEl soldado con mayor nivel de vida del ejercito %d es: ", n );
        System.out.println("\n"+ ejercito.get("Soldado_"+ ejercito.size()).mostrar());
        return total;
    }
    public static void ejercitoGanador(int p1, int p2){
    //Gana el ejercito con mayor puntaje acumulado
        if(p1 > p2){
            System.out.println("\n\u001B[33m************* GANO EL EJERCITO 1 *****************\u001B[0m");
        }else{
            if(p1 == p2){
                System.out.println("\n\u001B[33m******************** EMPATE *******************\u001B[0m");
            }
            else{System.out.println("\n\u001B[33m****************** GANO EL EJERCITO 2 ***************\u001B[0m");
            }
        }
    }
}


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
         //   ejercitoGanador(total1, total2);
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
/*
    public static void ordenarPorNivelBurbuja(HashMap <String, Soldado> soldados){
        for(int i = 1; i< soldados.size(); i++){
            for(int j = 0; j < soldados.size() - i; j++){
                if(soldados.get(j).getNivelDeVida() > soldados.get(j + 1).getNivelDeVida()){
                    intercambiar(soldados, j , j + 1);
                }
            }
        }
    }

    public static void ordenarPorNivelSelección(HashMap <String, Soldado> soldados){
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

    public static void intercambiar(HashMap <String, Soldado> lista, int i, int j){
        Soldado vControl = lista.get(i);
        lista.set(i,lista.get(j));
        lista.set(j, vControl);
    }*/

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
        if(n == 4){
	    //	ordenarPorNivelBurbuja(ejercito);//Ordenando el ejercito con el método Burbuja
            System.out.println("\n       ~MÉTODO BURBUJA~");
	    }
    //	else{ ordenarPorNivelSelección(ejercito);//Ordenando el ejercito con el método de Selección;
	        System.out.println("\n       ~MÉTODO DE SELECCIÓN~");
      //  }
        mostrarSoldados(soldKey);
        System.out.printf("\nEl soldado con mayor nivel de vida del ejercito %d es: ", n );
        System.out.println("\n"+ ejercito.get("Soldado_"+ ejercito.size()).mostrar());
        return total;
    }/*
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
    }*/
}


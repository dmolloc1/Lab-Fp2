import java.util.*;

public class VideoJuego2 {
    static Soldado[][] tablero = new Soldado[10][10];

    public static void main(String[] args) {
    	Soldado[] ejercito =  creandoEjercito();
	System.out.println("		~TABLERO~");
	mostrarTablero(tablero);
	mayorNivelVida(ejercito).mostrar();
	System.out.println("\nEl total de nivel de vida del ejercito es :" + totalNivelVida(ejercito));
	System.out.println("El promedio de nivel de vida del ejercito es :" + promedioNivelVida(ejercito));
	System.out.println("\n~~~ Nivel de vida de los soldados ~~~");
	mostrarNivelVida(ejercito);
	System.out.println("\n~~~ Soldados del ejercito ~~~");
	mostrarSoldados(ejercito);
    }

    public static Soldado[] creandoEjercito() {
        int aleatorio = (int) (Math.random() * 10 + 1);
        return ingresarDatos(aleatorio);
    }

    public static Soldado[] ingresarDatos(int num) {
	Soldado[] soldados = new Soldado[num];
	int nivelR = 0, filaR = 0, columnaR = 0;
	for (int i = 0; i < soldados.length; i++) {
            soldados[i] = new Soldado();
            soldados[i].setNombre("Soldado_" + (i + 1));
            nivelR = (int) (Math.random() * 5 + 1);
            soldados[i].setNivelDeVida(nivelR);
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
            boolean posicionValida = false;
            while (!posicionValida) {
                filaR = (int) (Math.random() * 9);
                columnaR = (int) (Math.random() * 9);
                if (rellenarTablero(filaR, columnaR, soldados[i])) {
                    posicionValida = true;
                }
            }
            soldados[i].setFila(filaR + 1);
            soldados[i].setColumna((char) (columnaR + 65));
        }
	return soldados;
    }

    public static boolean rellenarTablero(int fila, int columna, Soldado sol) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }

    public static void mostrarTablero(Soldado[][] ejercito){
    	for(int i = 0; i < ejercito.length; i++){
	    	String fila = "|";
	    	for(int j = 0; j < ejercito[i].length; j++){
	    		if(ejercito[i][j] == null){
					fila = fila +" - " + "|"; 
				}else{
					fila = fila + " S " + "|";
				}
	    	}
	    	System.out.println(fila);
		}
    }

    public static Soldado mayorNivelVida(Soldado[] soldados){
		Soldado soldMayor = soldados[0];

		for(int i = 1; i < soldados.length; i++){
			int min = soldados[i].getNivelDeVida();
			if(soldados[i].getNivelDeVida() > soldMayor.getNivelDeVida()){
				soldMayor = soldados[i];
			}
		}
		return soldMayor;
    }
    public static int totalNivelVida(Soldado[] soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }
    public static int promedioNivelVida(Soldado[] soldados){
    	return totalNivelVida(soldados)/ soldados.length;
    }
    public static void mostrarNivelVida(Soldado[] soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }
    public static void mostrarSoldados(Soldado[] soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }
}

import java.util.*;

public class VideoJuego2 {
    static Soldado[][] tablero = new Soldado[10][10];

    public static void main(String[] args) {
        creandoEjercito();
    }

    public static void creandoEjercito() {
        int aleatorio = (int) (Math.random() * 10 + 1);
        ingresarDatos(aleatorio);
    }

    public static void ingresarDatos(int num) {
        Soldado[] soldados = new Soldado[num];
	int nivelR = 0, filaR = 0, columnaR = 0;
	for (int i = 0; i < soldados.length; i++) {
            soldados[i] = new Soldado();
            soldados[i].setNombre("Soldado_" + (i + 1);
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
        for (Soldado n : soldados) {
            System.out.println(n.mostrar());
        }
    }

    public static boolean rellenarTablero(int fila, int columna, Soldado sol) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }
}

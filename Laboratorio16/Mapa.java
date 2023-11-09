import java.util.*;
public class Mapa{
    String tipo;
    Ejercito [][] mapa;
    
    public Mapa(){
        mapa = new Ejercito [10][10];
    }
    public boolean rellenarTableroEje(int fila, int columna, Ejercito eje) {
        if (mapa[fila][columna] == null) {
            mapa[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public static void mostrarTablero(){
        System.out.println("* | A | B | C | D | E | F | G | H | I | J |\n"+
                           "-------------------------------------------");
        for(int i = 0; i < tablero.length; i++){
                String fila = "|";
                for(int j = 0; j < tablero[i].length; j++){
                    if(tablero[i][j] == null){ fila = fila +" - " + "|";
                    }else fila = fila + " " + tablero[i][j].getColor() + "E"  + "\u001B[0m |";
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }
}

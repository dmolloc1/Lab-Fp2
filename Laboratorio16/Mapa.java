import java.util.*;
public class Mapa{
    String tipo;
    Ejercito [][] mapa;
    
    public Mapa(){
        mapa = new Ejercito [10][10];
    }
    public boolean posiciónValida(int fila, int columna, Ejercito eje) {
        if (this.mapa[fila][columna] == null) {
            this.mapa[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public void mostrarTablero(){
        System.out.println("* | A | B | C | D | E | F | G | H | I | J |\n"+
                           "-------------------------------------------");
        for(int i = 0; i < this.mapa.length; i++){
                String fila = "|";
                for(int j = 0; j <this.mapa[i].length; j++){
                    if(this.mapa[i][j] == null){ fila = fila +" - " + "|";
                    }else fila = fila + " " + this.mapa[i][j].getColor() + "E"  + "\u001B[0m |";
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }
    public void rellenarTablero(ArrayList <Ejercito> ejercito){
        int fila = 0, columna = 0;
        for(Ejercito e : ejercito){
            boolean posicionValida = false;
            while (!posicionValida) {
                fila = (int) (Math.random() * 9);
                columna = (int) (Math.random() * 9);
                posicionValida = this.posiciónValida(fila, columna, e);         
            }
            e.setFila(fila);
            e.setColumna(columna);
        }
    }
}

import java.util.*;
public class Mapa{
    String territorio;
    Ejercito [][] mapa;
    
    public Mapa(){
        mapa = new Ejercito [10][10];
        int n = (int)Math.random()* 5 + 1;
        this.setTerritorio(n);
    }
    lic void setTerritorio(int n){
        switch(n){
            case 1:
                this.territorio = "bosque";
                break;
            case 2:
                this.territorio = "campoAbierto";
                break;
            case 3:
                this.territorio = "montaña";
                break;
            case 4:
                this.territorio = "desierto";
                break;
            case 5:
                this.territorio = "playa";
                break;
        }
    }public void setTerritorio(int n){
        switch(n){
            case 1:
                this.territorio = "bosque";
                break;
            case 2:
                this.territorio = "campoAbierto";
                break;
            case 3:
                this.territorio = "montaña";
                break;
            case 4:
                this.territorio = "desierto";
                break;
            case 5:
                this.territorio = "playa";
                break;
        }
    }
    public void bonificación(Ejercito e){
   //     if(e.getReino){}

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
                    }else fila = fila + " " + this.mapa[i][j].getColor() + this.mapa[i][j].size() + " - " + this.mapa[i][j].totalNivelVida()  + "\u001B[0m |";
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
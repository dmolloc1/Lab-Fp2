import java.util.*;
public class Mapa{
    char bonificación;
    String territorio;
    Ejercito [][] mapa;
    
    public Mapa(){
        mapa = new Ejercito [10][10];
        int n = (int)Math.random()* 5 + 1;
        this.setTerritorio(n);
    }

    public void setTerritorio(int n){
        switch(n){
            case 1:
                this.bonificación = '1';
                this.territorio = "bosque";
                break;
            case 2:
                this.bonificación = '2';
                this.territorio = "campoAbierto";
                break;
            case 3:
                this.bonificación = '3';
                this.territorio = "montaña";
                break;
            case 4:
                this.bonificación = '4';
                this.territorio = "desierto";
                break;
            case 5:
                this.bonificación = '5';
                this.territorio = "playa";
                break;
        }
    }
    public void bonificación(ArrayList <Ejercito> reino){
        Ejercito e = reino.get(1);
        if(e.getBono().charAt(0) == this.bonificación){
            Ejercito.bono(reino);
        }
    }
    public boolean posiciónValida(int fila, int columna, Ejercito eje) {
        if (this.mapa[fila][columna] == null) {
            this.mapa[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public void mostrar(){
        System.out.println("* |   A   |   B   |   C   |   D   |   E   |   F   |   G   |   H   |   I   |   J   |\n"+
                           "-----------------------------------------------------------------------------------");
        for(int i = 0; i < this.mapa.length; i++){
                String fila = "|";
                for(int j = 0; j <this.mapa[i].length; j++){
                    if(this.mapa[i][j] == null){ fila = fila +"  ---  " + "|";
                    }else{
                        if(this.mapa[i][j].size() > 9){
                            fila += " " + this.mapa[i][j].getColor() + this.mapa[i][j].size() + "-";
                        }
                        else{fila += "  " + this.mapa[i][j].getColor() + this.mapa[i][j].size() + "-";}
                        
                        if(this.mapa[i][j].totalNivelVida() > 9 ){
                            fila += this.mapa[i][j].totalNivelVida()  + "\u001B[0m |";
                        }
                        else {
                            fila += " " + this.mapa[i][j].totalNivelVida()  + "\u001B[0m |";
                        }
                    }
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }
    public void rellenar(ArrayList <Ejercito> ejercito){
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

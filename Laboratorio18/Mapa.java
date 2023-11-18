import java.util.*;
public class Mapa{
    char bonificación;
    String territorio;
    Ejercito [][] mapa;
    Soldado [][] campo;
    public Mapa(){
        mapa = new Ejercito [10][10];
        int n = (int)Math.random()* 5 + 1;
        this.setTerritorio(n);
    }
    public Mapa(String a){
        campo = new Soldado [10][10];
    }
    public String getTerritorio(){
        return this.territorio;
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
    
    public boolean posiciónValida(int fila, int columna, Soldado sold) {
        if (this.campo[fila][columna] == null) {
            this.campo[fila][columna] = sold;
            return true;
        }
        return false;
    }
    
    public void rellenar(Ejercito ejercito){ //Metodo para rellenar pero de soldados
        int fila = 0, columna = 0;
        for(Soldado e : ejercito.getSoldados()){
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
    public void mostrarE(){
        System.out.println("* |   A   |   B   |   C   |   D   |   E   |   F   |   G   |   H   |   I   |   J   |\n"+
                           "-----------------------------------------------------------------------------------");
        for(int i = 0; i < this.campo.length; i++){
                String fila = "|";
                for(int j = 0; j <this.campo[i].length; j++){
                    if(this.campo[i][j] == null){ fila = fila +"  ---  " + "|";
                    }else{
                        fila += " " + this.campo[i][j].getColor() + this.campo[i][j].getNombre().charAt(0) + " - ";
                        fila += this.campo[i][j].getNivelDeVida()  + "\u001B[0m |";
                    }
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }    
}

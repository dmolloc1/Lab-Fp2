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
    public void bonificación(ArrayList <Ejercito> reino){
        Ejercito e = reino.get(0);
        for(int i = 0; i < e.getBono().length(); i++){
            if(e.getBono().charAt(i) == this.bonificación) {Ejercito.bono(reino);}
        }
        
    }
    public boolean posiciónValida(int fila, int columna, Ejercito eje) {
        if (this.mapa[fila][columna] == null) {
            this.mapa[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public boolean posiciónValida(int fila, int columna, Soldado sold) {
        if (this.campo[fila][columna] == null) {
            this.campo[fila][columna] = sold;
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
        for(int i = 0; i < this.mapa.length; i++){
                String fila = "|";
                for(int j = 0; j <this.mapa[i].length; j++){
                    if(this.mapa[i][j] == null){ fila = fila +"  ---  " + "|";
                    }else{
                        fila += " " + this.campo[i][j].getColor() + this.campo[i][j].getNombre().charAt(0) + "-";
                        if(this.campo[i][j].getNivelDeVida() > 9 ){
                            fila += this.campo[i][j].getNivelDeVida()  + "\u001B[0m |";
                        }
                        else {
                            fila += " " + this.campo[i][j].getNivelDeVida()  + "\u001B[0m |";
                        }
                    }
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }
   //Metodos para mover el tablero
    public void jugar(int ejercito, ArrayList <Ejercito> reino1, ArrayList <Ejercito> reino2){
       
	    Scanner sc = new Scanner (System.in);
        System.out.print("Posición del ejercito a mover:" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        while(this.mapa[fila][columna] == null){
            System.out.print("Posición invalida");
            System.out.print("Posición del ejercito a mover:" + "\nFila: ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna: ");
	        columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        }
	    boolean posValida = true;
        while (posValida){
        	System.out.print("\nDirección (I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ ):");
	     	String dir = sc.next();
	     	posValida = this.moverEjercito(fila, columna, dir, ejercito, reino1, reino2);
        }
        
        this.mapa[fila][columna]= null;
    }
    public boolean moverEjercito(int fila, int columna, String comando, int ejercito, ArrayList <Ejercito> r1, ArrayList <Ejercito> r2){	
    	Ejercito eje = this.mapa[fila][columna];
        switch (comando) {
            case "A":
                fila = fila - 1;
                if(fila < 0){return true;}
                break;
            case "B":
                fila = fila + 1;
                if(fila > 9){return true;}
                break;
            case "I":
                columna =  columna - 1;
                if(columna  < 0){return true;}
                break;
            case "D":
                columna = columna + 1;
                if(columna > 9){return true;}
                break;
            case "DII":
                fila = fila + 1;
                columna =  columna - 1;
                if(fila > 9 || columna < 0){return true;}
		        break;
            case "DDI":
                fila = fila + 1;
                columna =  columna + 1;
                if(fila > 9 || columna > 9){return true;}
                break;
            case "DIS":
                fila = fila - 1;
                columna =  columna - 1;
                if(fila < 0 || columna < 0){return true;}
                break;
            case "DDS":
                fila = fila - 1;
                columna =  columna + 1;
                if(fila < 0 || columna > 9){return true;}
                break;
        }
        System.out.println(fila+ " "+ columna);
        this.cambiarPosición(eje , fila , columna, ejercito, r1, r2);
        return false;
    }

    public void cambiarPosición(Ejercito eje, int fila, int columna, int ejercito, ArrayList <Ejercito> reino1, ArrayList <Ejercito> reino2){
        Ejercito enemigo = this.mapa[fila][columna];
        if (enemigo == null) {
            this.mapa[fila][columna] = eje;
        }

      /* else{
            if(VideoJuego5.ganador(eje, enemigo, fila, columna, ejercito)){
                mapa[fila][columna] = eje;
                eje.avanzar(fila, columna);
            }
            
        }*/
    } 
            
            
            
}

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mapa extends JFrame{
    //variables para la interfaz grafica
    private JTextField filaF;
    private JTextField columnaF;
    private JTextField direccionF;
     
    char bonificación;
    private String territorio;
    protected Ejercito [][] mapaR;
    private Soldado [][] mapa;
    private Scanner sc = new Scanner (System.in);
    public Mapa(){
        mapaR = new Ejercito [10][10];
        int n = (int)Math.random()* 5 + 1;
        this.setTerritorio(n);
    }
    public Mapa(String a){
        mapa = new Soldado [10][10];
        int n = (int)Math.random()* 5 + 1;
        this.setTerritorio(n);
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
                this.territorio = "mapaAbierto";
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

    public void bonificación(Ejercito eje){
        if(eje.getBono().charAt(0) == this.bonificación) eje.bonificación();    
    }

    public boolean posiciónValida(int fila, int columna, Ejercito eje) {
        if (this.mapaR[fila][columna] == null) {
            this.mapaR[fila][columna] = eje;
            return true;
        }
        return false;
    }
    public boolean posiciónValida(int fila, int columna, Soldado s) {
        if (this.mapa[fila][columna] == null) {
            this.mapa[fila][columna] = s;
            return true;
        }
        return false;
    }
   public Tablero mostrar() {
    return new Tablero(this);
  
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
        System.out.println("* |   A    |   B    |    C   |    D   |   E    |    F   |    G   |    H   |    I   |    J   |\n"+
                           "---------------------------------------------------------------------------------------------");
        for(int i = 0; i < this.mapa.length; i++){
                String fila = "|";
                for(int j = 0; j <this.mapa[i].length; j++){
                    if(this.mapa[i][j] == null){ fila = fila +"  ---   " + "|";
                    }else{
                        fila += " " + this.mapa[i][j].getColor() + this.mapa[i][j].getNombre().substring(0,2) + " - ";
                        if( this.mapa[i][j].getNivelDeVida() > 9) fila += this.mapa[i][j].getNivelDeVida()  + "\u001B[0m|";
                        else fila += this.mapa[i][j].getNivelDeVida()  + " \u001B[0m|";

                    }
                }
                if(i == 9){
                    System.out.println((i + 1)  + fila);
                }
                else System.out.println((i + 1) +" " + fila);
        }
    }
    //Metodos para mover el tablero de soldados

    public boolean moverSoldado(int fila, int columna, String comando, int num, Ejercito ej1, Ejercito ej2){	
	    Soldado sold = this.mapa[fila][columna];
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
        this.cambiarPosición(sold, fila , columna, num, ej1, ej2);
        return false;
    }
    public  void cambiarPosición(Soldado sold, int fila, int columna, int ejercito, Ejercito e1, Ejercito e2){
        Soldado enemigo = this.mapa[fila][columna];
        if (enemigo == null) {
            this.mapa[fila][columna] = sold;
            sold.avanzar(fila, columna);
        }
        else{ //Se agrega las ecepciones de batalla
            boolean gano = aplicarReglas(sold, enemigo);
            sold.atacar(gano);
            enemigo.serAtacado(gano);
            if(gano){
                this.mapa[fila][columna] = sold;
                sold.avanzar(fila, columna);
            }
            if(!enemigo.getVive()){
                if(ejercito == 1){
                    e2.remove(enemigo);
                }
                else{e1.remove(enemigo);}
            }
        }
        if(ejercito == 1){
            if(!sold.getVive()){
                e1.remove(sold);
            }    
        }else{
            if(!sold.getVive()){
                e2.remove(sold);
            }    
        }
    }
    public boolean aplicarReglas(Soldado sold, Soldado enemigo) {
        char s1 = sold.getNombreM().charAt(0);
        char s2 = enemigo.getNombreM().charAt(0);

        if ((s1 == 'C' || s2 == 'C') && (s1 == 'L' || s2 == 'L')) {
            if (s1 == 'C' && sold.getNombreM().equals("C ")) {
                return reglas(1, enemigo, sold);
            } else if (s2 == 'C' && enemigo.getNombreM().equals("C ")) {
                return reglas(1, sold, enemigo);
            }
        }

    if ((s1 == 'A' || s2 == 'A') && (s1 == 'L' || s2 == 'L')) {
        if (s1 == 'A') {
            return reglas(1, sold, enemigo);
        } else {
            return reglas(1, enemigo, sold);
        }
    }

    if ((s1 == 'C' || s2 == 'C') && (s1 == 'E' || s2 == 'E')) {
        if (s1 == 'C') {
            return reglas(1, sold, enemigo);
        } else {
            return reglas(1, enemigo, sold);
        }
    }

    if ((s1 == 'C' || s2 == 'C') && (s1 == 'A' || s2 == 'A')) {
        if (s1 == 'C') {
            if (sold.getNombreM().compareTo("C ") > 0) {
                return reglas(2, sold, enemigo);
            } else {
                return reglas(1, sold, enemigo);
            }
        } else {
            if (enemigo.getNombreM().compareTo("C ") > 0) {
                return reglas(2, enemigo, sold);
            } else {
                return reglas(1, enemigo, sold);
            }
        }
    }

    if ((s1 == 'E' || s2 == 'E') && (s1 == 'L' || s2 == 'L')) {
        if (s1 == 'E') {
            if (sold.getNombreM().compareTo("E ") > 0) {
                return reglas(1, sold, enemigo);
            } else {
                return reglas(1, sold, enemigo);
            }
        } else {
            if (enemigo.getNombreM().compareTo("E ") > 0) {
                return reglas(2, enemigo, sold);
            } else {
                return reglas(1, enemigo, sold);
            }
        }
    }

    if ((s1 == s2) && (s1 == 'E' || s1 == 'C')) {
        if (sold.getNombreM().compareTo(enemigo.getNombreM()) > 0) {
            return reglas(1, sold, enemigo);
        }
        if (sold.getNombre().compareTo(enemigo.getNombreM()) != 0) {
            return reglas(1, enemigo, sold);
        }
    }

    return VideoJuego5.definirGanador(sold.getNivelDeVida(), enemigo.getNivelDeVida());
}

    public boolean reglas(int n, Soldado sold, Soldado enemigo){
        if(n == 1){
            return VideoJuego5.definirGanador(sold.getNivelDeVida() + 1, enemigo.getNivelDeVida());
        }
        return VideoJuego5.definirGanador(sold.getNivelDeVida() + 2, enemigo.getNivelDeVida());
    }
    public void jugarE(int ejercito, Ejercito ej1, Ejercito ej2) {
        Mapa mJuego = new Mapa();
        mJuego.setTitle("Juego - Mover Soldado");
        mJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("Fila:"));
        filaF = new JTextField();
        panel.add(filaF);

        panel.add(new JLabel("Columna:"));
        columnaF = new JTextField();
        panel.add(columnaF);

        panel.add(new JLabel("Dirección:(I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ )"));
        direccionF = new JTextField();
        panel.add(direccionF);

        //convertir valores
        int fila = Integer.parseInt(filaF.getText()) - 1;
        int columna = Character.toUpperCase(columnaF.getText().charAt(0)) - 'A';
        String dir = direccionF.getText();

        JButton moverBtn = new JButton("Mover Soldado");
        moverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moverSoldado(fila, columna, dir, ejercito, ej1, ej2);
            }
        });
        panel.add(moverBtn);

        mJuego.add(panel, BorderLayout.CENTER);

        mJuego.pack();
        mJuego.setLocationRelativeTo(null);
        mJuego.setVisible(true);
        this.mapa[fila][columna]= null;
        this.mostrarE();
    }
    /*public  void jugar(int ejercito, Ejercito ej1, Ejercito ej2){
        
        System.out.print("Posición del soldado a mover:" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        while(this.mapa[fila][columna] == null){
            System.out.print("Posición invalida");
            System.out.print("Posición del soldado a mover:" + "\nFila: ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna: ");
	        columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        }
	    boolean posValida = true;
        while (posValida){
        	System.out.print("\nDirección (I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ ):");
	     	String dir = sc.next();
	     	posValida = this.moverSoldado(fila, columna, dir, ejercito, ej1, ej2);
        }
        this.mapa[fila][columna]= null;
        this.mostrarE();
    }*/
   //Metodos para mover el tablero de ejercitos
   public boolean jugar(int num, ArrayList <Ejercito> r1, ArrayList <Ejercito> r2) {
        String filaInput = JOptionPane.showInputDialog("Fila:");
        String columnaInput = JOptionPane.showInputDialog("Columna:");
        String direccionInput = JOptionPane.showInputDialog("Dirección:(I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ )");
        String continuar ;
        if (filaInput != null && columnaInput != null && direccionInput != null) {
            int fila = Integer.parseInt(filaInput) - 1;
            int columna = Character.toUpperCase(columnaInput.charAt(0)) - 'A';
            String dir = direccionInput;
            moverEjercito(fila, columna, dir, num, r1, r2);
            this.mapaR[fila][columna] = null;
        } 
        continuar = JOptionPane.showInputDialog("¿Desea continuar?(y/n)");
        if (continuar.equalsIgnoreCase("n")) {
            return false;
        }    
        return true;
    }
    /*public void jugar(int num, ArrayList <Ejercito> r1, ArrayList <Ejercito> r2){
       
	    Scanner sc = new Scanner (System.in);
        System.out.print("Posición del ejercito a mover:" + "\nFila: ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna: ");
        int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
        while(this.mapaR[fila][columna] == null){
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
	     	posValida = this.moverEjercito(fila, columna, dir, num, r1, r2);
        }
        
        this.mapaR[fila][columna]= null;
    }*/
    public boolean moverEjercito(int fila, int columna, String c, int ejercito, ArrayList <Ejercito> r1, ArrayList <Ejercito> r2){	
    	Ejercito eje = this.mapaR[fila][columna];
        switch (c) {
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

    public void cambiarPosición(Ejercito eje, int fila, int columna, int num, ArrayList <Ejercito> r1, ArrayList <Ejercito> r2){
        Boolean es1 = num == 1 ;
        Ejercito enemigo = this.mapaR[fila][columna];
        if (enemigo == null) {
            this.mapaR[fila][columna] = eje;
        }

       else{
            if(VideoJuego5.batallaEjercitos(eje, enemigo)){
                mapaR[fila][columna] = eje;
                eje.avanzar(fila, columna);
                if(es1){
                    r2.remove(enemigo);
                }else { r1.remove(enemigo); }
            }else if(es1){
                r1.remove(eje);
            }else{r2.remove(enemigo);}
            
       }
    } 
            
            
            
}

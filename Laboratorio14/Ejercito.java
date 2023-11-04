import java.util.*;
public class Ejercito{
    public static final int MAX_SIZE = 10;
    private String nombre, color;
    private int fila;
	private char columna;
    private Reino reino;
    private ArrayList <Soldado> army ;
    public Ejercito(String nom){
        this.army = new ArrayList <>();
        this.nombre = nom;
    }
    public void reclutar(Soldado sold){
        this.army.add(sold);
        sold.setEjercito(this);
    }
    public void setReino(Reino miReino){
        this.reino = miReino;
    } 
    public Reino getReino(){
        return this.reino;
    } 
    public int size(){
        return this.army.size();

    }

    public void setFila(int num){
		this.fila = num;
	}

	public void setColumna(int colum){
		this.columna = (char)(colum + 65);
	}
    public void setColor(String color){
		this.color = color; 
	}
    public String getColor(){
        return  color;
}
}

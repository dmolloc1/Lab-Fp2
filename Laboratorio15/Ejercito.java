import java.util.*;
public class Ejercito{
    public static final int MAX_SIZE = 10;
    private String nombre, color;
    private int fila;
	private char columna;
    private String reino;
    private ArrayList <Soldado> misSoldados ;
    public Ejercito(String nom){
        this.misSoldados = new ArrayList <>();
        this.nombre = nom;
    }
    public void add(Soldado sold){
        this.misSoldados.add(sold);
        sold.setEjercito(this);
    }
    public void setReino(String miReino){
        this.reino = miReino;
    } 
    public Reino getReino(){
        return this.reino;
    } 
    public int size(){
        return this.misSoldados.size();
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
    public void toString(){
        for(Soldado a : this.misSoldados){
            System.out.println(a.mostrar());
        }
    }
}

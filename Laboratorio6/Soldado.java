public class Soldado {
	private String nombre, color;
	private int nivelVida, fila;
	private char columna;
   	public void setNombre( String n){
		nombre = n;
	}
	public void setNivelDeVida(int num){
		nivelVida = num;
	}
	public void setFila(int num){
		fila = num;
	}
	public void setColumna(char colum){
		columna = colum;
	}
	public String getNombre(){
		return nombre;
	}	
	public int getNivelDeVida(){
		return nivelVida;
	}
	public int getFila(){
		return fila;
	}
	public char getColumna(){
		return columna;
	}
    public void setColor(String colorE){
        color = colorE + " S \u001B[0m";
    }
    public String getColor(){
        return color;
    }

	public String mostrar(){
		return "Nombre: " + nombre  + "\n	-Nivel de Vida: "
            + nivelVida + "\n	-Fila/Columna: "+ fila + " / "+ columna; 	
	}
}

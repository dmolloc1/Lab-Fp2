public class Soldado {

	private String nombre;
	private int nivelVida, fila;
	private char columna;
    private String valorTablero;
    //nuevos atributos
    private int nivelAtaque, nivelDefensa, vidaActual, velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(int nivelAtaque, int nivelDefensa, int velocidad){
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.velocidad = velocidad;
    }
    public Soldado(String actitud){
        this.actitud = actitud;
    }
    public Soldado(boolean vive){
        this.vive = vive;
    }
   	
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

	public String mostrar(){
		return "Nombre: " + nombre  + "\n	-Nivel de Vida: "
            + nivelVida + "\n	-Fila/Columna: "+ fila + " / "+ columna; 	
	}
  	public void setValorTablero(String color, String nivelVida){
      	valorTablero = color + nivelVida + "\u001B[0m"; 
   	}
   	public String getValorTablero(){
       	return valorTablero;
   	}
}


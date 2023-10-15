public class Soldado {

	private String nombre;
	private int nivelVida, fila;
	private char columna;
    private String valorTablero;
    //nuevos atributos
    private int nivelAtaque, nivelDefensa, vidaActual, velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(int nivelVida, int nivelAtaque, int nivelDefensa, int velocidad, boolean vive){//Atributos de batalla
        this.nivelVida = nivelVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.velocidad = velocidad;
        this.vive = vive;
    }

    public Soldado(int fila, char columna ){//Atributos de ubicacion y nombre
        this.fila = fila;
        this.columna = columna;
    }

    public Soldado(String nombre, String actitud){// Atributos de estado
        this.nombre = nombre;
        this.actitud = actitud;
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
//Metodos
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
    public void atacar(){
        this.velocidad += 1;
        this.avanzar();
        this.actitud = "Atacar";
    }
    public void defender(){
        this.velocidad = 0;
        this.actitud = "Defender";
    }
    public void huir (){
        this.velocidad += 2;
        this.actitud = "Huir";
    }
    public void retroceder(){
        if(this.velocidad > 0){
            this.velocidad = 0;
            this.actitud = "Defender";
            this.defender();
        }
        else{ 
            this.velocidad = this.velocidad - 1;
        }
    } 
    public void avanzar(){
        velocidad += 1;
    }
    public void serAtacado(Soldado enemigo){
        this.nivelVida -= enemigo.nivelVida;
    }

}


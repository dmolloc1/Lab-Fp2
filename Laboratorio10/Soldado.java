public class Soldado {

	private String nombre;
	private int nivelVida, fila;
	private char columna;
    private String valorTablero;
    //nuevos atributos
    private int nivelAtaque, nivelDefensa, vidaActual, velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(String nombre, int nivelVida, int nivelAtaque, int nivelDefensa, int velocidad){//Atributos de batalla
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.velocidad = velocidad;
    }

    public Soldado(int fila, char columna ){//Atributos de ubicacion y nombre
        this.fila = fila;
        this.columna = columna;
    }

    public Soldado(String actitud, boolean vive){// Atributos de estado
        this.actitud = actitud;
        this.vive = vive;
    }

	public void setNivelDeVida(int num){
		nivelVida = num;
	}

	public void setFila(int num){
		fila = num;
	}

	public void setColumna(int colum){
		columna = char(colum + 65);
	}
    public void setVive(boolean vivir){
        vive = vivir;
    }
    public void setActitud (String a){
        actitud = a ;
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
    public boolean getVive(){
        return vive;
    }
    public String getActitud(){
        return actitud;
    }

//Metodos
	public String mostrar(){
		return "Nombre: " + nombre  + "\n	-Nivel de Vida: "
            + nivelVida + "\n	-Fila/Columna: "+ fila + " / "+ columna +"\nEstado: "+ actitud; 	
	}

  	public void setValorTablero(String color, String nivelVida){
      	valorTablero = color + nivelVida + "\u001B[0m"; 
   	}

   	public String getValorTablero(){
       	return valorTablero;
   	}

    public void atacar(Soldado enemigo){
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

    public void avanzar(int fila, int columna){
        this.velocidad += 1;
        setFila(fila);
        setColumna(columna);
    }

    public boolean serAtacado(Soldado enemigo){
        this.nivelVida -= enemigo.nivelVida;
        if(this.nivelVida <= 0){
            enemigo.nivelVida = -(this.nivelVida);
            this.morir();
            return true;//Retorna verdadero si muere
        }
        return false;
    }

    public void morir(){
        this.vive = false;
    }

    public void setVidaActual(int vidaActual){
        this.nivelVida = vidaActual;
    }
    public int getVidaActual(){
        return nivelVida;
    }
}


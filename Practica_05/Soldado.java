public class Soldado {
	private String nombre;
	private int nivelVida;

	public void setNombre( String n){
		nombre = n;
	}
	public void setNivelDeVida(int num){
		nivelVida = num;
	}
	public String getNombre(){
		return nombre;
	}	
	public int getNivelDeVida(){
		return nivelVida;
	}

	public String mostrar(){
		return "Nombre: " + nombre  + "\nNivel de Vida: "+ nivelVida; 	
	}
}

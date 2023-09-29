import java.util.*;
public class Ejercito{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Soldado [] soldados = new Soldado[5];
		System.out.println("INGRESE DATOS DE SOLDADOS");
		for(int i = 0; i < soldados.length; i++){
			soldados[i]= new Soldado();
			System.out.println("Nombre :");
			String nom = sc.next();
			soldados[i].setNombre(nom);
			System.out.println("Nivel de vida :");
			int niv = sc.nextInt();
         		soldados[i].setNivelDeVida(niv);
		}
		for(Soldado n : soldados){
			System.out.println(n.mostrar());
		}
	}	
}

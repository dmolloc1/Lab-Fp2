import java.util.*;
public class Ejercito{
	public static void main(String[] args){
		Soldado [][] ejercitos = new Soldado[2][];
		System.out.println("INGRESE DATOS D SOLDADOS");
			for(int i= 0; i<2; i++){
				ejercito[i] = creando£jercito();
				System.out.printn("EJERCITO " + (i + 1) +"-------”);
				for(String nombres: ejercito[1])(
				for(Soldado n : soldados){
         	System.out.println(n.getNombre());
      		}
			}
	}
public static Soldadosg[] creando£jercito()(

int aleatorio = (int) (Math.random() * 5 + 1);
return ingresarDatos (aleatorio);

	public static void ingresarDatos(int n){
		Scanner sc = new Scanner(System.in);
                Soldado [] soldados = new Soldado[n];
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

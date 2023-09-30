//Laboratorio A Fundamentos 2 
//Autor: Mollo Chuquicaña Dolly Yadhira
import java.util.*;
public class DemoBatalla {
	public static void main(String [] args){
		Nave [] misNaves = new Nave[1];
		Scanner sc = new Scanner(System.in);
		String nomb, col;
		int fil, punt;
		boolean est;
		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.print("Fila: ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
		System.out.println("\nNaves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).mostrar());
	}		
//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
		System.out.println("Acontinuación las Naves de nuestra flota");
		for(int i = 0; i < flota.length; i++){
			System.out.print(flota[i].mostrar());
		}	
	}
//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota){
		Scanner sc = new Scanner(System.in);	  
		System.out.println("Ingres el nombre de la nave:");
		String buscar = sc.nextLine();
		for(int i = 0; i < flota.length; i++){
			 if(buscar.equalsIgnoreCase(flota[i].getNombre().substring(0, buscar.length()))){
				 System.out.println("\n	 - Nave "+ flota[i].getNombre());
			 }	
		}	
	}
//Método para mostrar todas las naves con un número de puntos inferior o igual
//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave [] flota){
		Scanner sc = new Scanner(System.in);	  
		System.out.println("Ingres el puntaje:");
		int puntaje = sc.nextInt();
		for(int i = 0; i < flota.length; i++){
			 if(puntaje >= flota[i].getPuntos()){
				 System.out.println("\n	 - Nave "+ flota[i].getNombre()+ ": "+ flota[i].getPuntos());
			 }	
		}	
	}
//Método que devuelve la Nave con mayor número de Puntos
	public static Nave mostrarMayorPuntos(Nave [] flota){
		int max = Integer.MIN_VALUE;
		int indice = 0;	
		for(int i = 0; i < flota.length; i++){
			 if(max < flota[i].getPuntos()){
				max = flota[i].getPuntos();
				indice = i ;
			 }	
		}	
		return flota[indice];
	}
//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados
//pero aleatoriamente desordenados
	public static Nave [] navesAleatoriamente(Nave [] flota){
		int lon = flota.length;
		Nave [] aleatorio = new Nave[lon];
		boolean [] control = new boolean[lon];
		int i = 0;
		while(i < lon){
			int num = (int)(Math.random()*lon) ;
			if (control[num] == false){
				control[num] = true;
				aleatorio[i] = flota[num];
				i++;
			}
		}
		return aleatorio;
	}
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s){
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(s)) {
                 return i;
             } 
        }
        return -1;
    }

    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota){
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota){
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - i - 1; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) > 0) {
                    Nave vControl = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = vControl;
                }
            }
        }
    }
//Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s){
    	int left = 0;
        int right = flota.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparar = flota[mid].getNombre().compareToIgnoreCase(s);
            if (comparar == 0) {
                return mid; 
            }
            if (comparar < 0) {
                left = mid + 1; 
	    } else {
                right = mid - 1;
            }
        }
        return -1;
    }
//Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota){
	    for (int i = 0; i < flota.length - 1; i++) {
            	int minIndice = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getPuntos() < flota[minIndice].getPuntos()) {
                    minIndice = j;
                }
            }
            Nave vControl = flota[i];
            flota[i] = flota[minIndice];
            flota[minIndice] = vControl;
        }
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota){
        for (int i = 0; i < flota.length - 1; i++) {
            int minIndice = i;
            for (int j = i + 1; j < flota.length; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[minIndice].getNombre()) < 0) {
                    minIndice = j;
                }
            }
            Nave vControl = flota[i];
            flota[i] = flota[minIndice];
            flota[minIndice] = vControl;
        }    
    }
    //Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota){
	int n = flota.length;
        for (int i = 1; i < flota.lengthn; ++i) {
            Nave llave = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() < llave.getPuntos()) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = llave;
        }
    }
    //Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota){
        for (int i = 1; i < flota.length; ++i) {
            Nave llave = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareToIgnoreCase(llave.getNombre()) < 0) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = llave;
        }
    }
}

import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego2 {
    static Soldado[][]tablero = new Soldado[10][10];
    public static void main(String[] args) {
    	List <Soldado> ejercito1, ejercito2;
        String turqueza = "\u001B[36m";
        String amarillo = "\u001B[33m";
 	    ejercito1 = creandoEjercito(turqueza);
        ejercito2 = creandoEjercito(amarillo);
        System.out.println("		~TABLERO~");
	    mostrarTablero();
/*	    mayorNivelVida(ejercito).mostrar();
	    System.out.println("\nEl total de nivel de vida del ejercito es :" + totalNivelVida(ejercito));
	    System.out.println("El promedio de nivel de vida del ejercito es :" + promedioNivelVida(ejercito));
	    System.out.println("\n~~~ Nivel de vida de los soldados ~~~");
	    mostrarNivelVida(ejercito);
    	System.out.println("\n~~~ Soldados del ejercito ~~~");
	    mostrarSoldados(ejercito);
        ordenarPorNivelBurbuja(ejercito);
	    System.out.println("\n~~~ Soldados ordenados Metodo Burbuja ~~~");
        mostrarSoldados(ejercito);
    //Creamos otro ejercito para aplicar el otro metodo de ordenamiento
        Soldado[] ejercito2 = creandoEjercito();
        ordenarPorNivelSelección(ejercito2);
	    System.out.println("\n~~~ Soldados ordenados Metodo de Selección ~~~");
        mostrarSoldados(ejercito2);*/
    }

    public static List <Soldado> creandoEjercito(String color) {
        List <Soldado> listArmy = new ArrayList <Soldado>();
    	int nivelR = 0, filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * 10 + 1);
	    for (int i = 0; i < armyLength; i++) {
            Soldado nuevo = new Soldado();
            nuevo.setNombre("Soldado_" + (i + 1));
            nuevo.setNivelDeVida((int) (Math.random() * 5 + 1));
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
            boolean posicionValida = false;
            while (!posicionValida) {
                filaR = (int) (Math.random() * 9);
                columnaR = (int) (Math.random() * 9);
                if (rellenarTablero(filaR, columnaR, nuevo)) {
                    posicionValida = true;
                }
            }
            nuevo.setFila(filaR + 1);
            nuevo.setColumna((char) (columnaR + 65));
            nuevo.setValorTablero(color,""+ nuevo.getNivelDeVida());
            listArmy.add(nuevo);
        }

	return listArmy;
    }

    public static boolean rellenarTablero(int fila, int columna, Soldado sol) {
        if (tablero[fila][columna] == null) {
            tablero[fila][columna] = sol;
            return true;
        }
        return false;
    }

    public static void mostrarTablero(){
    	for(int i = 0; i < tablero.length; i++){
	    	String fila = "|";
	    	for(int j = 0; j < tablero[i].length; j++){
	            if(tablero[i][j] == null){
					fila = fila +" - " + "|"; 
				}else{
					fila = fila + " " + tablero[i][j].getValorTablero() + " |";
				}
	    	}
	    	System.out.println(fila);
		}
    }
/*
    public static Soldado mayorNivelVida(Soldado[] soldados){
		Soldado soldMayor = soldados[0];

		for(int i = 1; i < soldados.length; i++){
			int min = soldados[i].getNivelDeVida();
			if(soldados[i].getNivelDeVida() > soldMayor.getNivelDeVida()){
				soldMayor = soldados[i];
			}
		}
		return soldMayor;
    }
    public static int totalNivelVida(Soldado[] soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }
    public static int promedioNivelVida(Soldado[] soldados){
    	return totalNivelVida(soldados)/ soldados.length;
    }
    public static void mostrarNivelVida(Soldado[] soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }
    public static void ordenarPorNivelBurbuja(Soldado[] soldados){
        for(int i = 1; i< soldados.length; i++){
            for(int j = 0; j < soldados.length - i; j++){
                if(soldados[j].getNivelDeVida() > soldados[j + 1].getNivelDeVida()){
                    intercambiar(soldados, j , j + 1);
                }
            }
        }
    }
    public static void ordenarPorNivelSelección(Soldado[] soldados){
        for(int i = 0; i < soldados.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < soldados.length; j++){
                if(soldados[min].getNivelDeVida() >  soldados[j].getNivelDeVida()){
                    min = j;
                }  
            }
            intercambiar(soldados, min, i);
        }
    }
    public static void intercambiar(Soldado[] lista, int i, int j){
        Soldado vControl = lista[i];
        lista[i]= lista[j];
        lista[j]= vControl;
    }
    public static void mostrarSoldados(Soldado[] soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }
    
  */
}

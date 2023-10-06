import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego2 {
    static ArrayList <ArrayList <Soldado>> tablero = new ArrayList <ArrayList<Soldado>>();
    public static void main(String[] args) {
        //Para diferenciar los soldados se agregara colores
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
        ArrayList <Soldado> ejercito1 = creandoEjercito(turqueza);
	    System.out.println("\nEl total de nivel de vida del ejercito 1 es :" + totalNivelVida(ejercito1));
	    System.out.println("El promedio de nivel de vida del ejercito 1 es :" + promedioNivelVida(ejercito1));
    	System.out.println("\n~~~ Soldados del ejercito 1 ~~~");
	    mostrarSoldados(ejercito1);
        ordenarPorNivelBurbuja(ejercito1);
	    System.out.println("\n~~~ Soldados ordenados Metodo Burbuja ~~~");
        mostrarSoldados(ejercito1);
	    System.out.println("\nEl soldado con mayor nivel de vida del ejercito 1 es: \n"+ mayorNivelVida(ejercito1).mostrar());
    //Creamos el segundo ejercito
    	ArrayList <Soldado> ejercito2 = creandoEjercito(amarillo);
	    System.out.println("\nEl total de nivel de vida del ejercito 2 es :" + totalNivelVida(ejercito2));
	    System.out.println("El promedio de nivel de vida del ejercito 2 es :" + promedioNivelVida(ejercito2));
    	System.out.println("\n~~~ Soldados del ejercito 2 ~~~");
	    mostrarSoldados(ejercito2);
        ordenarPorNivelSelección(ejercito2);//Ordenando el ejercito con el metodo de Selcción
	    System.out.println("\n~~~ Soldados ordenados Metodo de Selección ~~~");
        mostrarSoldados(ejercito2);
	    System.out.println("\nEl soldado con mayor nivel de vida del ejercito 2 es:\n"+ mayorNivelVida(ejercito2).mostrar());
        System.out.println("		~TABLERO~");
        mostrarTablero();
    }

    public static ArrayList <Soldado> creandoEjercito(String color) {
        ArrayList <Soldado> listEjercito = new ArrayList <Soldado>();
    	int nivelR = 0, filaR = 0, columnaR = 0;
	    int armyLen = (int)(Math.random()* 10 + 1);
        for (int i = 0; i < armyLen; i++) {
            Soldado nuevo = new Soldado();
            nuevo.setNombre("Soldado_" + (i + 1));
            nuevo.setNivelDeVida((int) (Math.random() * 5 + 1));
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
            boolean posicionValida = false;
            while (!posicionValida) {
                filaR = (int) (Math.random() * 9);
                columnaR = (int) (Math.random() * 9);
                if (rellenarTablero(filaR, columnaR,nuevo)) {
                    posicionValida = true;
                }
            }
            nuevo.setFila(filaR + 1);
            nuevo.setColumna((char) (columnaR + 65));
            nuevo.setColor(color);
            listEjercito.add(nuevo);
        }

        return listEjercito;
    } 
    
    public static boolean rellenarTablero(int fila, int columna, Soldado sol) {
        if(fila < tablero.size()){
            if (tablero.get(fila).size() > columna) {
                if(tablero.get(fila).get(columna)== null){
                    tablero.get(fila).set(columna, sol);
                    return true;
                }
                return false;
            }else{
                while(tablero.get(fila).size() <= columna){
                    tablero.get(fila).add(null);
                }
                tablero.get(fila).set(columna, sol);
                return true;
            }
        }else{
            while(tablero.size() <= fila){
                tablero.add( new ArrayList<>());
            }
            while(columna >= tablero.get(fila).size()){
                tablero.get(fila).add(null);
            }
        }
        if(columna < tablero.get(fila).size()){
            if (tablero.get(fila).get(columna)== null) {
                tablero.get(fila).set(columna, sol);
                return true;
            }
            return false;
        }
        
        tablero.get(fila).add(columna, sol);
        return true;
    }

    public static void mostrarTablero(){
    	
        for(int i = 0; i < tablero.size(); i++){
	    	String fila = "|";
	    	for(int j = 0; j < tablero.get(i).size(); j++){
	            if(tablero.get(i).get(j) == null){
					fila = fila +" - " + "|"; 
				}else{
					fila = fila + tablero.get(i).get(j).getColor() + "|";
				}
	    	}
	    	System.out.println(fila);
		}
    }

   public static Soldado mayorNivelVida(ArrayList <Soldado> soldados){
		Soldado soldMayor = soldados.get(soldados.size() - 1);
		return soldMayor;
    }
    public static int totalNivelVida(ArrayList <Soldado> soldados) {
        int total = 0;
        for (Soldado soldado : soldados) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }
    public static int promedioNivelVida(ArrayList<Soldado> soldados){
    	return totalNivelVida(soldados)/ soldados.size();
    }
    public static void mostrarNivelVida(ArrayList<Soldado> soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.mostrar());
        }
    }
    public static void ordenarPorNivelBurbuja(ArrayList<Soldado> soldados){
        for(int i = 1; i< soldados.size(); i++){
            for(int j = 0; j < soldados.size() - i; j++){
                if(soldados.get(j).getNivelDeVida() > soldados.get(j + 1).getNivelDeVida()){
                    intercambiar(soldados, j , j + 1);
                }
            }
        }
    }
    public static void ordenarPorNivelSelección(ArrayList <Soldado> soldados){
        for(int i = 0; i < soldados.size() - 1; i++){
            int min = i;
            for(int j = i + 1; j < soldados.size(); j++){
                if(soldados.get(min).getNivelDeVida() >  soldados.get(j).getNivelDeVida()){
                    min = j;
                }  
            }
            intercambiar(soldados, min, i);
        }
    }
    public static void intercambiar(ArrayList <Soldado> lista, int i, int j){
        Soldado vControl = lista.get(i);
        lista.set(i,lista.get(j));
        lista.set(j, vControl);
    }
    public static void mostrarSoldados(ArrayList <Soldado> soldados){
        for (Soldado n : soldados) {
            System.out.println("---------------------------------\n"+n.mostrar());
        }
    }
}


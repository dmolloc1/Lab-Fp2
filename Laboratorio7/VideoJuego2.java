import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego2 {
    static Soldado[][]tablero = new Soldado[10][10];
    public static void main(String[] args) {
    	List <Soldado> ejercito1, ejercito2;
        String turqueza = "\u001B[30m";
        String amarillo = "\u001B[31m";
	
	datosEjercito(1, turqueza);
	datosEjercito(2, amarillo);

	//Gana el ejercito con mayor cantidad de puntos
        if(total1 <= total2){
            if(total2 > total1){
                System.out.println("GANO EL EJERCITO 1");
            }
            else{
                System.out.println("EMPATE");
            }
        }
        else{
            System.out.println("GANO EL EJERCITO 1");
        }
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

    public static void datosEjercito(int n, String color){
	ArrayList <Soldado> ejercito = creandoEjercito(color);
        int total = totalNivelVida(ejercito1);
        System.out.printf("\nEl total de nivel de vida del ejercito %d es : %d", n, total);
        System.out.printf("El promedio de nivel de vida del ejercito %d es : %d", n, promedioNivelVida(ejercito));
        System.out.printf("\n~~~ Soldados del ejercito %d ~~~", n);
        mostrarSoldados(ejercito);
        if(n == 1){
		ordenarPorNivelBurbuja(ejercito);//Ordenando el ejercito con el método Burbuja
	}
	else{ ordenarPorNivelSelección(ejercito2);//Ordenando el ejercito con el método de Selección;
	}
        mostrarSoldados(ejercito);
        System.out.printf("\nEl soldado con mayor nivel de vida del ejercito %d es: %d\n", n,  mayorNivelVida(ejercito1).mostrar());
    }
}


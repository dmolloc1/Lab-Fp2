import java.util.*;
public class Ejercito{
    Scanner sc = new Scanner(System.in);
    public static final int MAX_SIZE = 10;
    private String nombre, color;
    private int fila, totalNivelVida;
    private char columna;
    private String reino, bonificación;
    private ArrayList <Soldado> misSoldados ;

    public Ejercito(String nom){
        this.misSoldados = new ArrayList <>(1);
        this.nombre = nom;
    }
    public void add(Soldado sold){
        this.misSoldados.add(sold);
        sold.setEjercito(this);
    }
    public void setReino(int n){
        switch(n){
            case 1:
                this.bonificación = "1";
                this.reino = "Inglaterra";
                break;
            case 2:
                this.bonificación = "2";
                this.reino = "Francia";
                break;
            case 3:
                this.bonificación = "3";
                this.reino = "Castilla-Aragon";
                break;
            case 4:
                this.bonificación = "4";
                this.reino = "Moros";
                break;
            case 5:
                this.bonificación = "125";
                this.reino = "Sacro Imperio Romano Germánico";
                break;
        }
    }
    public String getBono(){
        return this.bonificación;
    }
         
    public String getNombre(){
        return this.nombre;
    }
    public String getReino(){
        return this.reino;
    } 
    public ArrayList <Soldado> getSoldados(){
        return this.misSoldados;
    }
    public int size(){
        return this.misSoldados.size();
    }

    public void setFila(int num){
		this.fila = num;
	}

	public void setColumna(int colum){
		this.columna = (char)(colum + 65);
	}

    public void setColor(String color){
		this.color = color; 
	}
    public String getColor(){
        return  color;
    }
    public static int totalSoldados(ArrayList <Ejercito> rei){
        int total = 0;
        for(Ejercito ejer : rei){
            total  += ejer.size();
        }
        return total;
    }
    public String toString(){
        String mostrar = "";
        for(Soldado a : this.misSoldados){
            mostrar += "\n"+ a.mostrar() ;
        }
        return mostrar;
    }
    public void avanzar(int fila, int columna){
        setFila(fila);
        setColumna(columna);
    }

    public static void bono(ArrayList <Ejercito> ejercitos){
        for(Ejercito e : ejercitos){
            e.bonificación();
        }
    }
    public void bonificación(){
        for(Soldado s : this.misSoldados){
            s.aumentarVida(1);    
        }
    }
//Metodo para rellenar a el ejercito sus soldados
    public  void ingresarDatosAleatorio(String color) {
        this.misSoldados.clear();
        int armyLength = (int)(Math.random() * Soldado.MAX_SIZE + 1);
        int tipo = 0; 
        for (int i = 0; i < armyLength; i++) {
            tipo = (int) (Math.random() * 4 + 1);   
            switch (tipo){
                    case 1: 
                        Espadachin nE = new Espadachin("Espadachin X " + i,(int)( Math.random()* 2 + 3), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0,"neutro", true, color, (int)(Math.random()*3 + 1));
                        this.misSoldados.add(nE);
                        break;
                    case 2:
                        Caballero nC = new Caballero("Caballero X " + i,(int)( Math.random()* 3 + 3), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0,"neutro", true, color, true);
                        this.misSoldados.add(nC);
                        break;
                    case 3:
                        Arquero nA = new Arquero("Arquero X " + i,(int)( Math.random()* 3 + 1), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0, "neutro", true, color,(int)(Math.random()*5 + 1));
                        this.misSoldados.add(nA);
                        break;
                    case 4: 
                        Lancero nL = new Lancero("Lancero X " + i,(int)( Math.random()* 2 + 1), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0,"neutro", true, color, (int)(Math.random()*5 + 1));
                        this.misSoldados.add(nL);
                        break;
            }
        }
    }
    public void ingresarDatosManual(Soldado [][] tablero, String color){
        this.misSoldados.clear();
        int armyLength = (int)(Math.random() * Soldado.MAX_SIZE + 1);
        System.out.println("Ingrese los datos de Soldados. Cantidad:" + armyLength);
        for(int i = 0; i < armyLength; i++){
            this.crearSoldado(tablero, color);
        }
    }
//Menu para ver datos de soldados

   public void datosEjercito(){
        int comando = 0;
        do{
            System.out.print("\n1. Total de vida del ejercito\n2. Promedio de vida\n3. Mostrar Soldados"+
        "\n4. Ordenamiento por Burbuja\n5. Ordenamiento por Selección\n6. Soldados con mayor nivel de vida\n7. Salir\n");
            System.out.print("Elección: ");
            comando = sc.nextInt();
            switch(comando){
                case 1:
                    System.out.printf("\n*** El total de nivel de vida del ejercito %s es : %d\n", this.getNombre(), this.totalNivelVida());  
                    break;
                case 2:
                    System.out.printf("\n*** El promedio de nivel de vida del ejercito %s es : %d\n", this.getNombre(), this.promedioNivelVida());
                    break;
                case 3:
                    System.out.printf("\n~ ~ ~ Soldados de %s ~ ~ ~", this.getNombre());
                    System.out.println("\n" + this.toString()+ "\n"); 
                    break;
                case 4:
                    this.ordenarPorNivelBurbuja();//Ordenando el ejercito con el método Burbuja
        	        System.out.println("\n       ~MÉTODO BURBUJA~");
                    System.out.println(this.toString() + "\n"); 
                    break;
                case 5:
                    this.ordenarPorNivelSelección();//Ordenando el ejercito con el método Burbuja
        	        System.out.println("\n       ~MÉTODO DE SELLECIÓN~");
                    System.out.println( this.toString()+ "\n"); 
                    break;
                case 6:
                    System.out.println("\n*** El soldado con mayor nivel de vida del ejercito es: \n" );
                    this.ordenarPorNivelSelección();
                    System.out.println( this.get(this.size() - 1).mostrar());
                    break;
            }
        }while(comando != 7);
    }
//Metodos para editar al soldado
    public void crearSoldado( Soldado [][] tablero, String color){
        if(this.size() + 1 <= Soldado.MAX_SIZE){
            Soldado nuevo = new Soldado("Neutro", true);
            System.out.print("Nombre del Soldado:");
            nuevo.setNombre(sc.next());
            System.out.print("\nNivel de vida (1 - 5):");
            nuevo.setNivelDeVida(sc.nextInt());
            System.out.print("\nNivel de ataque(1 - 5):");
            nuevo.setNivelAtaque(sc.nextInt());
            System.out.print("\nNivel de defensa(1 - 5):");
            nuevo.setNivelDefensa(sc.nextInt());
            System.out.print("\nFila");
            int fila = sc.nextInt() - 1;
            System.out.print("\nColumna:");
            int columna = Integer.valueOf(sc.next().toUpperCase().charAt(0)) - 65;
            tablero[fila][columna] = nuevo;
            nuevo.setFila(fila);
            nuevo.setColumna(columna);
            nuevo.setColor(color);
            this.add(nuevo);        
        }
    }

    public void modificarSoldado(Soldado soldado){
        int opcion;
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Modificar nivel de ataque");
            System.out.println("2. Modificar nivel de defensa");
            System.out.println("3. Modificar vida actual");
            System.out.println("4. Mostrar información del soldado");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nuevo nivel de ataque: ");
                    int nuevoAtaque = sc.nextInt();
                    soldado.setNivelAtaque(nuevoAtaque);
                    break;
                case 2:
                    System.out.print("Ingrese nuevo nivel de defensa: ");
                    int nuevaDefensa = sc.nextInt();
                    soldado.setNivelDefensa(nuevaDefensa);
                    break;
                case 3:
                    System.out.print("Ingrese nueva vida actual: ");
                    int nuevaVida = sc.nextInt();
                    soldado.setVidaActual(nuevaVida);
                    break;
                case 4:
                    System.out.println(soldado.mostrar());
		    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 5);
    }
    public void remove(Soldado sold){
        this.misSoldados.remove(sold);
    }
//Metodos para saber caracteristicas del ejercito
    public int totalNivelVida() {
        int total = 0;
        for (Soldado soldado : this.misSoldados) {
            total += soldado.getNivelDeVida();
        }
        this.totalNivelVida = total;
        return total;
    }

    public int promedioNivelVida(){
        return this.totalNivelVida()/ this.size();
    }
    public Soldado get(int n){
        return this.misSoldados.get(n);
    }
// Metodos de ordenamiento
    public void ordenarPorNivelBurbuja(){
        for(int i = 1; i< this.size(); i++){
            for(int j = 0; j < this.size() - i; j++){
                if(this.misSoldados.get(j).getNivelDeVida() > this.misSoldados.get(j + 1).getNivelDeVida()){
                    Ejercito.intercambiar(this, j , j + 1);
                }
            }
        }
    }
    public  void ordenarPorNivelSelección(){
        for(int i = 0; i < this.size() - 1; i++){
            int min = i;
            for(int j = i + 1; j < this.size(); j++){
                if(this.misSoldados.get(min).getNivelDeVida() >  this.misSoldados.get(j).getNivelDeVida()){
                    min = j;
                }
            }
            Ejercito.intercambiar( this, min, i);
        }
    }

    public static void intercambiar( Ejercito lista, int i, int j){
        Soldado vControl = lista.misSoldados.get(i);
        lista.misSoldados.set(i,lista.misSoldados.get(j));
        lista.misSoldados.set(j, vControl);
    }
//Metodo de ordenamiento por nombre
    public void insertionSortName (){
    	int j;
    	Soldado pivot;
    	for(int i = 0; i < this.size(); i++){
    		j = i - 1;
    		pivot = this.misSoldados.get(i);
    		while(j >= 0 && VideoJuego5.compareString(this.misSoldados.get(j).getNombre(), pivot.getNombre())){
			    this.misSoldados.set((j + 1), this.misSoldados.get(j));
			    j--;
      		}
      	    this.misSoldados.set((j + 1), pivot);
	    }
    }
}

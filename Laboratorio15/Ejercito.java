import java.util.*;
public class Ejercito{
    Scanner sc = new Scanner(System.in);
    public static final int MAX_SIZE = 10;
    private String nombre, color;
    private int fila, totalNivelVida;
	private char columna;
    private String reino;
    private ArrayList <Soldado> misSoldados ;
    public Ejercito(String nom){
        this.misSoldados = new ArrayList <>();
        this.nombre = nom;
    }
    public void add(Soldado sold){
        this.misSoldados.add(sold);
        sold.setEjercito(this);
    }
    public void setReino(String miReino){
        this.reino = miReino;
    } 
    public String getNombre(){
        return this.nombre;
    }
    public String getReino(){
        return this.reino;
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
//Metodo para rellenar a el ejercito sus soldados
    public  void ingresarDatosAleatorio(String color, Soldado[][] tablero) {
        int filaR = 0, columnaR = 0;
        int armyLength = (int)(Math.random() * Soldado.MAX_SIZE + 1);
        for (int i = 0; i < armyLength; i++) {
                Soldado nuevo = new Soldado(("Soldado_" + (i + 1)),(int)( Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), (int) (Math.random()* 5 + 1), 0);
            // Este ciclo nos permitirá comprobar que los valores generados no coincidan con uno ya existente
                boolean posicionValida = false;
                while (!posicionValida) {
                    filaR = (int) (Math.random() * 9);
                    columnaR = (int) (Math.random() * 9);
                    if (VideoJuego5.rellenarTablero(filaR, columnaR, nuevo, tablero)) {
                        posicionValida = true;
                    }
                }
                nuevo.setFila(filaR + 1);
                nuevo.setColumna(columnaR );
                nuevo.setActitud("Neutro");
                nuevo.setVive(true); //Valores por defecto
                nuevo.setColor(color);
                this.misSoldados.add(nuevo);
        }
    }
    public void ingresarDatosManual(Soldado [][] tablero, String color){
        int armyLength = (int)(Math.random() * Soldado.MAX_SIZE + 1);
        System.out.println("Ingrese los datos de Soldados. Cantidad:" + armyLength);
        for(int i = 0; i < armyLength; i++){
            this.crearSoldado(tablero, color);
        }
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
    public Soldado getSoldado(int n){
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

}

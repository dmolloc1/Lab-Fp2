import java.util.*;
public class Ejercito{
    Scanner sc = new Scanner(System.in);
    public static final int MAX_SIZE = 10;
    private String nombre, color;
    private int fila;
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

}

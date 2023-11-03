public class Ejercito{
    public static final int MAX_SIZE = 10;
    private static int ejercitoscantidad;
    private static int totalEjercitos;
    private static ArrayList<Ejercito> reino;
    private ArrayList <Soldado> army ;
    public static void crearEjercitos(Ejercito armyList){
        reino.add(armyList);
    }
    public Ejercito(){
        this.army = new ArrayList <>();
    }
    public void reclutar(Soldado sold){
        this.army.add(sold);
    }
    public static  ArrayList <ArrayList<Soldado>> getReino(){
        return reino;
    }
    
}

import java.util.*;
public class Ejercito{
    public static final int MAX_SIZE = 10;
    private static Reino reino;
    private ArrayList <Soldado> army ;
    
    public Ejercito(){
        this.army = new ArrayList <>();
    }
    public void reclutar(Soldado sold){
        this.army.add(sold);
    }
    public static  Reino retornarEjercitos(){
        return reino;
    }
    
}

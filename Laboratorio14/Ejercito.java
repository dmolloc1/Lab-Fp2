import java.util.*;
public class Ejercito{
    public static final int MAX_SIZE = 10;
    private Reino reino;
    private ArrayList <Soldado> army ;
    public Ejercito(){
        this.army = new ArrayList <>();
    }
    public void reclutar(Soldado sold){
        this.army.add(sold);
        sold.setEjercito(this);
    }
    public void setReino(Reino miReino){
        this.reino = miReino;
    } 
    public Reino getReino(){
        return this.reino;
    }
    public int size(){
        return this.army.size();
    }
}

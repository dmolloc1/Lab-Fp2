import java.util.*;
public class Reino{
    private int totalEjercitos;
    private ArrayList<Ejercito> listArmy;
    public Reino(){
        this.listArmy = new ArrayList <>();
    }
   
    public void reclutar(Ejercito army){
        this.listArmy.add(army);
        army.setReino(this);
    }

    public   ArrayList <Ejercito> ejercitos(){
        return listArmy;
    }
    public static int cantidad(Reino reino){
        return reino.listArmy.size();
    }
}

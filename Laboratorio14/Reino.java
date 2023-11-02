import java.util.*;
public class Reino{
    private int totalEjercitos;
    private ArrayList<Ejercito> listArmy;
    public Reino(){
        this.listArmy = new ArrayList <>();
    }
   
    public void reclutar(Ejercito army){
        this.listArmy.add(army);
    }

    public static  ArrayList <ArrayList<Soldado>> ejercitos(){
        return listArmy;
    }

}

import java.util.*;
public class Reino{
    private ArrayList<Ejercito> listArmy;
    
    public Reino(){
        this.listArmy = new ArrayList <>();
    }
   
    public void reclutar(Ejercito army){
        this.listArmy.add(army);
        army.setReino(this);
    }

    public ArrayList <Ejercito> getEjercitos(){
        return listArmy;
    }
    public int size(){
        return this.listArmy.size();
    }
}

import java.util.*;
public class Reino{
    private String nombre;
    private ArrayList<Ejercito> listArmy;
    
    public Reino(String nom){
        this.listArmy = new ArrayList <>();
        this.nombre = "" + :nom.charAt(0);
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
    public String getNombre(){
        return this.nombre;
    }
}

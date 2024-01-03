import java.util.*;
public class Map{
    private Image land;//es un Image
    private ArrayList<Land> field;
    private HashMap<Integer,Castle> castles;
    private Graphics currentG ;
    public Map(Castle cas1, Castle cas2){ 
        this.field = new ArrayList<>(0);
        this.field = Land.createLands();
        castles = new HashMap<Integer,Castle>();
        castles.put(1, cas1);
        castles.put(2, cas2);
    }
    public void print(){
        currentG = new Graphics(this.builtMap(), this);
		currentG.print();
    }
    public void dispose(){
        this.currentG.again();
    }
    public Image builtMap(){
        land = this.row(0).encima(row(4)).encima(row(8)).encima(row(12));
        return land;
    }
    public Image row(int i){
        Image row = this.field.get(i).getImage();
        row = row.alLado(this.field.get(i+1).getImage().alLado(this.field.get(i+2).getImage())).alLado(this.field.get(i+3).getImage());
        return row;
    }
    public void levelUp(Castle c, Land l){
        //Logicca para agregar un item
    }
    public void setCastle(int i, Castle c){
        this.land = this.field.get(i).getImage().colorImage(c.getColor());
        this.field.get(i).setImage(land);
        this.field.get(i).setCastle(c);
    }
    //l es el indice del Land y c es el jugador al que le pertenece
    public void play(int l, int c){
        MiniGame mg = new MiniGame();
        if(this.field.get(l).getCastle() == null){
            if(mg.individual()){
                this.field.get(l).setPoints(this.castles.get(l));
            }
        }
        this.print();
    }


}

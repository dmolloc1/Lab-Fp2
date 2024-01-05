import java.util.*;
public class Map{
    private Image land;//es un Image
    private ArrayList<Land> field;
    private HashMap<Integer,Castle> castles;
    private Graphics currentG ;
    private Image image;
    public Map(Castle cas1, Castle cas2){ 
        this.field = new ArrayList<>(0);
        this.field = Land.createLands();
        castles = new HashMap<Integer,Castle>();
        castles.put(1, cas1);
        castles.put(2, cas2);
    }
    public void print(){
        Graphics g = new Graphics(this.land, this);
        this.currentG = g;
		g.print();
    }
    public void dispose(){
        this.currentG.again();
    }
    public void builtMap(){
        this.land = this.row(0).encima(row(4)).encima(row(8)).encima(row(12));
        
    }
    public Image row(int i){
        Image row = this.field.get(i).getImage();
        row = row.alLado(this.field.get(i+1).getImage().alLado(this.field.get(i+2).getImage())).alLado(this.field.get(i+3).getImage());
        return row;
    }

    public void setCastle(int i, Castle c){
        this.image = this.field.get(i).getImage().colorImage(c.getColor());
        this.field.get(i).setImage(image);
        this.field.get(i).setCastle(c);
    }
    //l es el indice del Land y c es el jugador al que le pertenece
    public void play(int l, int c, Boolean win){
        if(win){
                this.changeLand(l, c);
                this.field.get(l).setCastle(this.getCastle(c));
                this.field.get(l).setPoints(this.getCastle(c));
        }
    }
    public Boolean typeMiniGame(int l){
        return this.field.get(l).getCastle() == null;
    }
    public void changeLand(int l, int c){
        this.image = this.field.get(l).getImage().colorImage(c);
        this.field.get(l).setImage(image);
    }
    public Castle getCastle(int i){
        return castles.get(i);
    }
    /*public static void main(String[] args) {
        Castle ca1 = new Castle("1", 1);
        Castle ca2 = new Castle("2", 2);
        Map m = new Map(ca1,ca2);
        m.builtMap();
        m.print();
        m.dispose();
        m.changeLand(4, 1);
        m.builtMap();
        m.print();
        m.dispose();
        m.changeLand(8, 2);
        m.builtMap();
        m.print();
    }*/

}

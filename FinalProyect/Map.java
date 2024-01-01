import java.util.*;
class Map{
    private Image land;//es un Image
    private ArrayList<Land> field;
    public Map(){ 
        this.field = new ArrayList<>(0);
        this.field = Land.createLands();
    }
    public void print(){
        Graphics g = new Graphics(this.builtMap());
		g.print();
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
    public void setCastle(int i, int col, Castle c){
        this.land = this.field.get(i).getImage().colorImage(col);
        this.field.get(i).setImage(land);
        this.field.get(i).setCastle(c);
    }


}

import java.util.*;
import graphic.*;
class Map{
    private Image land;//es un Image
    private Land [] field;
    public Map(){ 
        this.field = new Land[Land.SIZE_MAP];
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
        Image row = land.alLado(this.field[i + 1].getImage().alLado(this.field[i + 2].getImage())).alLado(this.field[i+3].getImage());
        return row;
    }
    public void levelUp(Castle c, Land l){
        //Logicca para agregar un item
    }
}

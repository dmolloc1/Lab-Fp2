import java.util.*;

class Land {
    public static int SIZE_MAP = 16;
    private static ArrayList<Land> map;
    private Image land;
    private int points;
    private Castle castle;
    public Land(int n){
        super();
        this.points = 10;
        switch (n) {
            case 1:
                this.land = Image.part1();
                break;
            case 2:
                this.land = Image.part2();
                break;
            case 3:
                this.land = Image.part3();
                break;
            case 4:
                this.land = Image.part4();
                break;
            case 5:
                this.land = Image.part5();
                break;
            case 6:
                this.land = Image.part6();
                break;
            case 7:
                this.land = Image.part7();
                break;
            case 8:
                this.land = Image.part8();
                break;
            case 9:
                this.land = Image.part9();
                break;
            case 10:
                this.land = Image.part10();
                break;
            case 11:
                this.land = Image.part11();
                break;
            case 12:
                this.land = Image.part12();
                break;
            case 13:
                this.land = Image.part13();
                break;
            case 14:
                this.land = Image.part14();
                break;
            case 15:
                this.land = Image.part15();
                break;
            case 16:
                this.land = Image.part16();
                break;
        
            default:
                break;
        }
    }
    public void setImage(Image i){
        this.land = i;
    }
    public void setCastle(Castle c){
        this.castle = c;
    }
    public Castle getCastle(){
        return this.castle;
    }
    // Instancia el arreglo de Lands
   public static ArrayList<Land> createLands(){
        map = new ArrayList<>();
        for(int i = 1; i <= SIZE_MAP; i++){
            map.add(new Land(i));
        }
        return map;

    } 
    public Image getImage(){
        return land;
    }



}

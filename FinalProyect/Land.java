import java.util.Arrays;
import java.util.Iterator;
import javax.swing.*;
import java.awt.*;
class Land extends JFrame{
    private static int SIZE_MAP = 16;
    private static Land[] map;

    private int points;
    private Castle castle;
    public Land(int n){
        super();
    }

    public static Land [] createLands(){
        map = new Land[SIZE_MAP];
        for(int i = 0; i <SIZE_MAP; i++){
            map[i] = new Land(i);
        }
        return map;
    }
    public String print(){
        return "L";
    }


}

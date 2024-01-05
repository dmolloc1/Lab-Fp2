import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class BattleGame extends JFrame{

    //archivo para guardar los records
    private Map map;
    private Castle c1 ,c2;//posicion actual
    private static BattleGame currentG;
    public static boolean go;
    //constructor
    public BattleGame(){
        this.c1 = new Castle("Estados Unidos",1);
        this.c2 = new Castle("China",2);
        this.map = new Map(c1,c2);
        this.map.setCastle(12, c1);
        this.c1.setPosicion(12);
        this.map.setCastle(7, c2);
        this.c2.setPosicion(7);
        this.currentG = this;
        map.serBattleGame(this);
    }
    public BattleGame(Map m, Castle cas1, Castle cas2){
        this.map = new Map(c1,c2);
        this.c1 = new Castle("",1);
        this.c2 = new Castle("",2);
    }
    public Map getMap(){
        return this.map;
    }
    public void startGame(){
        
        this.map.builtMap();
        this.map.print();
        
    }
    public static void continueGame(Boolean b){
        if(b){
            currentG.map.builtMap();
            currentG.map.print();
        }
    }
    public static void endGame(){
        currentG.map.dispose();
    }
    public void newRound(){
        if(go){
            startGame();
        }
    }
}

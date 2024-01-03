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
        this.c1 = new Castle("",1);
        this.c2 = new Castle("",2);
        this.map = new Map(c1,c2);
        this.map.setCastle(12, c1);
        this.c1.setPosicion(12);
        this.map.setCastle(7, c2);
        this.c2.setPosicion(7);
    }
    public void startGame(){
        
        this.map.builtMap();
        this.map.print();
        
    }
    public static void continueGame(Boolean b){
        go = b;
    }
    public static void endGame(){
        currentG.map.dispose();
    }
    public void newRound(){
        if(go){
            startGame();
        }
    }
    
    //main
    public static void main(String[] args){
        BattleGame bg = new BattleGame();
        currentG = bg;
        bg.menu();
        System.out.println("Fin primera ronda");
        
    }
    //Parte de mensajes

    public void menu(){
        JFrame menu = new JFrame("Menu de instrucciónes:");
        menu.setSize(500,200);
        menu.setLayout (new BorderLayout());
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        menu.setLocationRelativeTo(null);
        menu.add(BattleGame.contenido(), BorderLayout.CENTER);
        menu.add(this.empezar(menu), BorderLayout.SOUTH );
        menu.setVisible(true);

    }
    public static JTextArea contenido(){
        String mensaje= "El juego esta por comenzar...\n"+
        "Cada jugador se el asignara un castillo con un general a elección del jugador\n"+
        "OBJETIVO: Conquistar el castillo del enemigo\n"+
        "BONIFICACIONES: Por cada territorio conquistado se le daran puntos\n"+
        "Para conquistar un territorio se debera pasar un desafio(MINIJUEGOS)\n"+
        "En caso el terreno ya estuviera conquistado se producira una batalla por el territorio";

        JTextArea texto = new JTextArea();
        texto.setText(mensaje);
        texto.setEditable(false);
        return texto;
    }
//Botones
    public  JButton empezar(JFrame m){
        //boton
        JButton empezar = new JButton("Empezar");
        empezar.setBounds(150, 100, 100, 30);
        empezar.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
          startGame();
          m.dispose();
        }
      });
        return empezar;
    }
    public  JButton conquistar(int i){
              
        JButton empezar = new JButton("Enviar");
         empezar.setBounds(150, 100, 100, 30);
        empezar.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getName());
            }
        });
        return empezar;
    }
}

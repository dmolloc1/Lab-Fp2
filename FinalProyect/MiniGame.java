import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class MiniGame extends JFrame {
    protected JFrame game;
    protected JPanel panel;
    protected String[][] indQuestion;
    protected Boolean win ;
    protected Reader r;
    protected Map map;
    protected int indice, player;

    public MiniGame(Map m, int ind, int p){
        this.map = m;
        this.indice = ind;
        this.player = p;
    }
    public boolean getWin(){
        return this.win;
    }
    public void individual(){
        int i = (int)(Math.random()*2 + 1);
        switch (i) {
            case 1:
                AlternativeGame ag = new AlternativeGame(map, indice, player);
                ag.getResult();
                break;
            case 2://Adivinanza
                Guess g = new Guess(map, indice, player);
                System.out.println("Funcion prueba");
                g.play();
                break; 
            default:
                break;
        }
    }
    
    public void show(JLabel l, JPanel panel, Map m){
        this.setSize(500,200);
        this.setLayout (new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.setLocationRelativeTo(null);    
        this.add(l, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(itemButton(m), BorderLayout.WEST);
        this.setVisible(true);
    } 
    //Botones para usar los items
    public JButton itemButton(Map map){
        MiniGame mg = this;
        JButton it = new JButton("Items");
        it.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Items.useItems(map.getCastle(player), mg);
                
            }
        });
        return it;
    }
}

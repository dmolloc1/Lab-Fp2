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
    protected Boolean useIt ;
    protected Reader r;
    protected Map map;
    protected int indice, player;
    private AlternativeGame ag;
    private Guess g;
    private TresEnRaya tR;

    public MiniGame(Map m, int ind, int p){
        this.map = m;
        this.indice = ind;
        this.player = p;
    }

    public void individual(){
        int i = (int)(Math.random()*2 ) + 1;
        switch (i) {
            case 1:
                ag = new AlternativeGame(map, indice, player);
                ag.play();
                break;
            case 2://Adivinanza
                g = new Guess(map, indice, player);
                System.out.println("Funcion prueba");
                g.play();
                break;

            default:
                break;
        }
    }
    public void group(){
        int i = (int)(Math.random()*2 ) + 1;
        switch (i) {
            case 1:
                tR = new TresEnRaya(map, indice, player);
                tR.play();
                break;
            case 2://Adivinanza
                g = new Guess(map, indice, player);
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
        MiniGame m = this;
        JButton it = new JButton("Items");
        it.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Items.useItems(map.getCastle(player), m);
            }
        });
        return it;
    }
    public void useItems(String type){
        System.out.println("Justo antes de los if");
        if(g != null){
            g.useItems(type);
        }else if(ag != null){
            ag.useItems(type);
        }else if(tR != null){
            tR.useItems(type);
        }
    }
}

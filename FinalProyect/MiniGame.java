import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class MiniGame extends JFrame {
    private int points;
    private JFrame game;
    private JPanel panel;
    private String[][] indQuestion;
    private Boolean win ;
    public MiniGame(){
        int i = (int)(Math.random()*3 + 1);
        switch (i) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
    public boolean culturalQuestion(){
        game = new JFrame("Mini Game");
        panel = new JPanel(new GridLayout(4,1));

        return true;
    }
    public String[][] readFile(/*Que suba el archivo */){
        //Ingresar código para lectura
        indQuestion = new String[9][4];
        return indQuestion;
    }
    public void playIndividual(){
        MiniGame mgame = this;
        int i = (int)(Math.random()*this.indQuestion.length);
        panel = new JPanel(new GridLayout(indQuestion[i].length, 1));
        //Post: agregar una columna despues de la pregunta que diga cual es la respuesta 
        int resp = Integer.parseInt(indQuestion[i][1]) ;
        int j = 2;
        for (j = 2; j < indQuestion[i].length ; j ++){
            JButton b = new JButton(indQuestion[i][j]); 
            if(j == resp){
                b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mgame.win =true;
                    b.setBackground(Color.GREEN);
                }
            });
            }else{
                b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    b.setBackground(Color.RED);
                }
            });
            }
            panel.add(b);
        }
        //Pregunta
        game = new JFrame("MiniGame");
        JLabel question = new JLabel(indQuestion[i][0]);
        game.setSize(500,200);
        game.setLayout (new BorderLayout());
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);       
        game.setLocationRelativeTo(null);    
        game.add(question, BorderLayout.NORTH);
        game.add(panel, BorderLayout.CENTER);
        game.setVisible(true);   
    }

    public Boolean getWin(Boolean w){
        return this.win = w;
    }
}

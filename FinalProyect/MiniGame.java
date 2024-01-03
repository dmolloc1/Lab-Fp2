import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class MiniGame extends JFrame {
    private JFrame game;
    private JPanel panel;
    private String[][] indQuestion;
    private Boolean win ;
    private Reader r;
    
    public boolean getWin(){
        return this.win;
    }
    public Boolean individual(){
        this.win = false;
        int i = (int)(Math.random()*3 + 1);
        switch (i) {
            case 1:
                this.win = culturalQuestion();
                break;
            case 2://Adivinanza
                this.win = culturalQuestion();
                break;
            default:
            
                break;
        }
        return this.win;
    }
    public Boolean culturalQuestion(){
        r = new Reader();
        String f =  "./File/cultural.csv.csv";
        indQuestion = r.getData(f);
        System.out.println(indQuestion[1].length);
        this.win = multipleChoice();
        return this.win;
    
    }
 /*   public String[][] readFile(/*Que suba el archivo ){
        //Ingresar código para lectura
        indQuestion = new String[9][4];
        return indQuestion;
    }*/
    public Boolean multipleChoice(){
        MiniGame mgame = this;
        int len = indQuestion.length;
        int i = (int)(Math.random()*len);
        panel = new JPanel(new GridLayout(len ,1, 5,5));
        //Post: agregar una columna despues de la pregunta que diga cual es la respuesta 
        int resp = Integer.parseInt(indQuestion[i][1]) ;
        System.out.println(indQuestion[i][5]);
        int j = 2;
        for (j = 2; j < indQuestion[i].length; j++) {
            JButton b = new JButton(indQuestion[i][j]);
            if (j == resp) {
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mgame.win = true;
                        b.setBackground(Color.green);
                        game.dispose();
                        //mgame.continueGame();
                    }
                });
            } else {
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.setBackground(Color.RED);
                        b.setForeground(Color.white);
                        mgame.win = false;
                        game.dispose();
                        //mgame.continueGame();
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
        return mgame.win;
    }

    public Boolean getWin(Boolean w){
        return this.win = w;
    }
    public void continueGame(){
        
            this.game.dispose();
        
    }

}

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
    private Map map;
    private int indice, player;

    public MiniGame(Map m, int ind, int p){
        this.map = m;
        this.indice = ind;
        this.player = p;
    }
    public boolean getWin(){
        return this.win;
    }
    public Boolean individual(){
        int i = (int)(Math.random()*2 + 1);
        switch (i) {
            case 1:
                return  culturalQuestion();
                
            case 2://Adivinanza
                return  culturalQuestion();
            default:
                break;
        }
        return false;
    }
    public Boolean culturalQuestion(){
        r = new Reader();
        String f =  "./File/cultural.csv.csv";
        indQuestion = r.getData(f);
        System.out.println(indQuestion[1].length);
        
        return this.multipleChoice();
    }
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
                       
                        JOptionPane.showMessageDialog(null, "¡Ganaste!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        int result = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            mgame.map.play(mgame.indice, mgame.player, true);
                            BattleGame.endGame();
                            BattleGame.continueGame(true);
                            game.dispose();
                        } else {
                            BattleGame.continueGame(false);
                            BattleGame.endGame();
                            game.dispose();
                        }
                        
                    }
                });
            } else {
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.setBackground(Color.RED);
                        b.setForeground(Color.white);
                        mgame.win = false;
                        JOptionPane.showMessageDialog(null, "¡Oh, suerte a la próxima!", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
                        int result2 = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result2 == JOptionPane.YES_OPTION) {
                            mgame.map.play(mgame.indice, mgame.player,false);
                            BattleGame.endGame();
                            BattleGame.continueGame(true);
                            game.dispose();
                        } else {
                            BattleGame.continueGame(false);
                            BattleGame.endGame();
                            game.dispose();
                        }
                        
                        //mgame.continueGame();
                    }
                });
            }
            
            panel.add(b);
        }
        //Pregunta
        JLabel question = new JLabel(indQuestion[i][0]);
        mgame.show(question, panel, this.map );
        return mgame.win;
    }  
    public void show(JLabel l, JPanel panel, Map m){
        game = new JFrame("MiniGame");
        game.setSize(500,200);
        game.setLayout (new BorderLayout());
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);       
        game.setLocationRelativeTo(null);    
        game.add(l, BorderLayout.NORTH);
        game.add(panel, BorderLayout.CENTER);
        game.add(itemButton(m), BorderLayout.WEST);
        game.setVisible(true);
    } 
    //Botones para usar los items
    public JButton itemButton(Map map){
        JButton it = new JButton("Items");
        it.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Items.useItems(map.getCastle(player));
                
            }
        });
        return it;
    }
}

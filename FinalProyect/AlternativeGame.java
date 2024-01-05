import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class AlternativeGame extends MiniGame {
    private int indArchivo;
    public AlternativeGame(Map m, int ind, int p) {
        super(m, ind, p);
        r = new Reader();
        String f =  "./File/cultural.csv.csv";
        indQuestion = r.getData(f);
        System.out.println(indQuestion[1].length);
    }
    public void play(){
        MiniGame mgame = this;
        int len = indQuestion.length;
        int i = (int)(Math.random()*len);
        this.indArchivo = i;
        this.panel = new JPanel(new GridLayout(len ,1, 5,5));
        //Post: La segunda columna del array es el indice de la respuesta de la pregunta 
        int resp = Integer.parseInt(indQuestion[i][1]) ;
        System.out.println(indQuestion[i][5]);
        int j = 2;
        for (j = 2; j < indQuestion[i].length; j++) {
            JButton b = new JButton(indQuestion[i][j]);
            if (j == resp) {
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "¡Ganaste!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        int result = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            mgame.map.play(mgame.indice, mgame.player, true);
                            BattleGame.endGame();
                            BattleGame.continueGame(true);
                            mgame.dispose();
                        } else {
                            BattleGame.continueGame(false);
                            BattleGame.endGame();
                            mgame.dispose();
                        }
                        
                    }
                });
            } else {
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.setBackground(Color.RED);
                        b.setForeground(Color.white);
                        
                        JOptionPane.showMessageDialog(null, "¡Oh, suerte a la próxima!", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
                        int result2 = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result2 == JOptionPane.YES_OPTION) {
                            mgame.map.play(mgame.indice, mgame.player,false);
                            BattleGame.endGame();
                            BattleGame.continueGame(true);
                            mgame.dispose();
                        } else {
                            BattleGame.continueGame(false);
                            BattleGame.endGame();
                            mgame.dispose();
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
    }
    public void useItems(String t){
        switch (t) {
            case "loro":
                JOptionPane.showMessageDialog(null, "la respuesta es " + indQuestion[indArchivo][1], "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "escalera":
                JOptionPane.showMessageDialog(null, indQuestion[indArchivo][indQuestion[indArchivo].length - 1], "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                break; 
            case "escudo":
            JOptionPane.showMessageDialog(null,"ESCUDO: El juego se termino" , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                break;   
            default:
                break;
        }
    }
}

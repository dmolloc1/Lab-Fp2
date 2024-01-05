import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guess extends MiniGame {
    private JTextField textField;
    private JLabel labelResult;
    private int numeroAleatorio;
    private int intentos;
    private JPanel panel;
    private Boolean result;
    public Guess(Map m, int ind, int p) {
        super(m, ind, p);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        Random random = new Random();
        numeroAleatorio = random.nextInt(100) + 1; // Genera número aleatorio entre 1 y 100

        panel.setSize(300, 150);
    }

    public boolean play(){
        MiniGame mg = this;
        result = this.win;
        intentos = 0;

        JLabel labelInstruccion = new JLabel("Adivina el número entre 1 y 100:");
        
        JTextField textField = new JTextField(10);
        panel.add(textField);

        JLabel labelResult = new JLabel("");
        panel.add(labelResult);

        JButton buttonGuess = new JButton("Adivinar");
        panel.add(buttonGuess);

        buttonGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(textField.getText());

                if (intentos <= 3) {
                    if (guess == numeroAleatorio) {
                        labelResult.setText("¡Correcto! Has adivinado el número en " + intentos + " intentos.");
                        textField.setEditable(false);
                        result = true;
                        mg.map.play(mg.indice, mg.player, true);
                        BattleGame.endGame();
                        BattleGame.continueGame(true);
                        mg.dispose();
                    } else if (guess < numeroAleatorio) {
                        labelResult.setText("El número es mayor. Intenta de nuevo.");
                    } else {
                        labelResult.setText("El número es menor. Intenta de nuevo.");
                    }
                } else {
                    labelResult.setText("Ya no tienes más intentos.");
                    textField.setEditable(false);
                    result = false;
                    BattleGame.endGame();
                    BattleGame.continueGame(true);
                    mg.dispose();
                }
                intentos++;
            }
        });
        show(labelInstruccion, panel, map);
        return result; 

    }
    public void showMessa(){
        if(result){
            JOptionPane.showMessageDialog(null, "¡Ganaste!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            int result = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                this.map.play(this.indice, this.player, true);
                BattleGame.endGame();
                BattleGame.continueGame(true);
                this.dispose();
                } else {
                BattleGame.continueGame(false);
                BattleGame.endGame();
                this.dispose();
            }            
        }
    }
}

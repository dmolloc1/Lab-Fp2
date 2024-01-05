import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TresEnRaya extends MiniGame{
    private final int GRID_SIZE = 3;
    private final JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
    private boolean playerXTurn = true;
    private JLabel text;

    public TresEnRaya(Map m, int ind, int p) {
        super(m, ind, p);
    }

    private void thereAreWinner() {
        if (checkForWin()) {
            String winner;
            if(player == 1){
               winner = playerXTurn ? "Jugador 2" : "Jugador 1"; 
               if(playerXTurn){this.map.play(this.indice, 2,true);}
               else{this.map.play(this.indice, 1,true);}
            }else{winner = playerXTurn ? "Jugador 1" : "Jugador 2";
                JOptionPane.showMessageDialog(null, winner + " ganó!");
                if(playerXTurn){this.map.play(this.indice, 1,true);}
                else{this.map.play(this.indice, 2,true);}
            }
            //Condicion que un jugador perdio su base
            if((winner.equals("Jugador 1") && indice == 7) ||(winner.equals("Jugador 2") && indice == 12)){

                
                int result = JOptionPane.showConfirmDialog(null, "La partida termino.Desea guardar en un archivo la partida?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    BattleGame.endGame();
                    BattleGame.continueGame(true);
                    this.dispose();
                } else {
                    BattleGame.continueGame(false);
                    BattleGame.endGame();
                    this.dispose();
                }
            }else{
                int result = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Continuar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
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

    public  void play() {
        JPanel panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(100, 100));
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getText().isEmpty()) {
                            if (playerXTurn) {
                                clickedButton.setText("X");
                            } else {
                                clickedButton.setText("O");
                            }
                            playerXTurn = !playerXTurn;
                        }
                        thereAreWinner(); 
                    }
                });

                buttons[i][j] = button;
                panel.add(button);
            }
        }
        text = new JLabel("Juego de tres en raya");
        show(text, panel, map);
    }

    private  boolean checkForWin() {
        // Verifica las filas
        for (int i = 0; i < GRID_SIZE; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][0].getText().equals(buttons[i][2].getText())
                    && !buttons[i][0].getText().isEmpty()) {
                return true;
            }
        }
    
        // Verifica las columnas
        for (int j = 0; j < GRID_SIZE; j++) {
            if (buttons[0][j].getText().equals(buttons[1][j].getText())
                    && buttons[0][j].getText().equals(buttons[2][j].getText())
                    && !buttons[0][j].getText().isEmpty()) {
                return true;
            }
        }
    
        // Verifica las diagonales
        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[0][0].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().isEmpty()) {
            return true;
        }
    
        if (buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[0][2].getText().equals(buttons[2][0].getText())
                && !buttons[0][2].getText().isEmpty()) {
            return true;
        }
    
        return false;
    }
    public void useItems(String t){
        switch (t) {
            case "loro":
                JOptionPane.showMessageDialog(null, "Item no valido " , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "escalera":
                JOptionPane.showMessageDialog(null, "Item no valido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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

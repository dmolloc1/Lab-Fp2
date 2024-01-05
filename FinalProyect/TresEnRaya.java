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
            String winner = playerXTurn ? "Jugador 2" : "Jugador 1";
            JOptionPane.showMessageDialog(null, winner + " ganó!");
            System.exit(0);
        }
    }

    private  void play() {
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
}

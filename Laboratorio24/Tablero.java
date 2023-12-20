import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JFrame {

    private JPanel panel;
    private JTextField filaTextField;
    private JTextField columnaTextField;

    public Tablero(Mapa map) {
        setTitle("Campo de Batalla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600); // Ajusta el tamaño de la ventana

        // Panel para el párrafo de texto
        JTextArea mensajeTextArea = new JTextArea("Campo de Batalla");
        mensajeTextArea.setEditable(false);
        mensajeTextArea.setLineWrap(true);
        mensajeTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(mensajeTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 80));
        add(scrollPane, BorderLayout.NORTH);

        JPanel numerosPanel = new JPanel(new GridLayout(10, 1));
        for (int i = 1; i <= 10; i++) {
            JLabel label = new JLabel(Integer.toString(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            numerosPanel.add(label);
        }
        add(numerosPanel, BorderLayout.WEST);

        // Panel para etiquetas de columnas (A-J)
        JPanel letrasPanel = new JPanel(new GridLayout(1, 10));
        for (char c = 'A'; c <= 'J'; c++) {
            JLabel label = new JLabel(Character.toString(c));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            letrasPanel.add(label);
        }
        add(letrasPanel, BorderLayout.NORTH);

        // Panel para el tablero
        panel = new JPanel(new GridLayout(10, 10));
        crearTablero(map);
        add(panel, BorderLayout.CENTER);
        

        setVisible(true);
    }
    
   /*  private void tableroMover(Mapa map){

        Tablero tablero = new Tablero(map);
        JButton bMover = new JButton("Mover");
        bMover.addActionListener(new ActionListener() {
            
        })*/
   // }

    private void crearTablero(Mapa map) {
        Color color1 = Color.YELLOW;
        Color color2 = Color.GREEN;
        String fila = "";

        for (int i = 0; i < 10 ;i++) {
            for (int j = 0; j < 10; j++) {
                JPanel cuadro = new JPanel();
                cuadro.setPreferredSize(new Dimension(100, 50));
                cuadro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                if (map.mapaR[i][j] == null) {
                    cuadro.setBackground(Color.WHITE);
                } else {
                    fila = "";
                    if(map.mapaR[i][j].getColor().equals("1")){
                    cuadro.setBackground(color1);
                    } else {cuadro.setBackground(color2);
                    }

                    if (map.mapaR[i][j].size() > 9) {
                        fila += " "  + map.mapaR[i][j].size() + "-";
                    } else {
                        fila += "  " + map.mapaR[i][j].size() + "-";
                    }
    
                    // Modificación para permitir que el nivel de vida llegue a 100
                    if (map.mapaR[i][j].totalNivelVida() > 99) {
                        fila += map.mapaR[i][j].totalNivelVida();
                    } else if (map.mapaR[i][j].totalNivelVida() > 9) {
                        fila += " " + map.mapaR[i][j].totalNivelVida();
                    } else {
                        fila += "  " + map.mapaR[i][j].totalNivelVida();
                    }
                    JLabel letra = new JLabel(fila);
                    letra.setForeground(Color.BLACK);
                    cuadro.add(letra);
                }
                
                panel.add(cuadro);
            }
        }
    }

   /*  public static void main(String[] args) {
        Mapa mapa = new Mapa();
        new Tablero(mapa);
    }*/
}

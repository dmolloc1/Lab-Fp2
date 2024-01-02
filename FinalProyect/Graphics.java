import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics {
    private JFrame frame;
    private GPicture window;
    private JLayeredPane layeredPane;
    private int player;
    private JButton player1, player2;
    public Graphics(Image pic, Map map) {
        frame = new JFrame("BATTLE FIELD");
        window = new GPicture(pic);

        frame.setSize(900, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(window, BorderLayout.CENTER);

        // Crear un JLayeredPane para superponer botones sobre la imagen
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 300));
        frame.add(layeredPane, BorderLayout.CENTER);

        // Agregar la imagen al fondo del JLayeredPane
        layeredPane.add(window, JLayeredPane.DEFAULT_LAYER);

        // Crear y agregar botones transparentes con números del 1 al 16
        int buttonWidth = 173;
        int buttonHeight = 70;
        int rows = 4;
        int cols = 4;
        int buttonCount = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton(String.valueOf(buttonCount));
                button.setBounds(j * buttonWidth, i * buttonHeight, buttonWidth, buttonHeight);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(true);
                button.setForeground(Color.black); // Cambiar el color del texto si es necesario
                button.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    map.play(Integer.parseInt(button.getText()) - 1, player);
                    System.out.println(button.getText()+ "fddddd" + player);

                  }
                  
                });
                layeredPane.add(button, JLayeredPane.PALETTE_LAYER);
                buttonCount++;
            }
        }
            //TITULO
        JPanel section1 = new JPanel(new FlowLayout());
        JLabel titulo = new JLabel("La batalla  ha comenzado");
        player1 = new JButton("Jugador 1");
        player1.addActionListener(new ActionListener() {
          @Override
                  public void actionPerformed(ActionEvent e) {
                    player = 1;
                    player2.setBackground(null);
                    player1.setBackground(Color.ORANGE);
                  }
        });
        player2 = new JButton("Jugador 2");
        player2.addActionListener(new ActionListener() {
          @Override
                  public void actionPerformed(ActionEvent e) {
                    player = 2;
                    player1.setBackground(null);
                    player2.setBackground(Color.ORANGE);
                  }
        });
        section1.add(player1);
        section1.add(player2);
        frame.add(section1, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void print() {
        frame.repaint();
        frame.setVisible(true);
    }
}


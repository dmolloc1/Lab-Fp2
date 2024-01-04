import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

        frame.setSize(870, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(window, BorderLayout.CENTER);

        // Crear un JLayeredPane para superponer botones sobre la imagen
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 283));
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
                button.addActionListener(new Listener(map, button) );
                layeredPane.add(button, JLayeredPane.PALETTE_LAYER);
                buttonCount++;
            }
        }
            //BOTONES DE JUGADORES
        
        frame.add(this.partNorth(map), BorderLayout.NORTH);
        frame.add(this.partEast(map), BorderLayout.EAST);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void print() {
        frame.repaint();
        frame.setVisible(true);
    }
    public void again(){
      this.frame.dispose();
    }
    private class Listener implements ActionListener{
      private Map map;
      private JButton button;
      public Listener(Map map, JButton b){
        this.map = map;
        this.button = b;
      }
      public void actionPerformed(ActionEvent e) {
        System.out.println(this.button.getText()+ "fddddd" + player);
        MiniGame mg = new MiniGame(map,Integer.parseInt(this.button.getText()) - 1, player);
        if(this.map.typeMiniGame(Integer.parseInt(this.button.getText()) - 1, player)){
          mg.individual();
        }
        //this.map.play(Integer.parseInt(this.button.getText()) - 1, player);
      }      
    }

    //Componentes
          //Componentes
    public JPanel partNorth(Map map){
      JPanel section1 = new JPanel(new FlowLayout());
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
        //BOTON DE COMPRA
        JButton squareButton = new JButton();
        squareButton.setPreferredSize(new Dimension(50, 50)); 
        squareButton.setIcon(new ImageIcon("./img/logo_comprar.png")); // Ruta a la imagen
        squareButton.setContentAreaFilled(false); // Hace que el área de contenido no esté pintada
        squareButton.setBorderPainted(false);
        squareButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
              Items.showItems(map.getCastle(player));
            }
        });
        section1.add(player1);
        section1.add(player2);
        section1.add(squareButton);
        return section1;
      }
     
      public JPanel partEast(Map m) {
        JPanel panel = new JPanel(new GridLayout(3, 1,5,5)); // 3 filas
        panel.setPreferredSize(new Dimension(90, 10)); // Tamaño: 100x80

        JLabel label1 = new JLabel("Points");
        panel.add(createRow(label1));

        JLabel label2 = new JLabel("Jugador 1: "+ m.getCastle(1).getPoints()); 
        panel.add(createRow(label2));

        JLabel label3 = new JLabel("Jugador 2: "+ m.getCastle(2).getPoints());
        panel.add(createRow(label3));

        return panel;
    }

    private static JPanel createRow(JLabel label) {
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new BorderLayout());
        rowPanel.add(label, BorderLayout.WEST);
        rowPanel.setBorder(new EmptyBorder(1, 1, 1, 1)); 

        return rowPanel;
    }
}


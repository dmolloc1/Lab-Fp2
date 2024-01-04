import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Items {
    public static final HashMap<String, Integer> items;
    private static int points;

    static {
        items = new HashMap<>();
        items.put("escudo", 120);
        items.put("loro", 80);
        items.put("escalera", 50);
    }

    public static void buyItems(Castle c, String i) {
        if (c.getPoints() >= items.get(i)) {
            c.buyItems(i);
            System.out.println("compro");
        }else{
            JOptionPane.showMessageDialog(null, "No tienes suficientes puntos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void showItems(Castle c) {
        JFrame frame = new JFrame();
        frame.setSize(843, 675);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLayeredPane para manejar superposición de componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 600));

        // Imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("./img/ITEMS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 820, 675);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Botón 1
        JButton button1 = new JButton("Buy Escudo");
        button1.setBounds(110, 530, 120, 30); // Establece la posición y el tamaño del botón
        button1.setBackground(new Color(211, 172, 252));
        button1.setForeground(Color.BLACK);
        button1.addActionListener(new Listener(c, "escudo", frame));
        layeredPane.add(button1, JLayeredPane.PALETTE_LAYER); // Cambia la capa según sea necesario

        // Botón 2
        JButton button2 = new JButton("Buy Loro");
        button2.setBounds(370, 530, 120, 30);
        button2.setBackground(new Color(250, 187, 249));
        button2.setForeground(Color.BLACK);
        button2.addActionListener(new Listener(c, "loro", frame));
        layeredPane.add(button2, JLayeredPane.PALETTE_LAYER);


        // Botón 3
        JButton button3 = new JButton("Buy Escalera");
        button3.setBounds(640, 530, 120, 30);
        button3.setBackground(new Color(153, 238, 240));
        button3.setForeground(Color.BLACK);
        button3.addActionListener(new Listener(c, "escalera", frame));
        layeredPane.add(button3, JLayeredPane.PALETTE_LAYER);

        frame.add(layeredPane);
        frame.setVisible(true);
    }

    private static class Listener implements ActionListener {
        private Castle c;
        private String i;
        private JFrame frame;

        public Listener(Castle c, String i, JFrame f) {
            this.c = c;
            this.i = i;
            this.frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buyItems(c, i);
            BattleGame.endGame();
            BattleGame.continueGame(true);
            frame.dispose();
            //this.map.play(Integer.parseInt(this.button.getText()) - 1, player);
        }
    }
    public static void useItems(Castle c, MiniGame mg){
        JFrame frame = new JFrame();
        frame.setSize(750, 613);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JLayeredPane para manejar superposición de componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(720, 575));

        // Imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("./img/useItems.jpeg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 720, 575);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Botón 1
        JButton button1 = new JButton("Cantidad :" + c.getItem("escudo"));
        button1.setBounds(50, 460, 170, 40); // Establece la posición y el tamaño del botón
        button1.setBackground(new Color(211, 172, 252));
        button1.setForeground(Color.BLACK);
        //button1.addActionListener(new Listener(c, "escudo", frame));
        layeredPane.add(button1, JLayeredPane.PALETTE_LAYER); // Cambia la capa según sea necesario

        // Botón 2
        JButton button2 = new JButton("Cantidad :" + c.getItem("loro"));
        button2.setBounds(283, 460, 170, 40);
        button2.setBackground(new Color(250, 187, 249));
        button2.setForeground(Color.BLACK);
        //button2.addActionListener(new Listener(c, "loro", frame));
        layeredPane.add(button2, JLayeredPane.PALETTE_LAYER);


        // Botón 3
        JButton button3 = new JButton("Cantidad :" + c.getItem("escalera"));
        button3.setBounds(500, 460, 170, 40);
        button3.setBackground(new Color(153, 238, 240));
        button3.setForeground(Color.BLACK);
       // button3.addActionListener(new Listener(c, "escalera", frame));
        layeredPane.add(button3, JLayeredPane.PALETTE_LAYER);

        //Botón Back
        JButton back = new JButton("Regresar");
        back.setBounds(230, 50, 240, 35); // Establece la posición y el tamaño del botón
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();     
            }
        });
        layeredPane.add(back, JLayeredPane.PALETTE_LAYER);

        frame.add(layeredPane);
        frame.setVisible(true);
    }
}

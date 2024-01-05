import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton botonManual, botonRestaurar, botonComenzar;
    private JLabel imagenFondo;
    

    public Menu () {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 900);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(700, 900));

        // Imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("./img/Menu.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 820, 700);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        JButton buttonManual = new JButton("Manual de Usuario");
        buttonManual.setBounds(310, 330, 300,50); 
        buttonManual.setBackground(Color.white);
        buttonManual.setForeground(Color.BLACK);
        layeredPane.add(buttonManual, JLayeredPane.PALETTE_LAYER); 
;
        JButton buttonRestaurar = new JButton("Restaurar Archivo");
        buttonRestaurar.setBounds(310, 400,300,50);
        buttonRestaurar.setBackground(Color.white);
        buttonRestaurar.setForeground(Color.BLACK);
        layeredPane.add(buttonRestaurar, JLayeredPane.PALETTE_LAYER); 
       
        JButton buttonStar = new JButton("Comenzar");
        buttonStar.setBounds(310, 470, 300,50); 
        buttonStar.setBackground(Color.white);
        buttonStar.setForeground(Color.BLACK);
        layeredPane.add(buttonStar, JLayeredPane.PALETTE_LAYER); 
        
       

        // Agregar acciones a los botones
        buttonManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manual();
            }
        });

        buttonRestaurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //el de leer archivos 
            }
        });
        Menu m = this;
        buttonStar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BattleGame bg = new BattleGame();
                bg.startGame();
                m.dispose();
            }
        });

        add(layeredPane);
        setVisible(true);
    }
    public void manual(){
        JFrame v = new JFrame("Menu");
        v.setTitle("Menú Principal");
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setSize(600, 500);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 500));

        // Imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("./img/manual.jpeg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 720, 500);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        JButton button = new JButton("Back");
        button.setBounds(0, 0, 100,50); 
        button.setBackground(Color.white);
        button.setForeground(Color.BLACK);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
        layeredPane.add(button ,JLayeredPane.PALETTE_LAYER); 
        v.add(layeredPane);
        v.setVisible(true);
;
    }
    public static void main(String[] args) {
        Menu m = new Menu();
    }
}


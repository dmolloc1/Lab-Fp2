import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Permite ver un arreglo de String como una imagen
public class Graphics{
  private JFrame frame;
  private GPicture window;

  public Graphics(Image pic){
    frame = new JFrame("BATTLE FIELD");
    window = new GPicture(pic);
  
    frame.setSize(window.getWidth() + 5, window.getHeight() + 40);
    frame.setLayout (new BorderLayout());
    frame.setLocationRelativeTo(null);
    frame.add(window, BorderLayout.CENTER);
    // frase
    String mensaje= "Ingrese dirección a conquistar(I = ⬅ , D = ➡ , A = ⬆ , B = ⬇ , DIS = ⬉ , DII = ⬋, DDS = ⬈, DDI = ⬊ )";
    JLabel texto = new JLabel(mensaje);
    frame.add(texto, BorderLayout.BEFORE_FIRST_LINE);
    //cuadrado de texto
    JTextField resp = new JTextField();
    resp.setBounds(20, 60, 300, 30);
    frame.add(resp, BorderLayout.AFTER_LAST_LINE);
    

    //boton
    JButton empezar = new JButton("Enviar");
    empezar.setBounds(150, 100, 100, 30);
      empezar.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
          String respuesta = resp.getText();
          BattleGame.jugar(respuesta);
        }
      });
    frame.add(empezar, BorderLayout.NORTH );
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

  }
 //Mostrar la imagen
  public void print(){
    frame.repaint();
    frame.setVisible(true);
  }
}

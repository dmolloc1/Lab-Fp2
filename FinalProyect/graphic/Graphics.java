package graphic;
import javax.swing.*;
//Permite ver un arreglo de String como una imagen
public class Graphics{
  private JFrame frame;
  private GPicture window;

  public Graphics(Image pic){
    frame = new JFrame("BATTLE FIELD");
    window = new GPicture(pic);
    frame.add(window);
    frame.setSize(window.getWidth() + 5, window.getHeight() + 5);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 //Mostrar la imagen
  public void print(){
    frame.repaint();
    frame.setVisible(true);
  }
}
package graphic;
import javax.swing.*;
/**
 * This class let you see an interpretation of a String array
 * as an graphics image in a window.
 */
public class Graphics{
  private JFrame frame;
  private GPicture window;
  /**
   * The constructors needs an instance of Picture
   * @param pic a String array that will be interpreted as an graphics
   * image
   */
  public Graphics(Image pic){
    frame = new JFrame("BATTLE FIELD");
    window = new GPicture(pic);
    frame.add(window);
    frame.setSize(window.getWidth() + 5, window.getHeight() + 5);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  /*
  public void refresh (Image pic) {
    GPicture n = new GPicture(pic);
    frame.remove(window);
    
    window = new GPicture(pic);
    frame.add(window);
    //frame.setSize(currentW.getWidth() + 5, currentW.getHeight() + 28);
    frame.repaint();
   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void closeBoard() {
    frame.remove(window);
    frame.repaint();
    frame.setVisible(false);
    window = null;
    frame = null;
  }
*/
  /**
   * Shows the imagen in a JFrame window.
   */
  public void print(){
    frame.repaint();
    frame.setVisible(true);
  }
}
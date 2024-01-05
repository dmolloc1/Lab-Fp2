import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Reader{
  private String[][] basedata;
  private String [] parts;
  private ArrayList<String[]> questions = new ArrayList<>();

  public String[][] getData(String f){
    readDataFile(f);
    basedata = questions.toArray(new String[questions.size()][parts.length]);
    return basedata;
  }

  private void readDataFile(String f){
    Scanner fileIn;
    String line;
    try{
 
    fileIn = new Scanner (new FileReader(f));
    while (fileIn.hasNextLine()){
      line = fileIn.nextLine();
      parts = line.split(";");
        questions.add(parts);
    }
    fileIn.close();
    }
    catch(FileNotFoundException e){
      JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage());
    }

  }
  public void saveGame(BattleGame bg){
            String nameFile = JOptionPane.showInputDialog("Nombre del Archivo:");
           
        try {
            FileOutputStream fileOut = new FileOutputStream(nameFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(bg.getMap());
            objectOut.writeObject(bg.getMap().getCastle(1));
            objectOut.writeObject(bg.getMap().getCastle(2));

            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }

  public BattleGame openSavedGame(String f){
    BattleGame bg;
    try {
      FileInputStream fileIn = new FileInputStream(f); 
      ObjectInputStream objectIn = new ObjectInputStream(fileIn);

      
      Map map = (Map) objectIn.readObject();
      Castle c1 = (Castle) objectIn.readObject();
      Castle c2 = (Castle) objectIn.readObject();
      
      objectIn.close();
      fileIn.close();
      return bg = new BattleGame(map, c1, c2);
      
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    bg = new BattleGame();
    return bg;
  }
  public static void main(String[] args){
    Reader r = new Reader();
    String f =  "./File/cultural.csv";
    String[][] indQuestion = r.getData(f);
    System.out.println(indQuestion[4][5] + " " + indQuestion[1].length);
  }
}

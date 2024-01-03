import java.io.*;
import java.util.*;
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
    BufferedReader reader = null;
    String line = "";
    try {
      FileReader fileReader = new FileReader(f);
      reader = new BufferedReader(fileReader);
      while ((line = reader.readLine()) != null) {
        parts = line.split(";");
        questions.add(parts);
      }
    }catch (Exception exception){
      exception.printStackTrace();
    }finally{
      try{ reader.close();} catch (Exception exception){}
    }
  }

  public static void main(String[] args){
    Reader r = new Reader();
    String f =  "./File/cultural.csv.csv";
    String[][] indQuestion = r.getData(f);
    System.out.println(indQuestion[1][5] + " " + indQuestion[1].length);
  }
}

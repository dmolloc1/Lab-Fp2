import java.io.*;
import java.util.*;
public class FileReader{
  private String[][] basedata;
  private String [] parts;
  private ArrayList<String[]> questions = new ArrayList<>();

  public String[][] getData(){
    readDataFile();
    basedata = questions.toArray(new String[questions.size()][parts.length]);
    return basedata;
  }

  private void readDataFile(){
    BufferedReader reader = null;
    String line = "";
    try {
      FileReader fileReader = new FileReader("h.cvs");
      reader = new BufferedReader(fileReader);
      while ((line = reader.readLine()) != null) {
        parts = line.split(",");
        questions.add(parts);
      }
    }catch (Exception exception){
      exception.printStackTrace();
    }finally{
      try{ reader.close();} catch (Exception exception){}
    }
  }

  public static void main(String[] args){
      ReaderP r = new ReaderP();
      String [][] a = r.getData();
      System.out.println(a[0][0] + "Hola");
  }
}

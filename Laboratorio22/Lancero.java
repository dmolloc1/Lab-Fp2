public class Lancero extends Soldado{
    private int longLanza;
    
    public Lancero(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int lanza){
    	super(n, nV, nA, nD, v, act, vive, c);
        this.longLanza = lanza;
    }
    public void schiltrom(){
        this.setNivelDefensa(this.getNivelDefensa() + 1);
    }
}


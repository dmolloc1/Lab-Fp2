public class Lancero extends Soldado{
    private int longLanza;
    
    public Lancero(String nombre, int nVida, int nAtaque, int nDefensa, int v, String act, boolean vive, String color, int longLanza){
    	super(nombre, nVida, nAtaque, nDefensa, v, act, vive, color);
        this.longLanza = longLanza;
    }
    public void schiltrom(){
        this.setNivelDefensa(this.getNivelDefensa() + 1);
    }
}


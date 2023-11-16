public class Espadachin extends Soldado{
    private int longEspada;
    
    public Espadachin(String nombre, int nVida, int nAtaque, int nDefensa, int v, String act, boolean vive, String color, int espada){
    	super(nombre, nVida, nAtaque, nDefensa, v, act, vive, color);
        this.longEspada =  espada;
    }
    public void muroEscudos(){}
}

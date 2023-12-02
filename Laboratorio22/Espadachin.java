public class Espadachin extends Soldado{
    protected int longEspada;
    protected String arma ;
    public Espadachin(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int espada){
    	super(n, nV, nA, nD, v, act, vive, c);
        this.longEspada =  espada;
        this.arma = "Espada";
    }
    public void ataque(){}
}

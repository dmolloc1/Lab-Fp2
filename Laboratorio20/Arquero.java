public class Arquero extends Soldado{
    private int flechas;
    
    public Arquero(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int flechas){
    	super(nombre, nV, nA, nD, v, act, vive, c);
        this.flechas =  flechas;
    }
    public void disparar(){
        this.flechas = this.flechas - 1;
        this.atacar();
    }
}


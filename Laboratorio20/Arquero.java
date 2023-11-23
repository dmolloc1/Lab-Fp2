public class Arquero extends Soldado{
    private int flechas;
    
    public Arquero(String nombre, int nVida, int nAtaque, int nDefensa, int v, String act, boolean vive, String color, int flechas){
    	super(nombre, nVida, nAtaque, nDefensa, v, act, vive, color);
        this.flechas =  flechas;
    }
    public void disparar(){
        this.flechas = this.flechas - 1;
        this.atacar();
    }
}


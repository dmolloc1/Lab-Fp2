public class Caballero extends Soldado{
    private boolean montar;
    protected String arma;
    protected int longArma;
    public Caballero(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, boolean montar){
    	super(n, nV, nA, nD, v, act, vive, c);
        this.montar =  montar;
        this.longArma = 1;
    }
    public void montar(){
        if(!this.montar){
            this.arma = "Lanza";
            this.ataque();
        }
    }
    
    public void desmontar(){
        if(this.montar){
            this.arma = "Espada";
        }
    }

    public void ataque(){
        if(!montar){
            this.atacar();
            this.atacar();
        }
        else{
            this.atacar();
            this.atacar();
            this.atacar();
        }
    }
}

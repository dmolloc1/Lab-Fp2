public class Caballero extends Soldado{
    private boolean montar;
    private String arma;
    public Caballero(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, boolean montar){
    	super(n, nV, nA, nD, v, act, vive, c);
        this.montar =  montar;
    }
    public void montar(){
        if(!this.montar){
            this.arma = "Lanza";
            this.embestir();
        }
    }
    
    public void desmontar(){
        if(this.montar){
            this.arma = "Espada";
        }
    }

    public void embestir(){
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

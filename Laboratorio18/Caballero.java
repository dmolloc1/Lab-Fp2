public class Caballero extends Soldado{
    private boolean montar;
    private String arma;
    public Caballero(String nombre, int nVida, int nAtaque, int nDefensa, int v, String act, boolean vive, String color, boolean montar){
    	super(nombre, nVida, nAtaque, nDefensa, v, act, vive, color);
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

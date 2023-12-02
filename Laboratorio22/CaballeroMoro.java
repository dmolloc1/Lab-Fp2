public class CaballeroMoro extends Caballero implements AtaqueEspecial{
    private int numArma, numArmaE;
    private String armaE;
    public CaballeroMoro(String n, int nV, int nA, int nD, int v, String act, boolean vi, String c, boolean m){
    	super(n, nV, nA, nD, v, act, vi, c, m);
        this.numArma = 1;
        this.armaE = "Flechas";
    }
    public void lanzar(){
        for (int i = 0; i < numArmaE && numArmaE <= AtaqueEspecial.MAX_CANTIDAD; i++){
            this.atacar();
        }
        this.evolucionar();
    }
    public void embestir(){
        for (int i = 0; i < numArma && numArma <= AtaqueEspecial.MAX_CANTIDAD; i++){
            this.ataque();
        }
        this.evolucionar();
    }
    public void evolucionar(){
        this.longArma += 1;
        this.numArma += 1;
        this.numArmaE += 1;
    }
}

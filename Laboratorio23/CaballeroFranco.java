public class CaballeroFranco extends Caballero implements AtaqueEspecial{
    private int numArma;
    public CaballeroFranco(String n, int nV, int nA, int nD, int v, String act, boolean vi, String c, boolean m){
    	super(n, nV, nA, nD, v, act, vi, c, m);
        this.setNombreM("CF ");
        this.numArma = 1;
        this.arma = "Lanza";
    }
    public void lanzar(){
        for (int i = 0; i < numArma && numArma <= AtaqueEspecial.MAX_CANTIDAD; i++){
            this.atacar();
        }
        this.evolucionar();
    }
    public void evolucionar(){
        this.longArma += 1;
        this.numArma += 1;
    }
}

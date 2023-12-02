public class CaballeroFranco extends Caballero implements AtaqueEspecial{
    private int numArma;
    public EspadachinReal(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int espada){
    	super(n, nV, nA, nD, v, act, vive, c, espada);
        this.numArma = 1;
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

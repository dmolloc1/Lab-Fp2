public class EspadachinReal extends Espadachin implements AtaqueEspecial{
    private int numEspadas;
    public EspadachinReal(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int espada){
    	super(n, nV, nA, nD, v, act, vive, c, espada);
        this.setNombreM("ER");
        this.numEspadas = 1;
    }
    public void lanzar(){
        for (int i = 0; i < numEspadas && numEspadas <= AtaqueEspecial.MAX_CANTIDAD; i++){
            this.atacar();
        }
        this.evolucionar();
    }
    public void evolucionar(){
        this.longEspada += 1;
        this.numEspadas += 1;
    }
}

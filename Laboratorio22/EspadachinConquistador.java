public class EspadachinConquistador extends Espadachin implements AtaqueEspecial{
    private int numEspadas;
    public EspadachinConquistador(String n, int nV, int nA, int nD, int v, String act, boolean vi, String c, int es){
    	super(n, nV, nA, nD, v, act, vi, c, es);
        this.setNombreM("EC");
        this.numEspadas = 1;
        this.arma = "Hacha";
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

public class EspadachinTeutonico extends Espadachin implements AtaqueEspecial{
    private int numEspadas, numDefensa;
    public EspadachinConquistador(String n, int nV, int nA, int nD, int v, String act, boolean vi, String c, int es){
    	super(n, nV, nA, nD, v, act, vive, c, es);
        this.numEspadas = 1;
        this.numDefensa = 1;
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

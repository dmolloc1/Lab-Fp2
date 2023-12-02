public class EspadachinTeutonico extends Espadachin implements AtaqueEspecial{
    private int numEspadas, numDefensa;
    public EspadachinTeutonico(String n, int nV, int nA, int nD, int v, String act, boolean vive, String c, int espada){
    	super(n, nV, nA, nD, v, act, vive, c, espada);
        this.numEspadas = 1;
        this.numDefensa = 1;
        this.arma = "Jabalina";
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
    
    public void modoTortuga(){
        for (int i = 0; i < numDefensa && numDefensa <= AtaqueEspecial.MAX_CANTIDAD; i++){
            this.defender();
        }
        this.evolucionar();
    }
}

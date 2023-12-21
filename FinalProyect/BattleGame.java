class BattleGame{
    //archivo para guardar los records
    private Castle c1, c2;
    private Map map;

    //constructor
    public BattleGame(){
        this.c1 = new Castle("");
        this.c2 = new Castle("");
        this.map = new Map();
    }
    public void startGame(){
        this.map.print();

    }
    //main
    public static void main(String[] args){

    }

}

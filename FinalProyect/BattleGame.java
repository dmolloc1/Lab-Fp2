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
 
        map.builtMap();
        map.print();

    }
    //main
    public static void main(String[] args){
        BattleGame bg = new BattleGame();
        bg.startGame();
    }

}

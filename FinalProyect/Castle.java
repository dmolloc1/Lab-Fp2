class Castle{
    private int points;
    private String warrior;
    //Nombre del conquistador otro nombre alternativo

    public Castle(String w){
        this.warrior = w;
    }

    public void setPoints(int p){
        this.points += p;
    }

    public int getPoints(int p){
        return this.points;
    }
    
    public void buyItems(){
        //if(i > this.points)
    }

}

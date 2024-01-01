package vgame;
class Castle{
    private int points, posicion, p;
    private String warrior;
    //Nombre del conquistador otro nombre alternativo

    public Castle(String w){
        this.warrior = w;
    }

    public void setPoints(int p){
        this.points += p;
    }
    public void setPosicion(int i){
        this.posicion =i;
    }
    public int getPoints(int p){
        return this.points;
    }
    
    public void buyItems(){
        //if(i > this.points)
    }

    public void conquistar(String comando){	
	    p = this.posicion;
        switch (comando) {
            case "A":
                p -=  4;
                if(p >= 0){this.posicion = p ;}
                break;
            case "B":
                p += 4;
                if(p < 16){this.posicion = p;}
                break;
            case "I":
                p -= 1;
                if(p >= 0){this.posicion = p;}
                break;
            case "D":
                p += 1;
                if(p < 16){this.posicion = p;}
                break;
            case "DII":
                p = p - 1 + 4;
                if(p <  16 && p >= 0){this.posicion  = p ;}
                break;
            case "DDI":
                p = p + 1 + 4;
                if(p <  16 && p >= 0){this.posicion  = p ;}
                break;
            case "DIS":
                p = p - 1 - 4;
                if(p <  16 && p >= 0){this.posicion  = p ;}
                break;
            case "DDS":
                p = p + 1 - 4;
                if(p <  16 && p >= 0){this.posicion  = p ;}
                break;
        }
    }

}
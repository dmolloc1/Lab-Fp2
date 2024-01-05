import java.util.HashMap;

class Castle{
    private int points, posicion, p, color;
    private String warrior;
    private HashMap<String,Integer> items;
    //Nombre del conquistador otro nombre alternativo

    public Castle(String w, int c){
        this.warrior = w;
        this.color = c;
        this.items = new HashMap<>();
        items.put("escudo", 0);
        items.put("loro", 0);
        items.put("escalera", 0);
    }
    public void buyItems(String i){
        this.items.put(i,this.items.get(i) + 1);
        this.points -= Items.items.get(i); 
        System.out.println("compro: " + i);
    }
    public void useItems(String i){
        this.items.put(i,this.items.get(i) - 1);
    }
    public int getItem(String i){
        return this.items.get(i);
    }
    public void setPoints(int p){
        this.points += p;
    }
    public void setPosicion(int i){
        this.posicion =i;
    }
    public String name(){
        return this.warrior;
    }
    public int getColor(){
        return this.color;
    }

    public int getPoints(){
        return this.points;
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


import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class Soldado {

	private String nombre;
	private int nivelVida, fila;
	private char columna;
	private String color;
    	public static final int limite = 10;
    	private static int nSoldados;
    //nuevos atributos
    	private int nivelAtaque, nivelDefensa, vidaActual, velocidad;
    	private String actitud;
    	private boolean vive;

    	public Soldado(String nombre, int nivelVida, int nivelAtaque, int nivelDefensa, int velocidad){//Atributos de batalla
        	this.nombre = nombre;
        	this.nivelVida = nivelVida;
        	this.nivelAtaque = nivelAtaque;
        	this.nivelDefensa = nivelDefensa;
        	this.velocidad = velocidad;
            n.Soldados += 1;
    	}

    	public Soldado(int fila, char columna ){//Atributos de ubicacion y nombre
        	this.fila = fila;
        	this.columna = columna;
    	}

    	public Soldado(String actitud, boolean vive){// Atributos de estado
           	this.actitud = actitud;
        	this.vive = vive;
    	}
    
        public static int total(){
            return nSoldados;
        }
    	
	public void setNivelDeVida(int num){
		nivelVida = num;
	}

    	public void setNivelAtaque(int num){
		nivelAtaque = num;
	}
    	public void setNivelDefensa(int num){
		nivelDefensa = num;
	}
    	public void setNombre(String nom){
        	this.nombre = nom;
    	}

    	public void setFila(int num){
		fila = num;
	}

	public void setColumna(int colum){
		columna = (char)(colum + 65);
	}
    	
	public void setVive(boolean vivir){
        	vive = vivir;
    	}
    	
	public void setActitud (String a){
    		actitud = a ;
    	}

	public String getNombre(){
		return nombre;
	}	

	public int getNivelDeVida(){
		return nivelVida;
	}

	public int getFila(){
		return fila;
	}
	
	public char getColumna(){
		return columna;
	}
   
	public boolean getVive(){
        	return vive;
    	}
    	
	public String getActitud(){
        	return actitud;
    	}

	public void setColor(String color){
		this.color = color; 
	}

   	public String getColor(){
       		return  color;
	}
    	
	public void setVidaActual(int vidaActual){
        	this.nivelVida = vidaActual;
    	}
    	
	public int getVidaActual(){
        	return nivelVida;
    	}

//Metodos
	public String mostrar(){
		return "Nombre: " + nombre  + "\n	-Nivel de Vida: "
            + nivelVida + "\n	-Fila/Columna: "+ fila + " / "+ columna +"\nEstado: "+ actitud; 	
	}

	public void atacar(boolean gano){
        	this.velocidad += 1;
        	this.actitud = "Atacar";
        	this.nivelVida += 1;
        	if(!gano){
        	    morir();
        	    this.vive = false;
        	}
    	}

    	public void defender(){
        	this.velocidad = 0;
        	this.actitud = "Defender";
    	}

    	public void huir (){
        	this.velocidad += 2;
        	this.actitud = "Huir";
    	}

    	public void retroceder(){
        	if(this.velocidad > 0){
        	    this.velocidad = 0;
        	    this.actitud = "Defender";
        	    this.defender();
        	}
        	else{ 
        	    this.velocidad = this.velocidad - 1;
        	}
    	}

    	public void avanzar(int fila, int columna){
        	this.velocidad += 1;
        	setFila(fila);
        	setColumna(columna);
    	}

    	public void serAtacado(boolean perdio){
        	if(!perdio){
            	this.nivelVida += 1;
        	}
        	else morir();
    	}

    	public void morir(){
        	this.vive = false;
    	}
}

import java.util.*;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class Soldado {
	//Variables de clase
	public static final int MAX_SIZE = 10;
       	private static int cantidad;	
	private static int totalSoldados;
	//Atributos de objeto
	private String nombre;
	private int nivelVida, fila;
	private char columna;
	private String color;
      	private int nivelAtaque, nivelDefensa, vidaActual, velocidad;
    	private String actitud;
    	private boolean vive;
//Metodos de clase
	public static int creados(){
		return totalSoldados;
	}
//Constructores
    	public Soldado(String nombre, int nivelVida, int nivelAtaque, int nivelDefensa, int velocidad){//Atributos de batalla
        	this.nombre = nombre;
        	this.nivelVida = nivelVida;
        	this.nivelAtaque = nivelAtaque;
        	this.nivelDefensa = nivelDefensa;
        	this.velocidad = velocidad;
		totalSoldados += 1;
    	}

    	public Soldado(int fila, char columna ){//Atributos de ubicacion y nombre
        	this.fila = fila;
        	this.columna = columna;
		totalSoldados += 1;
    	}

    	public Soldado(String actitud, boolean vive){// Atributos de estado
           	this.actitud = actitud;
        	this.vive = vive;
		totalSoldados += 1;
    	}
 //Getters and Setters
	public void setNivelDeVida(int num){
		this.nivelVida = num;
	}

	public void setNivelAtaque(int num){
		this.nivelAtaque = num;
	}
	
	public void setNivelDefensa(int num){
		this.nivelDefensa = num;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}

	public void setFila(int num){
		this.fila = num;
	}

	public void setColumna(int colum){
		this.columna = (char)(colum + 65);
	}
    	
	public void setVive(boolean vivir){
        	this.vive = vivir;
    	}
    	
	public void setActitud (String a){
    		this.actitud = a ;
    	}

	public void setVidaActual(int vidaActual){
        	this.nivelVida = vidaActual;
    	}
	
	public void setColor(String color){
		this.color = color; 
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
	
	public int getNivelAtaque() {
		return nivelAtaque;
	}
	public int getNivelDefensa() {
		return nivelDefensa;
	}

   	public String getColor(){
       		return  color;
	}
    	    	
	public int getVidaActual(){
        	return nivelVida;
    	}

//Metodos
	public String mostrar(){
		return "Nombre: " + nombre  + "\n	-Nivel de Vida: "
            + nivelVida + "\n	-Nivel de Ataque: " + nivelAtaque + "\n	-Nivel de Defensa: " + nivelDefensa +
 	"\n	-Velocidad: "+ velocidad +"\nEstado: "+ actitud; 	
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
        	else this.velocidad = this.velocidad - 1;
        	
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

	public void clonar(Soldado clon){
		this.nombre = clon.nombre;
		this.velocidad = clon.velocidad;
		this.nivelVida = clon.nivelVida;
		this.nivelAtaque = clon.nivelAtaque;
		this.nivelDefensa = clon.nivelDefensa;
	}
	
	public Soldado sumar(Soldado sumar){
		this.nivelVida += sumar.nivelVida;
		this.nivelAtaque += sumar.nivelAtaque;
		this.nivelDefensa += sumar.nivelDefensa;
		this.velocidad += sumar.velocidad;
		return this;
	}
}

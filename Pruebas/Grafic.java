import java.awt.*;
import javax.swing.*;
class Grafic extends JFrame{
    
    public static void menu(){
        JFrame menu = new JFrame("Menu de instrucciónes:");
        menu.setSize(300,200);
        menu.setLayout (new BorderLayout());
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String mensaje= "El juego esta por comenzar...\n"+
        "Cada jugador se el asignara un castillo con un general a elección del jugador\n"+
        "OBJETIVO: Conquistar el castillo del enemigo\n"+
        "BONIFICACIONES: Por cada territorio conquistado se le daran puntos\n"+
        "Para conquistar un territorio se debera pasar un desafio(MINIJUEGOS)\n"+
        "En caso el terreno ya estuviera conquistado se producira una batalla por el territorio";

        JTextArea texto = new JTextArea();
        texto.setText(mensaje);
        texto.setEditable(false);
        menu.setLocationRelativeTo(null);
        menu.add(texto, BorderLayout.NORTH);
        menu.setVisible(true);

    }
    public static void main(String[] args){
        menu();
    }


    
}

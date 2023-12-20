import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class Grafic extends JFrame{
    
    public static void menu(){
        JFrame menu = new JFrame("Menu de instrucciónes:");
        menu.setSize(500,200);
        menu.setLayout (new BorderLayout());
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        menu.setLocationRelativeTo(null);
        menu.add(contenido(), BorderLayout.CENTER);
        menu.add(empezar(), BorderLayout.SOUTH );
        menu.setVisible(true);

    }
    public static JTextArea contenido(){
        String mensaje= "El juego esta por comenzar...\n"+
        "Cada jugador se el asignara un castillo con un general a elección del jugador\n"+
        "OBJETIVO: Conquistar el castillo del enemigo\n"+
        "BONIFICACIONES: Por cada territorio conquistado se le daran puntos\n"+
        "Para conquistar un territorio se debera pasar un desafio(MINIJUEGOS)\n"+
        "En caso el terreno ya estuviera conquistado se producira una batalla por el territorio";

        JTextArea texto = new JTextArea();
        texto.setText(mensaje);
        texto.setEditable(false);
        return texto;
    }

    public static JButton empezar(){
        JButton empezar = new JButton("Empezar");
        empezar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola");
            }
            
        });
        return empezar;
    }
    public static void main(String[] args){
        menu();
    }


    
}

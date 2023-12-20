import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Laboratorio A Fundamentos 2
//Autor: Mollo Chuquicaña Dolly Yadhira
public class VideoJuego5 extends JFrame{
    private JTextArea outputArea;
    private JLabel mensajeLabel;
    static ArrayList <Ejercito> reino1, reino2;
    //static Ejercito ejercito_1, ejercito_2 ;
    static Scanner sc = new  Scanner(System.in);
    static final String turqueza = "1";
    static final String amarillo = "2";
    
    public VideoJuego5(){
        super("Juego");
        setSize(300, 200);
        
    }
    public static void main(String[] args) {
        iterativeGameReino();
    }
    public static void iterativeGameReino(){
        VideoJuego5 juego = new VideoJuego5();
        String nR1, nR2;
        
        Mapa map = new Mapa();
        int num1 = (int) (Math.random()*5) + 1;
        int num2 = (int) (Math.random()*5) + 1;
        while (num1 == num2){
            num2 = (int)Math.random()*5 + 1;
        }
        reino1 = crearReino(1, num1, turqueza);
        nR1 = reino1.get(0).getReino();
        map.rellenar(reino1);
            
        reino2 = crearReino(2, num2, amarillo);
        nR2 = reino2.get(0).getReino();
        map.rellenar(reino2);
       //Interfaz grafica
        juego.mensajesJuego(map, reino1,reino2, nR1, nR2);
        
        //map.mostrar();
        //map.jugar(1, reino1, reino2);
        //pantalla.iniciarJuego(map, nR1, nR2);    
    } 
    public void empezarPartida(Mapa map, String nR1, String nR2){
        VideoJuego5 juego = new VideoJuego5();
        JButton bEmpezar = new JButton("Empezar Partida");
        bEmpezar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJuego(map, nR1, nR2);
            }
        });
        juego.add(bEmpezar);
        juego.setLocationRelativeTo(null);
        juego.setVisible(true);
    }
    public void mensajesJuego(Mapa map, ArrayList <Ejercito> r1, ArrayList<Ejercito> r2,String nR1, String nR2) {
        setTitle("Mensajes del Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tablero tab = map.mostrar();

        map.bonificación(reino1);
        map.bonificación(reino2);

        JTextArea mensajeTextArea = new JTextArea();
        mensajeTextArea.setEditable(false);
        mensajeTextArea.setLineWrap(true);
        mensajeTextArea.setWrapStyleWord(true);

        // Mostrar los mensajes en diferentes líneas
        String mensaje1 = "*** EMPEZANDO EL JUEGO ***";
        String mensaje2 = "\n- El tipo de terreno del mapa es " + map.getTerritorio() +
                "\n-------------- Se procederá a efectuar la bonificación --------";
        String mensaje3 = "\nEl reino 1 es: " + reino1.get(0).getReino() +
                "\nEl reino 2 es: " + reino2.get(0).getReino();

        mensajeTextArea.setText(mensaje1 + mensaje2 + mensaje3);

        JScrollPane scrollPane = new JScrollPane(mensajeTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 120));

        // Agregar botón
        JButton bBonificacion = new JButton("Aplicar bonificación");
        bBonificacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tab.dispose();
                map.mostrar();
                dispose();
                empezarPartida(map, nR1, nR2);
            }
        });
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(scrollPane, BorderLayout.CENTER);
        panelCentral.add(bBonificacion, BorderLayout.SOUTH);

        add(panelCentral);

        pack(); // Ajusta el tamaño del frame según los componentes agregados
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    /*public void menu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(2, 1));

        JButton botonEmpezarJuego = new JButton("Empezar Juego");
        botonEmpezarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para empezar el juego
                System.out.println("El juego ha empezado.");
            }
        });

        JButton botonDatosEjercito = new JButton("Datos de Ejército");
        botonDatosEjercito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el ejercito (1 o 2):");

                if (input != null && (input.equals("1") || input.equals("2"))) {
                    int num = Integer.parseInt(input);
                    if(num == 1) reino1.datosEjercito(); // Llama al método ejercito(num) con el número ingresado
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido (1 o 2).");
                }
            }
        });

        add(botonEmpezarJuego);
        add(botonDatosEjercito);
    }*/
    public static boolean batallaEjercitos(Ejercito ejercito_1, Ejercito ejercito_2){
            Mapa map = new Mapa("Ejercito");
            map.rellenar(ejercito_1);
            System.out.printf("*** Datos del ejercito 1 %s ***", ejercito_1.getReino());
            ejercito_1.datosEjercito();
            map.rellenar(ejercito_2);
            System.out.printf("\nDatos del ejercito 2 %s", ejercito_2.getReino());
            ejercito_2.datosEjercito();
            map.mostrarE();
            System.out.println("\n*** En batalla ***");
            return startGame(map, ejercito_1, ejercito_2);
    }
    public static void ganador(Ejercito my, Ejercito enemigo){
       // boolean gano = definirGanador(my.totalNivelVida(), enemigo.totalNivelVida());
       boolean gano= true ;
       if(gano) System.out.println("--------- GANO EL EJERCITO 1 --------");
        else  System.out.println("--------- GANO EL EJERCITO 2 --------");
    }
    public void iniciarJuego(Mapa mapa, String nR1, String nR2) {
        boolean continuar = true;

        while (continuar && reino1.size() > 0 && reino2.size() > 0) {
            //mensajeLabel.setText("Turno del primer jugador(celeste)");
            continuar = mapa.jugar(1, reino1, reino2);
            mapa.mostrar();

            if (reino1.size() == 0 || reino2.size() == 0) {
                if (reino1.size() == 0) {
                    mensajeLabel.setText("~~~~~~~~~~~~~~~~~~~~~ GANO " + nR2 + " ~~~~~~~~~~~~~~~~~");
                    break;
                } else {
                    mensajeLabel.setText("~~~~~~~~~~~~~~~~~~~ GANO " + nR1 + " ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                }
            }

            if (!continuar) break;
            //mensajeLabel.setText("Turno del segundo jugador(amarillo)");
            continuar = mapa.jugar(2, reino1, reino2);
            mapa.mostrar();
            pack(); // Ajusta el tamaño del frame según los componentes agregados
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    }

    /*public static void startGame(Mapa mapa, String nR1, String nR2){
        boolean continuar = true;
        while(continuar && reino1.size() > 0 && reino2.size() > 0){
            System.out.println("\nTurno del primer jugador(celeste) ");
            mapa.jugar(1, reino1, reino2);
            mapa.mostrar();
            if(reino1.size() == 0 || reino2.size() == 0){
                if(reino1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO "+ nR2 + " ~~~~~~~~~~~~~~~~~");
                    break;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO "+ nR1+" ~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            mapa.jugar(2, reino1, reino2);
            mapa.mostrar();
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().charAt(0) == 'n';
        } 
        if(reino2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO "+ nR1+" ~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }*/
    public static  boolean startGame(Mapa map, Ejercito ejercito_1,Ejercito ejercito_2){ 
        boolean continuar = true;
        while (ejercito_1.size() > 0 && ejercito_2.size() > 0  && continuar){    
            System.out.println("\nTurno del primer jugador(celeste) ");
            //map.jugar(1, ejercito_1, ejercito_2);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            if(ejercito_1.size() == 0 || ejercito_2.size() == 0){
                if(ejercito_1.size() == 0){
            	    System.out.println("~~~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_2 ~~~~~~~~~~~~~~~~~");
                    return false;
                }else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");
                    return true;
		        }
	        }
            System.out.print("Desea salir (y/n)");
            continuar = sc.next().charAt(0) == 'n';
            if(!continuar) break;
            System.out.println("\nTurno del segundo jugador(amarillo) ");
            //map.jugar(2, ejercito_1, ejercito_2);
            System.out.println("Cantidad de soldados del Ejercito 1: " + ejercito_1.size());
            System.out.println("Cantidad de soldados del Ejercito 2: " + ejercito_2.size());
            System.out.print("\nDesea salir (y/n): ");
            continuar = sc.next().equalsIgnoreCase("n");
        } 
        if(ejercito_2.size() == 0){
            System.out.println("~~~~~~~~~~~~~~~~~~~ GANO EL EJERCITO_1 ~~~~~~~~~~~~~~~~~~~~~~~~");    
            return true;
        }
        return false;
    }
    public static boolean definirGanador(int vida1 , int vida2){
    	double prob1 = (vida1 * 100.0) / (vida1 + vida2);
        double prob2 = (vida2 * 100.0) / (vida1 + vida2);

        System.out.println("Probabilidad de vencer para el primero 1: " + prob1 + "%");
        System.out.println("Probabilidad de vencer para el segundo 2: " + prob2 + "%");
	    Random ran = new Random();
        double randomValue = ran.nextDouble() * 100 + 1 ;
        System.out.printf("\nEl número  es %.2f", randomValue);
        if (randomValue <= prob1) {
            System.out.printf("\nEl primero  gana porque es mayor o igual a %.2f\n", randomValue);
            return true;
        } else {
            System.out.printf("\nEl segundo  gana porque es menor a %.2f\n", randomValue);
            return false;
        }
        
    }
    public static boolean compareString(String word1, String word2){
    		word1 = word1.toUpperCase();
    		word2 = word2.toUpperCase();
    		if (word1.compareTo(word2) <= 0) return false;
    		return true;
    }
    
    
    
    public static ArrayList <Ejercito> crearReino(int nombre, int n, String color){
        ArrayList <Ejercito> reino = new ArrayList<>();
        int armyLength = (int)(Math.random() * Ejercito.MAX_SIZE + 1);
	    
        for (int i = 0; i < armyLength; i++) {
           	Ejercito nuevo = new Ejercito("Ejercito_"+ nombre + "X"+ (i + 1), n, color);
            nuevo.ingresarDatosAleatorio(color);
            reino.add(nuevo);
	    }
	    return reino;
    }
} 

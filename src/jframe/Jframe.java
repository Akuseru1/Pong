package jframe;

import javax.swing.*;


public class Jframe extends JFrame {

    public Jframe() {
        super("My Frame");

        //you can set the content pane of the frame 
        //to your custom class.
        setContentPane(new DrawPane());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 400);

        setVisible(true);
    }


    public static void main(String args[]) {
        new Jframe();
    }

    /*public static void EscogerJugador() {
        Raquetas jugador = new Raquetas();
        jugador.jugador = Integer.parseInt("ingrese si es jugador 1 o 2");

        if (jugador.jugador == 1) {
            jugador.jugador1 = 1;
        } else {
            jugador.jugador2 = 2;
        }
    }*/

}

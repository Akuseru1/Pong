package jframe;

import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Jframe {

    public static void main(String[] args) {

        String casado;

        JFrame window = new JFrame();
        window.setSize(640, 480);
        window.setTitle("Pong");
        window.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public static void EscogerJugador() {
        Raquetas jugador = new Raquetas();
        jugador.jugador = Integer.parseInt("ingrese si es jugador 1 o 2");

        if (jugador.jugador == 1) {
            jugador.jugador1 = 1;
        } else {
            jugador.jugador2 = 2;
        }
    }

}


package pong;

import javax.swing.JFrame;

public class Window extends JFrame {
    // metodo constructor
    public Window(){
        // dentro de este método van las caracteristicas de la ventana
        int width = 600, height = 400;
        Board board =  new Board();
        setTitle("Pong");
        setSize(width, height);
        setResizable(false);
        add(board);
    }
    
}

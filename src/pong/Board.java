package pong;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener {
    Ball ball = new Ball(0, 0);
    Racket player1 = new Racket(50, 60);
    public Board(){
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    // sobreescribe el metodo del mismo nombre en JPanel
    @Override
    public void paintComponent(Graphics g){
        // se ejecuta el método del mismo nombre pero de la clase JPanel
        super.paintComponent(g);
        ball.paint(g);
        player1.paint(g);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    
    private void update() {
        ball.update();
        player1.update();    
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        player1.pressed(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

}

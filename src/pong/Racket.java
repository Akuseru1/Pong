/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author ar4z
 */
public class Racket {
    int x, y, dy =1;
    
    public Racket(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g) {
        g.fillRect(x, y, 10, 60);
    }
    
    
    public void update() {
        this.y += this.dy;
    }

    public void pressed(int keyCode) {
        if (keyCode == KeyEvent.VK_UP)
            this.dy = -1;
        else if (keyCode == KeyEvent.VK_DOWN)
            this.dy = 1;
    }
    
    public void released(int keyCode) {
        this.dy = 0;
    }
}

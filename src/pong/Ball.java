package pong;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    int x, y, dx = 1, dy= 1;
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void update(){
        
        if (this.y >= 400) {
            dy *= -1;
        }
        if (this.x >= 600){
            dx *= -1;
        }
        if (this.x < 0){
            dx *=-1;
        }
        if(this.y < 0){
            dy *=-1;
        }
        this.x += dx;
        this.y += dy;
        System.out.println(this.y);
    }
    
    public void paint(Graphics g) {
        g.fillRect(x, y, 20, 20);
    }
}

package jframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Jframe extends JPanel implements ActionListener, KeyListener {

     Timer refrescar= new Timer(5,this);// this siendo el action listener. Timer se usa para animacion
     Bola x = new Bola();
     Bola y = new Bola(); //cambiar
     Raquetas RaquetaIZ= new Raquetas();
     Raquetas RaquetaDER= new Raquetas();
     int cont1=0;
     int cont2=0;
     String puntaje1=""+0;
     String puntaje2=""+0;
     int K=0; //se usa para el codigo del teclado
     
    public Jframe(){
    refrescar.start();
    addKeyListener(this);//añade el keyListener al principio del programa
    setFocusable(true);  //activa el Key Listener
    
}
    public static void main(String[] args) {
        
        Jframe Graph = new Jframe(); //objeto jpanel creado gracias a la herencia (extends)
        JFrame window = new JFrame();
        window.setSize(640, 480);
        window.setTitle("Pong");
        Graph.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(Graph); //añade el jpanel
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        
        super.paintComponent(g);//llana el metodo sin override, que se asegura que el fondo este pintado alrededor de los objetos
        g.setColor(Color.WHITE);
        g.fillOval(x.POSX, y.POSY, 20, 20);
        g.fillRect(20, RaquetaIZ.POSY, 15, 120);
        g.fillRect(590, RaquetaDER.POSY, 15, 120);
        g.drawString("JUGADOR1", 100,30);
        g.drawString("JUGADOR2", 470,30);
        g.drawString("", 470,30); //presione espacio
        g.drawString(puntaje1, 129, 50);
        g.drawString(puntaje2, 500, 50);
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  //movimiento y rebote de la pelota
       
        
        if(y.POSY==460 || y.POSY==20)
            y.vely=-y.vely;
                                               //abajo                                //arriba
         if(x.POSX==RaquetaIZ.POSXIZ && (y.POSY>RaquetaIZ.POSY-40) && (y.POSY<RaquetaIZ.POSY+120)) { //choque con las raquetas
             x.velx=-x.velx;
             
         }
         if(x.POSX==RaquetaDER.POSXDER && (y.POSY>RaquetaDER.POSY-40) && (y.POSY<RaquetaDER.POSY+120)) {
             x.velx=-x.velx;
             
         }
        
        y.POSY+=y.vely;  //MUEVEN LA PELOTA
        x.POSX+=x.velx;
        /////////////////////////////////////
        
        RaquetaIZ.POSY+=RaquetaIZ.vel;  //estas son las acciones al presionar botones
        RaquetaDER.POSY+=RaquetaDER.vel;
                    
        if(RaquetaIZ.POSY>330 ) {// Detienen la barra en los limites
            RaquetaIZ.vel=0;     //si se pone igual, se detiene la barra y no se vuelve a mover
            RaquetaIZ.POSY=330;
        }
        if(RaquetaIZ.POSY<0){
            RaquetaIZ.vel=0;
            RaquetaIZ.POSY=0;
         }
        if(RaquetaDER.POSY>330 ) {
            RaquetaDER.vel=0;
            RaquetaDER.POSY=330;
        }
        if(RaquetaDER.POSY<0){
            RaquetaDER.vel=0;
            RaquetaDER.POSY=0;
         }
        
        ////////////////////////////////////////////////////////////////////////
        if(x.POSX==0 && y.POSY!=RaquetaIZ.POSY) {
            RaquetaIZ.POSY=150;
            RaquetaDER.POSY=150;
            
            x.POSX=350;
            y.POSY=150;
            x.velx=0;
            y.vely=0;
            cont1++;
            puntaje2= ""+cont1;
        }
        if(x.POSX==640 && y.POSY!=RaquetaDER.POSY) {
            RaquetaIZ.POSY=150;
            RaquetaDER.POSY=150;
            
            x.POSX=350;
            y.POSY=150;
            x.velx=0;
            y.vely=0;
            cont2++;
            puntaje1= ""+cont2;
        }
        
       
        repaint();
    }

        
    @Override
    public void keyTyped(KeyEvent e) {
        
          
    }

    @Override
    public void keyPressed(KeyEvent e) {
        K=e.getKeyCode();
        
        if(K==KeyEvent.VK_SPACE){
            x.velx=2;
            y.vely=1;
        }
            
        if (K==KeyEvent.VK_S) 
            RaquetaIZ.vel=-1;
        if (K==KeyEvent.VK_X)
            RaquetaIZ.vel=1;
        if (K==KeyEvent.VK_UP) 
            RaquetaDER.vel=-1;
        if (K==KeyEvent.VK_DOWN)
            RaquetaDER.vel=1;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(K == KeyEvent.VK_S || K == KeyEvent.VK_X){
            RaquetaIZ.vel=0;
        } else if (K==KeyEvent.VK_UP || K==KeyEvent.VK_DOWN){
            RaquetaDER.vel=0;
        }       
    }

    
   
    
    
            
    
}

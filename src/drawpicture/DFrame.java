/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpicture;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Mark
 */
public class DFrame extends JFrame{
    
    public DPanel dPanel;// = new GameJPanel();
   public PicPanel pic;//  = new PicPanel();
   public Ninja ninja;// = new Ninja();
   public Monkey monkey;// = new Monkey();
   public Merchant merchant;// = new Monkey();
   public Police police;
    public int size = drawpicture.DrawPicture.size;
    private int lsize = size*21/10;
    private int hsize = size*22/10;
    
    
    
    public DFrame(int x, int y){
        
       
        super ("Random Face Drawing Test");
                getContentPane().setLayout(new BorderLayout());
                
                Random rand = new Random();
                int xfactor = 1 + rand.nextInt(drawpicture.DrawPicture.type);
                switch(xfactor){
                    
                    case 1 : pic  = new PicPanel(); getContentPane().add(pic,"Center"); break;
                    case 2 : ninja = new Ninja(); getContentPane().add(ninja,"Center"); break;
                    case 3 :  monkey = new Monkey(); getContentPane().add(monkey,"Center"); break;
                    case 4 :  merchant = new Merchant(); getContentPane().add(merchant,"Center"); break;
                    case 5 :  police = new Police(); getContentPane().add(police,"Center"); break;
                }
               // dPanel = new DPanel();
              // pic  = new PicPanel();
              // ninja = new Ninja();
              // monkey = new Monkey();
              
               //  gamePanel.createScreen();   
              
		//getContentPane().add(skyPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize (lsize, hsize);
               //setSize (1920, 1080);
                 
               
               setLocation(x,y);
               
               
               
		setVisible(true);
    }
 
  
}

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
    public int size = drawpicture.DrawPicture.size;
    private int lsize = size*21/10;
    private int hsize = size*22/10;
    
    
    
    public DFrame(){
        
       
        super ("Random Face Drawing Test");
                getContentPane().setLayout(new BorderLayout());
               // dPanel = new DPanel();
               pic  = new PicPanel();
              getContentPane().add(pic,"Center");
               //  gamePanel.createScreen();   
              
		//getContentPane().add(skyPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize (lsize, hsize);
               //setSize (1920, 1080);
                 Random rand = new Random();
               int x = 1 + rand.nextInt(1700);
               int y = 1 + rand.nextInt(800);
               setLocation(x,y);
               
               
               
		setVisible(true);
    }
 
  
}

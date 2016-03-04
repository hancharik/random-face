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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Mark
 */
public class DFrame extends JFrame{
    
    public DPanel dPanel;// = new GameJPanel();
   // public Clock clock = new Clock();
    
    public DFrame(){
        super ("Random Face Drawing Test");
                getContentPane().setLayout(new BorderLayout());
                dPanel = new DPanel();
              getContentPane().add(dPanel,"Center");
               //  gamePanel.createScreen();   
              
		//getContentPane().add(skyPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1920, 1080);
               // setLocation(400,400);
		setVisible(true);
    }
 
  
}

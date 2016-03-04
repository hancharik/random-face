/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpicture;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author mark
 */
public class DPanel extends JComponent {

    
    Color hair;
    Color skin;
    Color line;
    
    int headX;
    int headY;
    int skinX;
    int skinY;
    
    int headsize;
    int skinsize;
    int hairthickness;
    int mouthThickness;
    int mouthWidth;
    int eyeSize;
    int mouthX;
    int mouthY;
    int eyeRx;
    int eyeRy;
    int eyeLx;
    int eyeLy;
    
    public DPanel() {

        super();

       // drawSun(100,100,100,100);
        
        setVariables();
        
        
    }  // end constructor
    
    
    
    private void setVariables(){
        
        
    hair = new Color(10,10,10);
    skin = new Color(255,175,175);
    line = new Color(0,0,0);
    
    
    hairthickness = 10;
    
    
    
    
    
    
    
    headsize = 400;
    skinsize = headsize - hairthickness;
    
    
    
    mouthThickness = 6;
    mouthWidth = headsize/2;
    eyeSize = 10;
    
    
    
    headX = headsize/2;
    headY = headsize/2;
    
    mouthX =  headX*15/10;
    mouthY = headY*22/10;
    eyeRx = headX*21/10;
    eyeRy = headY*17/10;
    eyeLx = headX*18/10;
    eyeLy = headY*17/10;
     skinX = headX + (hairthickness/2);
    skinY = headY + (hairthickness/2);  
        
        
        
    }// end set variables
    
    
    
    
    
    
    public void paintComponent(Graphics g){
        
   
      // draw hair
        g.setColor(hair);
        g.fillOval(headX,headY,headsize,headsize);
      
        // draw face
        g.setColor(skin);
        g.fillOval(skinX,skinY,skinsize,skinsize);
        
        // set color
        g.setColor(line);
        
       //draw left eye
        g.fillOval(eyeLx,eyeLy, eyeSize,eyeSize);
        // draw right eye
        g.fillOval(eyeRx,eyeRy, eyeSize,eyeSize);
        
         // draw mouth
        g.fillRect(mouthX,mouthY, mouthWidth,mouthThickness);
        
        
        
    }
    
    
    
    
    

}

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
    
    
    
    public DPanel() {

        super();

       // drawSun(100,100,100,100);
        
        
        
        
    }  // end constructor
    
    public void paintComponent(Graphics g){
        
       // g.fillRect(100, 100, 100, 100);
       hair = new Color(10,10,10);
       g.setColor(hair);
        g.fillOval(200,200,200,200);
        g.setColor(Color.green);
        g.drawOval(210,210,180,190);
        g.setColor(Color.blue);
        g.fillOval(220,220,160,180);
    }
    
    
    
    
    
/*
    public void drawSun(int x, int y, int width, int height) {
        // get the graphics2D object for this picture
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        // create the gradient for painting from yellow to red with
        // yellow at the top of the sun and red at the bottom
        float xMid = (float) (width / 0.5 + x);
        GradientPaint gPaint = new GradientPaint(xMid, y,
                Color.yellow,
                xMid, y + height,
                Color.red);
        // set the gradient and draw the ellipse
       // g2.setPaint(gPaint);
        g2.fill(new Ellipse2D.Double(x, y, width, height));
    }
*/
}

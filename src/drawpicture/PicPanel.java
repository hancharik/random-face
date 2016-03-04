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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class PicPanel extends JPanel implements ActionListener {

    Color hair;
    Color skin;
    Color line;
    Color notskin;
    Color shirtout;
    Color shirtfill;

    int headX;
    int headY;
    int skinX;
    int skinY;
    int shirtOutX;
    int shirtOutY;
    int shirtFillX;
    int shirtFillY;
    
    
    
    int headsize;
    int skinsize;
    int hairthickness;
    int mouthThickness;
    int mouthWidth;
    int eyeSize;
    int shirtOutSize;
    int shirtFillSize;
    
    
    
    
    int mouthX;
    int mouthY;
    int eyeRx;
    int eyeRy;
    int eyeLx;
    int eyeLy;
    
    
    
    
    

    
    ///these are standard values to make the face look right
    
    int mouthXi = 15;
    int mouthYi = 22;
    int eyeRxi = 21;
    int eyeRyi = 17;
    int eyeLxi = 18;
    int eyeLyi = 17;

    Random rand;

    Timer t;

    public PicPanel() {

        super(true);

        rand = new Random();
       // setSize (200, 200);
          setVariables();
        //setRandomVariables();
       t = new Timer(2000, this);
      t.start();

    }  // end constructor

    private void setVariables() {

        hair = new Color(10, 10, 10);
        skin = new Color(255, 175, 175);
        line = new Color(0, 0, 0);
        shirtout = new Color(0, 0, 175);
        shirtfill = new Color(0, 175, 175);

        hairthickness = 10;

        headsize = drawpicture.DrawPicture.size;// 100;
        skinsize = headsize - hairthickness;

        mouthThickness = 6;
        mouthWidth = headsize / 2;
        eyeSize = 4;

        headX = headsize / 2;
        headY = headsize / 2;

        mouthX = headX * mouthXi / 10;
        mouthY = headY * mouthYi / 10;
        eyeRx = headX * eyeRxi / 10;
        eyeRy = headY * eyeRyi / 10;
        eyeLx = headX * eyeLxi / 10;
        eyeLy = headY * eyeLyi / 10;
        skinX = headX + (hairthickness / 2);
        skinY = headY + (hairthickness / 2);

        shirtOutX = headX - (int)(.45*headsize);
        shirtOutY =  headY + (int)(.80*headsize);
        shirtFillX = skinX  - (int)(.44*headsize);
        shirtFillY = skinY + (int)(.80*headsize);
        shirtOutSize = headsize*2;
        shirtFillSize =  skinsize*2;
        
    }// end set variables

    
    
    
    
    
    
    
    
    
    
    
    
    private void setRandomVariables() {

        Random rand = new Random();
        int r = 1 + rand.nextInt(255);
        int g = 1 + rand.nextInt(255);
        int b = 1 + rand.nextInt(255);
        hair = new Color(10, 10, 10);
        skin = new Color(r, g, b);
        notskin = new Color(g, b, b);
        line = new Color(0, 0, 0);
        shirtout = new Color(0,0,0);
        shirtfill = new Color(g,b,r);
        int x = 1 + rand.nextInt(20) - 4;

        hairthickness = 10;// + x;
        x = 1 + rand.nextInt(420) + 160;
         headsize = drawpicture.DrawPicture.size;
        skinsize = headsize - hairthickness;

        mouthThickness  = 1 + rand.nextInt(3) + 1;
        mouthWidth = headsize / 2;
        eyeSize = 1 + rand.nextInt(3) + 2;

        headX = headsize / 2 ;
        headY = headsize / 2 ;
        x = 1 + rand.nextInt(2) - 1;
        mouthX = headX * (mouthXi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        mouthY = headY * (mouthYi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        eyeRx = headX * (eyeRxi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        eyeRy = headY * (eyeRyi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        eyeLx = headX * (eyeLxi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        eyeLy = headY * (eyeLyi + x) / 10;
        x = 1 + rand.nextInt(2) - 1;
        skinX = headX + (hairthickness / 2);
        skinY = headY + (hairthickness / 2);

        
        shirtOutX = headX  - (int)(.45*headsize);
        shirtOutY =  headY + (int)(.80*headsize);
        shirtFillX = skinX - (int)(.44*headsize);
        shirtFillY = skinY + (int)(.80*headsize);
        shirtOutSize = headsize*2;
        shirtFillSize =  skinsize*2;
        
        
        
        
        this.repaint();

    }// end set variables

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        String choice = event.getActionCommand();

        if (obj == t) {
           setRandomVariables();
            //     int holdOn = 1 + rand.nextInt( 2000 ) ;
            //     t = new Timer(holdOn, this);
            // t.start();
        }

    }

    public void paintComponent(Graphics g) {

        // draw background
        g.setColor(notskin);
        g.fillRect(0, 0,1920,1080);
        
        
        
        // draw shirt outline
        g.setColor(shirtout);
        g.fillOval(shirtOutX, shirtOutY, shirtOutSize, shirtOutSize);
        // draw shirt
        g.setColor(shirtfill);
        g.fillOval(shirtFillX, shirtFillY, shirtFillSize, shirtFillSize);
        
        
        
        
        // draw hair
        g.setColor(hair);
        g.fillOval(headX, headY, headsize, headsize);
        // draw face
        g.setColor(skin);
        g.fillOval(skinX, skinY, skinsize, skinsize);

        // set color
        g.setColor(line);

        //draw left eye
        g.fillOval(eyeLx, eyeLy, eyeSize, eyeSize);
        // draw right eye
        g.fillOval(eyeRx, eyeRy, eyeSize, eyeSize);

        // draw mouth
        g.fillRect(mouthX, mouthY, mouthWidth, mouthThickness);

    }

}

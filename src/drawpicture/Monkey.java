/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpicture;

import java.awt.Color;
import java.awt.Font;
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
public class Monkey extends JPanel implements ActionListener {

    
    String race;// = "human";
    
    Color wangsBlue = new Color(162, 223, 254);
    Color headOutline;
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
    int headOutlinethickness;
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

    int raceCounter = 1; 
    
    Random rand;

    Timer t;

    public Monkey() {

        super(true);
        
        
        race = "human";
        rand = new Random();
       // setSize (200, 200);
         // setVariables();
         
        int race = 1 + rand.nextInt(11);
        setRandomVariables(race);
      t = new Timer(drawpicture.DrawPicture.speed, this);
      t.start();

    }  // end constructor

    private void setVariables() {

        headOutline = new Color(10, 10, 10);
       // skin = new Color(255, 175, 175);
        
        
          
        // real skin tones
        
       int a = 1 + rand.nextInt(175);
       int z = a + 80;
       skin = new Color(z,a, a);//= new Color(255, 175, 175);//= new Color(r, g, b);
        
        
        
        
        
        
        
        line = new Color(0, 0, 0);
        shirtout = new Color(0, 0, 175);
        shirtfill = new Color(0, 175, 175);

       

        headsize = drawpicture.DrawPicture.size;// 100;
        headOutlinethickness = (int)(.08*headsize);// + x;
        skinsize = headsize - headOutlinethickness;
        
     
         int tenth = (int)Math.ceil(headsize /10);
          int hundredth = (int)Math.ceil(headsize / 100);
         // System.out.println("hundredth"+hundredth);
        mouthWidth = (int)(.20*headsize);//(int)(headsize / 5) + (rand.nextInt(tenth) - (tenth / 2));
         mouthThickness  = (int)Math.ceil(hundredth + rand.nextInt(2 * hundredth));  // mouthThickness  = 1 + rand.nextInt(3) + 1;
        eyeSize = 4 * hundredth;

        headX = headsize / 2;
        headY = headsize / 2;

        mouthX = headX * mouthXi / 10;
        mouthY = headY * mouthYi / 10;
        eyeRx = headX * eyeRxi / 10;
        eyeRy = headY * eyeRyi / 10;
        eyeLx = headX * eyeLxi / 10;
        eyeLy = headY * eyeLyi / 10;
        skinX = headX + (headOutlinethickness / 2);
        skinY = headY + (headOutlinethickness / 2);

        shirtOutX = headX - (int)(.48*headsize);
        shirtOutY =  headY + (int)(.80*headsize);
        shirtFillX = skinX  - (int)(.44*headsize);
        shirtFillY = skinY + (int)(.80*headsize);
        shirtOutSize = headsize*2;
        shirtFillSize =  skinsize*2;
        
    }// end set variables

    
    
    
    
    
    
    
    
    
    
    
    
    private void setRandomVariables(int raceInt) {

        Random rand = new Random();
        int r = 1 + rand.nextInt(255);
        int g = 1 + rand.nextInt(255);
        int b = 1 + rand.nextInt(255);
        headOutline = new Color(0, 0, 0);
        
          
        // real skin tones
        
        int a = 1 + rand.nextInt(175);
        
        int z = a + 80;
        
        switch(raceInt){
             // humans
            case 1 :  skin = new Color(z,a, a); race = "human"; break;
            // pea green aliens
            case 2 :  skin = new Color(z,z, a);race = "pegran"; break;
            // light gray aliens
            case 3 :  skin = new Color(z,z, z); race = "ligran"; break;
            // dark gray aliens
            case 4 :   a = 40 + rand.nextInt(80); skin = new Color(a,a,a); race = "dagan"; break;
            // green aliens
            case 5 :  skin = new Color(a,z, a); race = "galgan"; break;
            // blue green aliens
            case 6 : skin = new Color(a,z, z); race = "valdran"; break;
            // blue aliens
            case 7 : skin = new Color(a,a, z); race = "ardian"; break;
            // purple aliens
            case 8 : skin = new Color(z,a, z); race = "tsynsan"; break;
             // red aliens
            case 9: skin = new Color(z,0,0); race = "gyntuan"; break;
             // untested
            case 10: skin = new Color(0,z,0);race = "vootan"; break;
             // untested
            case 11: skin = new Color(0,0,z); race = "boaan"; break;
        }
        // human skin
       // skin = new Color(z,a, a);//= new Color(255, 175, 175);//= new Color(r, g, b);
       
           // pea green green aliens!!! 
       // skin = new Color(z,z, a);//= new Color(255, 175, 175);//= new Color(r, g, b);
       
               // light gray aliens!!! 
       // skin = new Color(z,z, z);//= new Color(255, 175, 175);//= new Color(r, g, b); 
       
           // dark gray aliens!!! 
        //  a = 40 + rand.nextInt(80);
     //  skin = new Color(a,a,a);//= new Color(255, 175, 175);//= new Color(r, g, b); 
       
         //  green aliens!!!!
       // skin = new Color(a,z, a);//= new Color(255, 175, 175);//= new Color(r, g, b);
       
               // blue green aliens!!! 
       // skin = new Color(a,z, z);//= new Color(255, 175, 175);//= new Color(r, g, b);
        
          //  blue aliens!!! 
       // skin = new Color(a,a, z);//= new Color(255, 175, 175);//= new Color(r, g, b);
        
        
           // purple aliens!!! 
        //skin = new Color(z,a, z);//= new Color(255, 175, 175);//= new Color(r, g, b); 
        
     // red aliens!!! 
   //  a = 60 + rand.nextInt(195);
    // skin = new Color(z,0,0);//= new Color(255, 175, 175);//= new Color(r, g, b); 
       
     
       
       
       
        
        
        //skin = new Color(r, g, b);
        notskin = new Color(g, b, b);
        line = new Color(0, 0, 0);
        shirtout = new Color(0,0,0);
        shirtfill = skin;//new Color(0,0,0);//  there can be all kind of colored ninjas, but for now, black...    new Color(g,b,r);
        int x = 1 + rand.nextInt(20) - 4;

       
        x = 1 + rand.nextInt(420) + 160;
         headsize = drawpicture.DrawPicture.size;
              headOutlinethickness = (int)(.08*headsize);// + x;
        skinsize = headsize - headOutlinethickness;
    
        
        int hundredth = (int)Math.ceil(headsize / 100);
        mouthThickness = (int)(.02*headsize);// = hundredth + rand.nextInt(2 * hundredth) ;
       // System.out.println("mouthThickness"+mouthThickness);
        int tenth = (int)Math.ceil(headsize /10);
        mouthWidth = (int)(.44*headsize);// mouthWidth = (int)(headsize / 2) + (1 + rand.nextInt(tenth) - (tenth / 2));//mouthWidth = headsize / 2;
        
        
        
        eyeSize = (int)(.04*headsize);//= 1 + rand.nextInt(3 * hundredth) + (2 * hundredth);

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
        skinX = headX + (headOutlinethickness / 2);
        skinY = headY + (headOutlinethickness / 2);

        
        shirtOutX = headX  - (int)(.46*headsize);
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
           // int race = 1 + rand.nextInt(11); // all races in the game 1 is humans only, 2 is humans and greens, 3 is humans, greens, and grays, etc...
              int race = 7 ;  // 1 = the human race
              
        setRandomVariables(raceCounter);//setRandomVariables(race);
        raceCounter++;
        if(raceCounter > 11){
            // show all races
            int allOfThem = 1 + rand.nextInt(11);
            setRandomVariables(allOfThem);
            
            
            if(raceCounter > 16){ 
                // show just humans
                  allOfThem = 1;
            setRandomVariables(allOfThem);
          
            }
            
             if(raceCounter > 21){ 
             
            raceCounter = 1;
            }
        }
          // setRandomVariables();
            //     int holdOn = 1 + rand.nextInt( 2000 ) ;
            //     t = new Timer(holdOn, this);
            // t.start();
        }

    }

    public void paintComponent(Graphics g) {

        // draw background 
       // Color wangsBlue = new Color(162, 223, 254);
        g.setColor(wangsBlue);
        g.fillRect(0, 0,1920,1080);
        
        
        
        /* draw tail outline
        g.setColor(shirtout);
        g.fillOval(shirtOutX , shirtOutY - (int)(.54*headsize), shirtOutSize, shirtOutSize);
      
           // draw tail skin
        g.setColor(shirtfill);
        g.fillOval(shirtFillX, shirtFillY - (int)(.54*headsize), shirtFillSize, shirtFillSize);
        
         // draw tail outline
        g.setColor(shirtout);
        g.fillOval(shirtOutX + (int)(.20*headsize) , shirtOutY - (int)(.42*headsize), shirtOutSize- (int)(.54*headsize), shirtOutSize- (int)(.54*headsize));
        
        
          // draw tail outline edge
        g.setColor(wangsBlue);
        g.fillOval(shirtOutX + (int)(.24*headsize) , shirtOutY - (int)(.38*headsize), shirtOutSize- (int)(.54*headsize), shirtOutSize- (int)(.54*headsize));
         g.fillRect((int)(.74*headsize),   (int)(.38*headsize),(int)(2.0*headsize),(int)(2.0*headsize));
        
     
        */
        
        int tailOffset = (int)(1.340*headsize);
        
        
          g.setColor(shirtout);
        g.fillOval(shirtOutX + tailOffset, shirtOutY - (int)(.54*headsize), shirtOutSize, shirtOutSize);
      
           // draw tail skin
        g.setColor(shirtfill);
        g.fillOval(shirtFillX+ tailOffset, shirtFillY - (int)(.54*headsize), shirtFillSize, shirtFillSize);
        
         // draw tail outline
        g.setColor(shirtout);
        g.fillOval(shirtOutX + (int)(.20*headsize)+ tailOffset , shirtOutY - (int)(.42*headsize), shirtOutSize- (int)(.54*headsize), shirtOutSize- (int)(.54*headsize));
        
        
          // draw tail outline edge
        g.setColor(wangsBlue);
        g.fillOval(shirtOutX + (int)(.24*headsize) + tailOffset, shirtOutY - (int)(.38*headsize), shirtOutSize- (int)(.54*headsize), shirtOutSize- (int)(.54*headsize));
        // g.fillRect((int)(.74*headsize),   (int)(.38*headsize),(int)(2.0*headsize),(int)(2.0*headsize));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
             // draw box to block out side of tail
        g.setColor(shirtout);
        g.fillOval(shirtOutX, shirtOutY, shirtOutSize, shirtOutSize);
        
        
        
        
        
        // draw headOutline
        g.setColor(headOutline);
        g.fillOval(headX, headY, headsize, headsize);
        // outline for ears
         g.fillRoundRect((int)(.82*headX), (int)(1.68*headY), (int)(.14*headsize), (int)(.28*headsize), headX, headY + 60 );
         g.fillRoundRect((int)(2.93*headX), (int)(1.68*headY), (int)(.14*headsize), (int)(.28*headsize), headX, headY + 60 );
        
          // draw shirt
        g.setColor(shirtfill);
        g.fillOval(shirtFillX, shirtFillY, shirtFillSize, shirtFillSize);
        
        // draw face
        g.setColor(skin);
        g.fillOval(skinX, skinY, skinsize, skinsize);
        // draw ears
        g.fillRoundRect((int)(.86*headX), (int)(1.72*headY), (int)(.13*headsize), (int)(.22*headsize), headX, headY + 60 );
         g.fillRoundRect((int)(2.92*headX), (int)(1.72*headY),(int)(.11*headsize), (int)(.22*headsize), headX, headY + 60 );
        
        
        // draw slit for eyes
         g.setColor(shirtfill);
        // g.fillRect((int)(1.34*headX), (int)(1.58*headY), (int)(.69*headsize), (int)(.18*headsize));
    
        // set color
        g.setColor(line);

        //draw left eye
        g.fillOval(eyeLx, eyeLy, eyeSize, eyeSize);
        // draw right eye
        g.fillOval(eyeRx, eyeRy, eyeSize, eyeSize);

        //  draw a mouth
      g.fillRect(mouthX, mouthY, mouthWidth, mouthThickness);
        
       
        
        
        // draw label
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(.24*headsize))); 
         int stringX = (int)(.2*headsize);
         int stringY = (int)(.28*headsize);
        g.drawString(race + " monkey", stringX,stringY);

    }

}

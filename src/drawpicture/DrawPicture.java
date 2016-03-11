/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpicture;

import java.util.Random;

/**
 *
 * @author mark
 */
public class DrawPicture {

     public static  DFrame diggityDog;// = new DFrame();
     public static int size = 102; // RIGHT NOW 100 IS MINIMUM, or else it breaks... tricky, (not difficult, should be obvious) don't have time to find
     public static int speed = 6000; // in miliseconds
     public static int thisManyFaces = 1;
     public static int type = 5;
     public static int choice = 2;// 1 for random, 2 for wall at 102 size
     
    public static void main(String[] args) {
        
        switch(choice){
            case 1:  randomPlacement(); break;  
            case 2: tiledPlacement(); break;  
            
        }
     //  randomPlacement();
   // tiledPlacement();
      
    }  // end main
    
    
    public static void randomPlacement(){
        Random rand = new Random();
        int x;// = 1 + rand.nextInt(1700);
               int y;// = 1 + rand.nextInt(800);
         for(int i = 0; i < thisManyFaces; i++){
                x = 1 + rand.nextInt(1700);
                y = 1 + rand.nextInt(800);
             diggityDog = new DFrame(x,y);
        }
        
    }  // end random placement
    
    
  public static void tiledPlacement(){
      int columnz = 9;
      int rowz = 5;
       int x = 0;// = 1 + rand.nextInt(1700);
      int y = 0;// = 1 + rand.nextInt(800);
      for(int i = 0; i < rowz; i++){
          for(int j = 0; j < columnz; j++){
               diggityDog = new DFrame(x,y);
               x = x + (size*2) + 10;
               
          }
          y = y + (size*2) + 20;
          x = 0;
      }
      
  }  // end tiled placement
    
    
}  // end class

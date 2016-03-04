/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawpicture;

import java.awt.Graphics;
import java.util.*;
import java.text.DateFormat;

import javax.swing.JPanel;

public class Clock extends JPanel implements Runnable {
    private Thread clockThread = null;
    public void start() {
        if (clockThread == null) {
            clockThread = new Thread(this, "Clock");
            clockThread.start();
        }
    }
    public void run() {
        Thread myThread = Thread.currentThread();
        while (clockThread == myThread) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //the VM doesn’t want us to sleep anymore,
                //so get back to work
            }
        }
    }
    public void paint(Graphics g) {
        //get the time and convert it to a date
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        //format it and display it
        DateFormat dateFormatter =
				DateFormat.getTimeInstance();
        g.drawString(dateFormatter.format(date), 5, 10);
    }
    //overrides Applet’s stop method, not Thread’s
    public void stop() {
        clockThread = null;
    }
}
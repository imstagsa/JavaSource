package md;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

public class TestGamePanel extends JPanel {

	//List<Integer, Iteger>
	
	public TestGamePanel(){
		
		MouseAdapter mouseAdapter =  new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("clicked");
			}
		};
		
		addMouseListener(mouseAdapter);
     }

/*	public void getSecondLine()
	{
		int startX = x;
		int startY = y;
		int endX   = x + 40 * Math.sin(angle);
		int endY   = y + 40 * Math.cos(angle);
	}*/
	
     public void paintComponent(Graphics g) {
    	 
    	 Random rand = new Random();
    	 int x21 = rand.nextInt(595) + 1;
    	 int y21 = rand.nextInt(595) + 1;
    	 //int border = rand.nextInt(3);
    	 int border = 0;
    	 int randomNum2 = rand.nextInt(595) + 1;
    	 int x22, y22;
		 
		 if(border == 0)
		 {
			 x22 = randomNum2;
			 y22 = 0;
		 }
		 else if(border == 1)
		 {
			 x22 = 595;
			 y22 = randomNum2;
		 }
		 else if(border == 2)
		 {
			 x22 = randomNum2;
			 y22 = 595;
		 }
		 else
		 {
			 x22 = 0;
			 y22 = randomNum2;
		 }
		 System.out.println("randomNum=" + border + "   x21=" + x21 + "   y21=" + y21 + "   x22=" + x22 + "   y22=" + y22);
		 
    	 g.drawLine(x21, y21, x22, y22);
    	 double angel = getAngel(x21, y21, x22, y22, border);
    	
    	 System.out.println("angel " + angel);
    	 angel = Math.abs(angel);
    	 
    	 System.out.println("angel " + angel);
    	  // - angel;
    	 
    	 
    	 // draw second line
    	 double secondAngel = 180;
    	 if(border == 0)
    	 {
    		 if(angel < 90)
    			 //secondAngel = 180 - angel;
    			 secondAngel = 550 - angel;
    		 else secondAngel = 270 + angel;
    	 }
    	 System.out.println("secondAngel " + secondAngel);
    	 double secondAngel2 = secondAngel * Math.PI / 180;
    	 int endX = (int)(x22 + 140 * Math.sin(secondAngel2));
    	 int endY = (int)(y22 + 140 * Math.cos(secondAngel2));
    	 g.setColor(Color.BLUE);
    	 g.drawLine(x22, y22, endX, endY);
     }

     
/*     public double leftSideX(double angle, int length){
    	    double x = this.getWidth()/2 - (length * Math.cos(Math.toRadians(90-(Math.toDegrees(angle)-90))));
    	    return x;
    	}

    	public double leftSideY(double angle, int length){
    	    double y = this.getHeight() - (length * Math.sin(Math.toRadians(90-(Math.toDegrees(angle)-90))));
    	    return y;
    	}

    	public double rightSideX(double angle, int length){
    	    double x = this.getWidth()/2 + (length * Math.cos(angle));
    	    return x;
    	}

    	public double rightSideY(double angle, int length){
    	    double y = this.getHeight() - (length * Math.sin(angle));
    	    return y;
    	}*/
     
     
	/**
	 * get angel between to lines
	 * @param x21
	 * @param y21
	 * @param x22
	 * @param y22
	 * @param border
	 */
     public double getAngel(int x21, int y21, int x22, int y22, int border)
     {

 		int x11 = 0, y11 = 0, x12 = 0, y12 = 0;
 		if(border == 0)
 		{
 			x12 = 595; 
 		}
 		else if(border == 1)
 		{
 			x11 = 595;
 			x12 = 595; 
 			y12 = 595;
 		}
 		else if(border == 2)
 		{
 			y11 = 595; 
 			x12 = 595; 
 			y12 = 595;
 		}
 		else
 			y12 = 595;
 		
 	    int l1x = x12 - x11; 
 	    int l1y = y12 - y11;
 	    int l2x = x22 - x21;
 	    int l2y = y22 - y21;
 	    double atan1 = 180.0 / Math.PI * Math.atan2(l1y, l1x);
 	    double atan2 = 180.0 / Math.PI * Math.atan2(l2y, l2x);
 	    //System.out.println(atan1);
 	    //System.out.println(atan2);
 	    return atan2;
     }
}

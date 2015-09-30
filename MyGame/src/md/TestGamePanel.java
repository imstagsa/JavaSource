package md;
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
    	 int x21 = rand.nextInt(600) + 1;
    	 int y21 = rand.nextInt(600) + 1;
    	 int border = rand.nextInt(3);
    	 int randomNum2 = rand.nextInt(600) + 1;
    	 int x22, y22;
		 
		 if(border == 0)
		 {
			 x22 = randomNum2;
			 y22 = 0;
		 }
		 else if(border == 1)
		 {
			 x22 = 600;
			 y22 = randomNum2;
		 }
		 else if(border == 2)
		 {
			 x22 = randomNum2;
			 y22 = 600;
		 }
		 else
		 {
			 x22 = 0;
			 y22 = randomNum2;
		 }
		 System.out.println("randomNum=" + border + "   x21=" + x21 + "   y21=" + y21 + "   x22=" + x22 + "   y22=" + y22);
		 
    	 g.drawLine(x21, y21, x22, y22);
    	 getAngel(x21, y21, x22, y22, border);    	 
     }

     
     
     public void getAngel(int x21, int y21, int x22, int y22, int border)
     {

 		int x11, y11, x12, y12;
 		if(border == 0)
 		{
 			x11 = 0;
 			y11 = 0; 
 			x12 = 600; 
 			y12 = 0;
 		}
 		else if(border == 1)
 		{
 			x11 = 600;
 			y11 = 0; 
 			x12 = 600; 
 			y12 = 600;
 		}
 		else if(border == 2)
 		{
 			x11 = 0;
 			y11 = 600; 
 			x12 = 600; 
 			y12 = 600;
 		}
 		
 		else
 		{
 			x11 = 0;
 			y11 = 0; 
 			x12 = 0; 
 			y12 = 600;
 		}
 		
 	    int l1x = x12 - x11; 
 	    int l1y = y12 - y11;
 	    int l2x = x22 - x21;
 	    int l2y = y22 - y21;
 	    double atan1 = 180.0 / Math.PI * Math.atan2(l1y, l1x);
 	    System.out.println(atan1);
 	    double atan2 = 180.0 / Math.PI * Math.atan2(l2y, l2x);
 	    System.out.println(atan2);
     }
}

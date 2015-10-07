package md;

import java.util.Random;

public class MyCircle {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int curX;
	private int curY;
	private int radius;
	private int border;
	private int height;
	
	public MyCircle(int height)
	{
		this.height = height;
		Random rand = new Random();
		startX = rand.nextInt(height) + 1;
		startY = rand.nextInt(height) + 1;
   	 	border = rand.nextInt(3);
   	    radius = rand.nextInt(45);
   	 	int randomNum2 = rand.nextInt(height) + 1;

		 if(border == 0)
		 {
			 endX = randomNum2;
			 endY = 0;
		 }
		 else if(border == 1)
		 {
			 endX = height;
			 endY = randomNum2;
		 }
		 else if(border == 2)
		 {
			 endX = randomNum2;
			 endY = height;
		 }
		 else
		 {
			 endX = 0;
			 endY = randomNum2;
		 }
		 
		 //System.out.println("randomNum=" + border + "   x21=" + x21 + "   y21=" + y21 + "   x22=" + x22 + "   y22=" + y22);
	}
	
	public void check()
	{
		if((startX - radius <=0) ||
		   (startY - radius <=0) ||
		   (endX + radius >= height) ||
		   (endY + radius >= height))
		{
			//do something
		}
	}
	
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
 			x12 = 580; 
 		}
 		else if(border == 1)
 		{
 			x11 = 580;
 			x12 = 580; 
 			y12 = 580;
 		}
 		else if(border == 2)
 		{
 			y11 = 580; 
 			x12 = 580; 
 			y12 = 580;
 		}
 		else
 			y12 = 580;
 		
 	    //int l1x = x12 - x11; 
 	    //int l1y = y12 - y11;
 	    int l2x = x22 - x21;
 	    int l2y = y22 - y21;
 	    //double atan1 = 180.0 / Math.PI * Math.atan2(l1y, l1x);
 	    //double atan2 = 180.0 / Math.PI * Math.atan2(l2y, l2x);
 	    double atan2 = Math.toDegrees(Math.atan2(l2y, l2x));
 	    //System.out.println("Radiants " + Math.toDegrees(Math.atan2(l2y, l2x)));
 	    return atan2;
     }
}

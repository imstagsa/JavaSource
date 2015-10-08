package md;

import java.util.Random;

public class MyCircle {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int curX;
	private int curY;
	private int stepX;
	private int stepY;
	private int radius;
	private int border;
	private int height;

	

	public MyCircle(int height)
	{
		this.height = height;
		Random rand = new Random();
		radius = rand.nextInt(100);
		startX = rand.nextInt(height - radius * 2) + radius;
		startY = rand.nextInt(height - radius * 2) + radius;
   	 	border = rand.nextInt(3);
   	    
   	 	int randomNum2 = rand.nextInt(height - radius * 2) + radius;
   	 	//if(randomNum2 < radius) randomNum2 = radius;

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
		 curX = startX;
		 curY = startY;
		 getStepLength();
		 //g.drawLine(startX, startX, endX, endY);
		 System.out.println("randomNum=" + border + "   startX=" + startX + "   startY=" + startY + "   endX=" + endX + "   endY=" + endY);
		 System.out.println("stepX=" + stepX + "   stepY=" + stepY);
	}
	
	
	public int getCurX() {
		return curX;
	}

	public int getCurY() {
		return curY;
	}
	public int getRadius() {
		return radius;
	}

	private void getStepLength()
	{
		int xl = endX - startX;
		int yl = endY - startY;
		stepX = 1; stepY = 1;
		//System.out.println("startX " + startX + "  startY " + startY);
		//System.out.println("endX " + endX + "  endY " + endY);
		System.out.println("xl " + xl + "  yl " + yl);
		if(Math.abs(xl) < Math.abs(yl))
		{
			stepX = 1;
			stepY = (int)(yl / xl);
		}
		else if(Math.abs(xl) > Math.abs(yl))
		{
			stepY = 1;
			stepX = (int)(xl / yl);
		}
	   	 System.out.println("stepX " + stepX);
	   	 System.out.println("stepY " + stepY);
		if(xl < 0)
			stepX = stepX - (stepX * 2);
		if(yl < 0)
			stepY = stepY - (stepY * 2);
		
   	// System.out.println("stepX " + stepX);
   	// System.out.println("stepY " + stepY);
	}
	
	public void checkBorder()
	{

		if(curY - radius <= 0)
		{
			border = 0;
		}
		else if(curX + radius >= this.height)
		{
			border = 1;
		}	
		else if(curY + radius >= this.height)
		{
			border = 2;
		}
		else if(curX - radius <= 0)
		{
			border = 3;
		}
		
	}
	
	public void move()
	{
		if((curX - radius <= 0) ||
		   (curY - radius <= 0) ||
		   (curX + radius >= height) ||
		   (curY + radius >= height))
		{
			System.out.println("Move3 startX " + startX + "  startY " + startY);
			System.out.println("Move3 endX " + endX + "  endY " + endY);
			checkBorder();
			if(stepX > 0) endX = curX + radius;
			else endX = curX - radius;
			if(stepY > 0) endY = curY + radius;
			else endY = curY - radius;
			
			System.out.println("Move4 startX " + startX + "  startY " + startY);
			System.out.println("Move4 endX " + endX + "  endY " + endY);
			double angel = getAngel(startX, startY, endX, endY, border);
			startX = endX;
			startY = endY;
			
			double secondAngel = 180;
	    	 if(border == 0)
	    	 {
	    		 angel = Math.abs(angel);
	    		 if(angel > 90)  secondAngel = 360 - angel + 90;
	    		 else secondAngel = 360 + Math.abs(90 - angel);
	    	 }
	    	 if(border == 1)
	    	 {
	    		 secondAngel = 270 + angel;
	    	 }
	    	 if(border == 2)
	    	 {
	    		 secondAngel = 180 + Math.abs(angel) - 90;
	    	 }
	    	 if(border == 3)
	    	 {
	    		 if(angel > 0)
	    			 secondAngel = 360 + Math.abs(angel) - 90; 
	    		 else secondAngel = 90 +  Math.abs(angel) - 90;
	    	 }
	    	 System.out.println("secondAngel " + angel);
	    	 System.out.println("secondAngel " + secondAngel);
	    	 //System.out.println("stepX border " + stepX);
	    	 //System.out.println("stepY border" + stepY);
	    	 //secondAngel = secondAngel * Math.PI / 180;
	    	 System.out.println("Move startX " + startX + "  startY " + startY);
				System.out.println("Move endX " + endX + "  endY " + endY);
	    	 secondAngel = Math.toRadians(secondAngel);
	    	 endX = (int)(startX + 140 * Math.sin(secondAngel));
	    	 endY = (int)(startY + 140 * Math.cos(secondAngel));
	    	 System.out.println("Move2 startX " + startX + "  startY " + startY);
				System.out.println("Move2 endX " + endX + "  endY " + endY);
	    	 getStepLength();
	    	 curX = startX + stepX;
			 curY = startY + stepY;
	    	 
		}
		else
		{
			curX = curX + stepX;
			curY = curY + stepY;
			System.out.println("curX " + curX);
	    	System.out.println("curY " + curY);
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

 		int x11 = radius, y11 = radius, x12 = radius, y12 = radius;
 		if(border == 0)
 		{
 			x12 = height - radius; 
 		}
 		else if(border == 1)
 		{
 			x11 = height  - radius;
 			x12 = height - radius; 
 			y12 = height - radius;
 		}
 		else if(border == 2)
 		{
 			y11 = height - radius; 
 			x12 = height - radius; 
 			y12 = height - radius;
 		}
 		else
 			y12 = height - radius;
 		
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

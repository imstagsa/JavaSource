package md;

import java.awt.geom.Line2D;
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
		radius = rand.nextInt(80) + 20;
		radius = 80;
		startX = rand.nextInt(height - radius * 2) + radius;
		startY = rand.nextInt(height - radius * 2) + radius;
   	 	border = rand.nextInt(3);
   	 	int randomNum2 = rand.nextInt(height - radius * 2) + radius;
   	 
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

		if(Math.abs(xl) < Math.abs(yl))
		{
			stepX = 1;
			if(xl != 0 && yl !=0)
				stepY = (int)(Math.abs(yl) / Math.abs(xl));
			else stepY = 1;
		}
		else if(Math.abs(xl) > Math.abs(yl))
		{
			stepY = 1;
			if(xl != 0 && yl !=0)
				stepX = (int)(Math.abs(xl) / Math.abs(yl));
			else stepX = 1;
		}
		
		if(xl < 0)
			stepX = stepX - (stepX * 2);
		if(yl < 0)
			stepY = stepY - (stepY * 2);
	}
	
	public boolean checkBorder()
	{

		if(curY - stepY <= 0)
		{
			border = 0;
			return true;
		}
		else if(curX + radius >= this.height)
		{
			border = 1;
			return true;
		}	
		else if(curY + radius >= this.height)
		{
			border = 2;
			return true;
		}
		else if(curX - stepX <= 0)
		{
			border = 3;
			return true;
		}
		return false;
	}
	
	
	
	public void move()
	{
		
		if(checkBorder())
		{
			if(border == 0)
			{
				endX = curX;
				endY = 0;
			}
			else if(border == 1)
			{
				endX = curX + radius;
				endY = curY;
			}
			else if(border == 2)
			{
				endX = curX;
				endY = curY + radius;
			}
			else if(border == 3)
			{
				endX = 0;
				endY = curY + radius;
			}
		
			double angel = getAngel(startX, startY, endX, endY);
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
	    	 secondAngel = Math.toRadians(secondAngel);
	    	 endX = (int)(startX + 600 * Math.sin(secondAngel));
	    	 endY = (int)(startY + 600 * Math.cos(secondAngel));
			 getStepLength();
		   	 curX = curX + stepX;
			 curY = curY + stepY;
		}
		else
		{
			curX = curX + stepX;
			curY = curY + stepY;
		}
	}
	
     public double getAngel(int x21, int y21, int x22, int y22)
     {	
 	    int l2x = x22 - x21;
 	    int l2y = y22 - y21;
 	    double atan2 = Math.toDegrees(Math.atan2(l2y, l2x));
 	    return atan2;
     }
     
     public double angleBetween2Lines(Line2D line1, Line2D line2)
     {
    	 double atan2 = 0;
    	 double slope1 = (line1.getY1() - line1.getY2()) / (line1.getX1() - line1.getX2());
    	 double slope2 = (line2.getY1() - line2.getY2()) / (line2.getX1() - line2.getX2());
         try{
        	 atan2  = Math.atan((slope1 - slope2) / (1 - (slope1 * slope2)));
         }
         catch (Exception dbze){}
         return atan2;
     }
}

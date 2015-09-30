package md;
import java.util.Random;

public class MainTest {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;
		System.out.println(randomNum);
		int x11, y11, x12, y12;
		if(randomNum == 0)
		{
			x11 = 0;
			y11 = 0; 
			x12 = 600; 
			y12 = 0;
		}
		else if(randomNum == 1)
		{
			x11 = 600;
			y11 = 0; 
			x12 = 600; 
			y12 = 600;
		}
		else if(randomNum == 2)
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
		
		int x21 = 0, y21 = 40, x22 = 60, y22 = 45;
	    int l1x = x12 - x11; 
	    int l1y = y12 - y11;
	    int l2x = x22 - x21;
	    int l2y = y22 - y21;
	    double atan1 = 180.0 / Math.PI * Math.atan2(l1y, l1x);
	    System.out.println(atan1);
	    double atan2 = 180.0 / Math.PI * Math.atan2(l2y, l2x);
	    System.out.println(atan2);
		
	    if(randomNum == 3)
	    {
	    	if(atan1 == 0 && atan2 != 0)
	    	{
	    		System.out.println("sd");
	    	}
	    }
	}
}

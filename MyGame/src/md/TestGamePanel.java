package md;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class TestGamePanel extends JPanel {

	private MyCircle myCircle;
	private List<MyCircle> myCircleList = new ArrayList();
	
	public TestGamePanel(MyCircle myCircle){
		
		myCircleList.add(myCircle);
		
		MouseAdapter mouseAdapter =  new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myCircleList.add(new MyCircle(800, 600));
			}
		};
		
		addMouseListener(mouseAdapter);
     }
	
	public void paintComponent(Graphics g)
	{
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < myCircleList.size(); i++)
		{
			check_collision(myCircleList.get(i));
			myCircleList.get(i).move();
			int r = myCircleList.get(i).getRadius();
			int x = myCircleList.get(i).getCurX();
			int y = myCircleList.get(i).getCurY();
			g.setColor(Color.RED);
			g.drawRect (0, 0, this.getWidth(), this.getHeight()); 
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x,y,r,r);
				
		}
	}
	
	public void check_collision(MyCircle circle)
	{
		double radius1 = circle.getRadius();
		double X1 = circle.getCurX() - radius1 / 2;
	    double Y1 = circle.getCurY() - radius1 / 2;
	   
	    
	    for(int i = 0; i < myCircleList.size(); i++)
		{
			if (circle != myCircleList.get(i))
			{
				//System.out.println("Uraa");
				double radius2 = myCircleList.get(i).getRadius();
				double X2 = myCircleList.get(i).getCurX() - radius2 / 2;
			    double Y2 = myCircleList.get(i).getCurY() - radius2 / 2;
			       

			    double distance = Math.pow((X1 - X2) * (X1 - X2) + (Y1 - Y2) * (Y1 - Y2), 0.5);
			    if (radius2 >= radius1 && distance <= (radius2 - radius1)){
			        System.out.println("Circle 1 is inside Circle 2.");
			    }
			    else if (radius1 >= radius2 && distance <= (radius1 - radius2) ) {
			        System.out.println("Circle 2 is inside Circle 1.");
			    }
			    else if (distance > (radius1 + radius2)){
			        //System.out.println("Circle 2 does not overlap Circle 1.");
			    }
			    else {
			        System.out.println("Circle 2 overlaps Circle 1.");
/*			        if(circle.getStepX() < 0)
			        	circle.setStepX(circle.getStepX() + Math.abs(circle.getStepX() * 2));
			        else if(circle.getStepX() > 0)
			        	circle.setStepX(circle.getStepX() - Math.abs(circle.getStepX() * 2));*/
			        }
			    }
			}
		}

}

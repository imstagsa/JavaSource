package md;

import javax.swing.JPanel;

public class MyThread implements Runnable {
	
	private JPanel panel;
	
	public MyThread(JPanel panel)
	{
		this.panel = panel;
	}
	
    public void run(){
       try {
		while(true)
		{
			Thread.sleep(100);
			panel.repaint();
			
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
  }

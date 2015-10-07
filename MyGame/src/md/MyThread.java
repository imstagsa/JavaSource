package md;

import java.util.List;

import javax.swing.JPanel;

public class MyThread extends Thread {
	
	private JPanel panel;
	private List<MyCircle> listMyCircle;

	public MyThread(JPanel panel)
	{
		this.panel = panel;
	}
	
    public void run(){
       System.out.println("MyThread running");
    }
  }

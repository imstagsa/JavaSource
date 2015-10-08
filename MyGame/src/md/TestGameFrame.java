package md;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

public class TestGameFrame extends JFrame  {


	private static final long serialVersionUID = 1L;
	private static TestGamePanel panel = new TestGamePanel(new MyCircle(580));

	public TestGameFrame() {
		//panel.setBackground(Color.white);
		Container c = getContentPane();
		panel.setSize(580, 580);
    	c.add(panel);
	}

	public static void main(String[] args) {
		TestGameFrame frame = new TestGameFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyThread myThread = new MyThread(panel);

		   Thread thread = new Thread(myThread);
		   thread.start();
    	}
}

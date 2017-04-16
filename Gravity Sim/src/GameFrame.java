import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 5431095344210049871L;
	protected long timekeep = System.nanoTime();
	protected long runningtimekeep = 0;
	protected int iter = 0;

	public GameFrame() throws AWTException {
		super("Game Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final MatterBoxes matterBoxes = new MatterBoxes();
		getContentPane().add(matterBoxes, BorderLayout.CENTER);
		matterBoxes.setBackground(Color.black);
		final MatterManager physics = new MatterManager();
		final Robot robot = new Robot();
		robot.delay(1000);
		
		for (int i = 0; i < physics.list.size(); i++) {
			matterBoxes.addMatter(physics.list.get(i));
		}
		
		final Timer timer = new Timer(1000 / 60, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				iter += 1;
				physics.determineAllVectors();
				physics.gravitateAll();
				if (iter == 900){
					physics.printAllLocs();
				}
				for (int i = 0; i < physics.list.size(); i++) {
					matterBoxes.moveMatter(physics.list.get(i).x, physics.list.get(i).y, i);
				}
				repaint();
				timekeep = (System.nanoTime() - timekeep)/100000;
				runningtimekeep += timekeep;
				System.out.println(runningtimekeep/iter);
				timekeep  = System.nanoTime();
			}
		});
		
		
		timer.setRepeats(true);
		timer.start();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) throws AWTException {
		new GameFrame();
	}

}
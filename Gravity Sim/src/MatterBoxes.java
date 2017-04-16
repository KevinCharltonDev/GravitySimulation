import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class MatterBoxes extends JPanel {

		private static final long serialVersionUID = 2896160711316110276L;
		private static final int PREF_W = 1280;
		private static final int PREF_H = 720;
		private List<Rectangle> massRectangle = new ArrayList<Rectangle>();

		public void addMatter(MassBody particle) {
			Rectangle rect = new Rectangle((int)particle.x, (int)particle.y, 0, 0);
			massRectangle.add(rect);
		}

		public void moveMatter(double x, double y, int which) {
			massRectangle.get(which).setLocation((int)x,(int) y);
		}
	
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(PREF_W, PREF_H);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(255,255,255));
			for (int i = 0; i < massRectangle.size(); i ++) {
				g2.draw(massRectangle.get(i));
			}
		}

		

	}

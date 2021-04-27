package simplejavatexteditor;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Point{
	int x, y;
}

class CanvasPanel extends JPanel implements MouseMotionListener{
	private int index = 0;
	Point[] array = new Point[1000];
	
	public CanvasPanel() {
		this.addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(index > 1000)
			return;
		array[index] = new Point();
		array[index].x = e.getX();
		array[index].y = e.getY();
		index++;
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Point p : array)
			if(p != null)
				g.drawRect(p.x, p.y, 1, 1);
	}
	
	public void mouseMove(MouseEvent args) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

public class Canvasframe extends JFrame{
	public Canvasframe() {
		setSize (500, 300);
		setTitle("마우스로 그리기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new CanvasPanel());
		setVisible(true);
	}
}


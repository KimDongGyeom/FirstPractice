// java 2���� ����(4)
package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

public class BazierCurve extends JPanel implements MouseListener, MouseMotionListener{
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int drageIndex = -1;
	
	public BazierCurve() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		// �� 4�� ��� (���� ���ϱ�)
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.red);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		// �� 4���� �̿��� ������ � �׸���
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		GeneralPath path = new GeneralPath();
		path.moveTo(xs[0], ys[0]);
		path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		
		g2d.draw(path);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		drageIndex = -1;
		// 4���� �� �߿��� � ���� ������� �˻�...

		for (int i =0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[i]-4, ys[i]-4, 20, 20);
			
			if (r.contains(e.getX(), e.getY())) {
				drageIndex = i; // 0���� ���������� 0~4
				break;
			}
		}
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		drageIndex = -1;
	}
	
	@Override // Ŭ�� �� ���¿��� �����̴� ��.
	public void mouseDragged(MouseEvent e) {
		if (drageIndex != -1) {
			xs[drageIndex] = e.getX();
			ys[drageIndex] = e.getY();
		}
		
		repaint();
	}
	

// �Ⱦ��� �ڵ� ~
	@Override // Ŭ������ ���� ���¿��� �����̴� ��.
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
// �Ⱦ��� �ڵ�~
	
	
	public static void main(String[] args) {
		
	}
	
}
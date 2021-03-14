// java 2주차 수업(4)
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
		// 점 4개 찍기 (점색 정하기)
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.red);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		// 점 4개를 이용한 배지어 곡선 그리기
		
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
		// 4개의 점 중에서 어떤 점을 찍었는지 검사...

		for (int i =0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[i]-4, ys[i]-4, 20, 20);
			
			if (r.contains(e.getX(), e.getY())) {
				drageIndex = i; // 0으로 시작했지만 0~4
				break;
			}
		}
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		drageIndex = -1;
	}
	
	@Override // 클릭 한 상태에서 움직이는 것.
	public void mouseDragged(MouseEvent e) {
		if (drageIndex != -1) {
			xs[drageIndex] = e.getX();
			ys[drageIndex] = e.getY();
		}
		
		repaint();
	}
	

// 안쓰는 코드 ~
	@Override // 클릭하지 않은 상태에서 움직이는 것.
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
// 안쓰는 코드~
	
	
	public static void main(String[] args) {
		
	}
	
}
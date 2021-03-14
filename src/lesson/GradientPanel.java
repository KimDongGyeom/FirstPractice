// java 1���� ����(2)
package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class GradientPanel extends MyPanel1{
// ��� �ڹٴ� ������ 1���� ������ ������ ������ �ʾƵ� ���� ������ ������ �����Ѵ�.
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		// ���� �������� x,y��ǥ�� ���Ѵ�.
		// ���� ��� white��ǥ����~ red��ǥ�� ���Ѵ�.

		for (Shape s : shapeArray) { // ��ӹ޾ұ⶧���� ����� �����ϴ�.
			g2.setPaint(Color.red);
//			g2.setPaint(gp); // �׶��̼� ȿ���� ��Ÿ��
			g2.fill(s);
		}
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 130);
		frame.setTitle("Java 2D Shapers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new GradientPanel());
		frame.setVisible(true);
		
	}
}

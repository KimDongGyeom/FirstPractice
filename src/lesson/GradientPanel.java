// java 1주차 수업(2)
package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class GradientPanel extends MyPanel1{
// 모든 자바는 생성자 1개를 가지기 때문에 만들지 않아도 눈에 보이진 않지만 존재한다.
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		// 도형 내에서의 x,y좌표를 말한다.
		// 위의 경우 white좌표에서~ red좌표를 말한다.

		for (Shape s : shapeArray) { // 상속받았기때문에 사용이 가능하다.
			g2.setPaint(Color.red);
//			g2.setPaint(gp); // 그라데이션 효과가 나타남
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

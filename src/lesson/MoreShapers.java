
// java 1주차 수업(1)
package lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class MoreShapers extends JFrame {
	
	public MoreShapers() {
		this.setSize(600, 130);
		this.setTitle("Java 2D Shapers");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new MyPanel1(); // 이부분 // // // // // MyPanel

		this.add(panel);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MoreShapers();
		
	}
// 클래스를 만들때 public이 붙은 클래스는 단 하나만 가능하다.
}


class MyPanel1 extends JPanel {
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	
	public MyPanel1() { // rectangle이 shape를 상속하고 있어서 아래처럼 가능하다.
//		Shape rect = new Rectangle2D.Float(10, 10, 70, 80);
		shapeArray.add(new Rectangle2D.Float(10, 10, 70, 80)); // (사각형)
		shapeArray.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20)); //(모서리 둥근 사각형) cf) P515~
		shapeArray.add(new Ellipse2D.Float(210, 10, 80, 80)); // (원)
		shapeArray.add(new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN)); // 90: 각도. 오픈: 원호만 그려진다.
		shapeArray.add(new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD)); // (반원)
		shapeArray.add(new Arc2D.Float(510, 10, 80, 80, 45, 45, Arc2D.PIE)); // 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(3));
		for (Shape s : shapeArray) {
			g2.draw(s);
		}
	}
}

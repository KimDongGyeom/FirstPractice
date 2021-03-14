//  java 2주차 수업(3)
package lesson;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class MyPanel extends JPanel implements ActionListener {
	private Timer timer;
	private BufferedImage image;
	private final int STRAT_X = 0;
	private final int STRAT_Y = 250;
	private int x, y;
	
	public MyPanel() {
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension (500, 300));
		this.setDoubleBuffered(true);
		
		File file = new File("space.jpg");
		System.out.println(file.getAbsolutePath());
		
		try {
			image = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		x = STRAT_X;
		y = STRAT_Y;
		
		timer = new Timer(20, this);
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 이미지의 x ,y 좌표를 적절히 변경한다.
		 */
		x += 1;
		y -= 1;
		
		repaint();
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MyPanel panel = new MyPanel();
		frame.add(panel);
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}

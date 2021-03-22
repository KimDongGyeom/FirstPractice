// 2021.03.22 수업내용.

package dddd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniPingPongGame extends JPanel implements KeyListener {
	private Ball ball;
	protected Racquet racquet1;
	protected Racquet racquet2;
	
	public MiniPingPongGame() {
		ball = new Ball(this, Color.red); // this: MiniPingPongGame자기자진을 뜻함.
		this.setBackground(Color.green);
		racquet1 = new Racquet(this, 10, 150, Color.blue, 1);
		racquet2 = new Racquet(this, 560, 150, Color.yellow, 2);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	


	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
	}
	
	@Override // 여기에서 안쓰는 코드.
	public void keyTyped(KeyEvent e) {
	}
	
	void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong Game");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		MiniPingPongGame game = new MiniPingPongGame(); // 패널을 만듬.
		frame.add(game); // 프레임에 패널을 넣음
		frame.setVisible(true); // 보이게 만듬.
		while (true) { // 무한 루트 실행.
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Ball {
	private static final int RADIUS = 20;
	private int x = 0, y = 0, xSpeed = 1, ySpeed = 1;
	private MiniPingPongGame game;
	private Color color;
	
	public Ball(MiniPingPongGame game, Color color) {
		this.game = game;
		this.color = color;
	}
	
	void move() {
		if (x + xSpeed < 0)
			xSpeed = 1;
		if (x + xSpeed > game.getWidth() -2 * RADIUS)
			xSpeed = -1;
		if (y + ySpeed < 0)
			ySpeed = 1;
		if (y + ySpeed > game.getHeight() -2 * RADIUS)
			ySpeed = -1;
		if (collision()) // 라켓에 닿았는지 확인해야함(구현을 해야함!!!)
			xSpeed = -xSpeed;
		x += xSpeed;
		y += ySpeed;
	}
	
	private boolean collision() {
		Rectangle r1 = game.racquet1.getBounds();
		Rectangle r2 = game.racquet2.getBounds();
		Rectangle myr = getBounds();
		Boolean r1c = r1.intersects(myr);
		Boolean r2c = r2.intersects(myr);
		
		return r1c || r2c;

//		위 내용을 1줄로 줄여 쓴 것.(같은 의미)
//		return game.racquet1.getBounds().intersects(getBounds())
//				|| game.racquet2.getBounds().intersects(getBounds());
	}
	
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
}

class Racquet {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	private int x = 0, y = 0;
	private int id;
	
	private int xSpeed = 0;
	private int ySpeed = 0;
	private MiniPingPongGame game;
	private Color color;
	
	public Racquet(MiniPingPongGame game, int x, int y, Color color, int id) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
		this.id = id;
	}
	
	public void move() {
		if (y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
			y += ySpeed;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		ySpeed = 0;
	}
	
	public void keyPressed(KeyEvent e) { // ??키를 눌렀을 경우 x,y 좌료로 움직임.
		if (id == 1) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				ySpeed = -3;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				ySpeed = 3;
		}

		if (id == 2) {
			if (e.getKeyCode() == KeyEvent.VK_W)
			ySpeed = -3;
		else if (e.getKeyCode() == KeyEvent.VK_S)
			ySpeed = 3;

		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
}

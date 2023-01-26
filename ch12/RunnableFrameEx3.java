package ch12;
/*1.thread 기능
 * 2.9개의 프레임 실행(3열3행의 위치에 세팅)
 * 3.크기는 200*200
 * 4.원 색상은 랜덤색이고 갯수는 30개*/

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import awt.MColor;

public class RunnableFrameEx3 extends MFrame implements Runnable{
	
	Random r = new Random();
	int x, y;
	Color c;
	
	public RunnableFrameEx3(int x1, int y1) {
		super(200,200);
		setLocation(x1, y1);
		c = MColor.rColor();
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			x = r.nextInt(200);
			y = r.nextInt(200);
			try {
				Thread.sleep(100);
				repaint();
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	@Override
	public void update(Graphics g) {
		g.clearRect(x, y, 10, 10);
		paint(g);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx3 ra[] = new RunnableFrameEx3[9];
		for (int i = 0; i < ra.length; i++) {
			int x1 = 200 +(200*(i%3));
			int y1 = 200 +(200*(i/3));
			ra[i] = new RunnableFrameEx3(x1, y1);
			new Thread(ra[i]).start();
		}//for
	}


}

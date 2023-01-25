package event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx3 extends MFrame implements KeyListener{
	
	Button move;
	
	public KeyEventEx3() {
		super(500, 300, new Color(100,200,100));
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Graphics g = getGraphics();
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.setColor(Color.RED);
		g.drawString("code값 :" + (int)e.getKeyChar(), 30, 80);
		g.drawString("문자값 :" + e.getKeyChar(), 30, 180);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public static void main(String[] args) {
		new KeyEventEx3();
	}

}

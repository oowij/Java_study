package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventEx3 extends MFrame{
	
	Button btn;
	
	public MouseEventEx3() {
		add(btn = new Button("��ư"), BorderLayout.SOUTH);
		btn.addMouseListener(new MyMouseAdapter());
	}
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			//adapter �ʿ��� �޼��常 Override �ϸ��
			setBackground(MColor.rColor());
		}
	}
	public static void main(String[] args) {

	}

}

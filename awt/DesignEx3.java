package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class DesignEx3 extends MFrame{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"추가","지우기","전체지우기","종료"};
	TextField tf;
	String food[] ={"짜장면","짬뽕","우동"};
	
	public DesignEx3() {
		super(300,200);
		setTitle("디자인 예제3");
		setLayout(new BorderLayout());
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		for (int i = 0; i < b.length; i++) {
			b[i] = new Button(lab[i]);
			p.add(b[i]);
		}
		add(p, BorderLayout.EAST);

		
		list = new List();
		for (int i = 0; i < food.length; i++) {
			list.add(food[i]);
		}
		add(list);
		
		tf = new TextField();
		
		add(tf, BorderLayout.SOUTH);
		validate();
	}

	public static void main(String[] args) {
		new DesignEx3();
	}
}









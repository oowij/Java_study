package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

public class DesignEx1 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	
	public DesignEx1() {
		super(250,150);
		setTitle("������ ����1");
		setLayout(new BorderLayout());

		Panel p1 = new Panel();
		Panel p2 =new Panel();
		label = new Label("�����߿� ����", Label.CENTER);
		label.setBackground(Color.green);
		
		cbg = new CheckboxGroup();
		p1.add(cb1 = new Checkbox("���", cbg, true));
		p1.add(cb2 = new Checkbox("����", cbg, true));
		p1.add(cb3 = new Checkbox("����", cbg, true));
		
		p2.add(btn1 = new Button("start"));
		p2.add(btn1 = new Button("end"));
		
		add(label, "North");
		add(p1);
		add(p2, BorderLayout.SOUTH);
		validate();

	}	

	public static void main(String[] args) {
		new DesignEx1();
	}

}


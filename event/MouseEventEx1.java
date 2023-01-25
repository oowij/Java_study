package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventEx1 extends MFrame implements ActionListener, MouseListener {

   
   TextField tf;
   TextArea ta;
   Button bt1, bt2, bt3;
   
   public MouseEventEx1() {
      super(400, 500);
      setTitle("MouseEventEx1");
      tf = new TextField("안녕하세요!!!", 30);
      ta = new TextArea();
      bt1 = new Button("마우스시험용");
      bt2 = new Button("인사하기");
      bt3 = new Button("종료");
      Panel p1 = new Panel();
      p1.add(bt1);
      p1.add(bt2);
      p1.add(bt3);
      Panel p2 = new Panel();
      p2.add(tf);
      add(p1, BorderLayout.SOUTH);
      add(p2, BorderLayout.NORTH);
      add(ta, BorderLayout.CENTER);
      tf.addActionListener(this);
      bt2.addActionListener(this);
      bt3.addActionListener(this);
      bt1.addMouseListener(this);
      
      validate();
   }
   
   
   @Override
   public void mouseClicked(MouseEvent e) {
      ta.append("##mousePressed\n");

   }

   @Override
   public void mousePressed(MouseEvent e) {
      ta.append("##mousePressed\n");

   }

   @Override
   public void mouseReleased(MouseEvent e) {
      ta.append("##mousePressed\n");

   }

   @Override
   public void mouseEntered(MouseEvent e) {
      ta.append("##mousePressed\n");

   }

   @Override
   public void mouseExited(MouseEvent e) {
      ta.append("##mousePressed\n");

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      ta.append("##mousePressed\n");

   }

   public static void main(String[] args) {
      new MouseEventEx1();

   }

}
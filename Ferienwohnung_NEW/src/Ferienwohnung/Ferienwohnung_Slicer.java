package Ferienwohnung;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ferienwohnung_Slicer extends JFrame implements ActionListener {
	ImageIcon s[];
	JLabel l;
	JButton b1, b2;
	int i, l1;
	JPanel p;

	public static void main(String args[]) {
		Ferienwohnung_Slicer obj = new Ferienwohnung_Slicer();
	}

	public Ferienwohnung_Slicer() {
		setLayout(new BorderLayout());
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JPanel p = new JPanel(new FlowLayout());
		b1 = new JButton("<<");
		b2 = new JButton(">>");
		p.add(b1);
		p.add(b2);
		add(p, BorderLayout.SOUTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
		s = new ImageIcon[3];
		s[0] = new ImageIcon("Fewo11.jpg");
		s[1] = new ImageIcon("Fewo12.jpg");
		s[1] = new ImageIcon("Fewo13.jpg");
		l = new JLabel("", JLabel.CENTER);
		add(l, BorderLayout.CENTER);
		l.setIcon(s[0]);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "This is First Image");
			} else {
				i = i - 1;
				l.setIcon(s[i]);
			}
		}
		if (e.getSource() == b2) {
			if (i == s.length - 1) {
				JOptionPane.showMessageDialog(null, "This is LastImage");
			} else {
				i = i + 1;
				l.setIcon(s[i]);
			}
		}
	}

}

package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JFrame implements ActionListener{
	JLabel t = new JLabel("로그인");
	JButton set = new JButton("회원가입");
	JPanel panel = new JPanel();
	public Login() {
		this.setBounds(100,300, 200, 150);
		panel.setLayout(new FlowLayout());
		panel.add(set);
		this.add(panel,"Center");
		set.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(set)) {
			boolean a = true;
			Test_2 aTest_2 = new Test_2();
		}
		
	}
	
}

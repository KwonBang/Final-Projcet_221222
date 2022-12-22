package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test_2 extends JFrame implements ActionListener{
	JLabel title = new JLabel("회원가입");
	
	JPanel id_panel = new JPanel();
	JLabel id = new JLabel("아이디");
	JTextField id_text =new JTextField(10);
	
	JPanel name_panel = new JPanel();
	JLabel name = new JLabel("이름");
	JTextField name_text =new JTextField(10);
	
	JPanel pass_panel = new JPanel();
	JLabel pass = new JLabel("비밀번호");
	JTextField pass_text =new JTextField(10);
	
	JPanel tel_panel = new JPanel();
	JLabel tel = new JLabel("전화번호");
	JTextField tel_text =new JTextField(10);
	
	JPanel panel = new JPanel();
	
	JPanel btn = new JPanel();
	JButton set = new JButton("가입");
	JButton reset = new JButton("초기화");
	JButton exit = new JButton("종료");
	
	public Test_2() {
		this.setBounds(200,250, 250, 250);
		id_panel.setLayout(new FlowLayout());
		id_panel.add(id);
		id_panel.add(id_text);
		name_panel.setLayout(new FlowLayout());
		name_panel.add(name);
		name_panel.add(name_text);
		pass_panel.setLayout(new FlowLayout());
		pass_panel.add(pass);
		pass_panel.add(pass_text);
		tel_panel.setLayout(new FlowLayout());
		tel_panel.add(tel);
		tel_panel.add(tel_text);
		btn.setLayout(new FlowLayout());
		btn.add(set);
		btn.add(reset);
		btn.add(exit);
		panel.add(id_panel);
		panel.add(name_panel);
		panel.add(pass_panel);
		panel.add(tel_panel);
		this.add(title,"North");
		this.add(panel,"Center");
		this.add(btn,"South");
		
		panel.setLayout(new GridLayout(4, 1));	//행,열 고정
		btn.setLayout(new GridLayout(1, 3));	//행,열 고정
		
		set.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp = e.getSource();
		if(temp.equals(set)) {
			title.setText("아이디/이름/비번/전번");
		}else if(temp.equals(reset)) {
			id_text.setText("");
			name_text.setText("");
			pass_text.setText("");
			tel_text.setText("");
		}else if(temp.equals(exit)) {
			System.exit(0);
		}
	}

}

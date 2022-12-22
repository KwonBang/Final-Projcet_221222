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
	JLabel title = new JLabel("ȸ������");
	
	JPanel id_panel = new JPanel();
	JLabel id = new JLabel("���̵�");
	JTextField id_text =new JTextField(10);
	
	JPanel name_panel = new JPanel();
	JLabel name = new JLabel("�̸�");
	JTextField name_text =new JTextField(10);
	
	JPanel pass_panel = new JPanel();
	JLabel pass = new JLabel("��й�ȣ");
	JTextField pass_text =new JTextField(10);
	
	JPanel tel_panel = new JPanel();
	JLabel tel = new JLabel("��ȭ��ȣ");
	JTextField tel_text =new JTextField(10);
	
	JPanel panel = new JPanel();
	
	JPanel btn = new JPanel();
	JButton set = new JButton("����");
	JButton reset = new JButton("�ʱ�ȭ");
	JButton exit = new JButton("����");
	
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
		
		panel.setLayout(new GridLayout(4, 1));	//��,�� ����
		btn.setLayout(new GridLayout(1, 3));	//��,�� ����
		
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
			title.setText("���̵�/�̸�/���/����");
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

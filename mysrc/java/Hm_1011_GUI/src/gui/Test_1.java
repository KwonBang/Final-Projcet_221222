package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test_1 extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(button)) {
			System.out.println("버튼 클릭");
			String id = idInput.getText();
			titleLB.setText(id);
		}else if(object.equals(close)) {
			System.out.println("프로그램종료");
			System.exit(0);
		}
		
	}
	JLabel titleLB = new JLabel("휴먼 프로그램");
	JButton button = new JButton("Login");
	JButton close = new JButton("EXIT");
	JLabel idLB = new JLabel("아이디");
	JLabel passLB = new JLabel("비밀번호");
	//JTextField idInput = new JTextField(4);
	//JTextArea inputBody = new JTextArea(3,10);
	JTextField idInput = new JTextField(10);
	JTextField pwInput = new JTextField(10);
	JPanel centerP = new JPanel();
	JPanel centerPN = new JPanel();
	JPanel centerPS = new JPanel();
	JPanel southP = new JPanel();
	public Test_1() {
		System.out.println("프로그램이 시작되었습니다.");
		this.setBounds(100,300, 200, 150);	//사이즈 설정
		//this에 컴포넌트를 배치시킨다. 기본은 보더레이아웃
		//inputBody.setBackground(Color.YELLOW);
		//button.setBackground(Color.red);
		//this.add(titleLB,"North");
		//this.add(button,"East");
		//this.add(idLB,"West");
		//this.add(idInput,"Center");
		//this.add(inputBody,"South");
		
		centerP.setBackground(Color.cyan);
		centerPN.setBackground(Color.GREEN);
		centerPS.setBackground(Color.LIGHT_GRAY);
		
		centerP.setLayout(new GridLayout(2, 1));
		//centerPN.setLayout(new GridLayout(1, 2));
		//centerPS.setLayout(new GridLayout(1, 2));
		centerPN.setLayout(new FlowLayout());
		centerPS.setLayout(new FlowLayout());
		
		centerPN.add(idLB);
		centerPN.add(idInput);
		centerPS.add(passLB);
		centerPS.add(pwInput);
		centerP.add(centerPN);
		centerP.add(centerPS);
		this.add(titleLB,"North");
		this.add(centerP,"Center");
		//this.add(button,"South");
		
		southP.add(button);
		southP.add(close);
		this.add(southP,"South");
		button.addActionListener(this);
		close.addActionListener(this);
		
		//centerP.add(idLB);
		//centerP.add(idInput);
		//centerP.add(passLB);
		//centerP.add(pwInput);
		//this.add(titleLB,"North");
		//this.add(centerP,"Center");
		//this.add(button,"South");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}

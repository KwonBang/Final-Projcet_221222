package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import adm.ADM;
import dao.BookDAO;
import dao.Book_rental_listDAO;
import dao.MemberDAO;
import dto.BookDTO;
import dto.Book_rental_listDTO;
import dto.MemberDTO;
import oracle.net.aso.a;
import oracle.net.aso.b;

public class Main_gui extends JFrame implements ActionListener,ItemListener{
	MemberDTO login_member = null;
	MemberDAO memberDAO = new MemberDAO();
	BookDAO bookDAO = new BookDAO();
	ADM adm = new ADM();
	Book_rental_listDAO book_rental_listDAO = new Book_rental_listDAO();

	String login_member_id = null;

	Toolkit toolkit = this.getToolkit();
	Image image = toolkit.createImage("D:\\aa.png");

	//�α���ȭ��
	JPanel login = new JPanel();
	JPanel login_id = new JPanel();
	JLabel id_label = new JLabel("���̵�");
	JTextField id_textfield = new JTextField(15);

	JPanel login_pwd = new JPanel();
	JLabel pwd_label = new JLabel("��й�ȣ");
	JPasswordField pwd_textfield = new JPasswordField(15);

	JPanel id_pwd = new JPanel();

	JPanel login_btn = new JPanel();
	JButton log_btn = new JButton("�α���");
	JButton set_btn = new JButton("ȸ������");
	JButton adm_btn = new JButton("������");

	JPanel title_p = new JPanel();
	JLabel title = new JLabel("�޸� �����뿩 �α���");

	JPanel all_p = new JPanel();



	//ȸ������ ȭ��
	JPanel set_insert = new JPanel();
	JLabel set_title = new JLabel("ȸ������");

	JLabel set_id = new JLabel("���̵�");
	JTextField set_id_txt = new JTextField(15);

	JLabel set_pwd = new JLabel("��й�ȣ");
	JPasswordField set_pwd_txt = new JPasswordField(15);

	JLabel set_name = new JLabel("�̸�");
	JTextField set_name_txt = new JTextField(15);

	JLabel set_addr = new JLabel("�ּ�");
	JTextField set_addr_txt = new JTextField(15);

	JButton member_insert = new JButton("ȸ������");
	JButton back_set = new JButton("�ڷΰ���");

	JPanel set_title_p = new JPanel();
	JPanel id_p = new JPanel();
	JPanel pwd_p = new JPanel();
	JPanel name_p = new JPanel();
	JPanel addr_p = new JPanel();
	JPanel btn_p = new JPanel();

	JPanel all_set_p = new JPanel();

	//������ ȭ��
	JPanel admlog_p = new JPanel();

	JPanel adm_id_p = new JPanel();
	JLabel adm_id_L = new JLabel("������ ���̵�");
	JTextField adm_id_txt = new JTextField(15);

	JPanel adm_pwd_p = new JPanel();
	JLabel adm_pwd_L = new JLabel("������ ��й�ȣ");
	JTextField adm_pwd_txt = new JPasswordField(15);

	JPanel adm_btn_p = new JPanel();
	JButton adm_login = new JButton("�α���");
	JButton adm_back = new JButton("�ڷΰ���");

	//�����ڸ���ȭ��
	JPanel admmain_p = new JPanel();
	JPanel admmain_b = new JPanel();
	JButton book_manager = new JButton("��������");
	JButton member_manager = new JButton("ȸ������");
	JButton admmain_back = new JButton("�α׾ƿ�");
	//������������ ȭ��
	JPanel book_maneger_p = new JPanel();

	JPanel book_maneger_view = new JPanel();

	JPanel book_maneger_btn = new JPanel();
	JButton book_insert = new JButton("�������");
	JButton book_update = new JButton("��������");
	JButton book_delete = new JButton("��������");
	JButton book_list = new JButton("�������");

	//�������
	JPanel book_manager_view_insert = new JPanel();
	JPanel book_manager_view_insert_1 = new JPanel();
	JPanel book_manager_view_insert_2 = new JPanel();
	JPanel book_manager_view_insert_3 = new JPanel();
	JPanel book_manager_view_insert_4 = new JPanel();

	JLabel add_book_title = new JLabel("��������");
	JTextField add_book_title_txt = new JTextField(15);
	JLabel add_book_info = new JLabel("����");
	JTextField add_book_info_textfield = new JTextField(15);
	JLabel add_book_writer = new JLabel("���ڸ�");
	JTextField add_book_writer_textfield = new JTextField(15);
	JButton add_btn = new JButton("�����ϱ�");
	//��������
	JPanel book_manager_view_delete = new JPanel();
	JPanel delete_p = new JPanel();
	JLabel delete_label = new JLabel("������ȣ �Է�");
	JTextField delete_txt = new JTextField(15);
	JButton delete_btn = new JButton("�����ϱ�");
	//�������
	JPanel book_manager_view_list = new JPanel(new GridLayout(1,2));
	List book_list_all = new List(20);
	JTextArea book_list_all_txt = new JTextArea();
	JScrollPane book_list_all_scroll = new JScrollPane(book_list_all_txt);
	//�����˻�
	JPanel book_search_p = new JPanel();
	JLabel book_search_Label = new JLabel("�������� �Է�");
	JButton book_search_btn = new JButton("�����˻�");
	JTextField book_search_txt = new JTextField(15);
	List book_list_list = new List(20);
	JTextArea book_list_txtArea = new JTextArea();
	JScrollPane book_list_scroll = new JScrollPane(book_list_txtArea);
	JPanel search_list_view = new JPanel(new GridLayout(1,2));
	//��������
	JPanel book_manager_view_update = new JPanel(new GridLayout(5,1));
	JPanel update_1 = new JPanel();
	JPanel update_2 = new JPanel();
	JPanel update_3 = new JPanel();
	JPanel update_4 = new JPanel();
	JPanel update_5 = new JPanel();
	JLabel update_no = new JLabel("������ ���� ��ȣ");
	JLabel update_title = new JLabel("�������");
	JLabel update_info = new JLabel("�������� ����");
	JLabel update_writer = new JLabel("���ڸ� ����");
	JTextField update_no_txt = new JTextField(15);
	JTextField update_title_txt = new JTextField(15);
	JTextField update_info_txt = new JTextField(15);
	JTextField update_writer_txt = new JTextField(15);
	JButton update_set = new JButton("�����ϱ�");
	//ȸ������ȭ��
	JPanel member_maneger_view = new JPanel(new BorderLayout());

	JPanel member_manager_btn_p = new JPanel(new GridLayout(2,1));

	JPanel member_search_top_p = new JPanel();
	JLabel member_search_Label = new JLabel("ȸ���̸� �˻�");
	JTextField member_search_txt = new JTextField(15);
	JButton member_search_btn = new JButton("�˻�");

	JPanel member_CRUD_btn_p = new JPanel();
	JButton member_insert_btn = new JButton("ȸ�����");
	JButton member_update_btn = new JButton("ȸ������");
	JButton member_delete_btn = new JButton("ȸ������");
	JButton member_list_btn = new JButton("ȸ�����");

	//ȸ���˻�
	JPanel member_search_p = new JPanel(new GridLayout(1,2));
	List member_search_list = new List(20);
	JTextArea member_search_list_Area = new JTextArea();
	JScrollPane member_search_list_scroll = new JScrollPane(member_search_list_Area);
	//ȸ�����
	JPanel member_insert_p = new JPanel(new GridLayout(5,1));
	JPanel member_set_1 = new JPanel();
	JPanel member_set_2 = new JPanel();
	JPanel member_set_3 = new JPanel();
	JPanel member_set_4 = new JPanel();
	JPanel member_set_5 = new JPanel();

	JLabel member_id = new JLabel("���̵� �Է�");
	JLabel member_pwd = new JLabel("��й�ȣ �Է�");
	JLabel member_name = new JLabel("�̸� �Է�");
	JLabel member_addr = new JLabel("�ּ� �Է�");

	JTextField member_id_txt = new JTextField(15);
	JPasswordField member_pwd_txt = new JPasswordField(15);
	JTextField member_name_txt = new JTextField(15);
	JTextField member_addr_txt = new JTextField(15);

	JButton member_set_btn = new JButton("����ϱ�");

	//ȸ������
	JPanel member_update_p = new JPanel(new GridLayout(5,1));
	JPanel member_update_1 = new JPanel();
	JPanel member_update_2 = new JPanel();
	JPanel member_update_3 = new JPanel();
	JPanel member_update_4 = new JPanel();
	JPanel member_update_5 = new JPanel();
	JLabel member_update_id = new JLabel("������ ȸ�����̵�");
	JLabel member_update_pwd = new JLabel("��й�ȣ ����");
	JLabel member_update_name = new JLabel("�̸� ����");
	JLabel member_update_addr = new JLabel("�ּ� ����");
	JTextField member_update_id_txt = new JTextField(15);
	JPasswordField member_update_pwd_txt = new JPasswordField(15);
	JTextField member_update_name_txt = new JTextField(15);
	JTextField member_update_addr_txt = new JTextField(15);
	JButton member_update_set = new JButton("�����ϱ�");



	//ȸ������
	JPanel member_delete_p = new JPanel();
	JLabel member_delete_Label = new JLabel("������ ȸ�����̵� �Է�");
	JTextField member_delete_txt = new JTextField(15);
	JButton member_del_btn = new JButton("�����ϱ�");


	//ȸ�����
	JPanel member_list_p = new JPanel(new GridLayout(1,2));
	List member_list = new List(20);
	JTextArea member_list_Area = new JTextArea();
	JScrollPane member_list_scroll = new JScrollPane(member_list_Area);

	//�����뿩,�ݳ� ȭ��
	JPanel rental_main_p = new JPanel();
	JPanel rental_main_btn_p = new JPanel();
	JButton rental_menu_btn = new JButton("�����뿩 �޴�");
	JButton return_menu_btn = new JButton("�����ݳ� �޴�");
	JButton logout_btn = new JButton("�α׾ƿ�");

	JPanel rental_menu_p = new JPanel(new BorderLayout());
	JPanel rental_menu_btn_p = new JPanel();
	JButton rental_menu_book_list_btn = new JButton("�������");
	JButton rental_menu_book_search_btn = new JButton("�����˻�");
	JButton rental_menu_book_rental_btn = new JButton("�����뿩");

	JPanel rental_menu_book_list_p =new JPanel(new GridLayout(1,2));
	List rental_menu_book_list = new List(20);
	JTextArea rental_menu_book_list_Area = new JTextArea();
	JScrollPane rental_menu_book_list_scroll = new JScrollPane(rental_menu_book_list_Area);

	JPanel rental_menu_book_search_p = new JPanel(new BorderLayout());

	JPanel search_p = new JPanel();
	JLabel search_Label = new JLabel("�������� �Է�");
	JTextField rental_menu_book_search_txt = new JTextField(15);
	JButton search_btn = new JButton("�˻�");

	JPanel search_list_p = new JPanel(new GridLayout(1,2));
	List rental_menu_book_search_list = new List(20);
	JTextArea rental_menu_book_search_list_Area = new JTextArea();
	JScrollPane rental_menu_book_search_scroll = new JScrollPane(rental_menu_book_search_list_Area);

	JPanel rental_p = new JPanel();
	JLabel rental_Label = new JLabel("������ȣ �Է�");
	JTextField rental_txt = new JTextField(15);
	JButton rental_btn = new JButton("�뿩�ϱ�");

	JPanel return_menu_p = new JPanel(new BorderLayout());
	JPanel return_menu_top = new JPanel();
	JLabel return_book_no_Label = new JLabel("�ݳ��� �뿩��ȣ �Է�");
	JTextField return_book_no_txt = new JTextField(15);
	JButton return_book_btn = new JButton("�ݳ��ϱ�");
	JPanel rental_list_p = new JPanel(new GridLayout(1,2));
	List rental_list = new List();
	JTextArea rental_list_Area = new JTextArea();
	JScrollPane rental_list_scroll = new JScrollPane(rental_list_Area);

	public Main_gui() {
		this.setIconImage(image);
		this.setTitle("�޸� �����뿩");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		//�α���ȭ��
		login.setLayout(new BorderLayout());

		login_id.add(id_label);
		login_id.add(id_textfield);

		login_pwd.add(pwd_label);
		login_pwd.add(pwd_textfield);

		id_pwd.setLayout(new GridLayout(4,1));
		id_pwd.add(title_p);
		id_pwd.add(login_id);
		id_pwd.add(login_pwd);
		id_pwd.add(login_btn);

		login_btn.add(log_btn);
		login_btn.add(set_btn);
		login_btn.add(adm_btn);

		title_p.add(title);


		login.add(id_pwd,"Center");


		log_btn.addActionListener(this);
		adm_btn.addActionListener(this);
		set_btn.addActionListener(this);

		this.add(login,"Center");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);




		//ȸ������ ȭ��
		set_insert.setLayout(new BorderLayout());
		set_insert.add(set_title);

		id_p.add(set_id);
		id_p.add(set_id_txt);

		pwd_p.add(set_pwd);
		pwd_p.add(set_pwd_txt);

		name_p.add(set_name);
		name_p.add(set_name_txt);

		addr_p.add(set_addr);
		addr_p.add(set_addr_txt);

		all_set_p.setLayout(new GridLayout(4,1));
		all_set_p.add(id_p);
		all_set_p.add(pwd_p);
		all_set_p.add(name_p);
		all_set_p.add(addr_p);

		btn_p.add(member_insert);
		btn_p.add(back_set);

		set_insert.add(set_title_p,"North");
		set_insert.add(all_set_p,"Center");
		set_insert.add(btn_p,"South");

		this.member_insert.addActionListener(this);
		this.back_set.addActionListener(this);

		//�����ڷα��� ȭ��
		admlog_p.setLayout(new GridLayout(3,1));

		adm_id_p.add(adm_id_L);
		adm_id_p.add(adm_id_txt);

		adm_pwd_p.add(adm_pwd_L);
		adm_pwd_p.add(adm_pwd_txt);

		adm_btn_p.add(adm_login);
		adm_btn_p.add(adm_back);

		admlog_p.add(adm_id_p);
		admlog_p.add(adm_pwd_p);
		admlog_p.add(adm_btn_p);

		this.adm_login.addActionListener(this);
		this.adm_back.addActionListener(this);
		//������ ����ȭ��
		admmain_p.setLayout(new BorderLayout());
		admmain_b.setLayout(new FlowLayout());
		admmain_b.add(book_manager);
		admmain_b.add(member_manager);
		admmain_b.add(admmain_back);
		//��������ȭ��
		book_maneger_p.setLayout(new GridLayout(2,1));
		book_maneger_p.add(book_search_p);
		book_maneger_p.add(book_maneger_btn);
		book_search_p.add(book_search_Label);
		book_search_p.add(book_search_txt);
		book_search_p.add(book_search_btn);
		book_maneger_btn.add(book_insert);
		book_maneger_btn.add(book_update);
		book_maneger_btn.add(book_delete);
		book_maneger_btn.add(book_list);
		book_maneger_view.setLayout(new BorderLayout());
		book_maneger_view.add(book_maneger_p,"North");
		search_list_view.add(book_list_list);
		search_list_view.add(book_list_scroll);

		//�������
		book_manager_view_insert.setLayout(new GridLayout(4,1));
		book_manager_view_insert_1.add(add_book_title);
		book_manager_view_insert_1.add(add_book_title_txt);
		book_manager_view_insert_2.add(add_book_info);
		book_manager_view_insert_2.add(add_book_info_textfield);
		book_manager_view_insert_3.add(add_book_writer);
		book_manager_view_insert_3.add(add_book_writer_textfield);
		book_manager_view_insert_4.add(add_btn);
		book_manager_view_insert.add(book_manager_view_insert_1);
		book_manager_view_insert.add(book_manager_view_insert_2);
		book_manager_view_insert.add(book_manager_view_insert_3);
		book_manager_view_insert.add(book_manager_view_insert_4);
		//��������
		delete_p.add(delete_label);
		delete_p.add(delete_txt);
		delete_p.add(delete_btn);
		book_manager_view_delete.add(delete_p);
		//�������
		book_manager_view_list.add(book_list_all);
		book_manager_view_list.add(book_list_all_scroll);
		//��������
		update_1.add(update_no);
		update_1.add(update_no_txt);
		update_2.add(update_title);
		update_2.add(update_title_txt);
		update_3.add(update_info);
		update_3.add(update_info_txt);
		update_4.add(update_writer);
		update_4.add(update_writer_txt);
		update_5.add(update_set);
		book_manager_view_update.add(update_1);
		book_manager_view_update.add(update_2);
		book_manager_view_update.add(update_3);
		book_manager_view_update.add(update_4);
		book_manager_view_update.add(update_5);
		//�����뿩,�ݳ� ȭ��
		rental_main_p.setLayout(new BorderLayout());
		rental_main_btn_p.add(rental_menu_btn);
		rental_main_btn_p.add(return_menu_btn);
		rental_main_btn_p.add(logout_btn);
		rental_main_p.add(rental_main_btn_p,"South");
		this.rental_menu_btn.addActionListener(this);
		this.return_menu_btn.addActionListener(this);
		this.logout_btn.addActionListener(this);

		rental_menu_btn_p.add(rental_menu_book_search_btn);
		rental_menu_btn_p.add(rental_menu_book_list_btn);
		rental_menu_btn_p.add(rental_menu_book_rental_btn);
		rental_menu_p.add(rental_menu_btn_p,"North");
		this.rental_menu_book_search_btn.addActionListener(this);
		this.rental_menu_book_list_btn.addActionListener(this);
		this.rental_menu_book_rental_btn.addActionListener(this);

		search_p.add(search_Label);
		search_p.add(rental_menu_book_search_txt);
		search_p.add(search_btn);
		rental_menu_book_search_p.add(search_p,"North");
		rental_menu_book_search_p.add(search_list_p,"Center");
		this.search_btn.addActionListener(this);

		search_list_p.add(rental_menu_book_search_list);
		search_list_p.add(rental_menu_book_search_scroll);
		this.rental_menu_book_search_list.addItemListener(this);

		rental_menu_book_list_p.add(rental_menu_book_list);
		rental_menu_book_list_p.add(rental_menu_book_list_scroll);
		this.rental_menu_book_list.addItemListener(this);

		rental_p.add(rental_Label);
		rental_p.add(rental_txt);
		rental_p.add(rental_btn);
		this.rental_btn.addActionListener(this);

		return_menu_p.add(return_menu_top,"North");
		return_menu_p.add(rental_list_p,"Center");

		rental_list_p.add(rental_list);
		rental_list_p.add(rental_list_scroll);

		return_menu_top.add(return_book_no_Label);
		return_menu_top.add(return_book_no_txt);
		return_menu_top.add(return_book_btn);
		this.return_book_btn.addActionListener(this);
		this.rental_list.addItemListener(this);
		//������ ȸ������ ȭ��
		member_maneger_view.add(member_manager_btn_p,"North");
		member_search_top_p.add(member_search_Label);
		member_search_top_p.add(member_search_txt);
		member_search_top_p.add(member_search_btn);
		member_manager_btn_p.add(member_search_top_p);
		this.member_search_btn.addActionListener(this);

		//ȸ���˻�ȭ��
		member_search_p.add(member_search_list);
		member_search_p.add(member_search_list_scroll);
		this.member_search_list.addItemListener(this);

		member_CRUD_btn_p.add(member_insert_btn);
		member_CRUD_btn_p.add(member_update_btn);
		member_CRUD_btn_p.add(member_delete_btn);
		member_CRUD_btn_p.add(member_list_btn);
		member_manager_btn_p.add(member_CRUD_btn_p);
		this.member_insert_btn.addActionListener(this);
		this.member_update_btn.addActionListener(this);
		this.member_delete_btn.addActionListener(this);
		this.member_list_btn.addActionListener(this);

		//ȸ������
		member_insert_p.add(member_set_1);
		member_insert_p.add(member_set_2);
		member_insert_p.add(member_set_3);
		member_insert_p.add(member_set_4);
		member_insert_p.add(member_set_5);

		member_set_1.add(member_id);
		member_set_1.add(member_id_txt);
		member_set_2.add(member_pwd);
		member_set_2.add(member_pwd_txt);
		member_set_3.add(member_name);
		member_set_3.add(member_name_txt);
		member_set_4.add(member_addr);
		member_set_4.add(member_addr_txt);
		member_set_5.add(member_set_btn);
		this.member_set_btn.addActionListener(this);

		//ȸ�����
		member_list_p.add(member_list);
		member_list_p.add(member_list_scroll);
		this.member_list.addItemListener(this);
		//ȸ������ȭ��
		member_delete_p.add(member_delete_Label);
		member_delete_p.add(member_delete_txt);
		member_delete_p.add(member_del_btn);
		this.member_del_btn.addActionListener(this);

		//ȸ������
		member_update_p.add(member_update_1);
		member_update_p.add(member_update_2);
		member_update_p.add(member_update_3);
		member_update_p.add(member_update_4);
		member_update_p.add(member_update_5);

		member_update_1.add(member_update_id);
		member_update_1.add(member_update_id_txt);
		member_update_2.add(member_update_pwd);
		member_update_2.add(member_update_pwd_txt);
		member_update_3.add(member_update_name);
		member_update_3.add(member_update_name_txt);
		member_update_4.add(member_update_addr);
		member_update_4.add(member_update_addr_txt);
		member_update_5.add(member_update_set);
		this.member_update_set.addActionListener(this);

		admmain_p.add(admmain_b,"South");
		this.member_manager.addActionListener(this);
		this.book_manager.addActionListener(this);
		this.admmain_back.addActionListener(this);
		this.book_search_btn.addActionListener(this);
		this.book_insert.addActionListener(this);
		this.book_update.addActionListener(this);
		this.book_delete.addActionListener(this);
		this.book_list.addActionListener(this);
		this.book_list_list.addItemListener(this);
		this.add_btn.addActionListener(this);
		this.delete_btn.addActionListener(this);
		this.book_list_all.addItemListener(this);
		this.update_set.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object.equals(set_btn)) {
			//�α���ȭ�� ȸ�����Թ�ư
			id_textfield.setText("");
			pwd_textfield.setText("");
			this.remove(login);
			this.add(set_insert);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(back_set)) {
			//ȸ������ȭ�� �ڷΰ��� ��ư
			this.remove(set_insert);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_insert)) {
			//ȸ������ȭ�� ȸ�����Թ�ư
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(set_id_txt.getText());
			memberDTO.setPwd(set_pwd_txt.getText());
			memberDTO.setName(set_name_txt.getText());
			memberDTO.setAddr(set_addr_txt.getText());
			MemberDTO aDto = memberDAO.find_id(set_id_txt.getText());
			if(aDto!=null) {
				JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵� �Դϴ�.");
			}else {
				boolean chk = memberDAO.memberset(memberDTO);
				if(chk) {
					JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�");
					set_id_txt.setText("");
					set_pwd_txt.setText("");
					set_name_txt.setText("");
					set_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "����10���� or �ѱ�5���� ���� �Է��ϼ���.");
				}
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(adm_btn)) {
			//����ȭ�� ������ ��ư
			id_textfield.setText("");
			pwd_textfield.setText("");
			this.remove(login);
			this.add(admlog_p);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(adm_login)) {
			//������ �α���ȭ�� �α��ι�ư
			boolean chk = adm.login_adm(adm_id_txt.getText(),adm_pwd_txt.getText());
			if(chk) {
				adm_id_txt.setText("");
				adm_pwd_txt.setText("");
				this.remove(admlog_p);
				this.add(admmain_p);
				this.repaint();
				this.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "�α��� ����");
			}
		}else if(object.equals(adm_back)) {
			//������ �α���ȭ�� �ڷΰ��� ��ư
			this.remove(admlog_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_manager)) {
			//�����ڸ���ȭ�� ����������ư
			admmain_p.remove(member_maneger_view);
			admmain_p.add(book_maneger_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_manager)) {
			//�����ڸ���ȭ�� ȸ��������ư
			admmain_p.remove(book_maneger_view);
			admmain_p.add(member_maneger_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(admmain_back)) {
			//������ȭ�� �α׾ƿ���ư
			this.remove(admmain_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_search_btn)) {
			//�����˻���ư
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_list_list.removeAll();
			book_list_txtArea.setText("");
			if(book_search_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "�˻��� ���������� �Է��ϼ���.");
			}else {
				ArrayList<BookDTO> list = bookDAO.search(book_search_txt.getText());
				if(list!=null) {
					book_list_list.add("��������");
					for(BookDTO i : list) {
						book_list_list.add(i.getTitle());
					}
				}else if (list==null){
					JOptionPane.showMessageDialog(null, "�˻������ �����ϴ�.");
				}
			}
			book_maneger_view.add(search_list_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_insert)) {
			//������Ϲ�ư
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_insert,"Center");
			this.repaint();
			this.setVisible(true);

		}else if(object.equals(add_btn)){
			//������� �����ϱ��ư
			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle(add_book_title_txt.getText());
			bookDTO.setInfo(add_book_info_textfield.getText());
			bookDTO.setWriter(add_book_writer_textfield.getText());
			boolean a = bookDAO.insert_book(bookDTO);
			if(!a) {
				JOptionPane.showMessageDialog(null, "����10���� or �ѱ�5���� ���� �Է��ϼ���.");
			}else {
				add_book_title_txt.setText("");
				add_book_info_textfield.setText("");
				add_book_writer_textfield.setText("");
				JOptionPane.showMessageDialog(null, "����Ϸ�");
			}
		}else if(object.equals(book_update)) {
			//��������
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_update,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(update_set)) {
			//�����ϱ� ��ư
			boolean chk_1 = true;
			boolean chk_2 = true;
			boolean chk_3 = true;
			int chk = 0;
			if(update_no_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "������ȣ�� �Է��ϼ���.");
			}else if(bookDAO.select_no_One(update_no_txt.getText())==null){
				JOptionPane.showMessageDialog(null, "�������� �ʴ� ������ȣ �Դϴ�..");
			}else {
				int book_no = Integer.parseInt(update_no_txt.getText());
				if(update_title_txt.getText().length()!=0) {
					chk_1 = false;
					chk_1 = bookDAO.mod_title(book_no, update_title_txt.getText());
					chk++;
				}
				if(update_info_txt.getText().length()!=0) {
					chk_2 = false;
					chk_2 = bookDAO.mod_info(book_no, update_info_txt.getText());
					chk++;
				}
				if(update_writer_txt.getText().length()!=0) {
					chk_3 = false;
					chk_3 = bookDAO.mod_writer(book_no, update_writer_txt.getText());
					chk++;
				}
				if(chk_1&&chk_2&&chk_3&&chk>0) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");
				}else {
					JOptionPane.showMessageDialog(null,"�ѱ�5���� OR ����10���� �̳��� �Է��ϼ���");
				}
			}
			update_no_txt.setText("");
			update_title_txt.setText("");
			update_info_txt.setText("");
			update_writer_txt.setText("");
		}else if(object.equals(book_delete)) {
			//��������
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_delete,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(delete_btn)) {
			//�����ϱ� ��ư
			if(delete_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "������ȣ�� �Է��ϼ���");
			}else {
				BookDTO bookDTO = new BookDTO();
				int no = Integer.parseInt(delete_txt.getText());
				bookDTO.setNo(no);
				boolean chk = bookDAO.delete_book(no);
				if(chk) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");
					delete_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�");
				}
			}
		}else if(object.equals(book_list)) {
			//�������
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_list,"Center");
			book_list_all.removeAll();
			book_list_all_txt.setText("");
			ArrayList<BookDTO> list = bookDAO.select_title_group();
			if(list!=null) {
				book_list_all.add("---��������---");
				for(BookDTO i : list) {
					book_list_all.add(i.getTitle());
				}
			}else {
				JOptionPane.showMessageDialog(null, "��ϵ� ������ �����ϴ�.");
			}
			this.repaint();
			this.setVisible(true);
		}else if (object.equals(log_btn)) {
			//����ȭ�� �α��ι�ư
			login_member = memberDAO.find_id(id_textfield.getText());
			if(login_member==null) {
				JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
			}else if(login_member.getId()!=null) {
				if(login_member.getPwd().equals(pwd_textfield.getText())) {
					login_member_id = id_textfield.getText();
					id_textfield.setText("");
					pwd_textfield.setText("");
					this.remove(login);
					this.add(rental_main_p);
					this.repaint();
					this.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
			}
		}else if(object.equals(logout_btn)) {
			//�뿩�ݳ����� �α׾ƿ���ư
			this.remove(rental_main_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_menu_btn)) {
			//�뿩�޴���ư
			rental_main_p.remove(return_menu_p);
			rental_main_p.add(rental_menu_p);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(return_menu_btn)) {
			//�ݳ��޴���ư
			rental_main_p.remove(rental_menu_p);
			rental_main_p.add(return_menu_p);
			rental_list.removeAll();
			rental_list_Area.setText("");
			ArrayList<Book_rental_listDTO> list = book_rental_listDAO.rental_books(login_member_id);
			rental_list.add("�뿩���� ����");
			if(list==null) {
				JOptionPane.showMessageDialog(null, "�뿩�� ������ �����ϴ�.");
			}else {
				for(Book_rental_listDTO i : list) {
					rental_list.add(i.getTitle());
				}
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(return_book_btn)) {
			//�ݳ��ϱ��ư
			if(return_book_no_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "�뿩��ȣ�� �Է��ϼ���.");
			}else {
				boolean chk = book_rental_listDAO.return_book(login_member_id, return_book_no_txt.getText());
				if(chk) {
					JOptionPane.showMessageDialog(null, "�ݳ� �Ϸ�");
					rental_list.removeAll();
					rental_list_Area.setText("");
					ArrayList<Book_rental_listDTO> list = book_rental_listDAO.rental_books(login_member_id);
					rental_list.add("�뿩���� ����");
					if(list==null) {
						JOptionPane.showMessageDialog(null, "�뿩�� ������ �����ϴ�.");
					}else {
						for(Book_rental_listDTO i : list) {
							rental_list.add(i.getTitle());
						}
					}
					this.repaint();
					this.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.");
				}
			}
		}else if(object.equals(rental_menu_book_search_btn)) {
			//�뿩�޴� �˻���ư
			rental_menu_p.remove(rental_menu_book_list_p);
			rental_menu_p.remove(rental_p);
			rental_menu_p.add(rental_menu_book_search_p,"Center");
			rental_menu_book_search_list.removeAll();
			rental_menu_book_search_list_Area.setText("");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(search_btn)) {
			//�뿩�˻�ȭ�� �˻���ư
			rental_menu_book_search_list.removeAll();
			rental_menu_book_search_list_Area.setText("");
			rental_menu_book_search_list.add("---��������---");
			if(rental_menu_book_search_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "�˻��� ���������� �Է��ϼ���.");
			}else {
				ArrayList<BookDTO> list = bookDAO.search(rental_menu_book_search_txt.getText());
				if(list==null) {
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���������� �����ϴ�");
				}else {
					for(BookDTO i : list) {
						rental_menu_book_search_list.add(i.getTitle());
					}
				}
			}
		}else if(object.equals(rental_menu_book_list_btn)) {
			//�뿩�޴� ������Ϲ�ư
			rental_menu_p.remove(rental_menu_book_search_p);
			rental_menu_p.remove(rental_p);
			rental_menu_p.add(rental_menu_book_list_p,"Center");
			rental_menu_book_list.removeAll();
			rental_menu_book_list_Area.setText("");
			rental_menu_book_list.add("��������");
			ArrayList<BookDTO> list = bookDAO.select_title_group();
			if(list!=null) {
				for(BookDTO i : list) {
					rental_menu_book_list.add(i.getTitle());
				}
			}else {
				JOptionPane.showMessageDialog(null, "��ϵ� ������ �����ϴ�.");
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_menu_book_rental_btn)) {
			//�뿩�޴� �뿩��ư
			rental_menu_p.remove(rental_menu_book_search_p);
			rental_menu_p.remove(rental_menu_book_list_p);
			rental_menu_p.add(rental_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_btn)) {
			//�뿩�޴� �뿩�ϱ��ư
			BookDTO bookDTO = bookDAO.select_no_One(rental_txt.getText());
			if(bookDTO==null) {
				JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�.");
			}else {
				boolean chk = book_rental_listDAO.insert(bookDTO, login_member_id);
				if(chk) {
					JOptionPane.showMessageDialog(null,
							"������ȣ : "+bookDTO.getNo()+"\n"+"�������� : "+bookDTO.getTitle()+"\n"+"�뿩�Ϸ�");
				}
			}
		}else if(object.equals(member_search_btn)) {
			//������ ȸ������ȭ�� ȸ�� �˻���ư
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.add(member_search_p,"Center");
			member_search_list.removeAll();
			member_search_list_Area.setText("");
			if(member_search_txt.getText().length()!=0) {
				ArrayList<MemberDTO> list = memberDAO.select_name_group(member_search_txt.getText());
				if(list==null) {
					JOptionPane.showMessageDialog(null, "�˻��� �̸��� ���Ե� ȸ���� �����ϴ�.");
				}else {
					for(MemberDTO i : list) {
						member_search_list.add(i.getId());
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "ȸ���̸��� �Է��ϼ���");
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_insert_btn)) {
			//ȸ������ȭ�� ȸ����Ϲ�ư
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.add(member_insert_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_set_btn)) {
			//ȸ�����ȭ�� ����ϱ��ư
			if(memberDAO.find_id(member_id_txt.getText())==null) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(member_id_txt.getText());
				memberDTO.setPwd(member_pwd_txt.getText());
				memberDTO.setName(member_name_txt.getText());
				memberDTO.setAddr(member_addr_txt.getText());
				boolean chk = memberDAO.memberset(memberDTO);
				if(chk) {
					JOptionPane.showMessageDialog(null, "��� �Ϸ�");
					member_id_txt.setText("");
					member_pwd_txt.setText("");
					member_name_txt.setText("");
					member_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "����10���� or �ѱ�5���� ���� �Է��ϼ���.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵� �Դϴ�.");
			}
		}else if(object.equals(member_list_btn)) {
			//ȸ����� ��ư
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_list_p,"Center");
			ArrayList<MemberDTO> list = memberDAO.allselect();
			member_list.removeAll();
			member_list_Area.setText("");
			member_list.add("---ȸ�����̵� ���---");
			for(MemberDTO i : list) {
				member_list.add(i.getId());
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_delete_btn)) {
			//������ȭ�� ȸ��������ư
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_delete_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_del_btn)) {
			//ȸ������ ȭ�� �����ϱ��ư
			if(member_delete_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "ȸ�����̵� �Է��ϼ���.");
			}else {
				boolean chk = memberDAO.del(member_delete_txt.getText());
				if(chk) {
					JOptionPane.showMessageDialog(null, "�����Ϸ�.");
					member_delete_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���̵� �����ϴ�.");
				}
			}
		}else if(object.equals(member_update_btn)) {
			//ȸ��������ư
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_update_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_update_set)) {
			//�����ϱ� ��ư
			boolean chk_1 = true;
			boolean chk_2 = true;
			boolean chk_3 = true;
			int chk = 0;
			if(member_update_id_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "������ ȸ�����̵� �Է��ϼ���.");
			}else if(memberDAO.find_id(member_update_id_txt.getText())==null) {
				JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
			}else {
				if(member_update_pwd_txt.getText().length()!=0) {
					chk_1 = false;
					chk_1 = memberDAO.mod_pwd(member_update_pwd_txt.getText(), member_update_id_txt.getText());
					chk++;
				}
				if(member_update_name_txt.getText().length()!=0) {
					chk_2 = false;
					chk_2 = memberDAO.mod_name(member_update_name_txt.getText(), member_update_id_txt.getText());
					chk++;

				}
				if(member_update_addr_txt.getText().length()!=0) {
					chk_3 = false;
					chk_3 = memberDAO.mod_addr(member_update_addr_txt.getText(), member_update_id_txt.getText());
					chk++;
				}
				if(chk_1&&chk_2&&chk_3&&chk>0) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�");
					member_update_id_txt.setText("");
					member_update_pwd_txt.setText("");
					member_update_name_txt.setText("");
					member_update_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"�ѱ�5���� OR ����10���� �̳��� �Է��ϼ���");
				}
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(book_list_list)) {
			//�����ڵ����˻� ���
			String select = book_list_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			book_list_txtArea.setText("");
			for(BookDTO bookDTO : list) {
				book_list_txtArea.append("������ȣ : "+bookDTO.getNo()+"\n");
				book_list_txtArea.append("���� : "+bookDTO.getTitle()+"\n");
				book_list_txtArea.append("���� : "+bookDTO.getInfo()+"\n");
				book_list_txtArea.append("���� : "+bookDTO.getWriter()+"\n");
				book_list_txtArea.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(book_list_all)) {
			//������ �������
			String select = book_list_all.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			book_list_all_txt.setText("");
			for(BookDTO bookDTO : list) {
				book_list_all_txt.append("������ȣ : "+bookDTO.getNo()+"\n");
				book_list_all_txt.append("���� : "+bookDTO.getTitle()+"\n");
				book_list_all_txt.append("���� : "+bookDTO.getInfo()+"\n");
				book_list_all_txt.append("���� : "+bookDTO.getWriter()+"\n");
				book_list_all_txt.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_menu_book_search_list)) {
			//�����뿩 �˻�����Ʈ
			String select = rental_menu_book_search_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			rental_menu_book_search_list_Area.setText("");
			for(BookDTO bookDTO : list) {
				rental_menu_book_search_list_Area.append("������ȣ : "+bookDTO.getNo()+"\n");
				rental_menu_book_search_list_Area.append("���� : "+bookDTO.getTitle()+"\n");
				rental_menu_book_search_list_Area.append("���� : "+bookDTO.getInfo()+"\n");
				rental_menu_book_search_list_Area.append("���� : "+bookDTO.getWriter()+"\n");
				rental_menu_book_search_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_menu_book_list)) {
			//�����뿩 ���
			String select = rental_menu_book_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			rental_menu_book_list_Area.setText("");
			for(BookDTO bookDTO : list) {
				rental_menu_book_list_Area.append("������ȣ : "+bookDTO.getNo()+"\n");
				rental_menu_book_list_Area.append("���� : "+bookDTO.getTitle()+"\n");
				rental_menu_book_list_Area.append("���� : "+bookDTO.getInfo()+"\n");
				rental_menu_book_list_Area.append("���� : "+bookDTO.getWriter()+"\n");
				rental_menu_book_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_list)) {
			//�ݳ���ư ���
			String select = rental_list.getSelectedItem();
			ArrayList<Book_rental_listDTO> list = book_rental_listDAO.select_rentalOne(login_member_id, select);
			rental_list_Area.setText("");
			for(Book_rental_listDTO i : list) {
				rental_list_Area.append("�뿩��ȣ : "+Integer.toString(i.getRental_no())+"\n");
				rental_list_Area.append("������ȣ : "+Integer.toString(i.getBook_no())+"\n");
				rental_list_Area.append("�������� : "+i.getTitle()+"\n");
				rental_list_Area.append("�������� : "+i.getInfo()+"\n");
				rental_list_Area.append("���ڸ� : "+i.getWriter()+"\n");
				rental_list_Area.append("�뿩��¥ : "+i.getRental_date()+"\n");
				rental_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(member_search_list)) {
			//ȸ���̸��˻� ����Ʈ
			String select = member_search_list.getSelectedItem();
			ArrayList<MemberDTO> list = memberDAO.select_name_all(select);
			member_search_list_Area.setText("");
			for(MemberDTO i : list) {
				member_search_list_Area.append("ȸ�� ���̵� : "+i.getId()+"\n");
				member_search_list_Area.append("ȸ�� ��й�ȣ : "+i.getPwd()+"\n");
				member_search_list_Area.append("ȸ�� �̸� : "+i.getName()+"\n");
				member_search_list_Area.append("ȸ�� �ּ� : "+i.getAddr()+"\n");
				member_search_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(member_list)) {
			//ȸ�����̵���
			String select = member_list.getSelectedItem();
			MemberDTO memberDTO = memberDAO.find_id(select);
			member_list_Area.setText("");
			member_list_Area.append("ȸ�� ���̵� : "+memberDTO.getId()+"\n");
			member_list_Area.append("ȸ�� ��й�ȣ : "+memberDTO.getPwd()+"\n");
			member_list_Area.append("ȸ�� �̸� : "+memberDTO.getName()+"\n");
			member_list_Area.append("ȸ�� �ּ� : "+memberDTO.getAddr()+"\n");
		}
	}
}

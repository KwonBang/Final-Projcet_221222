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

	//로그인화면
	JPanel login = new JPanel();
	JPanel login_id = new JPanel();
	JLabel id_label = new JLabel("아이디");
	JTextField id_textfield = new JTextField(15);

	JPanel login_pwd = new JPanel();
	JLabel pwd_label = new JLabel("비밀번호");
	JPasswordField pwd_textfield = new JPasswordField(15);

	JPanel id_pwd = new JPanel();

	JPanel login_btn = new JPanel();
	JButton log_btn = new JButton("로그인");
	JButton set_btn = new JButton("회원가입");
	JButton adm_btn = new JButton("관리자");

	JPanel title_p = new JPanel();
	JLabel title = new JLabel("휴먼 도서대여 로그인");

	JPanel all_p = new JPanel();



	//회원가입 화면
	JPanel set_insert = new JPanel();
	JLabel set_title = new JLabel("회원가입");

	JLabel set_id = new JLabel("아이디");
	JTextField set_id_txt = new JTextField(15);

	JLabel set_pwd = new JLabel("비밀번호");
	JPasswordField set_pwd_txt = new JPasswordField(15);

	JLabel set_name = new JLabel("이름");
	JTextField set_name_txt = new JTextField(15);

	JLabel set_addr = new JLabel("주소");
	JTextField set_addr_txt = new JTextField(15);

	JButton member_insert = new JButton("회원가입");
	JButton back_set = new JButton("뒤로가기");

	JPanel set_title_p = new JPanel();
	JPanel id_p = new JPanel();
	JPanel pwd_p = new JPanel();
	JPanel name_p = new JPanel();
	JPanel addr_p = new JPanel();
	JPanel btn_p = new JPanel();

	JPanel all_set_p = new JPanel();

	//관리자 화면
	JPanel admlog_p = new JPanel();

	JPanel adm_id_p = new JPanel();
	JLabel adm_id_L = new JLabel("관리자 아이디");
	JTextField adm_id_txt = new JTextField(15);

	JPanel adm_pwd_p = new JPanel();
	JLabel adm_pwd_L = new JLabel("관리자 비밀번호");
	JTextField adm_pwd_txt = new JPasswordField(15);

	JPanel adm_btn_p = new JPanel();
	JButton adm_login = new JButton("로그인");
	JButton adm_back = new JButton("뒤로가기");

	//관리자메인화면
	JPanel admmain_p = new JPanel();
	JPanel admmain_b = new JPanel();
	JButton book_manager = new JButton("도서관리");
	JButton member_manager = new JButton("회원관리");
	JButton admmain_back = new JButton("로그아웃");
	//도서관리메인 화면
	JPanel book_maneger_p = new JPanel();

	JPanel book_maneger_view = new JPanel();

	JPanel book_maneger_btn = new JPanel();
	JButton book_insert = new JButton("도서등록");
	JButton book_update = new JButton("도서수정");
	JButton book_delete = new JButton("도서삭제");
	JButton book_list = new JButton("도서목록");

	//도서등록
	JPanel book_manager_view_insert = new JPanel();
	JPanel book_manager_view_insert_1 = new JPanel();
	JPanel book_manager_view_insert_2 = new JPanel();
	JPanel book_manager_view_insert_3 = new JPanel();
	JPanel book_manager_view_insert_4 = new JPanel();

	JLabel add_book_title = new JLabel("도서제목");
	JTextField add_book_title_txt = new JTextField(15);
	JLabel add_book_info = new JLabel("정보");
	JTextField add_book_info_textfield = new JTextField(15);
	JLabel add_book_writer = new JLabel("저자명");
	JTextField add_book_writer_textfield = new JTextField(15);
	JButton add_btn = new JButton("저장하기");
	//도서삭제
	JPanel book_manager_view_delete = new JPanel();
	JPanel delete_p = new JPanel();
	JLabel delete_label = new JLabel("도서번호 입력");
	JTextField delete_txt = new JTextField(15);
	JButton delete_btn = new JButton("삭제하기");
	//도서목록
	JPanel book_manager_view_list = new JPanel(new GridLayout(1,2));
	List book_list_all = new List(20);
	JTextArea book_list_all_txt = new JTextArea();
	JScrollPane book_list_all_scroll = new JScrollPane(book_list_all_txt);
	//도서검색
	JPanel book_search_p = new JPanel();
	JLabel book_search_Label = new JLabel("도서제목 입력");
	JButton book_search_btn = new JButton("도서검색");
	JTextField book_search_txt = new JTextField(15);
	List book_list_list = new List(20);
	JTextArea book_list_txtArea = new JTextArea();
	JScrollPane book_list_scroll = new JScrollPane(book_list_txtArea);
	JPanel search_list_view = new JPanel(new GridLayout(1,2));
	//도서수정
	JPanel book_manager_view_update = new JPanel(new GridLayout(5,1));
	JPanel update_1 = new JPanel();
	JPanel update_2 = new JPanel();
	JPanel update_3 = new JPanel();
	JPanel update_4 = new JPanel();
	JPanel update_5 = new JPanel();
	JLabel update_no = new JLabel("수정할 도서 번호");
	JLabel update_title = new JLabel("제목수정");
	JLabel update_info = new JLabel("도서정보 수정");
	JLabel update_writer = new JLabel("저자명 수정");
	JTextField update_no_txt = new JTextField(15);
	JTextField update_title_txt = new JTextField(15);
	JTextField update_info_txt = new JTextField(15);
	JTextField update_writer_txt = new JTextField(15);
	JButton update_set = new JButton("수정하기");
	//회원관리화면
	JPanel member_maneger_view = new JPanel(new BorderLayout());

	JPanel member_manager_btn_p = new JPanel(new GridLayout(2,1));

	JPanel member_search_top_p = new JPanel();
	JLabel member_search_Label = new JLabel("회원이름 검색");
	JTextField member_search_txt = new JTextField(15);
	JButton member_search_btn = new JButton("검색");

	JPanel member_CRUD_btn_p = new JPanel();
	JButton member_insert_btn = new JButton("회원등록");
	JButton member_update_btn = new JButton("회원수정");
	JButton member_delete_btn = new JButton("회원삭제");
	JButton member_list_btn = new JButton("회원목록");

	//회원검색
	JPanel member_search_p = new JPanel(new GridLayout(1,2));
	List member_search_list = new List(20);
	JTextArea member_search_list_Area = new JTextArea();
	JScrollPane member_search_list_scroll = new JScrollPane(member_search_list_Area);
	//회원등록
	JPanel member_insert_p = new JPanel(new GridLayout(5,1));
	JPanel member_set_1 = new JPanel();
	JPanel member_set_2 = new JPanel();
	JPanel member_set_3 = new JPanel();
	JPanel member_set_4 = new JPanel();
	JPanel member_set_5 = new JPanel();

	JLabel member_id = new JLabel("아이디 입력");
	JLabel member_pwd = new JLabel("비밀번호 입력");
	JLabel member_name = new JLabel("이름 입력");
	JLabel member_addr = new JLabel("주소 입력");

	JTextField member_id_txt = new JTextField(15);
	JPasswordField member_pwd_txt = new JPasswordField(15);
	JTextField member_name_txt = new JTextField(15);
	JTextField member_addr_txt = new JTextField(15);

	JButton member_set_btn = new JButton("등록하기");

	//회원수정
	JPanel member_update_p = new JPanel(new GridLayout(5,1));
	JPanel member_update_1 = new JPanel();
	JPanel member_update_2 = new JPanel();
	JPanel member_update_3 = new JPanel();
	JPanel member_update_4 = new JPanel();
	JPanel member_update_5 = new JPanel();
	JLabel member_update_id = new JLabel("수정할 회원아이디");
	JLabel member_update_pwd = new JLabel("비밀번호 수정");
	JLabel member_update_name = new JLabel("이름 수정");
	JLabel member_update_addr = new JLabel("주소 수정");
	JTextField member_update_id_txt = new JTextField(15);
	JPasswordField member_update_pwd_txt = new JPasswordField(15);
	JTextField member_update_name_txt = new JTextField(15);
	JTextField member_update_addr_txt = new JTextField(15);
	JButton member_update_set = new JButton("수정하기");



	//회원삭제
	JPanel member_delete_p = new JPanel();
	JLabel member_delete_Label = new JLabel("삭제할 회원아이디 입력");
	JTextField member_delete_txt = new JTextField(15);
	JButton member_del_btn = new JButton("삭제하기");


	//회원목록
	JPanel member_list_p = new JPanel(new GridLayout(1,2));
	List member_list = new List(20);
	JTextArea member_list_Area = new JTextArea();
	JScrollPane member_list_scroll = new JScrollPane(member_list_Area);

	//도서대여,반납 화면
	JPanel rental_main_p = new JPanel();
	JPanel rental_main_btn_p = new JPanel();
	JButton rental_menu_btn = new JButton("도서대여 메뉴");
	JButton return_menu_btn = new JButton("도서반납 메뉴");
	JButton logout_btn = new JButton("로그아웃");

	JPanel rental_menu_p = new JPanel(new BorderLayout());
	JPanel rental_menu_btn_p = new JPanel();
	JButton rental_menu_book_list_btn = new JButton("도서목록");
	JButton rental_menu_book_search_btn = new JButton("도서검색");
	JButton rental_menu_book_rental_btn = new JButton("도서대여");

	JPanel rental_menu_book_list_p =new JPanel(new GridLayout(1,2));
	List rental_menu_book_list = new List(20);
	JTextArea rental_menu_book_list_Area = new JTextArea();
	JScrollPane rental_menu_book_list_scroll = new JScrollPane(rental_menu_book_list_Area);

	JPanel rental_menu_book_search_p = new JPanel(new BorderLayout());

	JPanel search_p = new JPanel();
	JLabel search_Label = new JLabel("도서제목 입력");
	JTextField rental_menu_book_search_txt = new JTextField(15);
	JButton search_btn = new JButton("검색");

	JPanel search_list_p = new JPanel(new GridLayout(1,2));
	List rental_menu_book_search_list = new List(20);
	JTextArea rental_menu_book_search_list_Area = new JTextArea();
	JScrollPane rental_menu_book_search_scroll = new JScrollPane(rental_menu_book_search_list_Area);

	JPanel rental_p = new JPanel();
	JLabel rental_Label = new JLabel("도서번호 입력");
	JTextField rental_txt = new JTextField(15);
	JButton rental_btn = new JButton("대여하기");

	JPanel return_menu_p = new JPanel(new BorderLayout());
	JPanel return_menu_top = new JPanel();
	JLabel return_book_no_Label = new JLabel("반납할 대여번호 입력");
	JTextField return_book_no_txt = new JTextField(15);
	JButton return_book_btn = new JButton("반납하기");
	JPanel rental_list_p = new JPanel(new GridLayout(1,2));
	List rental_list = new List();
	JTextArea rental_list_Area = new JTextArea();
	JScrollPane rental_list_scroll = new JScrollPane(rental_list_Area);

	public Main_gui() {
		this.setIconImage(image);
		this.setTitle("휴먼 도서대여");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		//로그인화면
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




		//회원가입 화면
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

		//관리자로그인 화면
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
		//관리자 메인화면
		admmain_p.setLayout(new BorderLayout());
		admmain_b.setLayout(new FlowLayout());
		admmain_b.add(book_manager);
		admmain_b.add(member_manager);
		admmain_b.add(admmain_back);
		//도서관리화면
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

		//도서등록
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
		//도서삭제
		delete_p.add(delete_label);
		delete_p.add(delete_txt);
		delete_p.add(delete_btn);
		book_manager_view_delete.add(delete_p);
		//도서목록
		book_manager_view_list.add(book_list_all);
		book_manager_view_list.add(book_list_all_scroll);
		//도서수정
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
		//도서대여,반납 화면
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
		//관리자 회원관리 화면
		member_maneger_view.add(member_manager_btn_p,"North");
		member_search_top_p.add(member_search_Label);
		member_search_top_p.add(member_search_txt);
		member_search_top_p.add(member_search_btn);
		member_manager_btn_p.add(member_search_top_p);
		this.member_search_btn.addActionListener(this);

		//회원검색화면
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

		//회원수정
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

		//회원목록
		member_list_p.add(member_list);
		member_list_p.add(member_list_scroll);
		this.member_list.addItemListener(this);
		//회원삭제화면
		member_delete_p.add(member_delete_Label);
		member_delete_p.add(member_delete_txt);
		member_delete_p.add(member_del_btn);
		this.member_del_btn.addActionListener(this);

		//회원수정
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
			//로그인화면 회원가입버튼
			id_textfield.setText("");
			pwd_textfield.setText("");
			this.remove(login);
			this.add(set_insert);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(back_set)) {
			//회원가입화면 뒤로가기 버튼
			this.remove(set_insert);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_insert)) {
			//회원가입화면 회원가입버튼
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(set_id_txt.getText());
			memberDTO.setPwd(set_pwd_txt.getText());
			memberDTO.setName(set_name_txt.getText());
			memberDTO.setAddr(set_addr_txt.getText());
			MemberDTO aDto = memberDAO.find_id(set_id_txt.getText());
			if(aDto!=null) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
			}else {
				boolean chk = memberDAO.memberset(memberDTO);
				if(chk) {
					JOptionPane.showMessageDialog(null, "회원가입 완료");
					set_id_txt.setText("");
					set_pwd_txt.setText("");
					set_name_txt.setText("");
					set_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "영문10글자 or 한글5글자 내로 입력하세요.");
				}
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(adm_btn)) {
			//메인화면 관리자 버튼
			id_textfield.setText("");
			pwd_textfield.setText("");
			this.remove(login);
			this.add(admlog_p);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(adm_login)) {
			//관리자 로그인화면 로그인버튼
			boolean chk = adm.login_adm(adm_id_txt.getText(),adm_pwd_txt.getText());
			if(chk) {
				adm_id_txt.setText("");
				adm_pwd_txt.setText("");
				this.remove(admlog_p);
				this.add(admmain_p);
				this.repaint();
				this.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		}else if(object.equals(adm_back)) {
			//관리자 로그인화면 뒤로가기 버튼
			this.remove(admlog_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_manager)) {
			//관리자메인화면 도서관리버튼
			admmain_p.remove(member_maneger_view);
			admmain_p.add(book_maneger_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_manager)) {
			//관리자메인화면 회원관리버튼
			admmain_p.remove(book_maneger_view);
			admmain_p.add(member_maneger_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(admmain_back)) {
			//관리자화면 로그아웃버튼
			this.remove(admmain_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_search_btn)) {
			//도서검색버튼
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_list_list.removeAll();
			book_list_txtArea.setText("");
			if(book_search_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "검색할 도서제목을 입력하세요.");
			}else {
				ArrayList<BookDTO> list = bookDAO.search(book_search_txt.getText());
				if(list!=null) {
					book_list_list.add("도서제목");
					for(BookDTO i : list) {
						book_list_list.add(i.getTitle());
					}
				}else if (list==null){
					JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
				}
			}
			book_maneger_view.add(search_list_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(book_insert)) {
			//도서등록버튼
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_insert,"Center");
			this.repaint();
			this.setVisible(true);

		}else if(object.equals(add_btn)){
			//도서등록 저장하기버튼
			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle(add_book_title_txt.getText());
			bookDTO.setInfo(add_book_info_textfield.getText());
			bookDTO.setWriter(add_book_writer_textfield.getText());
			boolean a = bookDAO.insert_book(bookDTO);
			if(!a) {
				JOptionPane.showMessageDialog(null, "영문10글자 or 한글5글자 내로 입력하세요.");
			}else {
				add_book_title_txt.setText("");
				add_book_info_textfield.setText("");
				add_book_writer_textfield.setText("");
				JOptionPane.showMessageDialog(null, "저장완료");
			}
		}else if(object.equals(book_update)) {
			//도서수정
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_update,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(update_set)) {
			//수정하기 버튼
			boolean chk_1 = true;
			boolean chk_2 = true;
			boolean chk_3 = true;
			int chk = 0;
			if(update_no_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "도서번호를 입력하세요.");
			}else if(bookDAO.select_no_One(update_no_txt.getText())==null){
				JOptionPane.showMessageDialog(null, "존재하지 않는 도서번호 입니다..");
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
					JOptionPane.showMessageDialog(null, "수정 완료");
				}else {
					JOptionPane.showMessageDialog(null,"한글5글자 OR 영문10글자 이내로 입력하세요");
				}
			}
			update_no_txt.setText("");
			update_title_txt.setText("");
			update_info_txt.setText("");
			update_writer_txt.setText("");
		}else if(object.equals(book_delete)) {
			//도서삭제
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(book_manager_view_list);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_delete,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(delete_btn)) {
			//삭제하기 버튼
			if(delete_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "도서번호를 입력하세요");
			}else {
				BookDTO bookDTO = new BookDTO();
				int no = Integer.parseInt(delete_txt.getText());
				bookDTO.setNo(no);
				boolean chk = bookDAO.delete_book(no);
				if(chk) {
					JOptionPane.showMessageDialog(null, "삭제 완료");
					delete_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다");
				}
			}
		}else if(object.equals(book_list)) {
			//도서목록
			book_maneger_view.remove(book_manager_view_update);
			book_maneger_view.remove(book_manager_view_delete);
			book_maneger_view.remove(book_manager_view_insert);
			book_maneger_view.remove(search_list_view);
			book_maneger_view.add(book_manager_view_list,"Center");
			book_list_all.removeAll();
			book_list_all_txt.setText("");
			ArrayList<BookDTO> list = bookDAO.select_title_group();
			if(list!=null) {
				book_list_all.add("---도서제목---");
				for(BookDTO i : list) {
					book_list_all.add(i.getTitle());
				}
			}else {
				JOptionPane.showMessageDialog(null, "등록된 도서가 없습니다.");
			}
			this.repaint();
			this.setVisible(true);
		}else if (object.equals(log_btn)) {
			//메인화면 로그인버튼
			login_member = memberDAO.find_id(id_textfield.getText());
			if(login_member==null) {
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
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
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
				}
			}
		}else if(object.equals(logout_btn)) {
			//대여반납메인 로그아웃버튼
			this.remove(rental_main_p);
			this.add(login);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_menu_btn)) {
			//대여메뉴버튼
			rental_main_p.remove(return_menu_p);
			rental_main_p.add(rental_menu_p);
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(return_menu_btn)) {
			//반납메뉴버튼
			rental_main_p.remove(rental_menu_p);
			rental_main_p.add(return_menu_p);
			rental_list.removeAll();
			rental_list_Area.setText("");
			ArrayList<Book_rental_listDTO> list = book_rental_listDAO.rental_books(login_member_id);
			rental_list.add("대여도서 제목");
			if(list==null) {
				JOptionPane.showMessageDialog(null, "대여한 도서가 없습니다.");
			}else {
				for(Book_rental_listDTO i : list) {
					rental_list.add(i.getTitle());
				}
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(return_book_btn)) {
			//반납하기버튼
			if(return_book_no_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "대여번호를 입력하세요.");
			}else {
				boolean chk = book_rental_listDAO.return_book(login_member_id, return_book_no_txt.getText());
				if(chk) {
					JOptionPane.showMessageDialog(null, "반납 완료");
					rental_list.removeAll();
					rental_list_Area.setText("");
					ArrayList<Book_rental_listDTO> list = book_rental_listDAO.rental_books(login_member_id);
					rental_list.add("대여도서 제목");
					if(list==null) {
						JOptionPane.showMessageDialog(null, "대여한 도서가 없습니다.");
					}else {
						for(Book_rental_listDTO i : list) {
							rental_list.add(i.getTitle());
						}
					}
					this.repaint();
					this.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
				}
			}
		}else if(object.equals(rental_menu_book_search_btn)) {
			//대여메뉴 검색버튼
			rental_menu_p.remove(rental_menu_book_list_p);
			rental_menu_p.remove(rental_p);
			rental_menu_p.add(rental_menu_book_search_p,"Center");
			rental_menu_book_search_list.removeAll();
			rental_menu_book_search_list_Area.setText("");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(search_btn)) {
			//대여검색화면 검색버튼
			rental_menu_book_search_list.removeAll();
			rental_menu_book_search_list_Area.setText("");
			rental_menu_book_search_list.add("---도서제목---");
			if(rental_menu_book_search_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "검색할 도서제목을 입력하세요.");
			}else {
				ArrayList<BookDTO> list = bookDAO.search(rental_menu_book_search_txt.getText());
				if(list==null) {
					JOptionPane.showMessageDialog(null, "일치하는 도서제목이 없습니다");
				}else {
					for(BookDTO i : list) {
						rental_menu_book_search_list.add(i.getTitle());
					}
				}
			}
		}else if(object.equals(rental_menu_book_list_btn)) {
			//대여메뉴 도서목록버튼
			rental_menu_p.remove(rental_menu_book_search_p);
			rental_menu_p.remove(rental_p);
			rental_menu_p.add(rental_menu_book_list_p,"Center");
			rental_menu_book_list.removeAll();
			rental_menu_book_list_Area.setText("");
			rental_menu_book_list.add("도서제목");
			ArrayList<BookDTO> list = bookDAO.select_title_group();
			if(list!=null) {
				for(BookDTO i : list) {
					rental_menu_book_list.add(i.getTitle());
				}
			}else {
				JOptionPane.showMessageDialog(null, "등록된 도서가 없습니다.");
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_menu_book_rental_btn)) {
			//대여메뉴 대여버튼
			rental_menu_p.remove(rental_menu_book_search_p);
			rental_menu_p.remove(rental_menu_book_list_p);
			rental_menu_p.add(rental_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(rental_btn)) {
			//대여메뉴 대여하기버튼
			BookDTO bookDTO = bookDAO.select_no_One(rental_txt.getText());
			if(bookDTO==null) {
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
			}else {
				boolean chk = book_rental_listDAO.insert(bookDTO, login_member_id);
				if(chk) {
					JOptionPane.showMessageDialog(null,
							"도서번호 : "+bookDTO.getNo()+"\n"+"도서제목 : "+bookDTO.getTitle()+"\n"+"대여완료");
				}
			}
		}else if(object.equals(member_search_btn)) {
			//관리자 회원관리화면 회원 검색버튼
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
					JOptionPane.showMessageDialog(null, "검색한 이름이 포함된 회원이 없습니다.");
				}else {
					for(MemberDTO i : list) {
						member_search_list.add(i.getId());
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "회원이름을 입력하세요");
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_insert_btn)) {
			//회원관리화면 회원등록버튼
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.add(member_insert_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_set_btn)) {
			//회원등록화면 등록하기버튼
			if(memberDAO.find_id(member_id_txt.getText())==null) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(member_id_txt.getText());
				memberDTO.setPwd(member_pwd_txt.getText());
				memberDTO.setName(member_name_txt.getText());
				memberDTO.setAddr(member_addr_txt.getText());
				boolean chk = memberDAO.memberset(memberDTO);
				if(chk) {
					JOptionPane.showMessageDialog(null, "등록 완료");
					member_id_txt.setText("");
					member_pwd_txt.setText("");
					member_name_txt.setText("");
					member_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "영문10글자 or 한글5글자 내로 입력하세요.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
			}
		}else if(object.equals(member_list_btn)) {
			//회원목록 버튼
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_list_p,"Center");
			ArrayList<MemberDTO> list = memberDAO.allselect();
			member_list.removeAll();
			member_list_Area.setText("");
			member_list.add("---회원아이디 목록---");
			for(MemberDTO i : list) {
				member_list.add(i.getId());
			}
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_delete_btn)) {
			//관리자화면 회원삭제버튼
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_update_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_delete_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_del_btn)) {
			//회원삭제 화면 삭제하기버튼
			if(member_delete_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "회원아이디를 입력하세요.");
			}else {
				boolean chk = memberDAO.del(member_delete_txt.getText());
				if(chk) {
					JOptionPane.showMessageDialog(null, "삭제완료.");
					member_delete_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.");
				}
			}
		}else if(object.equals(member_update_btn)) {
			//회원수정버튼
			member_maneger_view.remove(member_search_p);
			member_maneger_view.remove(member_delete_p);
			member_maneger_view.remove(member_list_p);
			member_maneger_view.remove(member_insert_p);
			member_maneger_view.add(member_update_p,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(member_update_set)) {
			//수정하기 버튼
			boolean chk_1 = true;
			boolean chk_2 = true;
			boolean chk_3 = true;
			int chk = 0;
			if(member_update_id_txt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "수정할 회원아이디를 입력하세요.");
			}else if(memberDAO.find_id(member_update_id_txt.getText())==null) {
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
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
					JOptionPane.showMessageDialog(null, "수정 완료");
					member_update_id_txt.setText("");
					member_update_pwd_txt.setText("");
					member_update_name_txt.setText("");
					member_update_addr_txt.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"한글5글자 OR 영문10글자 이내로 입력하세요");
				}
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(book_list_list)) {
			//관리자도서검색 목록
			String select = book_list_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			book_list_txtArea.setText("");
			for(BookDTO bookDTO : list) {
				book_list_txtArea.append("도서번호 : "+bookDTO.getNo()+"\n");
				book_list_txtArea.append("제목 : "+bookDTO.getTitle()+"\n");
				book_list_txtArea.append("설명 : "+bookDTO.getInfo()+"\n");
				book_list_txtArea.append("저자 : "+bookDTO.getWriter()+"\n");
				book_list_txtArea.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(book_list_all)) {
			//관리자 도서목록
			String select = book_list_all.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			book_list_all_txt.setText("");
			for(BookDTO bookDTO : list) {
				book_list_all_txt.append("도서번호 : "+bookDTO.getNo()+"\n");
				book_list_all_txt.append("제목 : "+bookDTO.getTitle()+"\n");
				book_list_all_txt.append("설명 : "+bookDTO.getInfo()+"\n");
				book_list_all_txt.append("저자 : "+bookDTO.getWriter()+"\n");
				book_list_all_txt.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_menu_book_search_list)) {
			//도서대여 검색리스트
			String select = rental_menu_book_search_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			rental_menu_book_search_list_Area.setText("");
			for(BookDTO bookDTO : list) {
				rental_menu_book_search_list_Area.append("도서번호 : "+bookDTO.getNo()+"\n");
				rental_menu_book_search_list_Area.append("제목 : "+bookDTO.getTitle()+"\n");
				rental_menu_book_search_list_Area.append("설명 : "+bookDTO.getInfo()+"\n");
				rental_menu_book_search_list_Area.append("저자 : "+bookDTO.getWriter()+"\n");
				rental_menu_book_search_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_menu_book_list)) {
			//도서대여 목록
			String select = rental_menu_book_list.getSelectedItem();
			ArrayList<BookDTO> list = bookDAO.select_title(select);
			rental_menu_book_list_Area.setText("");
			for(BookDTO bookDTO : list) {
				rental_menu_book_list_Area.append("도서번호 : "+bookDTO.getNo()+"\n");
				rental_menu_book_list_Area.append("제목 : "+bookDTO.getTitle()+"\n");
				rental_menu_book_list_Area.append("설명 : "+bookDTO.getInfo()+"\n");
				rental_menu_book_list_Area.append("저자 : "+bookDTO.getWriter()+"\n");
				rental_menu_book_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(rental_list)) {
			//반납버튼 목록
			String select = rental_list.getSelectedItem();
			ArrayList<Book_rental_listDTO> list = book_rental_listDAO.select_rentalOne(login_member_id, select);
			rental_list_Area.setText("");
			for(Book_rental_listDTO i : list) {
				rental_list_Area.append("대여번호 : "+Integer.toString(i.getRental_no())+"\n");
				rental_list_Area.append("도서번호 : "+Integer.toString(i.getBook_no())+"\n");
				rental_list_Area.append("도서제목 : "+i.getTitle()+"\n");
				rental_list_Area.append("도서정보 : "+i.getInfo()+"\n");
				rental_list_Area.append("저자명 : "+i.getWriter()+"\n");
				rental_list_Area.append("대여날짜 : "+i.getRental_date()+"\n");
				rental_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(member_search_list)) {
			//회원이름검색 리스트
			String select = member_search_list.getSelectedItem();
			ArrayList<MemberDTO> list = memberDAO.select_name_all(select);
			member_search_list_Area.setText("");
			for(MemberDTO i : list) {
				member_search_list_Area.append("회원 아이디 : "+i.getId()+"\n");
				member_search_list_Area.append("회원 비밀번호 : "+i.getPwd()+"\n");
				member_search_list_Area.append("회원 이름 : "+i.getName()+"\n");
				member_search_list_Area.append("회원 주소 : "+i.getAddr()+"\n");
				member_search_list_Area.append("--------------------------"+"\n");
			}
		}else if(e.getSource().equals(member_list)) {
			//회원아이디목록
			String select = member_list.getSelectedItem();
			MemberDTO memberDTO = memberDAO.find_id(select);
			member_list_Area.setText("");
			member_list_Area.append("회원 아이디 : "+memberDTO.getId()+"\n");
			member_list_Area.append("회원 비밀번호 : "+memberDTO.getPwd()+"\n");
			member_list_Area.append("회원 이름 : "+memberDTO.getName()+"\n");
			member_list_Area.append("회원 주소 : "+memberDTO.getAddr()+"\n");
		}
	}
}

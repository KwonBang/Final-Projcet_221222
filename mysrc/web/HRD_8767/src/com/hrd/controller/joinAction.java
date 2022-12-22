package com.hrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.MemberVO;

/**
 * Servlet implementation class joinAction
 */
@WebServlet("/joinAction")
public class joinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//파라미터 받기
		String custno = request.getParameter("custno");
		String custname = (String)request.getParameter("custname");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		String joindate = (String)request.getParameter("joindate");
		String grade = (String)request.getParameter("grade");
		String city = (String)request.getParameter("city");
		
		System.out.println(custname+"/"+phone+"/"+address+"/"+joindate+"/"+grade+"/"+city);
		//dao에게 전달할 vo
		//번호자동 생성 이라는 기능을 구현한다면 자동생성된 번호도 추가 해야 합니다...
		MemberVO memberVO = new MemberVO();
		memberVO.setCustno(Integer.parseInt(custno));
		memberVO.setCustname(custname);
		memberVO.setCity(city);
		memberVO.setAddress(address);
		memberVO.setGrade(grade);
		memberVO.setJoindate(joindate);
		memberVO.setPhone(phone);
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.insert(memberVO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

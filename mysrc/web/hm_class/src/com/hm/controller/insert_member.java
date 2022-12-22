package com.hm.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hm.DAO.MemberDAO;
import com.hm.VO.MemberVO;

/**
 * Servlet implementation class insert_member
 */
@WebServlet("/insert_member")
public class insert_member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String joindate = (String)request.getParameter("joindate");
		String grade = request.getParameter("grade");
		MemberVO memberVO = new MemberVO();
		memberVO.setName(name);
		memberVO.setGrade(grade);
		memberVO.setJoindate(joindate);
		memberVO.setTel(tel);
		memberVO.setAddress(address);
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.insert(memberVO);
		String url = "index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

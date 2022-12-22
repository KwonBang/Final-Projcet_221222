package com.human.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.DAO.BoardDAO;
import com.human.vo.BoardVO;

/**
 * Servlet implementation class wrAction
 */
@WebServlet("/wrAction")
public class wrAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDAO =new BoardDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wrAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = (String)request.getParameter("name");
		String pass = (String)request.getParameter("pass");
		String email = (String)request.getParameter("email");
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		BoardVO boardVO = new BoardVO();
		boardVO.setName(name);
		boardVO.setPass(pass);
		boardVO.setEmail(email);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		if(name!=null) {
			boardDAO.board_insert(boardVO);
		}else {
			System.out.println("입력할 글이 없습니다.");
		}
		System.out.println(name+"/"+pass+"/"+email+"/"+title+"/"+content);
		//DB insert 작업 추가해야함.
		response.sendRedirect("boardList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

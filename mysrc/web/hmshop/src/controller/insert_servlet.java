package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmshopVO.*;

import hmshopDAO.*;

/**
 * Servlet implementation class insert_servlet
 */
@WebServlet("/insert_servlet")
public class insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardDAO boardDAO = new BoardDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String id = (String)request.getParameter("id");
		String name = (String)request.getParameter("name");
		String pass = (String)request.getParameter("pass");
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String chkbox = (String)request.getParameter("chkbox");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		boardVO.setId(id);
		boardVO.setName(name);
		boardVO.setPass(pass);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setChkbox(chkbox);
		if(name!=null) {
			boardDAO.insert(boardVO);
		}else {
			System.out.println("입력할 글이 없습니다.");
		}
		//DB insert 작업 추가해야함.
		response.sendRedirect("list_servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

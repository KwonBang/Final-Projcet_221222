package com.hrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.MemberVO;
import com.hrd.VO.ViewMoneyVO;

/**
 * Servlet implementation class viewMoney
 */
@WebServlet("/viewMoney")
public class viewMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 2. 파라미터 받을 필요없다. 그러나 페이지기능이 있다면 몇번 페이지를 요청했는지 받아야 한다.
		// 3. 모델	쿼리 > 리턴받을 값 (DTO단일 객체이거나 여러개일 경우는 List많이 사용)
		MemberDAO memberDAO = MemberDAO.getInstance(); //문제가 있냐면 계속 객체를 만들어요..>싱글톤(객체는 한개만 만들고 공유)
		ArrayList<ViewMoneyVO> totalList = new ArrayList<>();
		totalList = memberDAO.selectTotalAll();
		// 디버깅 하시오
		System.out.println(totalList.size()+"건 가져옴[디버깅]");
		
		// 4. 뷰지정
		// view지정..
		String url = "viewMoney.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("totalList", totalList); //타입
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

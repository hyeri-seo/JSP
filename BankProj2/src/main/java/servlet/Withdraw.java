package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null) {
			request.setAttribute("err", "로그인하세요");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("withdraw.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.계좌번호, 출금액을 가져온다.
		String id = request.getParameter("id");
		Integer money= Integer.parseInt(request.getParameter("money"));
		//2.계좌번호로 session에서 계좌를 찾는다.
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		
		RequestDispatcher dispatcher = null;
		//3.계좌가 없으면 error 페이지로 포워딩한다.
		if(acc==null) {
			request.setAttribute("err","계좌번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else {
		//4_0. 계좌를 찾으면 계좌에서 출금한다.
		acc.withdraw(money);
		//4_1. request에 계좌를 넣는다.
		request.setAttribute("acc", acc);
		//4_2. accountinfo.jsp로 포워딩 한다.
		dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		}
		dispatcher.forward(request,response);
		
	}

}

package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<Account> accountList = new ArrayList<>(); // 변수 정의
        AccountService accountService = new AccountService();
        try {
            accountList = accountService.allAccountInfo(); // 계좌 정보 조회
            request.setAttribute("accs", accountList); // JSP로 전달
            request.getRequestDispatcher("allaccountinfo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리
            request.setAttribute("err", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}

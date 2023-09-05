package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");//한글처리
		String id = request.getParameter("ID");//계정
		String name = request.getParameter("NAME");//이름
		String addr = request.getParameter("ADDR");//주소
		String phone = request.getParameter("PHONE");//연락처
		String password = request.getParameter("PWD");//암호
		String gender = request.getParameter("GENDER");//성별
		String email = request.getParameter("EMAIL");//이메일
		String job = request.getParameter("JOB");//직업
		Customer c = new Customer();//DTO생성
		c.setId(id); c.setPwd(password); c.setName(name); c.setAddr(addr);
		c.setPhone(phone); c.setGender(gender); c.setEmail(email);c.setJob(job);
		Crud dao = new Crud();
		int res = dao.register(c);
		String result = "";
		if(res > 0) result = "OK";
		else result = "NOK";
		response.sendRedirect("template.jsp?BODY=userEntryResult.jsp?R="+result);
	}

}














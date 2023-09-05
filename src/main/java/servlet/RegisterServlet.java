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
		request.setCharacterEncoding("euc-kr");//�ѱ�ó��
		String id = request.getParameter("ID");//����
		String name = request.getParameter("NAME");//�̸�
		String addr = request.getParameter("ADDR");//�ּ�
		String phone = request.getParameter("PHONE");//����ó
		String password = request.getParameter("PWD");//��ȣ
		String gender = request.getParameter("GENDER");//����
		String email = request.getParameter("EMAIL");//�̸���
		String job = request.getParameter("JOB");//����
		Customer c = new Customer();//DTO����
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














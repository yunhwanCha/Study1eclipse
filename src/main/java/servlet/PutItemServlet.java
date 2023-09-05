package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.Item;

/**
 * Servlet implementation class PutItemServlet
 */
@WebServlet("/putItem.do")
public class PutItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutItemServlet() {
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
		String code = request.getParameter("CODE");//��ǰ��ȣ ����
		String title = request.getParameter("TITLE");//��ǰ�̸� ����
		String price = request.getParameter("PRICE");//���� ����
		String origin = request.getParameter("ORIGIN");//������ ����
		String content = request.getParameter("CONTENT");//��ǰ ���� ����
		Item item = new Item();
		item.setCode(code); item.setTitle(title); 
		item.setPrice(Integer.parseInt(price)); item.setOrigin(origin);
		item.setContent(content);
		Crud dao = new Crud();
		int res = dao.putItem(item);
		String result = "";
		if(res > 0) result = "OK";
		else result = "NOK";
		response.sendRedirect("template.jsp?BODY=putItemResult.jsp?R="+result);
	}
}















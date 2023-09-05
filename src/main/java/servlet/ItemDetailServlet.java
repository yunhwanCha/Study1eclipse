package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.Item;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/itemDetail.do")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");//��ǰ��ȣ�� ������
		Crud dao = new Crud();
		Item item = dao.getItemDetail(code);//DB���� ��ǰ������ �˻�
		request.setAttribute("ITEM", item);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ADMIN");
		if(id != null) {//�����ڷ� �α��� �� ���
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=itemDetailAdmin.jsp");
			rd.forward(request, response);
		}else {//�α����� ���߰ų�, �����ڷ� �α��� �� ��찡 �ƴ� ���
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=itemDetail.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












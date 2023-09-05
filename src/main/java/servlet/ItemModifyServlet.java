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
 * Servlet implementation class ItemModifyServlet
 */
@WebServlet("/itemModify.do")
public class ItemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemModifyServlet() {
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
		String btn = request.getParameter("BTN");//��ư����
		String code = request.getParameter("CODE");//��ǰ��ȣ
		String title = request.getParameter("TITLE");//��ǰ�̸�
		String price = request.getParameter("PRICE");//��ǰ����
		String origin = request.getParameter("ORIGIN");//������
		String content = request.getParameter("CONTENT");//��ǰ����
		Item item = new Item();//��ǰ������ ���� DTO����
		item.setCode(code); item.setTitle(title); item.setContent(content);
		item.setPrice(Integer.parseInt(price)); item.setOrigin(origin);
		Crud dao = new Crud();
		String result = "";//�۾��� ����� ����� ���� ����
		if(btn.equals("�� ��")) {//���� ��ư�� ���� ���
			result = dao.deleteItem(code);
		}else if(btn.equals("�� ��")) {//���� ��ư�� ���� ���
			result = dao.updateItem(item);
		}
		response.sendRedirect("template.jsp?BODY=itemModifyResult.jsp?R="+result);
	}

}
















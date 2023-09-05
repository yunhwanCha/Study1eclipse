package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.Item;
import service.Cart;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cartList.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null || cart.getCodeList().size() == 0) {//��ٱ��ϰ� ���� ���
			request.setAttribute("CARTLIST", null);
		}else {//��ٱ��ϰ� �ִ� ���
			Crud dao = new Crud();
			int total = 0;//�Ѿ��� ���� ���� ����
			ArrayList<String> codeList=cart.getCodeList();//��ٱ����� ��ǰ���
			ArrayList<Integer> numList=cart.getNumList();//��ٱ����� �������
			ArrayList<Item> itemList = new ArrayList<Item>();
			for(int i=0; i < codeList.size(); i++) {
				String code = codeList.get(i);//n��° ��ǰ��ȣ�� ����
				Item item = dao.getItemDetail(code);//��ǰ��ȣ�� ��ǰ������ �˻��Ѵ�.
				item.setNum(numList.get(i));//�˻��� ��ǰ������ ������ �����Ѵ�.
				total = total + (item.getNum() * item.getPrice());//��ǰ�� �Ѿ��� ����Ѵ�.
				itemList.add(item);//���� Item�� ArrayList�� �����Ѵ�.
			}
			request.setAttribute("CARTLIST", itemList);
			request.setAttribute("TOTAL", total);
		}
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=cartList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








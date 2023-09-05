package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Cart;

/**
 * Servlet implementation class AddCartServet
 */
@WebServlet("/addCart.do")
public class AddCartServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");//��ǰ��ȣ ����
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");//���ǿ��� ������ ã�´�.
		Cart cart = (Cart)session.getAttribute("CART");//���ǿ��� ��ٱ��ϸ� ã�´�.
		if(cart == null) {//��ٱ��ϰ� ���� ���,��, �α��� �� ���ķ� ��ٱ��ϸ� ������� ����
			cart = new Cart(id);
		}
		cart.addCart(code, 1);
		session.setAttribute("CART", cart);//��ٱ��ϸ� ���ǿ� ����
		response.sendRedirect("addCartResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






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
 * Servlet implementation class ModifyCartServlet
 */
@WebServlet("/modifyCart.do")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCartServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String code = request.getParameter("CODE");
		String num = request.getParameter("NUM");
		String btn = request.getParameter("BTN");
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		if(btn.equals("����")) {
			cart.deleteItem(code);
		}else if(btn.equals("����")) {
			cart.modifyItem(code, Integer.parseInt(num));
		}
		response.sendRedirect("cartList.do");//�ٽ� ��ٱ��� ����� ����Ѵ�.
	}

}














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
		String code = request.getParameter("CODE");//상품번호 수신
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");//세션에서 계정을 찾는다.
		Cart cart = (Cart)session.getAttribute("CART");//세션에서 장바구니를 찾는다.
		if(cart == null) {//장바구니가 없는 경우,즉, 로그인 한 이후로 장바구니를 사용하지 않음
			cart = new Cart(id);
		}
		cart.addCart(code, 1);
		session.setAttribute("CART", cart);//장바구니를 세션에 저장
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






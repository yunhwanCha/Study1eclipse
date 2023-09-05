package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.CartItem;
import service.Cart;

//class LoginChecker {
//	String putMessage(String id, String password, HttpServletRequest  request){
////		DBExpert_ dbe = new DBExpert_();
//		String pwd = dbe.getPassword(id);
//		String result = "";
//		if(pwd != null) {//암호가 검색이 된 경우
//			if(password.equals(pwd)) {//입력한 암호와 검색된 암호가 같은 경우
//				result = "OK";
//				HttpSession session = request.getSession();
//				if(id.equals("manager")) {
//					session.setAttribute("ADMIN", id);
//				}else {
//					session.setAttribute("USER", id);
//				}
//				//로그인한 계정으로 장바구니 정보를 DB에서 검색한다.
//				//장바구니 정보가 검색된 경우, 검색정보를 Cart에 저장한다.
//				//로그인 성공시 장바구니 DB 검색 시작
////				ArrayList<CartItem> cartList = dbe.getCart(id);
////				if(cartList.size() > 0) {//검색된 건 수가 존재하는 경우
////					Cart cart = new Cart(id);//장바구니(Cart)를 생성
////					for(int i=0; i < cartList.size(); i++) {
////						CartItem ci = cartList.get(i);//N번째 CartItem을 가져옴
////						cart.getCodeList().add(ci.getCode());
////						cart.getNumList().add(ci.getNum());
////					}
////					session.setAttribute("CART", cart);//세션에 장바구니를 저장
////				}
//				//로그인 성공시 장바구니 DB 검색 끝
//			}else {//암호가 일치하지 않는 경우
//				result = "NOK";
//			}
//		}else {//암호가 검색이 안된 경우
//			result = "NOK";
//		}
//		return result;
//	}
//}

@WebServlet("/loginDo.do")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		Crud dao = new Crud();
		String pwdInDB = dao.getPwd(id);//계정으로 암호를 검색
		String result = "";
		if(pwdInDB == null) {//계정이 존재하지 않는 경우
			result = "NOK";
		}else {//계정이 존재하는 경우
			if(pwd.equals(pwdInDB)) {//암호가 일치하는 경우
				result = "OK";
				HttpSession session = request.getSession();
				if(id.equals("manager")) {
					session.setAttribute("ADMIN", id);
				}else {
					session.setAttribute("USER", id);
				}
				//로그인 성공시 장바구니 DB 검색 시작
				ArrayList<CartItem> cartList = dao.getCart(id);
				if(cartList.size() > 0) {//검색된 건 수가 존재하는 경우
					Cart cart = new Cart(id);//장바구니(Cart)를 생성
					for(int i=0; i < cartList.size(); i++) {
						CartItem ci = cartList.get(i);//N번째 CartItem을 가져옴
						cart.getCodeList().add(ci.getCode());
						cart.getNumList().add(ci.getNum());
					}
					session.setAttribute("CART", cart);//세션에 장바구니를 저장
				}
				//로그인 성공시 장바구니 DB 검색 끝
			}else {//암호가 일치하지 않는 경우
				result = "NOK";
			}
		}
		//페이지를 loginResult.jsp로 바꾼다.Redirect
		response.sendRedirect(
			"template.jsp?BODY=loginResult.jsp?R="+result);
	}
}













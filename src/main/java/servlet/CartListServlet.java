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
		if(cart == null || cart.getCodeList().size() == 0) {//장바구니가 없는 경우
			request.setAttribute("CARTLIST", null);
		}else {//장바구니가 있는 경우
			Crud dao = new Crud();
			int total = 0;//총액을 위한 변수 선언
			ArrayList<String> codeList=cart.getCodeList();//장바구니의 상품목록
			ArrayList<Integer> numList=cart.getNumList();//장바구니의 갯수목록
			ArrayList<Item> itemList = new ArrayList<Item>();
			for(int i=0; i < codeList.size(); i++) {
				String code = codeList.get(i);//n번째 상품번호를 추출
				Item item = dao.getItemDetail(code);//상품번호로 상품정보를 검색한다.
				item.setNum(numList.get(i));//검색된 상품정보에 갯수를 저장한다.
				total = total + (item.getNum() * item.getPrice());//상품의 총액을 계산한다.
				itemList.add(item);//위의 Item을 ArrayList에 저장한다.
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








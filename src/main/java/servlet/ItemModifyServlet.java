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
		request.setCharacterEncoding("euc-kr");//한글처리
		String btn = request.getParameter("BTN");//버튼제목
		String code = request.getParameter("CODE");//상품번호
		String title = request.getParameter("TITLE");//상품이름
		String price = request.getParameter("PRICE");//상품가격
		String origin = request.getParameter("ORIGIN");//원산지
		String content = request.getParameter("CONTENT");//상품설명
		Item item = new Item();//상품정보를 위한 DTO생성
		item.setCode(code); item.setTitle(title); item.setContent(content);
		item.setPrice(Integer.parseInt(price)); item.setOrigin(origin);
		Crud dao = new Crud();
		String result = "";//작업의 결과가 저장될 변수 선언
		if(btn.equals("삭 제")) {//삭제 버튼을 누른 경우
			result = dao.deleteItem(code);
		}else if(btn.equals("수 정")) {//수정 버튼을 누른 경우
			result = dao.updateItem(item);
		}
		response.sendRedirect("template.jsp?BODY=itemModifyResult.jsp?R="+result);
	}

}
















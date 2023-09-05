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
import model.FromTo;
import model.Item;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList.do")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("PAGE");
		int currentPage = 1;//현재 페이지가 저장될 변수
		if(page != null) currentPage = Integer.parseInt(page);
		int from = (currentPage - 1) * 5;
		int to = ((currentPage - 1) * 5) + 6;
		int totalCount = 0;//상품의 갯수가 저장될 변수
		Crud dao = new Crud();
		totalCount = dao.getItemCount();//상품의 갯수를 수신
		int startRow = 0; int endRow = 0; int pageCount = 0;
		if(totalCount > 0) {
			pageCount = totalCount / 5;
			if(totalCount % 5 > 0) pageCount++;
			startRow = ((currentPage - 1) * 5 ) + 1;
			endRow = currentPage * 5;
			if(endRow > totalCount) {
				endRow = totalCount;
			}
		}
		FromTo ft = new FromTo(); ft.setFrom(from); ft.setTo(to);
		ArrayList<Item> itemList = dao.getAllItems(ft);
		request.setAttribute("ITEMS", itemList);//상품목록을 저장
		request.setAttribute("START", startRow);
		request.setAttribute("END", endRow);
		request.setAttribute("TOTAL", totalCount);
		request.setAttribute("PAGES", pageCount);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");//로그인 여부를 검사
		if(id != null) {//일반 사용자로 로그인 한 경우
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=itemsList.jsp");
			rd.forward(request, response);
		}else {//로그인을 안 한 경우
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=itemsListDummy.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.FromTo;
import model.ImageBBS;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/imageList.do")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_num = request.getParameter("PAGE_NUM");
		int currentPage = 1;//현재 페이지 번호
		if(page_num != null) currentPage = Integer.parseInt(page_num);
		int startRow = (currentPage - 1) * 5;
		int endRow = ((currentPage - 1) * 5 ) + 6;
		Crud dao = new Crud();
		int totalCount = dao.getImageCount();//이미지 게시글의 갯수
		int pageCount = 0;//페이지 갯수가 저장될 변수 선언
		if(totalCount > 0) {
			pageCount = totalCount / 5;
			if(totalCount % 5 > 0) pageCount++;
			if(endRow > totalCount) endRow = totalCount + 1;
		}
		FromTo ft = new FromTo(); ft.setFrom(startRow); ft.setTo(endRow);
		ArrayList<ImageBBS> imageList = dao.getImages(ft);
		request.setAttribute("startRow", startRow+1);
		request.setAttribute("endRow", endRow-1);
		request.setAttribute("total", totalCount);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("IMAGES", imageList);
		request.setAttribute("currentPage", currentPage);
		RequestDispatcher rd = request.getRequestDispatcher(
			"template.jsp?BODY=imageList.jsp");
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







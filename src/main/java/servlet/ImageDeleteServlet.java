package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.ImageBBS;

/**
 * Servlet implementation class ImageDeleteServlet
 */
@WebServlet("/imageDelete.do")
public class ImageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDeleteServlet() {
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
		String w_id = request.getParameter("id");//글번호 수신
		Crud dao = new Crud();
		ImageBBS bbs = dao.getImageDetail(Integer.parseInt(w_id));//게시글 검색
		request.setAttribute("BBS", bbs);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=imageDeleteForm.jsp");
		rd.forward(request, response);
	}

}















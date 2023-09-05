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
 * Servlet implementation class ImageFormServlet
 */
@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageFormServlet() {
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
		String w_id=request.getParameter("id");
		String parentId=request.getParameter("parentid");
		String groupId=request.getParameter("groupid");
		String title = "";//답글의 제목을 위한 변수 선언
		Crud dao = new Crud();
		ImageBBS imageBBS = dao.getImageDetail(Integer.parseInt(w_id));
		imageBBS.setParent_id(Integer.parseInt(parentId));//부모글번호 설정
		title = "RE]"+imageBBS.getTitle();
		request.setAttribute("imageBBS", imageBBS);
		request.setAttribute("title", title);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=imageWriteForm.jsp");
		rd.forward(request, response);
	}

}









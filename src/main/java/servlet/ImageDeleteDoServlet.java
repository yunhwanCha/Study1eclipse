package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.ImageBBS;

/**
 * Servlet implementation class ImageDeleteDoServlet
 */
@WebServlet("/imageDeleteDo.do")
public class ImageDeleteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDeleteDoServlet() {
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
		String w_id = request.getParameter("id");
		String pwd = request.getParameter("password");
		Crud dao = new Crud();
		ImageBBS bbs = dao.getImageDetail(Integer.parseInt(w_id));
		String url="template.jsp?BODY=imageDeleteResult.jsp";
		if(bbs.getPassword().equals(pwd)) {//�Է��� ��ȣ�� ��ȸ�� ��ȣ�� ���� ���
			dao.deleteImageBBS(Integer.parseInt(w_id));
			response.sendRedirect(url);
		}else {//�ٸ� ���
			response.sendRedirect(url+"?id="+w_id);
		}
	}

}















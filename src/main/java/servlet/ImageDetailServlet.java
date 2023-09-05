package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.ImageBBS;

/**
 * Servlet implementation class ImageDetailServlet
 */
@WebServlet("/imageDetail.do")
public class ImageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String w_id = request.getParameter("W_ID");//�۹�ȣ ����
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("USER");
		Crud dao = new Crud();
		ImageBBS bbs = dao.getImageDetail(Integer.parseInt(w_id));
		request.setAttribute("BBS", bbs);
		if(writer == null) {//�α����� �� �� ���
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=imageDetail.jsp");
				rd.forward(request, response);
		}else if(writer.equals(bbs.getId())) {//�ۼ��ڿ� �α����� ������ ���� ���
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=imageDetailOwner.jsp");
			rd.forward(request, response);
		}else {//�ۼ��ڿ� �α����� ������ �ٸ� ���
			RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=imageDetailReply.jsp");
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

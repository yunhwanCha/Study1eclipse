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
import model.BBS;

/**
 * Servlet implementation class BBSReadServlet
 */
@WebServlet("/bbsRead.do")
public class BBSReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno = request.getParameter("SEQNO");
		Crud dao = new Crud();
		BBS bbs = dao.getBBS(Integer.parseInt(seqno));
		request.setAttribute("BBS", bbs);
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		if(id != null && bbs.getId().equals(id)) {//로그인한 계정과 작성자가 일치하는경우
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=bbsReadOwner.jsp");
			rd.forward(request, response);
		}else {//로그인을 안했거나 작성자가 아닌경우
			RequestDispatcher rd = request.getRequestDispatcher(
					"template.jsp?BODY=bbsRead.jsp");
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

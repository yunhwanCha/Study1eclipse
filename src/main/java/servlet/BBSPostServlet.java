package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.BBS;

/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/bbsPost.do")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String title = request.getParameter("TITLE");//글제목
		String content = request.getParameter("CONTENT");//글내용
		Crud dao = new Crud();
		BBS bbs = new BBS();//DTO생성
		bbs.setSeqno(dao.maxBBS() + 1);//글번호 설정
		bbs.setTitle(title);//제목설정
		bbs.setContent(content);//내용 설정
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		bbs.setId(id);//작성자 설정
		int re = dao.putBBS(bbs);
		String result = "";
		if(re > 0) result = "OK";
		else result = "NOK";
		response.sendRedirect("template.jsp?BODY=bbsInputResult.jsp?R="+result);
	}

}












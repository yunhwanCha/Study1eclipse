package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Crud;
import model.BBS;

/**
 * Servlet implementation class BBSModifyServlet
 */
@WebServlet("/bbsModify.do")
public class BBSModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSModifyServlet() {
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
		String btn = request.getParameter("BTN");//버튼 제목
		String seqno = request.getParameter("SEQNO");//글번호
		String title = request.getParameter("TITLE");//글제목
		String content = request.getParameter("CONTENT");//글내용
		Crud dao = new Crud();
		String result = "";
		if(btn.equals("수정")) {
			BBS bbs = new BBS();//DTO생성
			bbs.setSeqno(Integer.parseInt(seqno));//글번호 설정
			bbs.setTitle(title);//글제목 설정
			bbs.setContent(content);//글내용 설정
			int res = dao.updateBBS(bbs);
			if(res > 0) result = "OK";
			else result = "NOK";
		}else if(btn.equals("삭제")) {
			int res = dao.deleteBBS(Integer.parseInt(seqno));
			if(res > 0) result = "OK";
			else result = "NOK";
		}
		response.sendRedirect("template.jsp?BODY=bbsModifyResult.jsp?R="+result);
	}

}















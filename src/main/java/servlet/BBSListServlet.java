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
import model.BBS;
import model.FromTo;

/**
 * Servlet implementation class BBSListServlet
 */
@WebServlet("/bbsList.do")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Խñ� DB���̺��� �Խñ��� �˻��Ѵ�.
		Crud dao = new Crud();
		//��ü �Խñۿ� ���� ������ ������ ã�´�.
		int totalCount = dao.getBBSCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 != 0) pageCount++;
		//��ü �Խñ��� ���� / 5 -> ������ ��
		//��ü �Խñ� % 5, ���� �������� ������ ������ ���� ������ �� + 1
		int startrow = 0; int endrow = 0;
		String page_no = request.getParameter("PAGE_NO");
		int currentPage = 1;
		if(page_no != null) {
			currentPage = Integer.parseInt(page_no);
		}
		int from = (currentPage - 1) * 5;
		int to = ((currentPage - 1) * 5) + 6;
		FromTo ft = new FromTo();
		ft.setFrom(from); ft.setTo(to);
		ArrayList<BBS> bbsList = dao.getAllBBS(ft);
		if(totalCount > 0) {
			startrow = (currentPage - 1) * 5 + 1;
			endrow = currentPage * 5;
			if(endrow > totalCount) endrow = totalCount;
		}//�Խñ��� �����ϴ� ���
		request.setAttribute("BBSLIST", bbsList);
		request.setAttribute("STARTROW", startrow);
		request.setAttribute("ENDROW", endrow);
		request.setAttribute("TOTAL", totalCount);
		request.setAttribute("PAGES", pageCount);
		//������ ������ JSP(bbsList.jsp)�� �����Ѵ�.
		//�˻������ JSP(bbsList.jsp)�� �����Ѵ�.
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsList.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}

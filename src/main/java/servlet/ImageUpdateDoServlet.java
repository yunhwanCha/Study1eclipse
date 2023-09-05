package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Crud;
import model.ImageBBS;

/**
 * Servlet implementation class ImageUpdateDoServlet
 */
@WebServlet("/imageUpdateDo.do")
public class ImageUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUpdateDoServlet() {
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
		Crud dao = new Crud();
		String uploadPath = "/upload";//���ε� �� ������ ����� ���
		int maxLimit = 5 * 1024 * 1024;//���ε� �� ������ �ִ� ũ��(5 �ް��� ����)
		ServletContext ctx = this.getServletContext();//ServletContext ����
		String realPath = ctx.getRealPath(uploadPath);// upload������ ���� ��� ����
		String fileName = "";//���� ���ε尡 ������ ��� �����̸��� ����� ���� ����
		String result = "";//���� ���ε� ���� ������ ������ ���� ����
		try {
			MultipartRequest mr = new MultipartRequest(request,realPath,
					maxLimit,"euc-kr",new DefaultFileRenamePolicy());
			String w_id = mr.getParameter("id");//�۹�ȣ ����
			String pwd = mr.getParameter("pwd");//�Էµ� ��ȣ ����
			ImageBBS bbs = dao.getImageDetail(Integer.parseInt(w_id));
			if(bbs.getPassword().equals(pwd)) {//��ȣ�� ��ġ�ϴ� ���
				String title = mr.getParameter("title");//������ ����
				String content = mr.getParameter("content");
				fileName = mr.getFilesystemName("image_name");//���ε� ����
				
				bbs.setTitle(title);//�� ������ ����
				bbs.setContent(content);//�� ������ ����
				if(fileName != null) {//�� �̹��� ������ ������ ���
					bbs.setImage_name(fileName);//�� �̹��� �����̸��� ����
				}
				dao.updateImageBBS(bbs);//update ����
				result = "template.jsp?BODY=imageUpdateResult.jsp";
			}else {//��ȣ�� ��ġ���� �ʴ� ���
				result = "template.jsp?BODY=imageUpdateResult.jsp?id="+bbs.getW_id();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(result);
	}

}















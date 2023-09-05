package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Crud;
import model.ImageBBS;

/**
 * Servlet implementation class ImageWriteServlet
 */
@WebServlet("/imageWrite.do")
public class ImageWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageWriteServlet() {
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
		//MultipartRequest ��ü ������ ���Ǵ� ������ ����
		String uploadPath = "/upload";//���ε� �� ������ ����� ���
		int maxLimit = 5 * 1024 * 1024;//���ε� �� ������ �ִ� ũ��(5 �ް��� ����)
		ServletContext ctx = this.getServletContext();//ServletContext ����
		String realPath = ctx.getRealPath(uploadPath);// upload������ ���� ��� ����
		String fileName = "";//���� ���ε尡 ������ ��� �����̸��� ����� ���� ����
		String result = "";//���� ���ε� ���� ������ ������ ���� ����
		System.out.println("������ ����Ǵ� ��ġ:"+realPath);
		try {
			MultipartRequest mr = new MultipartRequest(request,realPath,
					maxLimit,"euc-kr",new DefaultFileRenamePolicy());
			fileName = mr.getFilesystemName("IMAGENAME");//���ε� �޼���
			if(fileName == null || fileName.equals("")) {//���ε� ����
				result = "NOK";
			}else {//���ε� ����
				result = "OK";
				//����� ���� �Ķ���͸� ���� ����
				String orderNo = mr.getParameter("orderno");
				String groupId = mr.getParameter("groupid");
				String parentId = mr.getParameter("parentid");
				//����� ���� �Ķ���͸� ���� ��
				HttpSession session = request.getSession();
				String title = mr.getParameter("TITLE");//������
				String id = (String)session.getAttribute("USER");//�ۼ���
				String pwd = mr.getParameter("PWD");//��ȣ
				String content = mr.getParameter("CONTENT");//�۳���
				ImageBBS ibbs = new ImageBBS();//DTO����
				ibbs.setTitle(title); ibbs.setPassword(pwd); ibbs.setId(id);
				ibbs.setContent(content); 
				String hangul = URLEncoder.encode(fileName,"euc-kr");
				ibbs.setImage_name(hangul);//DB�� �����̸� ����
				Crud dao = new Crud();
				int w_id = dao.getMaxImageBBS() + 1;
				ibbs.setW_id(w_id);//�۹�ȣ
				if(parentId == null || parentId.equals("")) {//������ ���
					ibbs.setGroup_id(w_id);//�׷��ȣ
					ibbs.setParent_id(0);//������ ��� �θ�� ��ȣ�� 0
					ibbs.setOrder_no(0);//������ ��� ������ȣ�� 0
				}else {//����� ���
					ibbs.setParent_id(Integer.parseInt(parentId));
					ibbs.setGroup_id(Integer.parseInt(groupId));
					ibbs.setOrder_no(Integer.parseInt(orderNo));
					//DB���� ������ȣ(order_no)�� �����Ѵ�.
					dao.updateOrderNo(ibbs);
				}
				result = dao.putImageBBS(ibbs);//DB�� ����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("template.jsp?BODY=uploadResult.jsp?R="+result);
	}

}















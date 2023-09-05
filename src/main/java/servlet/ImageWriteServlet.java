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
		//MultipartRequest 객체 생성에 사용되는 데이터 선언
		String uploadPath = "/upload";//업로드 된 파일이 저장될 경로
		int maxLimit = 5 * 1024 * 1024;//업로드 될 파일의 최대 크기(5 메가로 선언)
		ServletContext ctx = this.getServletContext();//ServletContext 생성
		String realPath = ctx.getRealPath(uploadPath);// upload폴더의 절대 경로 추출
		String fileName = "";//파일 업로드가 성공한 경우 파일이름이 저장될 변수 선언
		String result = "";//파일 업로드 성공 유무를 저장할 변수 선언
		System.out.println("파일이 저장되는 위치:"+realPath);
		try {
			MultipartRequest mr = new MultipartRequest(request,realPath,
					maxLimit,"euc-kr",new DefaultFileRenamePolicy());
			fileName = mr.getFilesystemName("IMAGENAME");//업로드 메서드
			if(fileName == null || fileName.equals("")) {//업로드 실패
				result = "NOK";
			}else {//업로드 성공
				result = "OK";
				//답글을 위한 파라미터를 수신 시작
				String orderNo = mr.getParameter("orderno");
				String groupId = mr.getParameter("groupid");
				String parentId = mr.getParameter("parentid");
				//답글을 위한 파라미터를 수신 끝
				HttpSession session = request.getSession();
				String title = mr.getParameter("TITLE");//글제목
				String id = (String)session.getAttribute("USER");//작성자
				String pwd = mr.getParameter("PWD");//암호
				String content = mr.getParameter("CONTENT");//글내용
				ImageBBS ibbs = new ImageBBS();//DTO생성
				ibbs.setTitle(title); ibbs.setPassword(pwd); ibbs.setId(id);
				ibbs.setContent(content); 
				String hangul = URLEncoder.encode(fileName,"euc-kr");
				ibbs.setImage_name(hangul);//DB에 파일이름 설정
				Crud dao = new Crud();
				int w_id = dao.getMaxImageBBS() + 1;
				ibbs.setW_id(w_id);//글번호
				if(parentId == null || parentId.equals("")) {//원글인 경우
					ibbs.setGroup_id(w_id);//그룹번호
					ibbs.setParent_id(0);//원글인 경우 부모글 번호는 0
					ibbs.setOrder_no(0);//원글인 경우 순서번호는 0
				}else {//답글인 경우
					ibbs.setParent_id(Integer.parseInt(parentId));
					ibbs.setGroup_id(Integer.parseInt(groupId));
					ibbs.setOrder_no(Integer.parseInt(orderNo));
					//DB에서 순서번호(order_no)를 변경한다.
					dao.updateOrderNo(ibbs);
				}
				result = dao.putImageBBS(ibbs);//DB에 삽입
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("template.jsp?BODY=uploadResult.jsp?R="+result);
	}

}















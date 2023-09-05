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
		String uploadPath = "/upload";//업로드 된 파일이 저장될 경로
		int maxLimit = 5 * 1024 * 1024;//업로드 될 파일의 최대 크기(5 메가로 선언)
		ServletContext ctx = this.getServletContext();//ServletContext 생성
		String realPath = ctx.getRealPath(uploadPath);// upload폴더의 절대 경로 추출
		String fileName = "";//파일 업로드가 성공한 경우 파일이름이 저장될 변수 선언
		String result = "";//파일 업로드 성공 유무를 저장할 변수 선언
		try {
			MultipartRequest mr = new MultipartRequest(request,realPath,
					maxLimit,"euc-kr",new DefaultFileRenamePolicy());
			String w_id = mr.getParameter("id");//글번호 수신
			String pwd = mr.getParameter("pwd");//입력된 암호 수신
			ImageBBS bbs = dao.getImageDetail(Integer.parseInt(w_id));
			if(bbs.getPassword().equals(pwd)) {//암호가 일치하는 경우
				String title = mr.getParameter("title");//제목을 수신
				String content = mr.getParameter("content");
				fileName = mr.getFilesystemName("image_name");//업로드 실행
				
				bbs.setTitle(title);//새 제목을 설정
				bbs.setContent(content);//새 내용을 설정
				if(fileName != null) {//새 이미지 파일을 선택한 경우
					bbs.setImage_name(fileName);//새 이미지 파일이름을 설정
				}
				dao.updateImageBBS(bbs);//update 실행
				result = "template.jsp?BODY=imageUpdateResult.jsp";
			}else {//암호가 일치하지 않는 경우
				result = "template.jsp?BODY=imageUpdateResult.jsp?id="+bbs.getW_id();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(result);
	}

}















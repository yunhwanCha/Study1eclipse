package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Crud;
import model.CartItem;
import service.Cart;

//class LoginChecker {
//	String putMessage(String id, String password, HttpServletRequest  request){
////		DBExpert_ dbe = new DBExpert_();
//		String pwd = dbe.getPassword(id);
//		String result = "";
//		if(pwd != null) {//��ȣ�� �˻��� �� ���
//			if(password.equals(pwd)) {//�Է��� ��ȣ�� �˻��� ��ȣ�� ���� ���
//				result = "OK";
//				HttpSession session = request.getSession();
//				if(id.equals("manager")) {
//					session.setAttribute("ADMIN", id);
//				}else {
//					session.setAttribute("USER", id);
//				}
//				//�α����� �������� ��ٱ��� ������ DB���� �˻��Ѵ�.
//				//��ٱ��� ������ �˻��� ���, �˻������� Cart�� �����Ѵ�.
//				//�α��� ������ ��ٱ��� DB �˻� ����
////				ArrayList<CartItem> cartList = dbe.getCart(id);
////				if(cartList.size() > 0) {//�˻��� �� ���� �����ϴ� ���
////					Cart cart = new Cart(id);//��ٱ���(Cart)�� ����
////					for(int i=0; i < cartList.size(); i++) {
////						CartItem ci = cartList.get(i);//N��° CartItem�� ������
////						cart.getCodeList().add(ci.getCode());
////						cart.getNumList().add(ci.getNum());
////					}
////					session.setAttribute("CART", cart);//���ǿ� ��ٱ��ϸ� ����
////				}
//				//�α��� ������ ��ٱ��� DB �˻� ��
//			}else {//��ȣ�� ��ġ���� �ʴ� ���
//				result = "NOK";
//			}
//		}else {//��ȣ�� �˻��� �ȵ� ���
//			result = "NOK";
//		}
//		return result;
//	}
//}

@WebServlet("/loginDo.do")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		Crud dao = new Crud();
		String pwdInDB = dao.getPwd(id);//�������� ��ȣ�� �˻�
		String result = "";
		if(pwdInDB == null) {//������ �������� �ʴ� ���
			result = "NOK";
		}else {//������ �����ϴ� ���
			if(pwd.equals(pwdInDB)) {//��ȣ�� ��ġ�ϴ� ���
				result = "OK";
				HttpSession session = request.getSession();
				if(id.equals("manager")) {
					session.setAttribute("ADMIN", id);
				}else {
					session.setAttribute("USER", id);
				}
				//�α��� ������ ��ٱ��� DB �˻� ����
				ArrayList<CartItem> cartList = dao.getCart(id);
				if(cartList.size() > 0) {//�˻��� �� ���� �����ϴ� ���
					Cart cart = new Cart(id);//��ٱ���(Cart)�� ����
					for(int i=0; i < cartList.size(); i++) {
						CartItem ci = cartList.get(i);//N��° CartItem�� ������
						cart.getCodeList().add(ci.getCode());
						cart.getNumList().add(ci.getNum());
					}
					session.setAttribute("CART", cart);//���ǿ� ��ٱ��ϸ� ����
				}
				//�α��� ������ ��ٱ��� DB �˻� ��
			}else {//��ȣ�� ��ġ���� �ʴ� ���
				result = "NOK";
			}
		}
		//�������� loginResult.jsp�� �ٲ۴�.Redirect
		response.sendRedirect(
			"template.jsp?BODY=loginResult.jsp?R="+result);
	}
}













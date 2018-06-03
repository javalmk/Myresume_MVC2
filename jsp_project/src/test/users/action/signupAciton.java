package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class signupAciton extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String id =request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String is_admin = request.getParameter("is_admin");
		String phone_no = request.getParameter("phone_no");
		
		TB_USERDto dto = new TB_USERDto(id, password, email, phone_no, is_admin, null, name);
		
		TB_USERDao.getInstance().insert(dto);
		
	
		
		request.setAttribute("id", id);
		
		ActionForward af =new ActionForward("/users/login.do");
		af.setRedirect(true);
		return af;
	}
}

package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;

public class LoginFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward af = null;
		if(url==null) {
			url=request.getContextPath()+"/home.do";
		}
		
		if(id != null) {
			url = request.getContextPath() + "/users/list.do";
			af = new ActionForward(url, true);
		}
		else {
			af = new ActionForward("/views/users/loginform.jsp");
		}
		
		return af;
		
	}

}

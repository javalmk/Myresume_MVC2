
package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class LoginAction extends Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
	
		
	
		TB_USERDto dto =new TB_USERDto();
		dto.setId(id);
		dto.setPassword(password);
		
		boolean isValid=TB_USERDao.getInstance().isValid(dto);
		
		if(isValid) {
			//로그인 성공
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			TB_USERDto myDto=TB_USERDao.getInstance().getData(id);
			session.setAttribute("myDto", myDto);
			url = request.getContextPath() + "/users/list.do";
		}
		else {
			url = request.getContextPath() + "/users/loginform.do";
			request.setAttribute("url", url);
			request.setAttribute("loginFail", "아이디 혹은 비밀번호를 확인해주세요.");
			return new ActionForward(url);
		}
		
		
		return new ActionForward(url, true);
	}

}

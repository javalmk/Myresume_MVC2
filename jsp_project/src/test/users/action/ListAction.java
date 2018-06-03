package test.users.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class ListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		//session id
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		//getdata(id) > dto
		TB_USERDto myDto = TB_USERDao.getInstance().getData(id);
		
		System.out.println("^^^^^^^^^^^");
		System.out.println(id);
		
		//is_admin : y > 전체출력
		//is_admin : n > 부분출력1
		List<TB_USERDto> list =TB_USERDao.getInstance().getList(myDto);
		
		session.setAttribute("myDto", myDto);
		System.out.println("****checksadlkasl********");
		System.out.println(list);
		request.setAttribute("list", list);
		
		
		
		return new ActionForward("/views/users/list.jsp");
	}

}

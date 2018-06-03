package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.IntsDao;
import test.profile.dto.IntsDto;

public class IntsDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String id= request.getParameter("id");
		IntsDao.getInstance().delete(new IntsDto(id, null, null, num));

		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

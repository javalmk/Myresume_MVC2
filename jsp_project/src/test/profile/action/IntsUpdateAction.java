package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.IntsDao;
import test.profile.dto.IntsDto;

public class IntsUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String ints_nm=request.getParameter("ints_nm");
		String ints_exp=request.getParameter("ints_exp");
		int num = Integer.parseInt(request.getParameter("num"));
		IntsDto dto = new IntsDto(id, ints_nm, ints_exp, num);
		IntsDao.getInstance().update(dto);

		
		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}
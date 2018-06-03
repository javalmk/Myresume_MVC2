package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.IntsDao;
import test.profile.dto.IntsDto;

public class IntsInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("id");
		String ints_nm=request.getParameter("ints_nm");
		String ints_exp=request.getParameter("ints_exp");
		IntsDto dto = new IntsDto(id, ints_nm, ints_exp, 0);
		IntsDao.getInstance().insert(dto);

		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

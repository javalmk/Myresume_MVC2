package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.EduDao;
import test.profile.dto.EduDto;

public class EduDeleteAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		
		EduDto dto = new EduDto();
		dto.setNum(num);
		dto.setId(id);
		
		EduDao.getInstance().delete(dto);
		
		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

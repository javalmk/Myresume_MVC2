package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.SkillsDao;
import test.profile.dto.SkillsDto;

public class SkillsDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		SkillsDao.getInstance().delete(new SkillsDto(id, null, null, num));
		ActionForward af=new ActionForward("/profile/detail.do?id="+id);
		af.setRedirect(true);
		return af;

	}

}

package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.SkillsDao;
import test.profile.dto.SkillsDto;

public class SkillsUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String skill_nm=request.getParameter("skill_nm");
		String skill_exp=request.getParameter("skill_exp");
		int num=Integer.parseInt(request.getParameter("num"));
		SkillsDto dto = new SkillsDto(id, skill_nm, skill_exp, num);
		SkillsDao.getInstance().update(dto);
		
		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

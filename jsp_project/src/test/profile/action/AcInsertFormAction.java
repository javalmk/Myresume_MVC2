package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dao.EduDao;
import test.profile.dao.ExpsDao;
import test.profile.dao.IntsDao;
import test.profile.dao.SkillsDao;
import test.profile.dto.AcDto;
import test.profile.dto.EduDto;
import test.profile.dto.ExpsDto;
import test.profile.dto.IntsDto;
import test.profile.dto.SkillsDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class AcInsertFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	
		String id = request.getParameter("id");
		System.out.println(id);
		TB_USERDto dto =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		
		return new ActionForward("/views/profile/acInsertForm.jsp");
	}
}

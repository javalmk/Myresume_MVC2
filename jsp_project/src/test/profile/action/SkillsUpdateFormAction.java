package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.SkillsDao;
import test.profile.dto.SkillsDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class SkillsUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		String id=request.getParameter("id");
		SkillsDto dto=SkillsDao.getInstance().getData(new SkillsDto(id, null, null, num));
		request.setAttribute("dto", dto);

		TB_USERDto dto2 =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto2);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		
		return new ActionForward("/views/profile/skillsUpdateForm.jsp");
	}

}

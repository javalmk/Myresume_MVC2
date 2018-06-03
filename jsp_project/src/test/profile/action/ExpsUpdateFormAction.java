package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.ExpsDao;
import test.profile.dto.ExpsDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class ExpsUpdateFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		
		ExpsDto dto = new ExpsDto();
		dto.setNum(num);
		dto.setId(id);
		
		ExpsDto resultDto = ExpsDao.getInstance().getData(dto);
		request.setAttribute("dto", resultDto);

		TB_USERDto dto2 =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto2);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		
		
		return new ActionForward("/views/profile/expsUpdateForm.jsp");
	}

}

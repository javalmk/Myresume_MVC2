package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dao.EduDao;
import test.profile.dto.AcDto;
import test.profile.dto.EduDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class EduUpdateFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		System.out.println("=================");
		System.out.println(id);
		System.out.println(num);
		
		EduDto dto = new EduDto();
		dto.setNum(num);
		dto.setId(id);
		EduDto resultDto = EduDao.getInstance().getData(dto);
		request.setAttribute("dto", resultDto);

		TB_USERDto dto2 =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto2);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		

		return new ActionForward("/views/profile/eduUpdateForm.jsp");
	}

}

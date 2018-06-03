package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dto.AcDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class AcUpdateFormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		System.out.println("=================AcUpdateFormAction");
		System.out.println(id);
		System.out.println(num);
	
		
		AcDto dto = new AcDto();
		dto.setId(id);
		dto.setNum(num);
		AcDto resultDto = AcDao.getInstance().getData(dto);
		request.setAttribute("dto", resultDto);
		
	
		TB_USERDto dto2 =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto2);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		
	
		return new ActionForward("/views/profile/acUpdateForm.jsp");
	}

}

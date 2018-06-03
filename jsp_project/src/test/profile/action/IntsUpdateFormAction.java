package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.IntsDao;
import test.profile.dto.IntsDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class IntsUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num=Integer.parseInt(request.getParameter("num"));
		String id=request.getParameter("id");
		IntsDto dto =IntsDao.getInstance().getData(new IntsDto(id, null, null, num));
		request.setAttribute("dto", dto);

		TB_USERDto dto2 =new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto2);
		request.setAttribute("userList", userList);
	
		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		request.setAttribute("id", id);
		request.setAttribute("userDto", userDto);
		
		
		return new ActionForward("/views/profile/intsUpdateForm.jsp");
	}

}

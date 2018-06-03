package test.home.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class HomeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// home.jsp 페이지로 forward 이동해서 응답할수 있도록 모든 회원의 정보 리스트
		TB_USERDto dto = new TB_USERDto();
		List<TB_USERDto> userList=TB_USERDao.getInstance().getList(dto);
		request.setAttribute("userList", userList);
		
		ActionForward af=new ActionForward("/views/home.jsp");
		return af;
	}
}












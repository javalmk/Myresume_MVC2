package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.ExpsDao;
import test.profile.dto.ExpsDto;

public class ExpsDeleteAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		System.out.println("=================");
		System.out.println(id);
		System.out.println(num);
		
		ExpsDto dto = new ExpsDto();
		dto.setNum(num);
		dto.setId(id);
		
		System.out.println("=================");
		System.out.println(dto);
		
		ExpsDao.getInstance().delete(dto);
		ActionForward af=new ActionForward("/profile/detail.do?id="+id);
		af.setRedirect(true);
		return af;
	}

}

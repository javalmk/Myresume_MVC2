package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.ExpsDao;
import test.profile.dto.ExpsDto;

public class ExpsUpdateAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String position = request.getParameter("position");
		String place = request.getParameter("place");
		String ex_exp = request.getParameter("ex_exp");
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		
		ExpsDto dto = new ExpsDto();
		dto.setNum(num);
		dto.setId(id);
		dto.setPosition(position);
		dto.setPlace(place);
		dto.setEx_exp(ex_exp);
		dto.setStart_date(start_date);
		dto.setEnd_date(end_date);
		
		ExpsDao.getInstance().update(dto);

		
		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}
package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.EduDao;
import test.profile.dto.EduDto;

public class EduUpdateAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String place = request.getParameter("place");
		String major = request.getParameter("major");
		String edu_exp = request.getParameter("edu_exp");
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
	
		EduDto dto = new EduDto();
		dto.setNum(num);
		dto.setId(id);
		dto.setPlace(place);
		dto.setMajor(major);
		dto.setEdu_exp(edu_exp);
		dto.setStart_date(start_date);
		dto.setEnd_date(end_date);
		
		EduDao.getInstance().update(dto);
		
		
		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dto.AcDto;

public class AcUpdateAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String ac_nm = request.getParameter("ac_nm");
		String ac_exp = request.getParameter("ac_exp");
		String ac_date = request.getParameter("ac_date");
		
		
		
		System.out.println("============AcUpdateAction");
		System.out.println(num + id + ac_nm + ac_exp + ac_date);
		
		AcDto dto = new AcDto();
		dto.setNum(num);
		dto.setId(id);
		dto.setAc_nm(ac_nm);
		dto.setAc_exp(ac_exp);
		dto.setAc_date(ac_date);	
		
		AcDao.getInstance().update(dto);

		return new ActionForward("/profile/detail.do?id=" + id, true);
	}

}

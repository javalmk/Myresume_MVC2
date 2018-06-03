package test.profile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dao.IntsDao;
import test.profile.dto.AcDto;
import test.profile.dto.IntsDto;

public class AcInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("id");
		String ac_nm=request.getParameter("ac_nm");
		String ac_exp=request.getParameter("ac_exp");
		String ac_date=request.getParameter("ac_date");
		
		AcDto dto = new AcDto();
		dto.setNum(0);
		dto.setId(id);
		dto.setAc_nm(ac_nm);
		dto.setAc_exp(ac_exp);
		dto.setAc_date(ac_date);
		
		AcDao.getInstance().insert(dto);
		ActionForward af=new ActionForward("/profile/detail.do?id="+id);
		af.setRedirect(true);
		return af;
	}

}

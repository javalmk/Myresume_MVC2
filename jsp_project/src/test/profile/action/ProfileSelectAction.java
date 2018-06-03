package test.profile.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.profile.dao.AcDao;
import test.profile.dao.EduDao;
import test.profile.dao.ExpsDao;
import test.profile.dao.IntsDao;
import test.profile.dao.SkillsDao;
import test.profile.dto.AcDto;
import test.profile.dto.EduDto;
import test.profile.dto.ExpsDto;
import test.profile.dto.IntsDto;
import test.profile.dto.SkillsDto;
import test.users.dao.TB_USERDao;
import test.users.dto.TB_USERDto;

public class ProfileSelectAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디값을 받아온다.
		String id = request.getParameter("id");
		System.out.println(id);

		TB_USERDto userDto=TB_USERDao.getInstance().getData(id);
		
		
		// id에 해당하는 테이블의 목록을 얻어온다.
		List<AcDto> acList = AcDao.getInstance().getList(id);
		List<ExpsDto> expsList = ExpsDao.getInstance().getList(id);
		List<EduDto> eduList = EduDao.getInstance().getList(id);
		List<IntsDto> intsList = IntsDao.getInstance().getList(id);
		List<SkillsDto> skillsList = SkillsDao.getInstance().getList(id);
		
		// request에 담는다
		request.setAttribute("id", id);
		request.setAttribute("acList", acList);
		request.setAttribute("expsList", expsList);
		request.setAttribute("eduList", eduList);
		request.setAttribute("intsList", intsList);
		request.setAttribute("skillsList", skillsList);
		request.setAttribute("userDto", userDto);
		
		// profile page로 ActionForward이동한다.
		return new ActionForward("/views/profile.jsp");
	}

}

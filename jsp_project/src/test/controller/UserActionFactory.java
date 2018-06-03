package test.controller;



import test.file.action.FileInsertAction;
import test.file.action.FileInsertFormAction;
import test.home.action.HomeAction;
import test.profile.action.AcDeleteAction;
import test.profile.action.AcInsertAction;
import test.profile.action.AcInsertFormAction;
import test.profile.action.AcUpdateAction;
import test.profile.action.AcUpdateFormAction;
import test.profile.action.DetailAction;
import test.profile.action.EduDeleteAction;
import test.profile.action.EduInsertAction;
import test.profile.action.EduInsertFormAction;
import test.profile.action.EduUpdateAction;
import test.profile.action.EduUpdateFormAction;
import test.profile.action.ExpsDeleteAction;
import test.profile.action.ExpsInsertAction;
import test.profile.action.ExpsInsertFormAction;
import test.profile.action.ExpsUpdateAction;
import test.profile.action.ExpsUpdateFormAction;
import test.profile.action.IntsDeleteAction;
import test.profile.action.IntsInsertAction;
import test.profile.action.IntsInsertFormAction;
import test.profile.action.IntsUpdateAction;
import test.profile.action.IntsUpdateFormAction;
import test.profile.action.ProfileSelectAction;
import test.profile.action.SkillsDeleteAction;
import test.profile.action.SkillsInsertAction;
import test.profile.action.SkillsInsertFormAction;
import test.profile.action.SkillsUpdateAction;
import test.profile.action.SkillsUpdateFormAction;

import test.users.action.ListAction;
import test.users.action.LoginAction;
import test.users.action.LoginFormAction;
import test.users.action.LogoutAction;
import test.users.action.signupAciton;
import test.users.action.signup_formAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	// 요청처리를 할 Action 객체를 리턴해주는 메소드
	public Action action(String command) {
		Action action=null;
		if(command.equals("/home")) {
			action=new HomeAction();
		} else if(command.equals("/users/signup_form")) {
			action=new signup_formAction();
		} else if(command.equals("/users/signup")) {
			action=new signupAciton();
		} else if(command.equals("/users/list")) {
			action=new ListAction();
		} else if(command.equals("/users/loginform")) {
			action=new LoginFormAction();
		} else if(command.equals("/users/login")) {
			action=new LoginAction();
			
		} else if(command.equals("/profile/acInsertForm")) {
			action = new AcInsertFormAction();
		} else if(command.equals("/profile/acInsert")) {
			action = new AcInsertAction();
		} else if(command.equals("/profile/acUpdateForm")) {
			action = new AcUpdateFormAction();
		} else if(command.equals("/profile/acUpdate")) {
			action = new AcUpdateAction();
		} else if(command.equals("/profile/acDelete")) {
			action = new AcDeleteAction();
			
		} else if(command.equals("/profile/expsInsertForm")) {
			action = new ExpsInsertFormAction();
		} else if(command.equals("/profile/expsInsert")) {
			action = new ExpsInsertAction();
		} else if(command.equals("/profile/expsUpdateForm")) {
			action = new ExpsUpdateFormAction();
		} else if(command.equals("/profile/expsUpdate")) {
			action = new ExpsUpdateAction();
		} else if(command.equals("/profile/expsDelete")) {
			action = new ExpsDeleteAction();
			
		} else if(command.equals("/profile/eduInsertForm")) {
			action = new EduInsertFormAction();
		} else if(command.equals("/profile/eduInsert")) {
			action = new EduInsertAction();
		} else if(command.equals("/profile/eduUpdateForm")) {
			action = new EduUpdateFormAction();
		} else if(command.equals("/profile/eduUpdate")) {
			action = new EduUpdateAction();
		} else if(command.equals("/profile/eduDelete")) {
			action = new EduDeleteAction();
			
		}else if(command.equals("/profile/intsInsertForm")){
			action=new IntsInsertFormAction();
		}else if(command.equals("/profile/intsUpdateForm")){
			action=new IntsUpdateFormAction();
		}else if(command.equals("/profile/intsUpdate")){
			action=new IntsUpdateAction();
		}else if(command.equals("/profile/intsInsert")){
			action=new IntsInsertAction();
		}else if(command.equals("/profile/intsDelete")){
			action=new IntsDeleteAction();
			
		}else if(command.equals("/profile/skillsInsertForm")){
			action=new SkillsInsertFormAction();
		}else if(command.equals("/profile/skillsInsert")){
			action=new SkillsInsertAction();
		}else if(command.equals("/profile/skillsUpdateForm")){
			action=new SkillsUpdateFormAction();
		}else if(command.equals("/profile/skillsUpdate")){
			action=new SkillsUpdateAction();
		}else if(command.equals("/profile/skillsDelete")){
			action=new SkillsDeleteAction();
			
		}else if(command.equals("/profile/fileInsertForm")) {
			action=new FileInsertFormAction();
		}else if(command.equals("/profile/fileInsert")) {
			action=new FileInsertAction();
		}
		
		else if(command.equals("/profile/detail")) {
			action= new DetailAction();
		}else if(command.equals("/users/logout")) {
			action= new LogoutAction();
		}
		
		else if(command.equals("/select")) {
			action = new ProfileSelectAction();
		}
		System.out.println("**************");
		System.out.println(command);
		return action;
	
	}
	
}













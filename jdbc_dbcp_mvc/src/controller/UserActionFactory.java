package controller;

import action.Action;
import action.UserDeleteAction;
import action.UserInsertAction;
import action.UserListAction;
import action.UserModifyAction;
import action.UserSelectAction;
import action.UserUpdateAction;

public class UserActionFactory {
	
	private static UserActionFactory factory;
	private UserActionFactory() {}
	public static UserActionFactory getInstance() {
		if(factory==null) {
			factory = new UserActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/insert.do")) {
			action = new UserInsertAction("list.do"); //성공시 이동페이지,이녀석이 할거다. 객체생성
		}else if(cmd.equals("/list.do")) { //조회
			action = new UserListAction("list.jsp");
		}else if(cmd.equals("/select.do")) { //선택
			action = new UserSelectAction("select.jsp");
		}else if(cmd.equals("/update.do")) { //추가
			action = new UserUpdateAction("update.jsp");
		}else if(cmd.equals("/modify.do")) { //수정
			action = new UserModifyAction("list.do"); //업데이트 성공시 -> list.do
		}else if(cmd.equals("/delete.do")) { //삭제
			action = new UserDeleteAction("list.do");
		}
		
		
		return action;
	}
}


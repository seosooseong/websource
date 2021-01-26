package controller;

import action.Action;
import action.DeleteAction;
import action.InsertAction;

public class ActionFactory { //액션
	
	
	//싱글톤 패턴 - 객체를 하나만 만들어서 쓰기
	private static ActionFactory factory;
	
	private ActionFactory() {} //외부에서 생성자를 못만들게 제한
		
	public static ActionFactory getInstance() {
		if(factory==null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAction("index.jsp");
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/select.do")) {
			
		}
		return action;
	}
}

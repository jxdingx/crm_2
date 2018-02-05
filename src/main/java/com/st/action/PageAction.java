package com.st.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.st.entity.UserEntity;

@Controller
@Scope("prototype")
public class PageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toPage() { // 方法名必须和 语句1 的跳转的action名称相同
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String login() { // 方法名必须和 语句1 的跳转的action名称相同
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return ERROR;
		}
		return SUCCESS;
	}

}

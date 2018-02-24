package com.st.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.HtmlUtil;
import com.st.entity.UserEntity;
import com.st.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction { // 语句2
	private static final long serialVersionUID = 1L;

	@Autowired(required = true)
	private UserService userService;
	private Integer id;
	private String userName;
	private String password;
	private String trueName;
	private String email;
	private String phone;

	private String code;
	private String result;

	private String newpassword;

	public String login() { // 方法名必须和 语句1 的跳转的action名称相同
		HttpSession session = ServletActionContext.getRequest().getSession();
		String rightcode = (String) session.getAttribute("imgCode");
		if (!rightcode.equalsIgnoreCase(code)) {
			result = "验证码输入错误";
			return INPUT;
		}
		UserEntity user = new UserEntity();
		user.setUserName(userName);
		user.setPassword(password);
		List<UserEntity> userList = userService.find(user);
		if (userList.size() == 1) {
			session.setAttribute("user", userList.get(0));
			result = "ok";
		} else {
			result = "该用户不存在";
		}
		return INPUT;
	}

	public void findAllUser() {
		String hql;
		if (userName == null || "".equals(userName)) {
			hql = " from UserEntity ";
		} else {
			hql = " from UserEntity  where userName " + " like '%" + userName + "%' ";
		}
		List<UserEntity> userList = userService.findAll(hql);
		HtmlUtil.writerJson(getResponse(), userList);
	}

	public String updateUser() {
		UserEntity user = new UserEntity(id, userName, password, trueName, email, phone);
		userService.update(user);
		result = "ok";
		return INPUT;
	}

	public void getManagerUser() {
		String hql = " from UserEntity where roleName='客户经理' ";
		List<UserEntity> userList = userService.findAll(hql);
		HtmlUtil.writerJson(getResponse(), userList);
	}

	public String updatepasswordUser() {
		String hql = " from UserEntity where id=" + id + " and password=" + password;
		List<UserEntity> userList = userService.findAll(hql);
		if (userList.size() != 1) {
			result = "err";
		} else {
			UserEntity user = userService.get(id);
			user.setPassword(newpassword);
			userService.update(user);
			result = "ok";
		}
		return INPUT;
	}

	public String exitUser() {
		getRequest().getSession().removeAttribute("user");
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}
package com.st.action;

import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.st.utils.ImgCodeUtil;

/**
 * 图片验证码action.
 * 
 * @author mashiji
 * 
 */
@Controller
public class ImgCodeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private ByteArrayInputStream inputStream;

	public String execute() throws Exception {
		ImgCodeUtil rdnu = ImgCodeUtil.Instance();
		this.setInputStream(rdnu.getImage()); // 取得带有随机字符串的图片
		HttpSession session = ServletActionContext.getRequest().getSession();
		/*
		 * ActionContext.getContext().getSession() .put("imgCode", rdnu.getString());
		 */
		// 取得随机字符串放入HttpSession
		session.setAttribute("imgCode", rdnu.getString());
		// 设置当前session的有效时间为10*60秒
		session.setMaxInactiveInterval(600);
		return SUCCESS;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

}

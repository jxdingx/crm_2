package com.st.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.CusLinkManEntity;
import com.st.service.CusLinkManService;

@Controller
@Scope("prototype")
public class CusLinkManAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusLinkManService cusLinkManService;

	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String linkName; // 姓名
	private String sex; // 性别
	private String zhiwei; // 职位
	private String officePhone; // 办公电话
	private String phone; // 手机

	private String result;

	public void findcusLinkMan() {
		CusLinkManEntity cEntity = new CusLinkManEntity();
		cEntity.setCusId(cusId);
		List<CusLinkManEntity> cEntityList = cusLinkManService.find(cEntity);
		HtmlUtil.writerJson(getResponse(), cEntityList);
	}

	public String updatecusLinkMan() {
		CusLinkManEntity cEntity = new CusLinkManEntity(id, cusId, linkName, sex, zhiwei, officePhone, officePhone);
		if (FormatEmpty.isEmpty(id)) {
			cusLinkManService.save(cEntity);
			result = "insert";
		} else {
			cusLinkManService.update(cEntity);
			result = "update";
		}
		return INPUT;
	}

	public String deletecusLinkMan() {
		CusLinkManEntity cEntity = new CusLinkManEntity();
		cEntity.setId(id);
		cusLinkManService.delete(cEntity);
		result = "delete";
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

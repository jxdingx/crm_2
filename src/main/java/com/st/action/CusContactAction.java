package com.st.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.CusContactEntity;
import com.st.service.CusContactService;

@Controller
@Scope("prototype")
public class CusContactAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusContactService cusContactService;

	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String contactTime; // 交往时间
	private String address; // 交往地点
	private String overView; // 概要

	private String result;

	public void findcusContact() {
		CusContactEntity cEntity = new CusContactEntity();
		cEntity.setCusId(cusId);
		List<CusContactEntity> cEntityList = cusContactService.find(cEntity);
		HtmlUtil.writerJson(getResponse(), cEntityList);
	}

	public String updatecusContact() {
		CusContactEntity cEntity = new CusContactEntity(id, cusId, contactTime, address, overView);
		if (FormatEmpty.isEmpty(id)) {
			cusContactService.save(cEntity);
			result = "insert";
		} else {
			cusContactService.update(cEntity);
			result = "update";
		}
		return INPUT;
	}

	public String deletecusContact() {
		CusContactEntity cEntity = new CusContactEntity();
		cEntity.setId(id);
		cusContactService.delete(cEntity);
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

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

package com.st.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.HtmlUtil;
import com.st.entity.CusDevPlanEntity;
import com.st.service.CusDevPlanService;

@Controller
@Scope("prototype")
public class CusDevPlanAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusDevPlanService cusDevPlanService;

	private Integer id; // 编号
	private Integer saleChanceId; // 销售机会id
	private String planItem; // 计划项
	private String planDate; // 计划日期
	private String exeAffect; // 执行效果

	private String customerName; // 客户名称
	private String overView; // 概要
	private String createMan; // 创建人

	private String result;

	public void findallcusDevPlan() {
		CusDevPlanEntity cEntity = new CusDevPlanEntity();
		cEntity.setSaleChanceId(saleChanceId);
		List<CusDevPlanEntity> cEntityList = cusDevPlanService.find(cEntity);
		HtmlUtil.writerJson(getResponse(), cEntityList);
	}

	public String updatecusDevPlan() {
		CusDevPlanEntity cEntity = new CusDevPlanEntity(saleChanceId, planItem, planDate, exeAffect);
		cusDevPlanService.save(cEntity);
		result = "insert";
		return INPUT;
	}

	public String deletecusDevPlan() {
		CusDevPlanEntity cEntity = new CusDevPlanEntity();
		cEntity.setId(id);
		cusDevPlanService.delete(cEntity);
		result = "delete";
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSaleChanceId() {
		return saleChanceId;
	}

	public void setSaleChanceId(Integer saleChanceId) {
		this.saleChanceId = saleChanceId;
	}

	public String getPlanItem() {
		return planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getExeAffect() {
		return exeAffect;
	}

	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

}

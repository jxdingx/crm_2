package com.st.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.SaleChanceEntity;
import com.st.service.SaleChanceService;

@Controller
@Scope("prototype")
public class SaleChanceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SaleChanceService saleChanceService;

	private Integer id; // 编号
	private String chanceSource; // 机会来源
	private String customerName; // 客户名称
	private Integer cgjl; // 成功几率
	private String overView; // 概要
	private String linkMan; // 联系人
	private String linkPhone; // 联系电话
	private String description; // 机会描述
	private String createMan; // 创建人
	private String createTime; // 创建时间
	private String assignMan; // 指派人
	private String assignTime; // 指派时间
	private Integer state; // 分配状态 0 未分配 1 已分配
	private Integer devResult; // 客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败

	private Integer page = 1;
	private Integer rows = 15;
	private String result;

	public void findallsaleChance() {

		String hql = "  from SaleChanceEntity  where  1=1 ";
		StringBuffer str = new StringBuffer(hql);
		if (!FormatEmpty.isEmpty(customerName)) {
			str.append(" and customerName " + " like '%" + customerName + "%' ");
		}
		if (!FormatEmpty.isEmpty(overView)) {
			str.append(" and overView " + " like '%" + overView + "%' ");
		}
		if (!FormatEmpty.isEmpty(createMan)) {
			str.append(" and createMan " + " like '%" + createMan + "%' ");
		}
		if (!FormatEmpty.isEmpty(devResult)) {
			str.append(" and devResult=" + devResult);
		}
		if (!FormatEmpty.isEmpty(state)) {
			str.append(" and state=" + state);
		}
		int first = rows * (page - 1);
		int max = rows;
		List<SaleChanceEntity> scList = saleChanceService.findAllPage(str.toString(), first, max);
		List<SaleChanceEntity> totalscList = saleChanceService.findAll(str.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalscList.size());
		map.put("rows", scList);
		HtmlUtil.writerJson(getResponse(), map);
	}

	public String updatesaleChance() {
		SaleChanceEntity scEntity = new SaleChanceEntity(id, chanceSource, customerName, cgjl, overView, linkMan,
				linkPhone, description, createMan, createTime, assignMan, assignTime, state, devResult);
		if (!FormatEmpty.isEmpty(assignMan)) {
			scEntity.setState(1);
		} else {
			scEntity.setState(0);
		}
		if (FormatEmpty.isEmpty(devResult)) {
			scEntity.setDevResult(0);
		}
		saleChanceService.update(scEntity);
		if (FormatEmpty.isEmpty(id)) {
			result = "insert";
		} else {
			result = "update";
		}
		return INPUT;
	}

	public String updateDevResultsaleChance() {
		SaleChanceEntity scEntity = saleChanceService.get(id);
		scEntity.setDevResult(devResult);
		saleChanceService.update(scEntity);
		result = "update";
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getChanceSource() {
		return chanceSource;
	}

	public void setChanceSource(String chanceSource) {
		this.chanceSource = chanceSource;
	}

	public Integer getCgjl() {
		return cgjl;
	}

	public void setCgjl(Integer cgjl) {
		this.cgjl = cgjl;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAssignMan() {
		return assignMan;
	}

	public void setAssignMan(String assignMan) {
		this.assignMan = assignMan;
	}

	public String getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(String assignTime) {
		this.assignTime = assignTime;
	}

	public Integer getDevResult() {
		return devResult;
	}

	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
